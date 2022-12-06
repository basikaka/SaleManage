package com.hogrider.dao;

import com.hogrider.pojo.Inbound;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InboundDao extends JpaRepository<Inbound, Integer> {
}
