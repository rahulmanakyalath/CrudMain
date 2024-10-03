package com.example.CrudMain.Repository;

import com.example.CrudMain.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface StudentRepo extends JpaRepository<Student, Long> {

    @Query(value = "SELECT COUNT(*) FROM student WHERE student.name = ?1 and student.fathersname=?2",nativeQuery = true)
    int IsExsistingStudent(String student,String father);
}
