package org.example.Repository;

import org.example.DTO.Email;
import org.example.DTO.Faculty;

import java.util.List;
import java.util.UUID;

public interface FacultyRepository {
    List<Faculty> getALLFaculties();

    List<Faculty> addNewFaculty(String nameOfFaculty);
}
