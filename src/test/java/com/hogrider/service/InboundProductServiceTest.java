package com.hogrider.service;

import com.hogrider.pojo.InboundProduct;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class InboundProductServiceTest {

    @Autowired
    private InboundProductService inboundProductService;

    @Test
    @Transactional
    void saveInboundProduct() {
        InboundProduct inboundProduct = new InboundProduct();
        inboundProduct.setInboundid("RKDD20221201001");
        inboundProduct.setOrderid("CGDD20221109001");
        inboundProduct.setMerchandise("悦天地1号");
        inboundProduct.setProductinfo("750ml");
        inboundProduct.setInprice(BigDecimal.valueOf(80));
        inboundProduct.setInventory(4);
        inboundProduct.setCreatetime(Timestamp.valueOf("2022-12-01 12:13:14"));
        inboundProduct.setViewtime(null);
        inboundProduct.setFtime(null);
        inboundProduct.setStatus("未开始");

        List<InboundProduct> inboundProductList = new ArrayList<>();
        inboundProductList.add(inboundProduct);

        inboundProductService.saveInboundProduct(inboundProductList);
    }

    @Test
    @Transactional
    void updateInventoryByNameAndInboundid() {
        Integer inventory = 5;
        String inboundid = "RKDD20221204113935";
        String name = "喜羊羊";
        List<InboundProduct> inboundProductList = new ArrayList<>();
        InboundProduct inboundProduct = new InboundProduct();
        inboundProduct.setInboundid(inboundid);
        inboundProduct.setInventory(inventory);
        inboundProduct.setMerchandise(name);
        inboundProductList.add(inboundProduct);
        inboundProductService.updateInventoryByNameAndInboundid(inboundProductList);
    }
}
