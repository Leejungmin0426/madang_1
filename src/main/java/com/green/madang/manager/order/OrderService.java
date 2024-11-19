package com.green.madang.manager.order;

import com.green.madang.manager.order.model.OrderGetReq;
import com.green.madang.manager.order.model.OrderGetRes;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
@Slf4j
public class OrderService {
    private final OrderMapper mapper;

    public List<OrderGetRes> selOrdersList (OrderGetReq p){
        int startIdx = (p.getPage() - 1) * p.getSize();
        p.setStartIdx(startIdx);
        return mapper.selOrdersList(p);
    }
}
