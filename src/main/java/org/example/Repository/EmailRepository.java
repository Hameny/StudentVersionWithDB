package org.example.Repository;

import org.example.DTO.Email;

import java.util.List;
import java.util.UUID;

public interface EmailRepository {
    List<Email> addEmailByStudentID(UUID student_id, String email);

    List<Email> getEmailByStudentID();
}
