package org.example.Services;

import org.example.DTO.Teacher;

import java.util.List;
import java.util.UUID;

public interface TeacherService {
    List<Teacher> addNewTeacher(String firstName, String secondName, UUID subjectID);
    List<Teacher> getAllTeachers();
}
