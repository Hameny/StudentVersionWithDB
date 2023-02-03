package org.example.Services.IMPL;

import org.example.DTO.Mark;
import org.example.Repository.IMPL.MarkRepositoryIMPLJDBC;
import org.example.Repository.MarkRepository;
import org.example.Services.MarkService;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public class MarkServiceIMPL implements MarkService {
    @Override
    public void addMarkToStudentBySubjectID(UUID studentSubjectID, UUID teacherID, Date dateMark, int mark) {
        MarkRepository markRepository = new MarkRepositoryIMPLJDBC();
        markRepository.addMArkBySpecializationID(studentSubjectID,teacherID,dateMark,mark);
    }

    @Override
    public List<Mark> getAllMarks() {
        MarkRepository markRepository = new MarkRepositoryIMPLJDBC();
        return markRepository.getAllMarks();
    }
}
