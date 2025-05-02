package com.recruitment.applicantservice.controller;

import com.recruitment.applicantservice.model.Applicant;
import com.recruitment.applicantservice.service.ApplicantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/applicants")
public class ApplicantController {
    private final ApplicantService applicantService;

    @Autowired
    public ApplicantController(ApplicantService applicantService) {
        this.applicantService = applicantService;
    }

    @PostMapping
    public Applicant createApplicant(@RequestBody Applicant applicant) {
        return applicantService.createApplicant(applicant);
    }

    @GetMapping
    public List<Applicant> getAllApplicants() {
        return applicantService.getAllApplicants();
    }

    @GetMapping("/{id}")
    public Applicant getApplicantById(@PathVariable Long id) {
        return applicantService.getApplicantById(id);
    }

    @GetMapping("/name/{name}")
    public List<Applicant> getApplicantsByName(@PathVariable String name) {
        return applicantService.getApplicantsByName(name);
    }

    @DeleteMapping("/{id}")
    public void deleteApplicantById(@PathVariable Long id) {
        applicantService.deleteApplicantById(id);
    }

    @DeleteMapping("/name/{name}")
    public void deleteApplicantsByName(@PathVariable String name) {
        applicantService.deleteApplicantsByName(name);
    }
}