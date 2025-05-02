package com.recruitment.applicantservice.service;

import com.recruitment.applicantservice.model.Application;
import com.recruitment.applicantservice.repository.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.List;

@Service
public class ApplicationService {
    private final ApplicationRepository applicationRepository;

    @Autowired
    public ApplicationService(ApplicationRepository applicationRepository) {
        this.applicationRepository = applicationRepository;
    }

    public Application submitApplication(Application application) {
        application.setStatus("SUBMITTED");
        return applicationRepository.save(application);
    }

    public Optional<Application> changeStatus(Long applicationId, String status) {
        Optional<Application> applicationOpt = applicationRepository.findById(applicationId);
        applicationOpt.ifPresent(app -> {
            app.setStatus(status);
            applicationRepository.save(app);
        });
        return applicationOpt;
    }

    public List<Long> getApplicantIdsByJobId(Long jobId) {
        return applicationRepository.findAll().stream()
            .filter(app -> app.getJobId().equals(jobId))
            .map(app -> app.getApplicantId())
            .toList();
    }
}