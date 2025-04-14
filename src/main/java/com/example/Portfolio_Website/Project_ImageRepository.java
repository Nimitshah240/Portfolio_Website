package com.example.Portfolio_Website;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface Project_ImageRepository extends JpaRepository<Project_Image, Long> {
    List<Project_Image> findBypId(Long p_id);
}
