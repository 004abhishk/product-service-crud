package com.abhishek.ojha.auditservice.service;

import com.abhishek.ojha.auditservice.entity.Audit;
import com.abhishek.ojha.auditservice.repository.AuditRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuditService {

    @Autowired
    private AuditRepository auditRepository;

    public Audit addAuditEntry(Audit audit) {
        return auditRepository.save(audit);
    }
}
