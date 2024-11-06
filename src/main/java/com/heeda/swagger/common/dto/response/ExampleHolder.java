package com.heeda.swagger.common.dto.response;

import io.swagger.v3.oas.models.examples.Example;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ExampleHolder {
    private String name;
    private Integer code;
    private Example holder;

}