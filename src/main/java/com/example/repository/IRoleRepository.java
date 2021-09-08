package com.example.repository;

import com.example.entity.Role;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRoleRepository  extends JpaRepository<Role, Integer> { 
}