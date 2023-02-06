package org.example.DTO;

import java.util.UUID;

public class Group {
    private UUID id;
    private int numberOfGroup;
    private UUID facultyID;

    public Group(UUID id, int numberOfGroup, UUID facultyID) {
        this.id = id;
        this.numberOfGroup = numberOfGroup;
        this.facultyID = facultyID;
    }

    public Group(int numberOfGroup, UUID facultyID) {
        this.id = UUID.randomUUID();
        this.numberOfGroup = numberOfGroup;
        this.facultyID = facultyID;
    }


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public int getNumberOfGroup() {
        return numberOfGroup;
    }

    public void setNumberOfGroup(int numberOfGroup) {
        this.numberOfGroup = numberOfGroup;
    }

    public UUID getFacultyID() {
        return facultyID;
    }

    public void setFacultyID(UUID facultyID) {
        this.facultyID = facultyID;
    }


    @Override
    public String toString() {
        return "Group{" +
                ", numberOfGroup=" + numberOfGroup +
                "id=" + id +
                ", facultyID=" + facultyID +
                '}';
    }
}
