package com.example.service;

import java.util.List;
import java.util.Optional;

import com.example.dto.CreateRoleDto;
import com.example.entity.Role;
import com.example.repository.IRoleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements IRoleService {

    @Autowired
    IRoleRepository repo;

    @Override
    public List<Role> findAll() {
        return repo.findAll();
    }

    @Override
    public Role findRoleById(Integer id) {
        Optional<Role> role= repo.findById(id);       
        return role.get();
    }

    @Override
    public Role saveRole(Role role) {
        return repo.save(role);
    }

    @Override
    public String deleteRole(Integer id) {
        String message="Role not found";
        if(repo.findById(id)!=null){
        repo.deleteById(id);
        message="Succesful deleted";
        }
        return message;
    }

    @Override
    public String updateRole(CreateRoleDto createRoleDto, int id) {
        String message="Role not found";
        
        Role role= this.findRoleById(id);
        if(role!=null){
            role.setName(createRoleDto.getName());
            repo.save(role);               
            message="Succesful updated";
        }
        
        return message;
    }
    
}
