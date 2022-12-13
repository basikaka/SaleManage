package com.hogrider.service;

import com.hogrider.dao.InboundDao;
import com.hogrider.pojo.Inbound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;

@Service
public class InboundService {
    @Autowired
    private InboundDao inboundDao;

    public List<Inbound> listInbound(){
        return inboundDao.findAll();
    }

    public void saveInbound(Inbound inbound) {
        inboundDao.save(inbound);
    }

    @Modifying
    @Transactional
    public void updateStatusByInboundid(Inbound inbound){
//        inboundDao.updateStatusByInboundid(status, inboundid);
        String status = inbound.getStatus();
        Timestamp vtime = inbound.getVtime();
        String inboundid = inbound.getInboundid();
        inboundDao.updateStatusByInboundid(status, vtime, inboundid);
    }
}
