package org.example.Repository;

import org.example.DTO.StudentSubject;

import java.util.List;
import java.util.UUID;

public interface StudentSubjectRepository {
    List<StudentSubject> addStudentSubjectToStudentIDANDSubjectID(UUID studentID, UUID specializationID);
    List<StudentSubject> getStudentSubjectToStudentByID(UUID studentID, UUID specializationID);
}
