package com.example.service;

import com.example.entity.Person;

import java.util.List;
import java.util.Optional;

public interface IPersonaService {

    public List<Person> findAll();

	public Optional<Person> findCustomerById(Long id);

	public Person savePerson(Person person);

	public String deletePerson(Long id);

	public String updatePerson(Person person);
}
