package com.hogrider.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "inboundproduct")
@JsonIgnoreProperties({"handler","hibernateLazyInitializer"})
public class InboundProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    private String inboundid; // 进库单号
    private String orderid; // 采购订单号
    private String merchandise; // 商品名称
    private String productinfo; // 规格
    private BigDecimal inprice; // 采购单价
    private Integer inventory; // 已经入库的数量

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Timestamp createtime; // 创建订单的时间

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Timestamp viewtime; // 修改状态时间

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Timestamp ftime; // 最终完成审核的时间

    private String status; // '0未审核，1待审核，2已审核，3驳回',

}
