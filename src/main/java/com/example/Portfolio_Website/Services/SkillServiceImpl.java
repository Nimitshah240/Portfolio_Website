package com.example.Portfolio_Website.Services;

import com.example.Portfolio_Website.DTO.Skills;
import com.example.Portfolio_Website.Repository.SkillRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillServiceImpl {

    private final SkillRepository skillRepository;

    public SkillServiceImpl(SkillRepository skillRepository) {
        this.skillRepository = skillRepository;
    }

    //    @Cacheable()
    public List<Skills> findAll() {
        return skillRepository.findAll();
    }
}

