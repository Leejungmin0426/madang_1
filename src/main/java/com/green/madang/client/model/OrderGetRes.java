package com.green.madang.client.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class OrderGetRes {
    private int orderId;
    private int salePrice;
    private int bookId;
    private String bookName;
    private String orderDate;

}
