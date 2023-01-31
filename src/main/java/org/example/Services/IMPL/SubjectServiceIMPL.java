package org.example.Services.IMPL;

import org.example.DTO.Subject;
import org.example.Repository.IMPL.SubjectRepositoryIMPL;
import org.example.Repository.SubjectRepository;
import org.example.Services.SubjectService;

import java.util.List;

public class SubjectServiceIMPL implements SubjectService {
    @Override
    public void addSubjectBySpecializationID(String nameSpecialization) {
        SubjectRepository subjectRepository = new SubjectRepositoryIMPL();
        subjectRepository.addSubjectToStudentByStudentID(nameSpecialization);
    }

    @Override
    public List<Subject> getAllSubjects() {
        SubjectRepository subjectRepository = new SubjectRepositoryIMPL();
        return subjectRepository.getAllSubjects();
    }
}
