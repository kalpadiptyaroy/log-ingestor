package com.sde.logingestor.service;

import java.util.Date;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.sde.logingestor.entity.Logdata;
import com.sde.logingestor.model.LogDataDTO;

@Service
public interface LogService {
    public boolean createNewLog(LogDataDTO logDataDTO);
    public Set<Logdata> searchByLevel(String x);
    public Set<Logdata> searchByMessage(String x);
    public Set<Logdata> searchByResourceId(String x);
    public Set<Logdata> searchByTimestampWithin(Date x, Date y);
    public Set<Logdata> searchBySpanId(String x);
    public Set<Logdata> searchByTraceId(String x);
    public Set<Logdata> searchByCommit(String x);
    public Set<Logdata> searchByMetadataParentResourceId(String x);
}