package org.example.Repository.IMPL;

import org.example.DTO.StudentSubject;
import org.example.Repository.StudentSubjectRepository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class StudentSubjectRepositoryIMPL implements StudentSubjectRepository {
    public void addSubjectBySubjectID(UUID studentID, UUID specializationID) {
        try (FileWriter fileWriter = new FileWriter("resources/studentSpecialization.txt", true)) {

            StudentSubject studentSubject = new StudentSubject(studentID, specializationID);
            String s = studentSubject.getId() + "," + studentSubject.getStudentID() + "," +
                    studentSubject.getSpecializationsID();
            fileWriter.write(s + "\n");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public List<StudentSubject> getStudentSubjectToStudentByID(UUID studentID, UUID specializationID) {
        List<StudentSubject> studentSubjectList = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("resources/studentSpecialization.txt"))) {
            String line = reader.readLine();
            while (line != null) {
                String[] s = line.split(",");
                StudentSubject studentSubject =
                        new StudentSubject(UUID.fromString(s[0]), UUID.fromString(s[1]), UUID.fromString(s[2]));
                if (studentSubject.getStudentID().equals(studentID) &&
                        studentSubject.getSpecializationsID().equals(specializationID)) {
                    studentSubjectList.add(studentSubject);
                }
                line = reader.readLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return studentSubjectList;
    }
}
