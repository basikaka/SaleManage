package com.hogrider.controller.purchase.order;


import com.hogrider.pojo.Purchase;
import com.hogrider.pojo.PurchaseDetail;
import com.hogrider.service.PurchaseDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class PurchaseDetailController {

    @Autowired
    private PurchaseDetailService purchaseDetailService;

    @GetMapping("/order/detail/{orderid}")
    public List<PurchaseDetail> findByOrderid(@PathVariable("orderid") String orderid){
        return purchaseDetailService.findByOrderid(orderid);
    }

    @PostMapping("/order/detail/add")
    public String saveOrderDetail(@RequestBody List<PurchaseDetail> purchaseDetail){
        return purchaseDetailService.saveOrderDetail(purchaseDetail).toString();
    }

    @DeleteMapping("/order/detail/delete/{orderid}")
    public void deleteByOrderId(@PathVariable("orderid") String orderid){
        purchaseDetailService.deleteByOrderId( orderid );
    }

    @PostMapping("/order/detail/update")
    public void updateDetailByOrderidAndName(@RequestBody List<PurchaseDetail> purchaseDetailList) {
        purchaseDetailService.updateDetailByOrderidAndName(purchaseDetailList);
    }

    // 采购单每样商品的详细记录，统一更新接口
//    @PostMapping("/order/detail/update")

}
