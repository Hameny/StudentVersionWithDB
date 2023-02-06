package org.example.Repository.IMPL;

import org.example.DTO.Subject;
import org.example.Repository.SubjectRepository;
import org.example.util.ConnectionManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class SubjectRepositoryIMPL implements SubjectRepository {
    List<Subject> subjectArrayList = new ArrayList<>();
    Statement statement = null;

    @Override
    public List<Subject> addNewSubject(String nameSubject) {
        String insertFaculty = "INSERT INTO public.subjects(name_of_subject) VALUES  (?)";
        try {
            PreparedStatement preparedStatement = ConnectionManager.open().prepareStatement(insertFaculty);
            preparedStatement.setString(1, nameSubject);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return subjectArrayList;
    }

    @Override
    public List<Subject> getSubjectByStudentID(UUID subjectID) {
//
//        try (BufferedReader reader = new BufferedReader(new FileReader("resources/subjects.txt"))) {
//            String line = reader.readLine();
//            while (line != null) {
//                String[] s = line.split(",");
//                Subject subject = new Subject(UUID.fromString(s[0]), s[1]);
//                if (subject.getSubjectID().equals(subjectID)) {
//                    subjectArrayList.add(subject);
//                }
//                line = reader.readLine();
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        return null;
    }

    @Override
    public List<Subject> getAllSubjects() {
        try {
            statement = ConnectionManager.open().createStatement();
            String select = "SELECT * FROM subjects";
            ResultSet resultSet = statement.executeQuery(select);
            while (resultSet.next()) {
                subjectArrayList.add(new Subject(UUID.fromString(resultSet.getString("id")),
                        resultSet.getString("name_of_subject")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return subjectArrayList;
    }

    @Override
    public List<Subject> getSubjectByID(UUID id) {
        String select = "SELECT * FROM subjects where id = ?";
        try {
            PreparedStatement preparedStatement = ConnectionManager.open().prepareStatement(select);
            preparedStatement.setObject(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){

                UUID uuidId = (UUID) resultSet.getObject(1);
                String nameOfSubject = resultSet.getString(2);
                Subject subject = new Subject(uuidId, nameOfSubject);
                System.out.println(subject);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return subjectArrayList;
    }
}
