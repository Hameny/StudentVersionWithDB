package org.example.Services;

import org.example.DTO.Faculty;

import java.util.List;

public interface FacultyService {
    void addFaculty(String nameOfFacultet);

    List<Faculty> getAllFaculties();
}
