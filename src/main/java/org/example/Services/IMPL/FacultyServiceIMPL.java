package org.example.Services.IMPL;

import org.example.DTO.Faculty;
import org.example.Repository.FacultyRepository;
import org.example.Repository.IMPL.FacultyRepositoryIMPL;
import org.example.Services.FacultyService;

import java.util.List;

public class FacultyServiceIMPL implements FacultyService {
    @Override
    public void addFaculty(String nameOfFaculty) {
        FacultyRepository facultyRepository = new FacultyRepositoryIMPL();
        facultyRepository.addNewFaculty(nameOfFaculty);

    }

    @Override
    public List<Faculty> getAllFaculties() {

        FacultyRepository facultyRepository = new FacultyRepositoryIMPL();
        return facultyRepository.getALLFaculties();
    }
}
