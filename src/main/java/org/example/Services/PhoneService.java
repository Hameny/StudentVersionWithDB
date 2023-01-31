package org.example.Services;

import org.example.DTO.Mark;

import java.util.List;
import java.util.UUID;

public interface PhoneService {
    void addPhoneByStudentID(UUID studentID,String phoneNumber);
}
