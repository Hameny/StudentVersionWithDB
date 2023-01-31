package org.example.Repository;

import org.example.DTO.Student;

import java.util.List;
import java.util.UUID;

public interface StudentRepository {
    List<Student> getAllStudents();

    List<Student> addNewStudent(String firstName, String secondNAme, int dateOfBirthday, UUID groupID);
    List<Student> deleteStudentByID(UUID id);
}
