package org.example.Services.IMPL;

import org.example.DTO.Mark;
import org.example.Repository.IMPL.MarkRepositoryIMPL;
import org.example.Repository.MarkRepository;
import org.example.Services.MarkService;

import java.util.List;
import java.util.UUID;

public class MarkServiceIMPL implements MarkService {
    @Override
    public void addMarkToStudentBySubjectID(UUID studentSubjectID, UUID teacherID, int mark) {
        MarkRepository markRepository = new MarkRepositoryIMPL();
        markRepository.addMArkBySpecializationID(studentSubjectID,teacherID,mark);
    }

    @Override
    public List<Mark> getAllMarks() {
        MarkRepository markRepository = new MarkRepositoryIMPL();
        return markRepository.getAllMarks();
    }
}
