package org.example.DTO;

import java.util.UUID;

public class Faculty {
    public UUID id;
    public String nameOfFaculty;

    public Faculty(UUID id, String nameOfFaculty) {
        this.id = id;
        this.nameOfFaculty = nameOfFaculty;
    }

    public Faculty(String nameOfFaculty) {
        this.id = UUID.randomUUID();
        this.nameOfFaculty = nameOfFaculty;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNameOfFaculty() {
        return nameOfFaculty;
    }

    public void setNameOfFaculty(String nameOfFaculty) {
        this.nameOfFaculty = nameOfFaculty;
    }

    @Override
    public String toString() {
        return nameOfFaculty + "{" +
                "id=" + id +
                ", NameOfFaculty='" + nameOfFaculty + '\'' +
                '}'+'\n';
    }
}
