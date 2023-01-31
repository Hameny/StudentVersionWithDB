package org.example.Services.IMPL;

import org.example.Repository.IMPL.PhoneRepositoryIMPL;
import org.example.Repository.PhoneRepository;
import org.example.Services.PhoneService;

import java.util.UUID;

public class PhoneServiceIMPL implements PhoneService {
    @Override
    public void addPhoneByStudentID(UUID studentID, String phoneNumber) {
        PhoneRepository phoneRepository = new PhoneRepositoryIMPL();
        phoneRepository.addPhoneByStudentID(studentID,phoneNumber);
    }
}

