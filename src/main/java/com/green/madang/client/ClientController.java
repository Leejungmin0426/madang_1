package com.green.madang.client;

import com.green.madang.client.model.OrderGetReq;
import com.green.madang.client.model.OrderGetRes;
import com.green.madang.client.model.OrderPostReq;
import com.green.madang.common.model.MyResponse;
import com.green.madang.manager.customer.model.CustomerGetRes;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("client")
@Tag(name = "주문", description =" 주문 처리 가능")
public class ClientController {
    private final ClientService service;


    @PostMapping("order")
    @Operation(summary = "책 주문")
    public MyResponse<Integer> insOrders (@RequestBody OrderPostReq p) {// Json 형태로 넘어올 때는 RequestBody. 이거 제이슨으로 넘어온다고 알려주는 것
        int result = service.insOrders(p);
        MyResponse<Integer> response =  new MyResponse<>(p.getOrderId()+"번 주문이 등록되었습니다.", result);
       return response;
    }

    @GetMapping("order")
    @Operation(summary = "주문한 책 리스트")
    public MyResponse<List<OrderGetRes>>selOrdersList (@ParameterObject @ModelAttribute OrderGetReq p){
        List<OrderGetRes> list = service.selOrdersList(p);
        return new MyResponse<>( list.size() + "rows", list);
    }


}
