package com.example.CrudMain;


import com.example.CrudMain.Entity.Student;
import com.example.CrudMain.Repository.StudentRepo;
import com.example.CrudMain.Service.StudentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

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

    @Test
    public void saveStudentTest(){

        Student std1 = new Student();
        std1.setId(13L);
        std1.setName("Ram");
        std1.setFather("sunil");
        std1.setAge(11);
        std1.setDob("12-23-1234");
        std1.setPhnumber("987654");
        std1.setGender("MALE");

        when(studentRepo.save(std1)).thenReturn(std1);
        assertEquals(std1,studentService.studentRegistration(std1));
        //when(studentRepo.UpdateStudentdetails(14,"123","Ram","sunil")).thenReturn(1);

    }

    @Test
    public void updateStudentTest(){

        Student std1 = new Student();
        std1.setId(13L);
        std1.setName("Ram");
        std1.setFather("sunil");
        std1.setAge(12);
        std1.setDob("12-23-1234");
        std1.setPhnumber("9876545");
        std1.setGender("MALE");

        Student std2 = new Student();
        std2.setId(13L);
        std2.setName("Ram");
        std2.setFather("sunil");
        std2.setAge(14);
        std2.setDob("12-23-1234");
        std2.setPhnumber("98765456");
        std2.setGender("MALE");

        studentRepo.save(std1);
        when(studentRepo.IsExsistingStudent("Ram","sunil")).thenReturn(1);
        when(studentRepo.UpdateStudentdetails(14,"98765456","Ram","sunil")).thenReturn(1);
        studentService.studentUpdation(std2);
        verify(studentRepo,times(1)).UpdateStudentdetails(14,"98765456","Ram","sunil");


    }

    @Test
    public void deleteStudentTest(){

        Student std1 = new Student();
        std1.setId(13L);
        std1.setName("Ram");
        std1.setFather("sunil");
        std1.setAge(11);
        std1.setDob("12-23-1234");
        std1.setPhnumber("987654");
        std1.setGender("MALE");

        when(studentRepo.findStudentdetails("987654")).thenReturn(std1);//this methof is called in the delete function so we need to mock this repo method too.
        when(studentRepo.DeleteStudentdetails("987654")).thenReturn(1);//this methof is called in the delete function so we need to mock this repo method too.
        studentService.deleteStudentDetails("987654");
        verify(studentRepo,times(1)).DeleteStudentdetails("987654");
    }
}
