package com.green.madang.manager.book;

import com.green.madang.common.model.MyResponse;
import com.green.madang.manager.book.model.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Slf4j
@RequiredArgsConstructor // final이 붙은 생성자만 만들어 준다. 그리고 DI 받는다.
@RequestMapping("manager/book")
@RestController // 데이터로 응답
@Tag(name = "도서", description = "도서 API") //제목, 설명
public class BookController {
    private final BookService service;

    @PostMapping
    @Operation(summary = "도서 추가", description = "<div>도서 입고 처리 API</div>" +
            "<div>ㅋㅋㅋㅋ</div>" +
            "<div>ㅎㅎㅎㅎ</div>")
    public MyResponse<Integer> postBook( @RequestBody BookPostReq p){
        log.info("info {}", p); //정보
        log.warn("warn"); //경고
        log.error("error"); //에러
        int result = service.postBook(p);
        MyResponse<Integer> response = new MyResponse<>("책 등록 완료", result);
        return response;
    }

    @GetMapping
    @Operation(summary = "도서 리스트", description =  "도서 정보 리스트<br> 보기 API")
    public MyResponse<List<BookGetRes>> getBookList(@ParameterObject @ModelAttribute BookGetReq p) {
        List<BookGetRes> list = service.getBookList(p);
        return new MyResponse<>(p.getPage() + "페이지 데이터", list);
    }


    @PutMapping
    @Operation(summary = "도서 수정")
    public MyResponse<Integer> updateBook (@RequestBody BookUpdateReq p){
        int result = service.updateBook(p);
        MyResponse<Integer> response = new MyResponse<>("책 수정 완료", result);
        return response;
    }

    @DeleteMapping
    @Operation(summary = "도서 삭제")
    public MyResponse<Integer> delBook (BookDelReq p){
        int result = service.delBook(p);
        MyResponse<Integer> response = new MyResponse<>("책 삭제 완료", result);
        return response;
    }

}
