package com.green.madang.manager.customer.model;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

public class CustomerGetRes {
    @Schema(title = "고객ID",  requiredMode = Schema.RequiredMode.REQUIRED)
    private int custid;
    @Schema(title = "고객이름", requiredMode = Schema.RequiredMode.REQUIRED)
    private String name;
    @Schema(title = "고객주소", requiredMode = Schema.RequiredMode.REQUIRED)
    private String address;
    @Schema(title = "고객번호", requiredMode = Schema.RequiredMode.REQUIRED)
    private String phone;
}
