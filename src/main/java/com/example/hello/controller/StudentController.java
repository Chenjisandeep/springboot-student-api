package com.example.hello.controller;

import com.example.hello.model.Student;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;

@RestController
public class StudentController {

        List<Student> students=new ArrayList<>();

        @PostMapping("/student")
        public Student addStudent(@RequestBody Student student){
            
            students.add(student);
            return student;
        }

        @GetMapping("/students")
        public List<Student> getStudents() {
            return students;
        }

        @GetMapping("/students/{id}")
        public Object getStudent(@PathVariable int id){
            for(Student student:students){
                if(student.getId()==id){
                    return student;
                }
            }
            return "Studen Not Found";
        }


        @PutMapping("/students/{id}")
        public Student updateStudent(@PathVariable int id, @RequestBody Student updatedStudent) {
            //TODO: process PUT request
            for(Student student:students){

            
            if(student.getId()==id){
                student.setName(updatedStudent.getName());
                student.setAge(updatedStudent.getAge());
                return student;
            }
            
           
        }
        return null;
        }

        @DeleteMapping("/students/{id}")
        public String deleteStudent(@PathVariable int id){
            for(Student student: students){
                if(student.getId()==id){
                    students.remove(student);

                    return "Student Deleted Successfully";
                }
            }
            return "Student Not Found";
        }
        
}
