package com.example.CrudMain;


import com.example.CrudMain.Entity.Student;
import com.example.CrudMain.Repository.StudentRepo;
import com.example.CrudMain.Service.StudentService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class crudMainTest {

    @Autowired
    private StudentService studentService;

    @MockBean
    private StudentRepo studentRepo;


    @Test
    public void getAllStudentTest(){

        Student std = new Student();
        std.setId(12L);
        std.setName("Rahul");
        std.setFather("sunil");
        std.setAge(12);
        std.setDob("12-23-4321");
        std.setPhnumber("123456");
        std.setGender("MALE");
        Student std2 = new Student();
        std.setId(13L);
        std.setName("Ram");
        std.setFather("sunil");
        std.setAge(11);
        std.setDob("12-23-1234");
        std.setPhnumber("987654");
        std.setGender("MALE");

        List<Student> sd = new ArrayList<>();
        sd.add(std);
        sd.add(std2);
        when(studentRepo.findAll()).thenReturn(sd);

        assertEquals(2,studentService.fullList().size());
    }
    @Test
    public void getUserByPhoneNumber()
    {
        Student std1 = new Student();
        std1.setId(13L);
        std1.setName("Ram");
        std1.setFather("sunil");
        std1.setAge(11);
        std1.setDob("12-23-1234");
        std1.setPhnumber("987654");
        std1.setGender("MALE");

        when(studentRepo.Studentdetails("Ram","sunil")).thenReturn(std1);
        assertEquals(std1,studentService.getStudentDetails("Ram","sunil"));
    }
}
