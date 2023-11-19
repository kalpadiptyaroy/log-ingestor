package com.sde.logingestor.repository;

import java.util.Date;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sde.logingestor.entity.Logdata;

public interface LogRepository extends JpaRepository<Logdata, Long> {
    public Set<Logdata> findByLevelLike(String x);
    public Set<Logdata> findByMessageLike(String x);
    public Set<Logdata> findByResourceIdLike(String x);
    public Set<Logdata> findByTimestampBetween(Date x, Date y);
    public Set<Logdata> findBySpanIdLike(String x);
    public Set<Logdata> findByTraceIdLike(String x);
    public Set<Logdata> findByCommitLike(String x);
    public Set<Logdata> findByMetadataParentResourceIdLike(String x);
}