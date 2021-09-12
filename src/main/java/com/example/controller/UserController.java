package com.example.controller;

import java.util.List;

import javax.validation.Valid;

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

    @PostMapping(value = "/registry",consumes = {"application/json"},produces = {"application/json"})
    @ResponseBody
    public ResponseEntity<UserDto> addItem(@RequestBody @Valid RegistryDto registryDto, UriComponentsBuilder builder){
        
        modelMapper = new ModelMapper();

        // convert DTO to entity
        Person person= modelMapper.map(registryDto, Person.class);

        person= persona_service.savePerson(person);

         // convert entity to DTO 
        UserDto userDto= modelMapper.map(person,UserDto.class);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/user/{id}").buildAndExpand(userDto.getId()).toUri());
        
        return new ResponseEntity<UserDto>(headers, HttpStatus.CREATED);
    }

    // @PostMapping("/signin")
    // public void signUp(@RequestBody User user)
    // {
    // user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
    //     userRepository.save(user);
    // }
    
}
