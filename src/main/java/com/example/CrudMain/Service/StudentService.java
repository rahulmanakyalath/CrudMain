package com.example.CrudMain.Service;


import com.example.CrudMain.Entity.Student;
import com.example.CrudMain.Repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
    public Student studentUpdation(Student student){

        Student udt =null;
        int count = studentRepo.IsExsistingStudent(student.getName(),student.getFather());
        if(count==1){
            System.out.println("exsisting student" +student.getName()+student.getName());
            studentRepo.UpdateStudentdetails(student.getAge(),student.getPhnumber(),student.getName(),student.getFather());
            udt=student;
        }
        return udt;
    }

    public Student getStudentDetails(String name, String fatehrname){
        Student std =studentRepo.Studentdetails(name,fatehrname);
        System.out.println(std);

        return std;

    }

    public List<Student> fullList(){
        List<Student> lists = new ArrayList<>();

        lists = studentRepo.findAll();
        return lists;
    }
    public String deleteStudentDetails(String phnumber){
        String delete = "Student not deleted";
        if(studentRepo.findStudentdetails(phnumber)!=null) {
            delete = "Student deleted";
            int i = studentRepo.DeleteStudentdetails(phnumber);
            System.out.println("delete index :- " + i);
        }
        return delete;

    }

}
