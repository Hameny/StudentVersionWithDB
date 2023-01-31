package org.example.Services;

import org.example.DTO.Group;

import java.util.List;
import java.util.UUID;

public interface GroupService {
    void addGroupByFacultyID(UUID facultyID, int numberOfGroup);
    List<Group> getAllGroups();
}
