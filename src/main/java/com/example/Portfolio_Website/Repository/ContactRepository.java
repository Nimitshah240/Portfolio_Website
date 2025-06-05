package com.example.Portfolio_Website.Repository;

import com.example.Portfolio_Website.DTO.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {

    Contact save(Contact contact);
}
