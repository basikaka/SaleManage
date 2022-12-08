package com.hogrider.controller.purchase.inbound;

import com.hogrider.pojo.Inbound;
import com.hogrider.service.InboundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class InboundController {
    @Autowired
    private InboundService inboundService;

    @GetMapping("/inbound")
    public List<Inbound> listInbound(){
        return inboundService.listInbound();
    }

    @PostMapping("/inbound/add")
    public void saveInbound(@RequestBody Inbound inbound) {
        inboundService.saveInbound(inbound);
    }
}
