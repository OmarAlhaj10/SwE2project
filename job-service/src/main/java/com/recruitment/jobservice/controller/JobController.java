package com.recruitment.jobservice.controller;

import com.recruitment.jobservice.model.Job;
import com.recruitment.jobservice.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/jobs")
public class JobController {
    private final JobService jobService;

    @Autowired
    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @PostMapping
    public Job createJob(@RequestBody Job job) {
        return jobService.createJob(job);
    }

    @GetMapping
    public List<Job> getAllJobs() {
        return jobService.getAllJobs();
    }

    @GetMapping("/title/{title}")
    public List<Job> getJobsByTitle(@PathVariable String title) {
        return jobService.getJobsByTitle(title);
    }

    @GetMapping("/location/{location}")
    public List<Job> getJobsByLocation(@PathVariable String location) {
        return jobService.getJobsByLocation(location);
    }

    @GetMapping("/department/{department}")
    public List<Job> getJobsByDepartment(@PathVariable String department) {
        return jobService.getJobsByDepartment(department);
    }

    @DeleteMapping("/{id}")
    public void deleteJobById(@PathVariable Long id) {
        jobService.deleteJobById(id);
    }

    @DeleteMapping("/title/{title}")
    public void deleteJobByTitle(@PathVariable String title) {
        jobService.deleteJobByTitle(title);
    }

    @DeleteMapping("/location/{location}")
    public void deleteLocation(@PathVariable String location) {
        jobService.deleteLocation(location);
    }

    @DeleteMapping("/department/{department}")
    public void deleteDepartment(@PathVariable String department) {
        jobService.deleteDepartment(department);
    }

   
    @DeleteMapping("/description/{id}")
    public void deleteJobDescription(@PathVariable Long id) {
        jobService.deleteJobDescription(id);
    }

    
    @PutMapping("/title/{id}")
    public void updateJobTitle(@PathVariable Long id, @RequestBody String title) {
        jobService.updateJobTitle(id, title);
    }

    
    @PutMapping("/location/{id}")
    public void updateJobLocation(@PathVariable Long id, @RequestBody String location) {
        jobService.updateJobLocation(id, location);
    }

    
    @PutMapping("/department/{id}")
    public void updateJobDepartment(@PathVariable Long id, @RequestBody String department) {
        jobService.updateJobDepartment(id, department);
    }

    
    @PutMapping("/description/{id}")
    public void updateJobDescription(@PathVariable Long id, @RequestBody String description) {
        jobService.updateJobDescriptionField(id, description);
    }
}