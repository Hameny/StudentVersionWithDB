package org.example.Services.IMPL;

import org.example.DTO.Email;
import org.example.Repository.EmailRepository;
import org.example.Repository.IMPL.EmailRepositoryIMPLJDBC;
import org.example.Services.EmailService;

import java.util.List;
import java.util.UUID;

public class EmailServiceIMPLJDBC implements EmailService {
    @Override
    public void addEmailByStudentID(UUID studentID, String email) {
        EmailRepository emailRepository = new EmailRepositoryIMPLJDBC();
        emailRepository.addEmailByStudentID(studentID,email);

    }

    @Override
    public List<Email> getEmailByStudentID() {
        EmailRepository emailRepository = new EmailRepositoryIMPLJDBC();
        return emailRepository.getEmailByStudentID();
    }
}
