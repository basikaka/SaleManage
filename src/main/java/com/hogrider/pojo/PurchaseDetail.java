package com.hogrider.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "purchasedetail")
@JsonIgnoreProperties({"handler","hibernateLazyInitializer"})
public class PurchaseDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    private String orderid; // 所在订单号
    private String merchandise; // 商品名称
    private String productinfo; // 规格
    private BigDecimal inprice; // 采购单价
    private Integer number; // 采购单采购商品数量
    private Integer inventory; // 未审核拟入库的数量
    private Integer finventory; // 审核通过入库的数量（入库单已审核完成）

}
