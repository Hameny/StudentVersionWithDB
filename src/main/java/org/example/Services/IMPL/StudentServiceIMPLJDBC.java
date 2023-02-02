package org.example.Services.IMPL;

import org.example.DTO.Student;
import org.example.Repository.IMPL.StudentRepositoryIMPLJDBC;
import org.example.Repository.StudentRepository;
import org.example.Services.StudentService;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public class StudentServiceIMPLJDBC implements StudentService {
    @Override
    public List<Student> getAllStudents() {
        StudentRepository studentRepository = new StudentRepositoryIMPLJDBC();
        return studentRepository.getAllStudents();
    }

    @Override
    public List<Student> addNewStudent(String firstName, String secondName, Date dateOfBirthday) {
        StudentRepository studentRepository = new StudentRepositoryIMPLJDBC();
        return studentRepository.addNewStudent(firstName,secondName, dateOfBirthday);
    }

    @Override
    public List<Student> deleteStudentByID(UUID id) {
        return null;
    }
}
