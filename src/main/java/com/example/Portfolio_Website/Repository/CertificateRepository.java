package com.example.Portfolio_Website.Repository;

import com.example.Portfolio_Website.DTO.Certificate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CertificateRepository extends JpaRepository<Certificate, Long> {
    List<Certificate> findAllByOrderByIdAsc();
}
