package com.hogrider.dao;

import com.hogrider.pojo.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PurchaseDao extends JpaRepository<Purchase, Integer> {

    Purchase findPurchaseByPonum( String num);
    void deleteAllByPonum(String num);
    // 通过采购订单的审核状态查找，准备给
    List<Purchase> findPurchaseByFinishAndRkstatusNot(String finish, String rkstatus);
}
