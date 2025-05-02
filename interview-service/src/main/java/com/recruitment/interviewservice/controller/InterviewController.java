package com.recruitment.interviewservice.controller;

import com.recruitment.interviewservice.model.Interview;
import com.recruitment.interviewservice.service.InterviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/interviews")
public class InterviewController {
    private final InterviewService interviewService;

    @Autowired
    public InterviewController(InterviewService interviewService) {
        this.interviewService = interviewService;
    }

    @PostMapping
    public Interview scheduleInterview(@RequestBody Interview interview) {
        return interviewService.scheduleInterview(interview);
    }

    @GetMapping
    public List<Interview> getAllInterviews() {
        return interviewService.getAllInterviews();
    }

    @PutMapping("/{id}/status")
    public Interview updateInterviewStatus(@PathVariable Long id, @RequestParam String status) {
        return interviewService.updateInterviewStatus(id, status);
    }

    @DeleteMapping("/{id}")
    public void deleteInterview(@PathVariable Long id) {
        interviewService.deleteInterview(id);
    }
}