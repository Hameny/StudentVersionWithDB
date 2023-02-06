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
    public List<Student> getAllDeleteStudents() {
        StudentRepository studentRepository = new StudentRepositoryIMPLJDBC();
        return studentRepository.getAllDeleteStudents();
    }

    @Override
    public void addNewStudent(String firstName, String secondName, Date dateOfBirthday) {
        StudentRepository studentRepository = new StudentRepositoryIMPLJDBC();
        studentRepository.addNewStudent(firstName,secondName, dateOfBirthday);
    }

    @Override
    public void deleteStudentByID(UUID id) {
        StudentRepository studentRepository = new StudentRepositoryIMPLJDBC();
        studentRepository.deleteStudentByID(id);
    }

    @Override
    public List<Student> findStudentById(UUID id) {
        StudentRepository studentRepository = new StudentRepositoryIMPLJDBC();
        return studentRepository.findStudentById(id);
    }

    @Override
    public void addStudentToGroupById(UUID studentId, UUID groupID) {
        StudentRepository studentRepository = new StudentRepositoryIMPLJDBC();
        studentRepository.addStudentToGroupById(studentId,groupID);
    }
}
