package com.example.Portfolio_Website.Services;

import com.example.Portfolio_Website.DTO.Contact;
import com.example.Portfolio_Website.Repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactServiceImpl {

    @Autowired
    public ContactRepository contactRepository;

    public Contact save(Contact contact) {
        return contactRepository.save(contact);
    }
}
