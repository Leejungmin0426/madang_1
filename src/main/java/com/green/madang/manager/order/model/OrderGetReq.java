package com.green.madang.manager.order.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

public class OrderGetReq {
    private int page;
    private int size;

    @JsonIgnore
    private int startIdx; //(page - 1) * size

}
