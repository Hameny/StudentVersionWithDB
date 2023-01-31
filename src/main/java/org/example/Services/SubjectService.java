package org.example.Services;

import org.example.DTO.Subject;

import java.util.List;

public interface SubjectService {
    void addSubjectBySpecializationID(String nameSubject);
    List<Subject> getAllSubjects();
}
