package org.example.Repository;

import org.example.DTO.Student;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public interface StudentRepository {
    List<Student> getAllStudents();
    List<Student> getAllDeleteStudents();

    List<Student> addNewStudent(String firstName, String secondNAme, Date dateOfBirthday);
    List<Student> deleteStudentByID(UUID id);
    List<Student> findStudentById(UUID id);
    List<Student> addStudentToGroupById(UUID studentId,UUID groupID);
}
