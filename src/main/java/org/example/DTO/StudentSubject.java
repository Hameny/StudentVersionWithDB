package org.example.DTO;

import java.util.UUID;

public class StudentSubject {
    private UUID id;
    private UUID specializationsID;
    private UUID studentID;

    public StudentSubject(UUID id, UUID specializationsID, UUID studentID) {
        this.id = id;
        this.specializationsID = specializationsID;
        this.studentID = studentID;
    }


    public StudentSubject(UUID specializationsID, UUID studentID) {
        this.id = UUID.randomUUID();
        this.specializationsID = specializationsID;
        this.studentID = studentID;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getSpecializationsID() {
        return specializationsID;
    }

    public void setSpecializationsID(UUID specializationsID) {
        this.specializationsID = specializationsID;
    }

    public UUID getStudentID() {
        return studentID;
    }

    public void setStudentID(UUID studentID) {
        this.studentID = studentID;
    }

    @Override
    public String toString() {
        return "StudentsSpecializations{" +
                ", specializationsID=" + specializationsID +
                ", studentID=" + studentID +
                '}';
    }
}
