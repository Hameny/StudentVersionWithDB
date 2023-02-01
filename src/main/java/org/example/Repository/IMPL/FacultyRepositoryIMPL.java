package org.example.Repository.IMPL;

import org.example.DTO.Faculty;
import org.example.Repository.FacultyRepository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class FacultyRepositoryIMPL implements FacultyRepository {
    List<Faculty> facultyArrayList = new ArrayList<>();


    @Override
    public List<Faculty> getALLFaculties() {
        try (BufferedReader reader = new BufferedReader(new FileReader("resources/faculty.txt"))) {
            String line = reader.readLine();
            while (line != null) {
                String[] s = line.split(",");
                Faculty faculty = new Faculty(UUID.fromString(s[0]), s[1]);
                facultyArrayList.add(faculty);
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return facultyArrayList;
    }

    @Override
    public List<Faculty> addNewFaculty(String nameOfFaculty) {
        try (FileWriter fileWriter = new FileWriter("resources/faculty.txt", true)) {

            Faculty faculty = new Faculty(nameOfFaculty);
            String s = faculty.getId().toString() + "," + faculty.getNameOfFaculty();
            fileWriter.write(s + "\n");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return facultyArrayList;
    }
}
