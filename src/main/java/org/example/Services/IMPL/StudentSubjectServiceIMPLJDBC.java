package org.example.Services.IMPL;

import org.example.Repository.IMPL.StudentSubjectRepositoryIMPLJDBC;
import org.example.Repository.StudentSubjectRepository;
import org.example.Services.StudentSubjectService;

import java.util.UUID;

public class StudentSubjectServiceIMPLJDBC implements StudentSubjectService {
    @Override
    public void addStudentSubjectToStudentIDANDSubjectID(UUID studentID, UUID subjectID) {
        StudentSubjectRepository studentSubjectRepository = new StudentSubjectRepositoryIMPLJDBC();
        studentSubjectRepository.addStudentSubjectToStudentIDANDSubjectID(studentID, subjectID);
    }
}
