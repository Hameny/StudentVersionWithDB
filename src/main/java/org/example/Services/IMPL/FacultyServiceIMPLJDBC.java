package org.example.Services.IMPL;

import org.example.DTO.Faculty;
import org.example.Repository.FacultyRepository;
import org.example.Repository.IMPL.FacultyRepositoryIMPLJDBC;
import org.example.Services.FacultyService;

import java.util.List;

public class FacultyServiceIMPLJDBC implements FacultyService {
    @Override
    public void addFaculty(String nameOfFaculty) {
        FacultyRepository facultyRepository = new FacultyRepositoryIMPLJDBC();
        facultyRepository.addNewFaculty(nameOfFaculty);

    }

    @Override
    public List<Faculty> getAllFaculties() {

        FacultyRepository facultyRepository = new FacultyRepositoryIMPLJDBC();
        return facultyRepository.getALLFaculties();
    }
}
