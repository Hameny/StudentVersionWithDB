package org.example.Services;

import org.example.DTO.Mark;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public interface MarkService {
    void addMarkToStudentBySubjectID(UUID studentSubjectID, UUID teacherID, Date dateMark, int mark);
    List<Mark> getAllMarks();
}
