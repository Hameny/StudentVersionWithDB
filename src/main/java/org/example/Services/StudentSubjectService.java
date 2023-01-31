package org.example.Services;

import java.util.UUID;

public interface StudentSubjectService {
    void addSubjectToStudentByStudentID(UUID studentID, UUID specializationID);
}
