package com.abhishek.ojha.auditservice.resource;

import com.abhishek.ojha.auditservice.entity.Audit;
import com.abhishek.ojha.auditservice.service.AuditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/audit")
public class AuditResource {

    @Autowired
    private AuditService auditService;

    @PostMapping
    public Audit addAuditEntry(@RequestBody Audit audit){
        return auditService.addAuditEntry(audit);
    }

    @GetMapping
    public List<Audit> findAllAuditEntries() {
        return null;
    }

    @GetMapping("{orderId}")
    public Audit findAuditDataForOrderId(@PathVariable("orderId") String orderId){
        return null;
    }
}
