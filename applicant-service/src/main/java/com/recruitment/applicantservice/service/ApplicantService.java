package com.recruitment.applicantservice.service;

import com.recruitment.applicantservice.model.Applicant;
import com.recruitment.applicantservice.repository.ApplicantRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ApplicantService {
    private final ApplicantRepository applicantRepository;

    @Autowired
    public ApplicantService(ApplicantRepository applicantRepository) {
        this.applicantRepository = applicantRepository;
    }

    public Applicant createApplicant(Applicant applicant) {
        return applicantRepository.save(applicant);
    }

    public List<Applicant> getAllApplicants() {
        return applicantRepository.findAll();
    }

    public Applicant getApplicantById(Long id) {
        return applicantRepository.findById(id).orElse(null);
    }

    public List<Applicant> getApplicantsByName(String name) {
        return applicantRepository.findByName(name);
    }

    public void deleteApplicantById(Long id) {
        applicantRepository.deleteById(id);
    }

    @Transactional
    public void deleteApplicantsByName(String name) {
        applicantRepository.deleteByName(name);
    }
}