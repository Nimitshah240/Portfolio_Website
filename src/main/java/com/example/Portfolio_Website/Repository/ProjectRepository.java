package com.example.Portfolio_Website.Repository;

import com.example.Portfolio_Website.DTO.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {

    List<Project> findAllByOrderByIdAsc();
}
