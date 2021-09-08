package com.example.service;

import com.example.entity.Person;
import com.example.repository.IPersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonaServiceImp implements IPersonaService {

    @Autowired
    IPersonRepository repo;

    // public PersonaServiceImp() {}

    @Override
    public List<Person> findAll() {
        return repo.findAll();
    }

    @Override
    public Optional<Person> findCustomerById(Long id) {
        
        return null;
    }

    @Override
    public Person savePerson(Person person) {
        System.out.println(person.getPassword());
        return repo.save(person);
    }

    @Override
    public String deletePerson(Long id) {
        
        return null;
    }

    @Override
    public String updatePerson(Person person) {
        
        return null;
    }
}
