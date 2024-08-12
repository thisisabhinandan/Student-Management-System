package com.example.studentmangementsystem;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface StudentRepository extends JpaRepository<Student,UUID> {

        Optional<Student> findById(UUID id);
        void deleteById(UUID id);
}


