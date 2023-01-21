package com.abhishek.ojha.auditservice.repository;

import com.abhishek.ojha.auditservice.entity.Audit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuditRepository extends JpaRepository<Audit, Integer> {
}
