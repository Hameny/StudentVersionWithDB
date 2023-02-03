package org.example.Services.IMPL;

import org.example.DTO.Phone;
import org.example.Repository.IMPL.PhoneRepositoryIMPLJDBC;
import org.example.Repository.PhoneRepository;
import org.example.Services.PhoneService;

import java.util.List;
import java.util.UUID;

public class PhoneServiceIMPLJDBC implements PhoneService {
    @Override
    public void addPhoneByStudentID(UUID studentID, String phoneNumber) {
        PhoneRepository phoneRepository = new PhoneRepositoryIMPLJDBC();
        phoneRepository.addPhoneByStudentID(studentID,phoneNumber);
    }

    @Override
    public List<Phone> getPhoneByStudentID(UUID studentID) {
        PhoneRepository phoneRepository = new PhoneRepositoryIMPLJDBC();
        return phoneRepository.getPhoneByStudentID(studentID);
    }
}

