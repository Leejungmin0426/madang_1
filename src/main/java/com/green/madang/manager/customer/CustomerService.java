package com.green.madang.manager.customer;

import com.green.madang.common.model.MyResponse;
import com.green.madang.manager.customer.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerMapper mapper;

    public int insCustomer (CustomerPostReq p){
        return mapper.insCustomer(p);
    }
    public List<CustomerGetRes> selCustomerList (CustomerGetReq p){
        //int startIdx = (p.getPage() - 1) * p.getSize();
      //  p.setStartIdx(startIdx);
        return mapper.selCustomerList(p);
    }






    public int putCustomer (CustomerPutReq p){
        return mapper.putCustomer(p);
    }

    public int delCustomer (int custId){
        return mapper.delCustomer(custId);
    }

}
