package com.recruitment.applicantservice.service;

import com.recruitment.applicantservice.model.HR;
import com.recruitment.applicantservice.repository.HRRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class HRService {
    private final HRRepository hrRepository;

    @Autowired
    public HRService(HRRepository hrRepository) {
        this.hrRepository = hrRepository;
    }

    public HR createHR(HR hr) {
        return hrRepository.save(hr);
    }

    public List<HR> getAllHRs() {
        return hrRepository.findAll();
    }

    public HR getHRById(Long id) {
        return hrRepository.findById(id).orElse(null);
    }

    public List<HR> getHRsByName(String name) {
        return hrRepository.findByName(name);
    }

    public void deleteHRById(Long id) {
        hrRepository.deleteById(id);
    }

    @Transactional
    public void deleteHRsByName(String name) {
        hrRepository.deleteByName(name);
    }
}