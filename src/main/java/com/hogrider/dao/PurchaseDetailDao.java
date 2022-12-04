package com.hogrider.dao;

import com.hogrider.pojo.PurchaseDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface PurchaseDetailDao extends JpaRepository<PurchaseDetail, Integer> {

    List<PurchaseDetail> findPurchaseDetailByOrderid( String orderid );
    void deleteAllByOrderid(String orderid);


    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Query(value = "update purchasedetail pcd set pcd.inventory = ?1 where pcd.orderid=?2 and pcd.merchandise = ?3", nativeQuery = true)
    void updateDetailsByNameAndOrderid(Integer inventory, String orderid, String name);
}
