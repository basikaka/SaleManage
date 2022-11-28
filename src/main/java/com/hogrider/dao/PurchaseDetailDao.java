package com.hogrider.dao;

import com.hogrider.pojo.PurchaseDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PurchaseDetailDao extends JpaRepository<PurchaseDetail, Integer> {

    List<PurchaseDetail> findPurchaseDetailByOrderid( String orderid );
    void deleteAllByOrderid(String orderid);
}
