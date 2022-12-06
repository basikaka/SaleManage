package com.hogrider.service;

import com.hogrider.pojo.Inbound;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class InboundServiceTest {

    @Autowired
    private InboundService inboundService;

    @Test
    void saveInbound() {

        String inboundid = "RKDD202212064456";
        String orderid  = "CGDD202211094434";
        String cname = "admin";
        Timestamp ctime = Timestamp.valueOf("2022-12-06 13:14:08");
        String vname = "";
        Timestamp vtime = null;
        Timestamp ftime = null;
        String status = "未开始";



        Inbound inbound = new Inbound();
        inbound.setInboundid(inboundid);
        inbound.setOrderid(orderid);
        inbound.setCname(cname);
        inbound.setCtime(ctime);
        inbound.setVname(vname);
        inbound.setVtime(vtime);
        inbound.setFtime(ftime);
        inbound.setStatus(status);

        inboundService.saveInbound(inbound);

    }
}
