package com.example.Portfolio_Website.Repository;

import com.example.Portfolio_Website.DTO.Project_Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Project_ImageRepository extends JpaRepository<Project_Image, Long> {
    List<Project_Image> findBypId(Long p_id);
}
