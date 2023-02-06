package org.example.Repository;

import org.example.DTO.Subject;

import java.util.List;
import java.util.UUID;

public interface SubjectRepository {
    List<Subject> addNewSubject(String nameSubject);

    List<Subject> getSubjectByStudentID(UUID fromString);

    List<Subject> getAllSubjects();
    List<Subject> getSubjectByID(UUID id);
}
