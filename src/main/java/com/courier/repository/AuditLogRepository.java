package com.courier.repository;

import com.courier.model.AuditLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuditLogRepository extends JpaRepository<AuditLog, Long> {
    List<AuditLog> findByTableNameAndRecordIdOrderByTimestampDesc(String tableName, Long recordId);
}
