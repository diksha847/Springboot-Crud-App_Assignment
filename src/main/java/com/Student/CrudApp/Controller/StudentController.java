package com.Student.CrudApp.Controller;
import com.Student.CrudApp.Entities.Student;

import com.Student.CrudApp.Repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/Student")
public class StudentController {


    @Autowired
    private StudentRepo stuRepo;

    @GetMapping("/")
    public List<Student> getAllStudents() {
        return stuRepo.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getUserById(@PathVariable("id") int id) {
        Student stu = stuRepo.findById(id).orElse(null);
        if (stu == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(stu, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Student> createUser(@RequestBody Student stu) {
        System.out.println("Student Object" + stu);
        Student savedStu = stuRepo.save(stu);
        return new ResponseEntity<>(savedStu, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> updateUser(@PathVariable("id") int id, @RequestBody Student stu) {
        Student currentStu = stuRepo.findById(id).orElse(null);
        if (currentStu == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        currentStu.setStuId(currentStu.getStuId());
        currentStu.setStuName(currentStu.getStuName());
        currentStu.setCity(currentStu.getCity());
        currentStu.setCourseName(currentStu.getCourseName());
        currentStu.setMarks(currentStu.getMarks());
        currentStu.setYearOfEnrollment(currentStu.getYearOfEnrollment());

        Student updatedStu = stuRepo.save(currentStu);
        return new ResponseEntity<>(updatedStu, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable("id") int id) {
        Student stu = stuRepo.findById(id).orElse(null);
        if (stu == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        stuRepo.delete(stu);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
