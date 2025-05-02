package com.recruitment.interviewservice.service;

import com.recruitment.interviewservice.model.Interview;
import com.recruitment.interviewservice.repository.InterviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class InterviewService {
    private final InterviewRepository interviewRepository;

    @Autowired
    public InterviewService(InterviewRepository interviewRepository) {
        this.interviewRepository = interviewRepository;
    }

    public Interview scheduleInterview(Interview interview) {
        return interviewRepository.save(interview);
    }

    public List<Interview> getAllInterviews() {
        return interviewRepository.findAll();
    }

    public Interview updateInterviewStatus(Long id, String status) {
        Interview interview = interviewRepository.findById(id).orElseThrow();
        interview.setStatus(status);
        return interviewRepository.save(interview);
    }

    public void deleteInterview(Long id) {
        interviewRepository.deleteById(id);
    }
}