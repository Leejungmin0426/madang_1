package com.green.madang.manager.customer;

import com.green.madang.common.model.MyResponse;
import com.green.madang.manager.customer.model.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Select;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("manager/customer")
@RestController
@Tag(name = "고객", description = "고객 입력 API")
public class CustomerController {
    private final CustomerService service;

    @PostMapping
    @Operation(summary = "고객", description = "고객 추가 API")
    public MyResponse<Integer> insCustomer(@RequestBody CustomerPostReq p) {
        int result = service.insCustomer(p);
        MyResponse<Integer> responce = new MyResponse<>("고객이 등록되었습니다.", result);
        return responce;
    }


    @GetMapping
    public MyResponse<List<CustomerGetRes>> getCustomerGetResList(@ParameterObject CustomerGetReq p) {
        List<CustomerGetRes> res = service.selCustomerList(p);
        return new MyResponse<>(p.getPage() + "페이지 데이터", res);
    }


    @GetMapping("/param")
    public MyResponse<List<CustomerGetRes>> getCustomerGetResList2(@RequestParam int page
            , @RequestParam int size
            , @RequestParam(name = "search_type", required = false) String searchType
            , @RequestParam(name = "search_text", required = false) String searchText) {
        CustomerGetReq p = new CustomerGetReq(page, size, searchType, searchText);
        log.info("get-req: {}", p);
        List<CustomerGetRes> res = service.selCustomerList(p);
        return new MyResponse<>(p.getPage() + "페이지 데이터", res);
    }

    @PutMapping
    public MyResponse<Integer> putCustomer(@RequestBody CustomerPutReq p) {
        int result = service.putCustomer(p);
        MyResponse<Integer> responce = new MyResponse<>(p.getCustId() + "번 고객 정보가 수정되었습니다.", result);
        return responce;
    }
//
//    @DeleteMapping
//    @Operation(summary = "고객 삭제", description = "고객 삭제 API")
//    public MyResponse<Integer> delCustomer(@ParameterObject CustomerDeleteReq p) {
//        int result = service.delCustomer(p);
//        MyResponse<Integer> responce = new MyResponse<>("고객 정보가 삭제되었습니다.", result);
//        return responce;
//    }


    @DeleteMapping
    @Operation(summary = "고객 삭제", description = "고객 삭제 API")
    public MyResponse<Integer> delCustomer(@RequestParam(value = "cust_id") int custId) {
        int result = service.delCustomer(custId);
        MyResponse<Integer> responce = new MyResponse<>("고객 정보가 삭제되었습니다.", result);
        return responce;
    }


}