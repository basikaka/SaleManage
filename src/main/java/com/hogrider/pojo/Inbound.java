package com.hogrider.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "inbound")
@JsonIgnoreProperties({"handler","hibernateLazyInitializer"})
public class Inbound {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    private String inboundid;
    private String orderid;

    private String cname;   // 入库单创建人
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Timestamp ctime;  // 入库单的创建时间

    private String vname;   // 入库单审核人
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Timestamp vtime;  // 入库单的审核时间，跟随入库单状态变化

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Timestamp ftime; // 入库单完成审核的时间

    private String status; // 入库单的状态： 0未开始 1待审核 2已完成 3已驳回（转入未开始）


}
