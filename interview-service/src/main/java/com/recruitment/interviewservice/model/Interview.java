package com.recruitment.interviewservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class Interview {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long applicantId;
    private Long jobId;
    private LocalDateTime scheduledTime;
    private String status;

    public Interview() {}

    public Interview(Long applicantId, Long jobId, LocalDateTime scheduledTime, String status) {
        this.applicantId = applicantId;
        this.jobId = jobId;
        this.scheduledTime = scheduledTime;
        this.status = status;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getApplicantId() { return applicantId; }
    public void setApplicantId(Long applicantId) { this.applicantId = applicantId; }
    public Long getJobId() { return jobId; }
    public void setJobId(Long jobId) { this.jobId = jobId; }
    public LocalDateTime getScheduledTime() { return scheduledTime; }
    public void setScheduledTime(LocalDateTime scheduledTime) { this.scheduledTime = scheduledTime; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}