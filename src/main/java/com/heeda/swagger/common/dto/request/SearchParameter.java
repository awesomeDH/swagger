package com.heeda.swagger.common.dto.request;

import lombok.*;
import org.springframework.data.domain.Sort;

/**
 * 공통 검색 조건
 */
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SearchParameter
{
//    @Schema(description = "페이지 번호", defaultValue = "1", type = "int")
    int page = 1;

//    @Schema(description = "한 페이지에 보여지는 아이템 수", defaultValue = "10", type = "int")
    int limit = 10;

//    @Schema(description = "검색에 적용되는 필터링 조건", type="String")
//    @Nullable
    String searchType;

//    @Schema(description = "검색 필드 값", type="String")
//    @Nullable
    String searchValue;

//    @Schema(description = "정렬에 사용되는 필드", defaultValue = "createdAt", type="String")
    String orderBy = "createdAt";

//    @Schema(description = "정렬 순서 (ASC | DESC)", defaultValue = "DESC", type="String")
    Sort.Direction sort = Sort.Direction.DESC;
}
