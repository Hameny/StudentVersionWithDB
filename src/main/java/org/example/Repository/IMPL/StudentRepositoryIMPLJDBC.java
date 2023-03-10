package org.example.Repository.IMPL;

import org.example.DTO.Student;
import org.example.Repository.StudentRepository;
import org.example.util.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class StudentRepositoryIMPLJDBC implements StudentRepository {
    List<Student> studentList = new ArrayList<>();
    Statement statement = null;

    @Override
    public List<Student> getAllStudents() {

        try {
            statement = ConnectionManager.open().createStatement();
            String select = "SELECT * FROM Students";
            ResultSet resultSet = statement.executeQuery(select);
            while (resultSet.next()) {
                studentList.add(new Student(UUID.fromString(resultSet.getString("id")),
                        resultSet.getString("first_name"), resultSet.getString("second_name"),
                        resultSet.getDate("date_of_birthday"),resultSet.getBoolean("isDelete"),UUID.fromString(resultSet.getString("id"))));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return studentList;
    }

    @Override
    public List<Student> getAllDeleteStudents() {
        try {
            statement = ConnectionManager.open().createStatement();
            String select = "SELECT * FROM Students WHERE \"isDelete\" = true";
            ResultSet resultSet = statement.executeQuery(select);
            while (resultSet.next()) {
                studentList.add(new Student(UUID.fromString(resultSet.getString("id")),
                        resultSet.getString("first_name"), resultSet.getString("second_name"),
                        resultSet.getDate("date_of_birthday"),resultSet.getBoolean("isDelete"),UUID.fromString(resultSet.getString("id"))));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return studentList;
    }


    @Override
    public List<Student> addNewStudent(String firstName, String secondName, Date dateOfBirthday) {
        String insertStudent = "INSERT INTO public.students (first_name,second_name,date_of_birthday)  VALUES (?,?,?)";
        try {
            PreparedStatement preparedStatement = ConnectionManager.open().prepareStatement(insertStudent);
            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, secondName);
            preparedStatement.setObject(3, dateOfBirthday, Types.DATE);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return studentList;
    }

    @Override
    public List<Student> deleteStudentByID(UUID id) {
        String insertStudent = "UPDATE students SET \"isDelete\" = true WHERE id =?";
        try {
            PreparedStatement preparedStatement = ConnectionManager.open().prepareStatement(insertStudent);
            preparedStatement.setObject(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return studentList;
    }

    @Override
    public List<Student> findStudentById(UUID id) {
        String insertStudent = "SELECT * FROM public.students  WHERE id = ?";
        try {
            PreparedStatement preparedStatement = ConnectionManager.open().prepareStatement(insertStudent);
            preparedStatement.setObject(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){

                UUID uuidId = (UUID) resultSet.getObject(1);
                String firstName = resultSet.getString(2);
                String secondName = resultSet.getString(3);
                Date date = resultSet.getDate(4);
                boolean isDelete = resultSet.getBoolean(5);
                UUID groupId = (UUID) resultSet.getObject(6);
                Student student = new Student(uuidId, firstName,
                        secondName, date, isDelete, groupId);
                System.out.println(student);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return studentList;
    }

    @Override
    public List<Student> addStudentToGroupById( UUID studentId,UUID groupID) {
        String insertStudent = "UPDATE students SET group_id = ? WHERE id =?";
        try {
            PreparedStatement preparedStatement = ConnectionManager.open().prepareStatement(insertStudent);
            preparedStatement.setObject(1, groupID);
            preparedStatement.setObject(2, studentId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return studentList;
    }

    @Override
    public List<Student> getAllInformationAboutStudent(UUID id) {
        String insertStudent = "select students.first_name,students.second_name,students.date_of_birthday," +
                "name_of_faculty,nuber_od_group\n" +
                "from students\n" +
                "left join groups g on g.id = students.group_id\n" +
                "left outer join faculties f on f.id = g.faculty_id\n" +
                "where students.id = ?";
        try {
            PreparedStatement preparedStatement = ConnectionManager.open().prepareStatement(insertStudent);
            preparedStatement.setObject(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                String firstName = resultSet.getString(1);
                String secondName = resultSet.getString(2);
                Date date = resultSet.getDate(3);
                String nameFaculty = resultSet.getString(4);
                int numberOfgroup = resultSet.getInt(5);
                Student student2 = new Student(firstName,
                        secondName, date, nameFaculty, numberOfgroup);
                System.out.println(student2);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return studentList;
    }
}