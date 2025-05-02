package com.recruitment.applicantservice.repository;

import com.recruitment.applicantservice.model.Applicant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApplicantRepository extends JpaRepository<Applicant, Long> {
    List<Applicant> findByName(String name);
    void deleteById(Long id);
    void deleteByName(String name);
}