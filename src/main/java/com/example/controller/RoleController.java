package com.example.controller;

import com.example.service.RoleServiceImpl;
import com.example.dto.RoleDto;
import com.example.entity.Role;

import java.util.ArrayList;
import java.util.List;

import com.example.dto.CreateRoleDto;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/roles")
public class RoleController {

    // @Autowired
	private ModelMapper modelMapper;
    
    @Autowired
	RoleServiceImpl role_service;

	@GetMapping
    public List<RoleDto> getAllRoles() {
        modelMapper = new ModelMapper();
        List<Role>list_role= role_service.findAll();
        List<RoleDto> list_roleDto= new ArrayList<>();
        
        for (Role role : list_role) {
            RoleDto roleDto= modelMapper.map(role,RoleDto.class);
            list_roleDto.add(roleDto);
        }

        return  list_roleDto;
    }

    @GetMapping("/{id}")
    public RoleDto getRole(@PathVariable Integer id) {
        modelMapper = new ModelMapper();
        Role role= role_service.findRoleById(id);
        RoleDto roleDto= modelMapper.map(role,RoleDto.class);
        
        return  roleDto;
    }


    @PutMapping("/{id}")
    public void updateCategory(@RequestBody CreateRoleDto createRoleDto,@PathVariable Integer id){
        
        String  message = role_service.updateRole(createRoleDto,id);
        System.out.println(message);
    
    }

    @PostMapping
    public ResponseEntity<RoleDto> createCategory(@RequestBody CreateRoleDto createRoleDto){
    
        modelMapper = new ModelMapper();

        // convert DTO to entity
        Role role= modelMapper.map(createRoleDto, Role.class);

        // create_category
        role= role_service.saveRole(role);
        // return UserDto
        RoleDto roleDto= modelMapper.map(role,RoleDto.class);
        return ResponseEntity.ok().body(roleDto);

    }

    @DeleteMapping("/{id}")
    void deleteRole(@PathVariable Integer id) {
        String message=role_service.deleteRole(id);
    }

    
}
