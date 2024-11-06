package com.heeda.swagger.config;

import com.heeda.swagger.common.annotation.CommonErrorResponseExamples;
import com.heeda.swagger.common.constant.ErrorCode;
import com.heeda.swagger.common.dto.response.CommonErrorResponse;
import com.heeda.swagger.common.dto.response.ErrorResponse;
import com.heeda.swagger.common.dto.response.ExampleHolder;
import io.swagger.v3.core.converter.AnnotatedType;
import io.swagger.v3.core.converter.ModelConverters;
import io.swagger.v3.oas.models.Operation;
import io.swagger.v3.oas.models.examples.Example;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.media.Content;
import io.swagger.v3.oas.models.media.MediaType;
import io.swagger.v3.oas.models.responses.ApiResponse;
import io.swagger.v3.oas.models.responses.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springdoc.core.customizers.OperationCustomizer;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.HandlerMethod;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(apiInfo())
                .components(new Components()
                        .addSchemas("CommonErrorResponse", ModelConverters.getInstance()
                        .resolveAsResolvedSchema(new AnnotatedType(CommonErrorResponse.class)).schema));
    }

    private Info apiInfo() {
        return new Info()
                .title("Swagger Demo Project")
                .description("Swagger Demo Project API")
                .version("1.0.0");
    }

    @Bean
    public OperationCustomizer customizer()
    {
        return (Operation operation, HandlerMethod handlerMethod) -> {
            CommonErrorResponseExamples commonErrorResponseExamples = handlerMethod.getMethodAnnotation(CommonErrorResponseExamples.class);
            // @CommonErrorResponseExamples 어노테이션이 붙어 있다면
            if (commonErrorResponseExamples != null) {
                generateErrorCodeResponseExample(operation, commonErrorResponseExamples.value());
            }
            return operation;
        };
    }

    private void generateErrorCodeResponseExample(Operation operation, ErrorCode[] errorCodes) {
        ApiResponses responses = operation.getResponses();

        // ExampleHolder 객체 생성 및 에러 코드별 그룹화
        Map<Integer, List<ExampleHolder>> statusWithExampleHolders = Arrays.stream(errorCodes)
                .map(
                        errorCode -> ExampleHolder.builder()
                                .holder(getSwaggerExample(errorCode))
                                .code(errorCode.getHttpStatus().value())
                                .name(errorCode.name())
                                .build()
                )
                .collect(Collectors.groupingBy(ExampleHolder::getCode));

        addExamplesToResponses(responses, statusWithExampleHolders);

        operation.setResponses(responses);
    }


    private void addExamplesToResponses(ApiResponses responses, Map<Integer, List<ExampleHolder>> statusWithExampleHolders) {
        statusWithExampleHolders.forEach((statusCode, examples) -> {
            ApiResponse apiResponse = new ApiResponse();
            Content content = new Content();
            MediaType mediaType = new MediaType();

            examples.forEach(exampleHolder ->
                    mediaType.addExamples(exampleHolder.getName(), exampleHolder.getHolder())
            );

            content.addMediaType("application/json", mediaType);
            apiResponse.setContent(content);
            responses.addApiResponse(String.valueOf(statusCode), apiResponse);
        });
    }


    private Example getSwaggerExample(ErrorCode error)
    {
        ErrorResponse errorResponse = ErrorResponse.of(error.getErrorCode(), error.getMessage());
        CommonErrorResponse<Object> response= CommonErrorResponse.ERROR(error.getHttpStatus().value(), errorResponse);
        Example example = new Example();
        example.setSummary(response.getError().getCode());
        example.setValue(Map.of(
                "success", response.isSuccess(),
                "message", response.getMessage(),
                "statusCode", response.getStatusCode(),
                "error", Map.of(
                        "code", error.getErrorCode(),
                        "message", error.getMessage()
                )
        ));

        return example;
    }


    @Bean
    public GroupedOpenApi allApi() {
        return GroupedOpenApi.builder()
                .group("전체")
                .pathsToMatch("/api/v1/**")
                .addOperationCustomizer(customizer())
                .build();
    }

    @Bean
    public GroupedOpenApi storeApi() {
        return GroupedOpenApi.builder()
                .group("유저 관리")
                .pathsToMatch("/api/v1/users/**")
                .addOperationCustomizer(customizer())
                .build();
    }

}
