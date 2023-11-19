package com.sde.logingestor.serviceimpl;

import java.util.Date;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sde.logingestor.entity.Logdata;
import com.sde.logingestor.entity.Metadata;
import com.sde.logingestor.model.LogDataDTO;
import com.sde.logingestor.repository.LogRepository;
import com.sde.logingestor.service.LogService;

@Service
public class LogServiceImpl implements LogService {

    @Autowired
    private LogRepository logRepository;

    @Override
    public boolean createNewLog(LogDataDTO logDataDTO) {
        Logdata logdata = new Logdata();
        Metadata metadata = new Metadata();

        metadata.setId(null); // auto-generate
        metadata.setParentResourceId(logDataDTO.getMetadata().getParentResourceId());

        logdata.setId(null); // auto-generate
        logdata.setLevel(logDataDTO.getLevel());
        logdata.setMessage(logDataDTO.getMessage());
        logdata.setTimestamp(logDataDTO.getTimestamp());
        logdata.setResourceId(logDataDTO.getResourceId());
        logdata.setTraceId(logDataDTO.getTraceId());
        logdata.setSpanId(logDataDTO.getSpanId());
        logdata.setCommit(logDataDTO.getCommit());
        
        logdata.setMetadata(metadata);

        Logdata x = logRepository.save(logdata);

        return x != null;
    }

    @Override
    public Set<Logdata> searchByLevel(String x) {
        return logRepository.findByLevelLike("%" + x + "%");
    }

    @Override
    public Set<Logdata> searchByMessage(String x) {
        return logRepository.findByMessageLike("%" + x + "%");
    }

    
    @Override
    public Set<Logdata> searchByResourceId(String x) {
        return logRepository.findByResourceIdLike("%" + x + "%");
    }

    @Override
    public Set<Logdata> searchByTimestampWithin(Date x, Date y) {
        return logRepository.findByTimestampBetween(x, y);
    }

    @Override
    public Set<Logdata> searchBySpanId(String x) {
        return logRepository.findBySpanIdLike("%" + x + "%");
    }

    @Override
    public Set<Logdata> searchByTraceId(String x) {
        return logRepository.findByTraceIdLike("%" + x + "%");
    }

    @Override
    public Set<Logdata> searchByCommit(String x) {
        return logRepository.findByCommitLike("%" + x + "%");
    }

    @Override
    public Set<Logdata> searchByMetadataParentResourceId(String x) {
        return logRepository.findByMetadataParentResourceIdLike("%" + x + "%");
    }
}