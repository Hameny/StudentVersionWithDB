package org.example.Services.IMPL;

import org.example.DTO.Subject;
import org.example.Repository.IMPL.SubjectRepositoryIMPL;
import org.example.Repository.SubjectRepository;
import org.example.Services.SubjectService;

import java.util.List;
import java.util.UUID;

public class SubjectServiceIMPL implements SubjectService {
    @Override
    public void addNewSubject(String nameSubject) {
        SubjectRepository subjectRepository = new SubjectRepositoryIMPL();
        subjectRepository.addNewSubject(nameSubject);
    }

    @Override
    public List<Subject> getAllSubjects() {
        SubjectRepository subjectRepository = new SubjectRepositoryIMPL();
        return subjectRepository.getAllSubjects();
    }

    @Override
    public List<Subject> getSubjectByID(UUID id) {
        SubjectRepository subjectRepository = new SubjectRepositoryIMPL();
        return subjectRepository.getSubjectByID(id);
    }
}
