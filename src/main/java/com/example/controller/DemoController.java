package com.example.controller;

import java.util.List;

import com.example.entity.Person;
import com.example.service.PersonaServiceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;


@RestController
public class DemoController {
    
	@Autowired
	PersonaServiceImp persona_service;

	@GetMapping("/persons")
    public List<Person> getAllPersons() {
        return persona_service.findAll();
    }

	@PostMapping(value = "/add_person",consumes = {"application/json"},produces = {"application/json"})
    @ResponseBody
    public ResponseEntity<Person> addItem(@RequestBody Person person, UriComponentsBuilder builder){
        persona_service.savePerson(person);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/addItem/{id}").buildAndExpand(person.getIdPerson()).toUri());
        
        return new ResponseEntity<Person>(headers, HttpStatus.CREATED);
    }

}
