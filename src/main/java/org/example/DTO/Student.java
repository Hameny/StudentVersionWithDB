package org.example.DTO;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public class Student {
    private UUID id;
    private String firstName;
    private String secondName;
    private Date dateOfBirthday;
    private List<Phone> phones;
    private List<Email> emails;
    private boolean isDelete = false;

    public Student(UUID id, String firstName, String secondName, Date dateOfBirthday, boolean isDelete) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.dateOfBirthday = dateOfBirthday;
        this.isDelete = isDelete;
    }

    public Student(String firstName, String secondName, Date dateOfBirthday) {
        this.id = UUID.randomUUID();
        this.firstName = firstName;
        this.secondName = secondName;
        this.dateOfBirthday = dateOfBirthday;
        this.isDelete = false;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public Date getDateOfBirthday() {
        return dateOfBirthday;
    }

    public void setDateOfBirthday(Date dateOfBirthday) {
        this.dateOfBirthday = dateOfBirthday;
    }

    public List<Phone> getPhones() {
        return phones;
    }

    public void setPhones(List<Phone> phones) {
        this.phones = phones;
    }

    public List<Email> getEmails() {
        return emails;
    }

    public void setEmails(List<Email> emails) {
        this.emails = emails;
    }

    public boolean getDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }


    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", dateOfBirthday=" + dateOfBirthday +
                ", phones=" + phones +
                ", emails=" + emails +
                ", isDelete=" + isDelete +
                '}';
    }
}
