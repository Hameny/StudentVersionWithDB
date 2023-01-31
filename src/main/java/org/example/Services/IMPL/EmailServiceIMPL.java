package org.example.Services.IMPL;

import org.example.Repository.EmailRepository;
import org.example.Repository.IMPL.EmailRepositoryIMPL;
import org.example.Services.EmailService;

import java.util.UUID;

public class EmailServiceIMPL implements EmailService {
    @Override
    public void addEmailByStudentID(UUID studentID, String email) {
        EmailRepository emailRepository = new EmailRepositoryIMPL();
        emailRepository.addEmailByStudentID(studentID,email);

    }
}
