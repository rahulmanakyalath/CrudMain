package com.example.CrudMain.Controller;


import com.example.CrudMain.Entity.Student;
import com.example.CrudMain.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Student")
public class StudentController {


    @Autowired
    StudentService studentService;


    @PostMapping("/details")
    public ResponseEntity<String> saveStudentDetails(@RequestBody Student student){
         System.out.println("reached controller");
        String str = "same user exists";

        if(studentService.studentRegistration(student)!=null){
            System.out.println("reached controller 2");
            str = "success";
        }
        System.out.println("reached controller3");
        return ResponseEntity.ok(str);
    }


}
