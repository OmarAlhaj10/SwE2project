package com.recruitment.applicantservice.repository;

import com.recruitment.applicantservice.model.HR;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HRRepository extends JpaRepository<HR, Long> {
    List<HR> findByName(String name);
    void deleteById(Long id);
    void deleteByName(String name);
}