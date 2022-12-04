package com.hogrider.service;

import com.hogrider.pojo.PurchaseDetail;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class PurchaseDetailServiceTest {

    @Autowired
    private PurchaseDetailService purchaseDetailService;

    @Test
    void list() {
        System.out.println( purchaseDetailService.list());
    }

    @Test
    @Transactional
    void saveOrderDetail() {
        PurchaseDetail purchaseDetail = new PurchaseDetail();
        purchaseDetail.setInprice(BigDecimal.valueOf(30));
        purchaseDetail.setOrderid("CCC333");
        purchaseDetail.setMerchandise("经典白酒");
        purchaseDetail.setInventory(0);
        purchaseDetail.setNumber(30);
        purchaseDetail.setProductinfo("精酿");
        purchaseDetail.setId(9999);

        List<PurchaseDetail> purchaseDetailList = new ArrayList<>();
        purchaseDetailList.add(purchaseDetail);
        System.out.println(purchaseDetailService.saveOrderDetail(purchaseDetailList));
    }

    @Test
    @Transactional
    void deleteByOrderId() {
        String orderid = "CXXX444";
        purchaseDetailService.deleteByOrderId(orderid);
    }

    @Test
    void updateInventoryByNameAndOrderid() {
        Integer inventory = 10;
        String name = "喜羊羊";
        String orderid = "CDDN20221029002";
        purchaseDetailService.updateInventoryByNameAndOrderid(inventory, orderid, name );
    }
}
