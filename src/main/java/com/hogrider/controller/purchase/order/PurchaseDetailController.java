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

    @PostMapping("/order/detail/inbound/update")
    public void updateInventoryByOrderidAndName(@RequestBody List<PurchaseDetail> purchaseDetailList) {
        for (PurchaseDetail item : purchaseDetailList
             ) {
            Integer inventory = item.getInventory();
            String orderid = item.getOrderid();
            String name = item.getMerchandise();
            // System.out.println(name + ": " + inventory + " " + orderid);
            purchaseDetailService.updateInventoryByNameAndOrderid(inventory, orderid, name);
        }
    }

}
