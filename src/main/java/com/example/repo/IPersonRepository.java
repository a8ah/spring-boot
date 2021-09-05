package com.example.repo;
import java.util.List;

import com.example.entity.Person;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPersonRepository extends JpaRepository<Person, Long> {

    List<Person> findByEmail(String email);

    Person findById(long id);
}
