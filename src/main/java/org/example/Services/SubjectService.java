package org.example.Services;

import org.example.DTO.Subject;

import java.util.List;
import java.util.UUID;

public interface SubjectService {
    void addNewSubject(String nameSubject);
    List<Subject> getAllSubjects();
    List<Subject> getSubjectByID(UUID id);
}
