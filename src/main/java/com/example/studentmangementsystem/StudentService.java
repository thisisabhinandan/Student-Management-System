package com.example.studentmangementsystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class StudentService {
    @Autowired
    private StudentRepository StudentRepo;

    public List<Student> getAllStudents()
    {
        return StudentRepo.findAll();
    }
    public Optional<Student> getByID(UUID id)
    {
        return StudentRepo.findById(id);
    }
    public Student saveStudent(Student student)
    {
        return StudentRepo.save(student);
    }
    public void deleteStudent(UUID id)
    {
        StudentRepo.deleteById(id);
    }
}
