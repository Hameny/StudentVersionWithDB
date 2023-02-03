package org.example.Services;

import org.example.DTO.Email;

import java.util.List;
import java.util.UUID;

public interface EmailService {

    void addEmailByStudentID(UUID studentID, String Email);
    List<Email> getEmailByStudentID();
}
