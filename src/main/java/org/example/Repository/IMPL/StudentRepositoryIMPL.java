package org.example.Repository.IMPL;

import org.example.DTO.Email;
import org.example.DTO.Phone;
import org.example.DTO.Student;
import org.example.Repository.EmailRepository;
import org.example.Repository.PhoneRepository;
import org.example.Services.StudentService;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class StudentRepositoryIMPL implements StudentService {
    List<Student> studentArrayList = new ArrayList<>();

    @Override
    public List<Student> getAllStudents() {

        try (BufferedReader reader = new BufferedReader(new FileReader("resources/students.txt"))) {
            String line = reader.readLine();
            while (line != null) {
                String[] s = line.split(",");
                Student student1 = new Student(UUID.fromString(s[0]), s[1], s[2], Integer.parseInt(s[3]), UUID.fromString(s[4]));
                PhoneRepository phoneRepository = new PhoneRepositoryIMPL();
                List<Phone> phones = phoneRepository.getPhoneByStudentID(UUID.fromString(s[0]));
                student1.setPhones(phones);
                EmailRepository emailRepository = new EmailRepositoryIMPL();
                List<Email> emails = emailRepository.getEmailByStudentID(UUID.fromString(s[0]));
                student1.setEmails(emails);
                studentArrayList.add(student1);
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return studentArrayList;
    }

    @Override
    public List<Student> addNewStudent(String firstName, String secondName, int dateOfBirthday, UUID groupID) {

        try (FileWriter fileWriter = new FileWriter("resources/students.txt", true)) {

            Student student = new Student(firstName, secondName, dateOfBirthday, groupID);
            String s = student.getId().toString() + "," + student.getFirstName() + "," + student.getSecondName()
                    + "," + student.getDateOfBirthday() + "," + student.getGroupID() + "," + student.getDelete();
            fileWriter.write(s + "\n");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return studentArrayList;
    }

    @Override
    public List<Student> deleteStudentByID(UUID id) {
        return studentArrayList;

    }
}
