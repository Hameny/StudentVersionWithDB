package org.example.Services.IMPL;

import org.example.Services.StudentSubjectService;

import java.util.UUID;

public class StudentSubjectServiceIMPL implements StudentSubjectService {
    @Override
    public void addSubjectToStudentByStudentID(UUID studentID, UUID specializationID) {
        StudentSubjectService studentSubjectService = new StudentSubjectServiceIMPL();
        studentSubjectService.addSubjectToStudentByStudentID(studentID, specializationID);
    }
}
