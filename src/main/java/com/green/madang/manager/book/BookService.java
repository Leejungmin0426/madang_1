package com.green.madang.manager.book;

import com.green.madang.manager.book.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor // DI 받기 위해서
@Service // 빈등록, 객체생성
public class BookService {
    private final BookMapper mapper; // DI 받기 위해서
    public int postBook(BookPostReq p){
        return mapper.insBook(p);
    }
    public List<BookGetRes> getBookList(BookGetReq p) {
        // sIdx값 세팅

        int page = p.getPage();
        int size = p.getSize();
        int startIdx = (page - 1) * size;
        p.setStartIdx(startIdx);

        //p.setStartId((p.getPage() - 1) * p.getSize());
        return mapper.selBookList(p);
    }

    public int updateBook(BookUpdateReq p){
        return mapper.updateBook(p);
    }
    public int delBook(BookDelReq p){
        return mapper.delBook(p);
    }

}
