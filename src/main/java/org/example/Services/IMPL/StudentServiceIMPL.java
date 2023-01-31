package org.example.Services.IMPL;

import org.example.DTO.Student;
import org.example.Repository.IMPL.StudentRepositoryIMPL;
import org.example.Repository.StudentRepository;
import org.example.Services.StudentService;

import java.util.List;
import java.util.UUID;

public class StudentServiceIMPL implements StudentService {


    @Override
    public List<Student> getAllStudents() {
        StudentRepository studentRepository = (StudentRepository) new StudentRepositoryIMPL();
        return studentRepository.getAllStudents();
    }

    @Override
    public List<Student> addNewStudent(String firstName, String secondName, int dateOfBirthday, UUID groupID) {
        StudentRepository studentRepository = (StudentRepository) new StudentRepositoryIMPL();
        return studentRepository.addNewStudent(firstName,secondName, dateOfBirthday,groupID);
    }

    @Override
    public List<Student> deleteStudentByID(UUID id) {
        StudentRepository studentRepository = (StudentRepository) new StudentRepositoryIMPL();
        return studentRepository.deleteStudentByID(id);
    }
}
