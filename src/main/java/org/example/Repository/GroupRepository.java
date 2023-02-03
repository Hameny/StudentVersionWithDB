package org.example.Repository;

import org.example.DTO.Group;

import java.util.List;
import java.util.UUID;

public interface GroupRepository {
    List<Group> addGroupByFacultyID(UUID facultyID, int numberOfGroup);
    List<Group> getAllGroups();
}
