package com.sde.logingestor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sde.logingestor.model.LogDataDTO;
import com.sde.logingestor.service.LogService;

@RestController
public class LogController {

    @Autowired
    private LogService logService;

    @PostMapping("/")
    public ResponseEntity<?> createNewLog(@RequestBody LogDataDTO logDataDTO) {
        boolean x = logService.createNewLog(logDataDTO);
        if (x) {
            return ResponseEntity.ok().build();
        }
        else
            return ResponseEntity.internalServerError().build();
    }

    @GetMapping("/searchByLevel")
    public ResponseEntity<?> searchByLevel(@RequestParam("level") String level) {
        return ResponseEntity.ok(logService.searchByLevel(level));
    }

    @GetMapping("/searchByMessage")
    public ResponseEntity<?> searchByMessage(@RequestParam("message") String message) {
        return ResponseEntity.ok(logService.searchByMessage(message));
    }

    @GetMapping("/searchByResourceId")
    public ResponseEntity<?> searchByResourceId(@RequestParam("resourceId") String resourceId) {
        return ResponseEntity.ok(logService.searchByResourceId(resourceId));
    }

    @GetMapping("/searchByTraceId")
    public ResponseEntity<?> searchByTraceId(@RequestParam("traceId") String traceId) {
        return ResponseEntity.ok(logService.searchByTraceId(traceId));
    }

    @GetMapping("/searchBySpanId")
    public ResponseEntity<?> searchBySpanId(@RequestParam("spanId") String spanId) {
        return ResponseEntity.ok(logService.searchByTraceId(spanId));
    }

    @GetMapping("/searchByCommit")
    public ResponseEntity<?> searchByCommit(@RequestParam("commit") String commit) {
        return ResponseEntity.ok(logService.searchByCommit(commit));
    }

    @GetMapping("/searchByMetadataParentResourceId")
    public ResponseEntity<?> searchByMetadataParentResourceId(@RequestParam("parentResourceId") String parentResourceId) {
        return ResponseEntity.ok(logService.searchByMetadataParentResourceId(parentResourceId));
    }
}