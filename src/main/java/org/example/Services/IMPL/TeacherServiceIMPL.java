package org.example.Services.IMPL;

import org.example.DTO.Teacher;
import org.example.Repository.IMPL.TeacherRepositoryIMPL;
import org.example.Repository.TeacherRepository;
import org.example.Services.TeacherService;

import java.util.List;
import java.util.UUID;

public class TeacherServiceIMPL implements TeacherService {
    @Override
    public void addNewTeacher(String firstName, String secondName, UUID subjectID) {
        TeacherRepository teacherRepository = new TeacherRepositoryIMPL();
        teacherRepository.addNewTeacher(firstName,secondName,subjectID);
    }

    @Override
    public List<Teacher> getAllTeachers() {
        TeacherRepository teacherRepository = new TeacherRepositoryIMPL();
        return teacherRepository.getAllTeachers();
    }
}
