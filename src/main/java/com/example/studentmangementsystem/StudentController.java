package com.example.studentmangementsystem;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/students")
public class StudentController {
   private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getAllStudents()
    {
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public Optional<Student> getByID(@PathVariable UUID id)
    {
        Optional<Student> student = studentService.getByID(id);
        if(student!=null)
        {
            return new ResponseEntity<>(student, HttpStatus.OK).getBody();
        }
        else return new ResponseEntity<>(student,HttpStatus.NOT_FOUND).getBody();
    }

    @PostMapping("/create")
    public Student create(@RequestBody Student student)
    {
        return studentService.saveStudent(student);
    }

    @PutMapping("/update/{id}")
    public Student update(@RequestBody Student studentDetails,@PathVariable UUID id)
    {
        Optional<Student> optionalStudent=studentService.getByID(id);
        if(optionalStudent!=null)
        {
            Student student=optionalStudent.get();
            student.setName(studentDetails.getName());
            student.setEmail(studentDetails.getEmail());
            student.setAge(studentDetails.getAge());
            Student updatedstudent=studentService.saveStudent(student);
            return new ResponseEntity<>(updatedstudent, HttpStatus.OK).getBody();
        }
        else
        {
            return new ResponseEntity<>(studentDetails,HttpStatus.NOT_FOUND).getBody();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> delete(@PathVariable UUID id)
    {
        studentService.deleteStudent(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
