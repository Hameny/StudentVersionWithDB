package org.example.Repository.IMPL;

import org.example.DTO.StudentSubject;
import org.example.Repository.StudentSubjectRepository;
import org.example.util.ConnectionManager;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class StudentSubjectRepositoryIMPLJDBC implements StudentSubjectRepository {
    List<StudentSubject> studentSubjectList = new ArrayList<>();
    Statement statement = null;
    public List<StudentSubject> addStudentSubjectToStudentIDANDSubjectID(UUID studentID, UUID subjectID) {
        String insertTeacher = "INSERT INTO public.student_subject (student_id,subject_id )VALUES (?,?);";
        try {
            PreparedStatement preparedStatement = ConnectionManager.open().prepareStatement(insertTeacher);
            preparedStatement.setObject(1, studentID);
            preparedStatement.setObject(2, subjectID);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return studentSubjectList;
    }


    @Override
    public List<StudentSubject> getStudentSubjectToStudentByID(UUID studentID, UUID specializationID) {

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
