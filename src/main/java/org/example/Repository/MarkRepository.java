package org.example.Repository;

import org.example.DTO.Mark;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public interface MarkRepository {
    List<Mark> addMArkBySpecializationID(UUID studentSpecializationID, UUID teacherID, Date dateMark, int mark);
    List<Mark> getAllMarks();
}
