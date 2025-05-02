package com.recruitment.applicantservice.controller;

import com.recruitment.applicantservice.model.HR;
import com.recruitment.applicantservice.service.HRService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/hrs")
public class HRController {
    private final HRService hrService;

    @Autowired
    public HRController(HRService hrService) {
        this.hrService = hrService;
    }

    @PostMapping
    public HR createHR(@RequestBody HR hr) {
        return hrService.createHR(hr);
    }

    @GetMapping
    public List<HR> getAllHRs() {
        return hrService.getAllHRs();
    }

    @GetMapping("/{id}")
    public HR getHRById(@PathVariable Long id) {
        return hrService.getHRById(id);
    }

    @GetMapping("/name/{name}")
    public List<HR> getHRsByName(@PathVariable String name) {
        return hrService.getHRsByName(name);
    }

    @DeleteMapping("/{id}")
    public void deleteHRById(@PathVariable Long id) {
        hrService.deleteHRById(id);
    }

    @DeleteMapping("/name/{name}")
    public void deleteHRsByName(@PathVariable String name) {
        hrService.deleteHRsByName(name);
    }
}