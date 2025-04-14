package com.example.Portfolio_Website;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface CertificateRepository extends JpaRepository<Certificate, Long> {
    List<Certificate> findAllByOrderByIdAsc();
}
