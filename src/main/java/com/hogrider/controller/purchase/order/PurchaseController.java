package com.hogrider.controller.purchase.order;


import com.hogrider.pojo.Purchase;
import com.hogrider.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class PurchaseController {

    @Autowired
    private PurchaseService purchaseService;

    @GetMapping("/order")
    public List<Purchase> list(){
        return purchaseService.list();
    }

    @GetMapping("/order/{page}/{size}")
    public Page<Purchase> findAllByPage(@PathVariable("page") Integer  page,
                                        @PathVariable("size") Integer size){
        Pageable pageable = PageRequest.of(page - 1, size);
        return purchaseService.findAllByPage(pageable);
    }

    @GetMapping("/order/search")
    public List<Purchase> findPurchaseByPurchaseNum(@RequestParam("keywords") String purchaseId){
        if( "".equals(purchaseId)){
            return this.findAllByPage(1,5).toList();
        }
        else {
            List<Purchase> purchaseList = new ArrayList<>();
            Purchase purchase = purchaseService.findByPurchaseNum( purchaseId );
            if( purchase != null){
                purchaseList.add( purchase);
                return purchaseList;
            }else {
                return this.findAllByPage(1,5).toList();
            }
        }
    }

    @PostMapping("/order/add")
    public String saveOrder(@RequestBody Purchase purchase){
        return purchaseService.saveOrder(purchase);
    }

    @DeleteMapping("/order/delete/{ponum}")
    public void deleteByPonum(@PathVariable("ponum") String orderid){
        purchaseService.deleteByPonum( orderid);
    }

    @PutMapping("/order/update")
    public Purchase updateOrder(@RequestBody Purchase purchase){return save_to_database(purchase);}

    public Purchase save_to_database(Purchase purchase){
        Purchase saved = purchaseService.updateOrder( purchase);
        return saved;
//        if( saved != null){
//            return "succeed";
//        }else {
//            return "failed";
//        }
    }

    @GetMapping("/inbound/detail")
    public List<Purchase> findOrderToInbound(){
        String finish = "通过审核";
        String rkstatus = "已完成";
        return purchaseService.findOrderToInbound( finish, rkstatus);
    }

    @PostMapping("/order/update/rkstatus")
    public void updateRkstatusByOrderid(@RequestBody Purchase purchase){
        purchaseService.updateRkstatusByOrderid(purchase);
    }
}
