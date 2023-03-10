package org.example.Services.IMPL;

import org.example.DTO.Group;
import org.example.Repository.GroupRepository;
import org.example.Repository.IMPL.GroupRepositoryIMPLJDBC;
import org.example.Services.GroupService;

import java.util.List;
import java.util.UUID;

public class GroupServiceIMPL implements GroupService {
    @Override
    public void addGroupByFacultyID(UUID facultyID, int numberOfGroup) {
        GroupRepository groupRepository = new GroupRepositoryIMPLJDBC();
        groupRepository.addGroupByFacultyID(facultyID, numberOfGroup);
    }

    @Override
    public List<Group> getAllGroups() {
        GroupRepository groupRepository = new GroupRepositoryIMPLJDBC();
        return groupRepository.getAllGroups();
    }
}
