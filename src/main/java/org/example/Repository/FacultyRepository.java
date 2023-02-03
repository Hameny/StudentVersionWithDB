package org.example.Repository;

import org.example.DTO.Faculty;

import java.util.List;

public interface FacultyRepository {
    List<Faculty> getALLFaculties();

    List<Faculty> addNewFaculty(String nameOfFaculty);
}
