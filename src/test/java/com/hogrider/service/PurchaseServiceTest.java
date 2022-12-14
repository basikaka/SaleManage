package com.hogrider.service;

import com.hogrider.pojo.Purchase;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PurchaseServiceTest {

    @Autowired
    private PurchaseService purchaseService;

    @Test
    void list() {
        System.out.println( purchaseService.list());
    }

    @Test
    void findByPonum(){
        String num = "CDDN20221029001";
        System.out.println( purchaseService.findByPurchaseNum( num ));
    }

    @Test
    void findAllByPage() {
        Pageable pageable = PageRequest.of(1, 5);
        System.out.println(purchaseService.findAllByPage(pageable));
    }

    @Test
    @Transactional
    void saveOrder() {
        Purchase purchase = new Purchase();
        purchase.setCreatetime(Timestamp.valueOf("2022-10-11 12:00:00"));
        purchase.setOrderid("CCCC2222");
        purchase.setSupname("天堂伞有限公司");
        purchase.setFinish("未审核");

        purchaseService.saveOrder(purchase);
    }

    @Test
    @Transactional
    void deleteByPonum() {
        String ponum = "CXXX444";
        purchaseService.deleteByPonum(ponum);
    }

    @Test
    @Transactional
    void updateOrder() {
        /*
        INSERT INTO `salemanage`.`purchaseorder` (`id`, `ponum`, `supname`, `createtime`, `viewtime`, `finish`) VALUES (7, 'CDDN20221129001', '天堂伞有限公司', '2022-11-29 00:00:00', NULL, '未审核');
         */

        Integer Id = 7;
        String ponum = "CDDN20221129001";
        String supname = "天堂伞有限公司";
        Timestamp createtime = Timestamp.valueOf("2022-11-29 00:00:00");
        Timestamp viewtime = Timestamp.valueOf("2022-11-30 13:13:13");
        String finish = "提交审核";
        Purchase purchase = new Purchase();
        purchase.setId(Id);
        purchase.setOrderid(ponum);
        purchase.setSupname(supname);
        purchase.setCreatetime(createtime);
        purchase.setViewtime(viewtime);
        purchase.setFinish(finish);

        purchaseService.updateOrder(purchase);
    }

    @Test
    void findOrderToInbound() {
        String finish = "通过审核";
        String rkstatus = "已完成";
        System.out.println(purchaseService.findOrderToInbound(finish, rkstatus));
    }

    @Test
    void updateRkstatusByOrderid() {
//        String rkstatus = "进行中";
//        String ponum = "CDDN20221029002";
//        purchaseService.updateRkstatusByOrderid(rkstatus, ponum);
    }
}
