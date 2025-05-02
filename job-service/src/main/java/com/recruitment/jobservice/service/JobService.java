package com.recruitment.jobservice.service;

import com.recruitment.jobservice.model.Job;
import com.recruitment.jobservice.repository.JobRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class JobService {
    private final JobRepository jobRepository;

    @Autowired
    public JobService(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    public Job createJob(Job job) {
        return jobRepository.save(job);
    }

    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }

    public List<Job> getJobsByTitle(String title) {
        return jobRepository.findByTitle(title);
    }

    public List<Job> getJobsByLocation(String location) {
        return jobRepository.findByLocation(location);
    }

    public List<Job> getJobsByDepartment(String department) {
        return jobRepository.findByDepartment(department);
    }

    public void deleteJobById(Long id) {
        jobRepository.deleteById(id);
    }

    @Transactional
    public void deleteJobByTitle(String title) {
        jobRepository.deleteByTitle(title);
    }

    @Transactional
    public void deleteLocation(String location) {
        List<Job> jobs = jobRepository.findByLocation(location);
        for (Job job : jobs) {
            job.setLocation(null);
            jobRepository.save(job);
        }
    }

    @Transactional
    public void deleteDepartment(String department) {
        List<Job> jobs = jobRepository.findByDepartment(department);
        for (Job job : jobs) {
            job.setDepartment(null);
            jobRepository.save(job);
        }
    }

    @Transactional
    public void deleteJobDescription(Long id) {
        Job job = jobRepository.findById(id).orElse(null);
        if (job != null) {
            job.setDescription(null);
            jobRepository.save(job);
        }
    }

    @Transactional
    public void updateJobTitle(Long id, String title) {
        Job job = jobRepository.findById(id).orElse(null);
        if (job != null) {
            job.setTitle(title);
            jobRepository.save(job);
        }
    }

    @Transactional
    public void updateJobLocation(Long id, String location) {
        Job job = jobRepository.findById(id).orElse(null);
        if (job != null) {
            job.setLocation(location);
            jobRepository.save(job);
        }
    }

    @Transactional
    public void updateJobDepartment(Long id, String department) {
        Job job = jobRepository.findById(id).orElse(null);
        if (job != null) {
            job.setDepartment(department);
            jobRepository.save(job);
        }
    }

    @Transactional
    public void updateJobDescriptionField(Long id, String description) {
        Job job = jobRepository.findById(id).orElse(null);
        if (job != null) {
            job.setDescription(description);
            jobRepository.save(job);
        }
    }
}