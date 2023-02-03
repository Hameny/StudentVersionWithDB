package org.example.Repository.IMPL;

import org.example.DTO.Subject;
import org.example.Repository.SubjectRepository;
import org.example.util.ConnectionManager;

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
    public void addSubjectToStudentByStudentID(String nameSubject) {
//        try (FileWriter fileWriter = new FileWriter("resources/subjects.txt", true)) {
//
//            Subject subject = new Subject(nameSubject);
//            String s = subject.getSubjectID() + "," + subject.getSubjectName();
//            fileWriter.write(s + "\n");
//
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
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
}
