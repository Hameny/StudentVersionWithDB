package org.example.Services;

import org.example.DTO.Student;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public interface StudentService {
    List<Student> getAllStudents();
    List<Student> getAllDeleteStudents();

    void addNewStudent(String firstName, String secondName, Date dateOfBirthday);
    void deleteStudentByID(UUID id);
    List<Student> findStudentById(UUID id);
    void addStudentToGroupById(UUID studentId,UUID groupID);
    List<Student> getAllInformationAboutStudent(UUID id);
}
