package org.example.Services;

import org.example.DTO.Student;

import java.util.List;
import java.util.UUID;

public interface StudentService {
    List<Student> getAllStudents();

    List<Student> addNewStudent(String firstName, String secondName, int dateOfBirthday, UUID groupID);
    List<Student> deleteStudentByID(UUID id);
}
