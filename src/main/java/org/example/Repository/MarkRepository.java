package org.example.Repository;

import org.example.DTO.Mark;

import java.util.List;
import java.util.UUID;

public interface MarkRepository {
    void addMArkBySpecializationID(UUID studentSpecializationID, UUID teacherID, int mark);
    List<Mark> getAllMarks();
}
