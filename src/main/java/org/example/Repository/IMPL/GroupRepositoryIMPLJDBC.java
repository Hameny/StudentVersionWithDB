package org.example.Repository.IMPL;

import org.example.DTO.Group;
import org.example.Repository.GroupRepository;
import org.example.util.ConnectionManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class GroupRepositoryIMPLJDBC implements GroupRepository {
    List<Group> groupList = new ArrayList<>();
    Statement statement = null;

    @Override
    public List<Group> addGroupByFacultyID(UUID facultyID, int numberOfGroup) {

        String insertGroup = "INSERT INTO groups (number_of_group, faculty_id)VALUES (?,?);";
        try {
            PreparedStatement preparedStatement = ConnectionManager.open().prepareStatement(insertGroup);
            preparedStatement.setInt(1, numberOfGroup);
            preparedStatement.setObject(2, facultyID);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return groupList;
    }

    @Override
    public List<Group> getAllGroups() {
        try {
            statement = ConnectionManager.open().createStatement();
            String select = "SELECT * FROM Groups";
            ResultSet resultSet = statement.executeQuery(select);
            while (resultSet.next()) {
                groupList.add(new Group(UUID.fromString(resultSet.getString("id")),
                        resultSet.getInt("name_of_group"), UUID.fromString(resultSet.getString("faculty_id"))));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return groupList;
    }
}
