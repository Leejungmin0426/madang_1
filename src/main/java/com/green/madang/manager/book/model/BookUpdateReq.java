package com.green.madang.manager.book.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BookUpdateReq {
    private Integer bookId;
    private int price;
    private String bookName;
    private String publisher;
    /*
    int price였을 때(구별 불가능)
    실제 책 가격을 0으로 수정하고 싶었음. 쿼리스트링에 추가함 price = 0
    책 가격을 수정하고 싶지 않았음(현상 유지). 쿼리스트링에 추가 안 함 price = 0

   Integer price였을 때(구별 불가능)
    실제 책 가격을 0으로 수정하고 싶었음. 쿼리스트링에 추가함 price = 0
    책 가격을 수정하고 싶지 않았음(현상 유지). 쿼리스트링에 추가 안 함 price = null
     */
}
