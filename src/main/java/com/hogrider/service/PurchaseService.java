package com.hogrider.service;

import com.hogrider.dao.PurchaseDao;
import com.hogrider.pojo.Purchase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Service
public class PurchaseService {
    @Autowired
    private PurchaseDao purchaseDao;

    public List<Purchase> list(){
        return purchaseDao.findAll();
    }

    public Purchase findByPurchaseNum( String number){
        return purchaseDao.findPurchaseByOrderid( number );
    }

    public Page<Purchase> findAllByPage(Pageable pageable){
        return purchaseDao.findAll(pageable);
    }

    public String saveOrder( Purchase purchase){
        return purchaseDao.save( purchase ).toString();
    }

    public Purchase updateOrder( Purchase purchase) {return purchaseDao.save(purchase);}


    @Modifying
    @Transactional
    public void deleteByPonum( String ponum){
        purchaseDao.deleteAllByOrderid(ponum);
    }

    public List<Purchase> findOrderToInbound( String finish, String rkstatus) {
        return purchaseDao.findPurchaseByFinishAndRkstatusNot( finish, rkstatus);
    }

    @Modifying
    @Transactional
    public void updateRkstatusByOrderid(Purchase purchase){
        String status = purchase.getRkstatus();
        String ponum = purchase.getOrderid();
        purchaseDao.updateRkstatusByOrderid(status, ponum);
    }
}
