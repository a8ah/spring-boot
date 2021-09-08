package com.example.controller;

import java.util.List;

import com.example.dto.RegistryDto;
import com.example.dto.UserDto;
import com.example.entity.Person;
import com.example.service.PersonaServiceImp;

import org.modelmapper.ModelMapper;
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
public class UserController {
    
	// @Autowired
	private ModelMapper modelMapper;
    
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

    // @PostMapping("/signin")
    // public void signUp(@RequestBody User user)
    // {
    // user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
    //     userRepository.save(user);
    // }

    @PostMapping("/registry")
    public ResponseEntity<UserDto> signUp(@RequestBody RegistryDto registryDto){
    
        modelMapper = new ModelMapper();

        // convert DTO to entity
        Person registry_person= modelMapper.map(registryDto, Person.class);

        // registry person
        registry_person= persona_service.savePerson(registry_person);

        // return UserDto
        UserDto registred_user= modelMapper.map(registry_person,UserDto.class);
        return ResponseEntity.ok().body(registred_user);

    }
}
