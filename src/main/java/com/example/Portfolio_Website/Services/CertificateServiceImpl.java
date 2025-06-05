package com.example.Portfolio_Website.Services;

import com.example.Portfolio_Website.DTO.Certificate;
import com.example.Portfolio_Website.Repository.CertificateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CertificateServiceImpl {

    @Autowired
    public CertificateRepository certificateRepository;

    public List<Certificate> findAllByOrderByIdAsc() {
        return certificateRepository.findAllByOrderByIdAsc();
    }

}
