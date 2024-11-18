package com.green.madang.manager.customer.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CustomerPostReq {
    @Schema(title = "고객이름", example = "이정민", requiredMode = Schema.RequiredMode.REQUIRED)
    private String name;
    @Schema(title = "고객주소",  example = "대한민국 대구", requiredMode = Schema.RequiredMode.REQUIRED)
    private String address;
    @Schema(title = "전화번호", example = "010-0000-0000", description="###-####-####", requiredMode = Schema.RequiredMode.REQUIRED)
    private String phone;

}
