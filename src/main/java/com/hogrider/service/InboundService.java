package com.hogrider.service;

import com.hogrider.dao.InboundDao;
import com.hogrider.pojo.Inbound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InboundService {
    @Autowired
    private InboundDao inboundDao;

    public void saveInbound(Inbound inbound) {
        inboundDao.save(inbound);
    }
}
