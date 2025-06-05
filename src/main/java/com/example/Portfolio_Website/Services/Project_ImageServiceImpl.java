package com.example.Portfolio_Website.Services;

import com.example.Portfolio_Website.DTO.Project_Image;
import com.example.Portfolio_Website.Repository.Project_ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Project_ImageServiceImpl {

    @Autowired
    public Project_ImageRepository projectImageRepository;

    public List<Project_Image> findBypId(Long p_id) {
        return projectImageRepository.findBypId(p_id);
    }

}
