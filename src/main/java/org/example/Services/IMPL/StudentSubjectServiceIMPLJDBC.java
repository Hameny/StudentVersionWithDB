package org.example.Services.IMPL;

import org.example.Services.StudentSubjectService;

import java.util.UUID;

public class StudentSubjectServiceIMPLJDBC implements StudentSubjectService {
    @Override
    public void addStudentSubjectToStudentIDANDSubjectID(UUID studentID, UUID specializationID) {
        StudentSubjectService studentSubjectService = new StudentSubjectServiceIMPLJDBC();
        studentSubjectService.addStudentSubjectToStudentIDANDSubjectID(studentID, specializationID);
    }
}
