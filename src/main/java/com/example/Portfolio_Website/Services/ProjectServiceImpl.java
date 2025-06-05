package com.example.Portfolio_Website.Services;

import com.example.Portfolio_Website.DTO.Project;
import com.example.Portfolio_Website.Repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl {

    @Autowired
    public ProjectRepository projectRepository;

    public List<Project> findAllByOrderByIdAsc() {
        return projectRepository.findAllByOrderByIdAsc();
    }
}
