package com.hogrider.service;

import com.hogrider.dao.PurchaseDetailDao;
import com.hogrider.pojo.Purchase;
import com.hogrider.pojo.PurchaseDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PurchaseDetailService {

    @Autowired
    private PurchaseDetailDao purchaseDetailDao;

    public List<PurchaseDetail> list(){
        return purchaseDetailDao.findAll();
    }

    public List<PurchaseDetail> findByOrderid(String orderid){
        return  purchaseDetailDao.findPurchaseDetailByOrderid( orderid );
    }

    public String saveOrderDetail(List<PurchaseDetail> purchaseDetailList){
        return purchaseDetailDao.saveAll(purchaseDetailList).toString();
    }

    @Modifying
    @Transactional
    public void deleteByOrderId(String orderid){
        purchaseDetailDao.deleteAllByOrderid(orderid);
    }
}
