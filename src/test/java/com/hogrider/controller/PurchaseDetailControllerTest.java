package com.hogrider.controller;

import com.hogrider.service.PurchaseDetailService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;

class PurchaseDetailControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    PurchaseDetailService purchaseDetailService;

    @Test
    void deleteByOrderId() {
        String orderid = "CXXX444";
        purchaseDetailService.deleteByOrderId(orderid);
    }
}
