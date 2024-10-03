package com.example.CrudMain.Service;


import com.example.CrudMain.Entity.Student;
import com.example.CrudMain.Repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {


    @Autowired
    StudentRepo studentRepo;

    public Student studentRegistration(Student student){

        Student udt =null;
        if(studentRepo.IsExsistingStudent(student.getName(),student.getFather())==0){
            System.out.println("reached service");
            studentRepo.save(student);
            udt=student;
        }
        return udt;
    }
}
