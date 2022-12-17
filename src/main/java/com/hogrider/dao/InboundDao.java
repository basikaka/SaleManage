package com.hogrider.dao;

import com.hogrider.pojo.Inbound;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;

@Repository
public interface InboundDao extends JpaRepository<Inbound, Integer> {

    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Query(value = "update inbound ib set ib.status = ?1, ib.vtime = ?2, ib.ftime = ?3 where ib.inboundid = ?4", nativeQuery = true)
    void updateStatusByInboundid(String status, Timestamp vtime, Timestamp ftime, String inboundid);
}
