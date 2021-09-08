package com.example.repository;

import com.example.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPersonRepository extends JpaRepository<Person, Long> {

    List<Person> findByEmail(String email);

    Person findById(long id);
}
