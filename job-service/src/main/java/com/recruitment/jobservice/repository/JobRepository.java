package com.recruitment.jobservice.repository;

import com.recruitment.jobservice.model.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobRepository extends JpaRepository<Job, Long> {
    List<Job> findByTitle(String title);
    List<Job> findByLocation(String location);
    List<Job> findByDepartment(String department);
    void deleteById(Long id);
    void deleteByTitle(String title);
    // Remove these methods since we no longer delete by location or department
    // void deleteByLocation(String location);
    // void deleteByDepartment(String department);
}