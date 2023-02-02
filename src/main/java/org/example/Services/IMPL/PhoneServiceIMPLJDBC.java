package org.example.Services.IMPL;

import org.example.Repository.IMPL.PhoneRepositoryIMPLJDBC;
import org.example.Repository.PhoneRepository;
import org.example.Services.PhoneService;

import java.util.UUID;

public class PhoneServiceIMPLJDBC implements PhoneService {
    @Override
    public void addPhoneByStudentID(UUID studentID, String phoneNumber) {
        PhoneRepository phoneRepository = new PhoneRepositoryIMPLJDBC();
        phoneRepository.addPhoneByStudentID(studentID,phoneNumber);
    }
}

