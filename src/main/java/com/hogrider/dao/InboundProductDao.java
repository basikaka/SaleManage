package com.hogrider.dao;

import com.hogrider.pojo.InboundProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface InboundProductDao extends JpaRepository<InboundProduct, Integer> {

    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Query(value = "update inboundproduct ibp set ibp.inventory = ?1 where ibp.inboundid=?2 and ibp.merchandise = ?3", nativeQuery = true)
    void updateInventoryByNameAndInboundid(Integer inventory, String inboundid, String name);

    List<InboundProduct> findByInboundid(String inboundid);
}
