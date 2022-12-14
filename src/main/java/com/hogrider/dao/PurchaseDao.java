package com.hogrider.dao;

import com.hogrider.pojo.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PurchaseDao extends JpaRepository<Purchase, Integer> {

    Purchase findPurchaseByOrderid( String num);
    void deleteAllByOrderid(String num);
    // 通过采购订单的审核状态查找，准备给
    List<Purchase> findPurchaseByFinishAndRkstatusNot(String finish, String rkstatus);

    @Modifying(flushAutomatically = true,clearAutomatically = true)
    @Query(value = "update purchaseorder pcd set pcd.rkstatus = ?1 where pcd.orderid = ?2", nativeQuery = true)
    public void updateRkstatusByOrderid(String status, String orderid);
}
