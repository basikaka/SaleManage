package com.hogrider.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "purchaseorder")
@JsonIgnoreProperties({"handler","hibernateLazyInitializer"})
public class Purchase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    private String ponum;
    private String supname;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Timestamp createtime; // 创建订单的时间

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Timestamp viewtime; // 审核订单的时间

    private String finish; // 订单完成情况：未审核，已审核，取消

    private String rkstatus; // 采购订单入库的状态；未开始，进行中（有部门商品已经入库），已完成（所有商品已入库）
}
