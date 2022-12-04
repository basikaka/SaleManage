package com.hogrider.service;

import com.hogrider.dao.InboundProductDao;
import com.hogrider.pojo.InboundProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.PrintWriter;
import java.util.List;

@Service
public class InboundProductService {

    @Autowired
    private InboundProductDao inboundProductDao;

    public String saveInboundProduct(List<InboundProduct> inboundProductList) {
        return inboundProductDao.saveAll(inboundProductList).toString();
    }

    @Modifying
    @Transactional
    public void updateInventoryByNameAndInboundid(List<InboundProduct> inboundProductList
            ){
        for (InboundProduct item: inboundProductList
             ) {
            Integer inventory = item.getInventory();
            String inboundid = item.getInboundid();
            String name = item.getMerchandise();
            inboundProductDao.updateInventoryByNameAndInboundid(inventory, inboundid, name);
        }
    }
}