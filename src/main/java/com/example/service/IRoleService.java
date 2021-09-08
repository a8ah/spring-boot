package com.example.service;

import java.util.List;

import com.example.dto.CreateRoleDto;
import com.example.entity.Role;

public interface IRoleService {
    
    public List<Role> findAll();

	public Role findRoleById(Integer id);

	public Role saveRole(Role role);

	public String deleteRole(Integer id);

	public String updateRole(CreateRoleDto createRoleDto, int id);
    
}
