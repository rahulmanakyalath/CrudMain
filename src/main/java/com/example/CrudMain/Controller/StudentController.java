package com.example.CrudMain.Controller;


import com.example.CrudMain.Entity.Student;
import com.example.CrudMain.Enumerations.Gender;
import com.example.CrudMain.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Student")
public class StudentController {


    @Autowired
    StudentService studentService;


    @PostMapping("/details")
    public ResponseEntity<String> saveStudentDetails(
                                                     @RequestParam String name,
                                                     @RequestParam String fathersname,
                                                     @RequestParam int age,
                                                     @RequestParam String dob,
                                                     @RequestParam String phnum,
                                                     @RequestParam Gender gender){

        Student student = new Student();
        student.setName(name.toUpperCase());
        student.setFather(fathersname.toUpperCase());
        student.setAge(age);
        student.setDob(dob);
        student.setPhnumber(phnum);
        student.setGender(String.valueOf(gender));

         System.out.println("reached controller");
        String str = "same user exists";

        if(studentService.studentRegistration(student)!=null){
            System.out.println("reached controller 2");
            str = "success";
        }
        System.out.println("reached controller3");
        return ResponseEntity.ok(str);
    }
    @PutMapping("/details")
    public ResponseEntity<String> updateStudentDetails(
            @RequestParam String name,
            @RequestParam String fathersname,
            @RequestParam int age,
            @RequestParam String dob,
            @RequestParam String phnum,
            @RequestParam Gender gender){

        Student student = new Student();
        student.setName(name.toUpperCase());
        student.setFather(fathersname.toUpperCase());
        student.setAge(age);
        student.setDob(dob);
        student.setPhnumber(phnum);
        student.setGender(String.valueOf(gender));

        System.out.println("reached controller");
        String str = "user not updated";

        if(studentService.studentUpdation(student)!=null){
            str = "successfully updated";
        }
        return ResponseEntity.ok(str);
    }

    @GetMapping("/details/{name}/{fathersname}")
    public ResponseEntity<Student> getStudentDetails(@PathVariable  String name,
                                                      @PathVariable String fathersname){

        Student std = new Student();
        std = studentService.getStudentDetails(name,fathersname);
        if(std!=null)
        {
            return new ResponseEntity<>(std, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/details/All")
    @PreAuthorize("ADMIN")
    public ResponseEntity<List<Student>> getAllAvailableStudents(){


            return new ResponseEntity<>(studentService.fullList(), HttpStatus.OK);
    }
    @DeleteMapping("/delete/{phnumber}")
    public ResponseEntity<String> deleteStudent(@PathVariable String phnumber )
    {


        String std = studentService.deleteStudentDetails(phnumber);

            return new ResponseEntity<>(std, HttpStatus.OK);

    }

}
