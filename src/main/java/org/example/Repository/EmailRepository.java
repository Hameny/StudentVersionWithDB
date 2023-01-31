package org.example.Repository;

import org.example.DTO.Email;

import java.util.List;
import java.util.UUID;

public interface EmailRepository {
    void addEmailByStudentID(UUID studentIDD, String email);

    List<Email> getEmailByStudentID(UUID fromString);
}
