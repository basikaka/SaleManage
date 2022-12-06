package com.hogrider.controller.purchase.inbound;

import com.hogrider.pojo.InboundProduct;
import com.hogrider.pojo.PurchaseDetail;
import com.hogrider.service.InboundProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class InboundProductController {

    @Autowired
    private InboundProductService inboundProductService;

    @PostMapping("/inbound/detail/add")
    public String saveOrderDetail(@RequestBody List<InboundProduct> inboundProductList){
        return inboundProductService.saveInboundProduct(inboundProductList).toString();
    }

    @PostMapping("/inbound/detail/update")
    public void updateInventoryByNameAndInboundid(@RequestBody List<InboundProduct> inboundProductList){
        inboundProductService.updateInventoryByNameAndInboundid(inboundProductList);
    }

}
