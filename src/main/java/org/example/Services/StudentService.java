package org.example.Services;

import org.example.DTO.Student;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public interface StudentService {
    List<Student> getAllStudents();

    List<Student> addNewStudent(String firstName, String secondName, Date dateOfBirthday);
    List<Student> deleteStudentByID(UUID id);
}
