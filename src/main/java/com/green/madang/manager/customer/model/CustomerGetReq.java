package com.green.madang.manager.customer.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.ToString;
import org.springframework.web.bind.annotation.BindParam;
/*
    우리가 만드는 API는 응답 때 JSON 형태로 응답한다.
    응답시 객체에 있는 특정 멤버필드의 값을 제외하고 싶을 때
    @JsonIgnore를 멤버필드에 붙이면 제외시킬 수 있다.
    (응답 때 JsonIgnore 을 쓰는 경우가 거의 없다.

    Swagger 문서상에 응답 Schema에서 안 보이기도 한다
 */

@Getter
@ToString
// @Schema와 JdonIgnor은 Swagger용 애노테이션
public class CustomerGetReq {
    @NotNull(message = "page 값은 필수입니다.")
    @Schema(description = "page 값", example = "1", requiredMode = Schema.RequiredMode.REQUIRED)
    private int page;

    @NotNull(message = "size 값은 필수입니다.")
    @Schema(description = "페이지에 보이는 고객정보 수", example = "50", requiredMode = Schema.RequiredMode.REQUIRED)
    private int size;

    @JsonIgnore
    private int startIdx; //(page - 1) * size

    @Schema(description = "검색 타입: {name, address, phone} 중 한 값을 보낸다.", example = "name")
    private String searchType;

    @Schema(description = "검색 내용", example = "ani")
    private String searchText;

    public CustomerGetReq(Integer page, Integer size, @BindParam("search_type") String searchType, @BindParam("search_text") String searchText) {
        this.page = page;
        this.size = size;
        this.searchType = searchType;
        this.searchText = searchText;
        this.startIdx = (page - 1) * size; // page가 null이면 계산 오류 발생
    }
}
