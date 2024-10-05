package com.example.CrudMain.Repository;

import com.example.CrudMain.Entity.Student;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface StudentRepo extends JpaRepository<Student, Long> {

    @Query(value = "SELECT COUNT(*) FROM student WHERE student.name = ?1 and student.fathersname=?2",nativeQuery = true)
    int IsExsistingStudent(String student,String father);

    @Query(value = "SELECT * FROM student WHERE student.name = ?1 and student.fathersname=?2",nativeQuery = true)
    Student Studentdetails(String student,String father);
    @Query(value = "SELECT * FROM student WHERE student.phnumber = ?1",nativeQuery = true)
    Student findStudentdetails(String phnumber);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM student WHERE student.phnumber = ?1",nativeQuery = true)
     int DeleteStudentdetails(String phnumber);

    @Transactional
    @Modifying
    @Query(value = "update student set age =?1,phnumber=?2 where student.name =?3 and student.fathersname =?4",nativeQuery = true)
    int UpdateStudentdetails(int age,String ph,String name,String father);
}
