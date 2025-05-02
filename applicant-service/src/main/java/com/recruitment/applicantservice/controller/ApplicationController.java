package com.recruitment.applicantservice.controller;

import com.recruitment.applicantservice.model.Application;
import com.recruitment.applicantservice.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;
import java.util.List;

@RestController
@RequestMapping("/applications")
public class ApplicationController {
    private final ApplicationService applicationService;

    @Autowired
    public ApplicationController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @PostMapping
    public ResponseEntity<Application> submitApplication(@RequestBody Application application) {
        Application saved = applicationService.submitApplication(application);
        return ResponseEntity.ok(saved);
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<Application> changeStatus(@PathVariable Long id, @RequestParam String status) {
        Optional<Application> updated = applicationService.changeStatus(id, status);
        return updated.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/job/{jobId}/candidates")
    public ResponseEntity<List<Long>> getCandidatesByJob(@PathVariable Long jobId) {
        List<Long> applicantIds = applicationService.getApplicantIdsByJobId(jobId);
        return ResponseEntity.ok(applicantIds);
    }
}