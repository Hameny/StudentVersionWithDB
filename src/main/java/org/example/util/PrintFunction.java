package org.example.util;

import org.example.Services.*;
import org.example.Services.IMPL.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.UUID;

public class PrintFunction {
    static Scanner scanner = new Scanner(System.in);

    public static void start1() {
        StudentService studentService = new StudentServiceIMPLJDBC();
        System.out.println(studentService.getAllStudents());
    }

    public static void start11() {
        System.out.println("Input ID of group:");
        UUID studentID = UUID.fromString(scanner.next());
        StudentService studentService = new StudentServiceIMPLJDBC();
        studentService.getAllInformationAboutStudent(studentID);
    }

    public static void start12() {
        StudentService studentService = new StudentServiceIMPLJDBC();
        System.out.println(studentService.getAllDeleteStudents());
    }

    public static void start2() throws ParseException {
        System.out.print("Input name of student: ");
        String firstName = scanner.next();
        System.out.print("Input name of surname: ");
        String secondName = scanner.next();
        System.out.print("Input date of birthday of student in format dd/мм/yyyy: ");
        String date = scanner.next();
        Date dateOfBirthday = new SimpleDateFormat("dd/MM/yyyy").parse(date);
        System.out.println("Date is : " + dateOfBirthday);
        StudentService studentService = new StudentServiceIMPLJDBC();
        studentService.addNewStudent(firstName, secondName, dateOfBirthday);
        System.out.println(studentService.getAllStudents());
    }

    public static void start21() {
        System.out.println("Input ID of student:");
        UUID studentID = UUID.fromString(scanner.next());
        System.out.println("Input ID of group:");
        UUID groupID = UUID.fromString(scanner.next());
        StudentService studentService = new StudentServiceIMPLJDBC();
        studentService.addStudentToGroupById(studentID, groupID);
    }

    public static void start22() {
        GroupService groupService = new GroupServiceIMPL();
        System.out.println(groupService.getAllGroups());
    }

    public static void start3() {
        System.out.println("Input ID of student:");
        UUID studentID = UUID.fromString(scanner.next());
        StudentService studentService = new StudentServiceIMPLJDBC();
        studentService.deleteStudentByID(studentID);
    }

    public static void start4() {
        System.out.println("Input ID of student :");
        UUID studentID = UUID.fromString(scanner.next());
        System.out.println("Input number phone : ");
        String phone = scanner.next();
        PhoneService phonesService = new PhoneServiceIMPLJDBC();
        phonesService.addPhoneByStudentID(studentID, phone);
    }

    public static void start5() {
        System.out.println("Input ID of student :");
        UUID studentID = UUID.fromString(scanner.next());
        StudentService studentService = new StudentServiceIMPLJDBC();
        studentService.findStudentById(studentID);
    }

    public static void start6() {
        System.out.println("Input ID of student :");
        UUID studentID = UUID.fromString(scanner.next());
        System.out.println("Input email : ");
        String email = scanner.next();
        EmailService emailService = new EmailServiceIMPLJDBC();
        emailService.addEmailByStudentID(studentID, email);
    }

    public static void start7() {
        SubjectService subjectService = new SubjectServiceIMPL();
        System.out.println(subjectService.getAllSubjects());
    }

    public static void start71() {
        System.out.println("Input ID of student:");
        UUID studentID = UUID.fromString(scanner.next());
        System.out.println("Input ID of subject : ");
        UUID subjectID = UUID.fromString(scanner.next());
        StudentSubjectService studentSubjectService = new StudentSubjectServiceIMPLJDBC();
        studentSubjectService.addStudentSubjectToStudentIDANDSubjectID(studentID, subjectID);
    }

    public static void start8() {
        System.out.println("Input name of subject : ");
        String nameSubject = scanner.next();
        SubjectService subjectService = new SubjectServiceIMPL();
        subjectService.addNewSubject(nameSubject);
    }

    public static void start81() throws ParseException {
        System.out.print("Input student_subject ID: ");
        UUID studentSpecializationID = UUID.fromString(scanner.next());
        System.out.print("Input teacher ID: ");
        UUID teacherID = UUID.fromString(scanner.next());
        System.out.print("Input date of mark(dd/MM/yyyy): ");
        String dateOfMark = scanner.next();
        Date dateMark = new SimpleDateFormat("dd/MM/yyyy").parse(dateOfMark);
        System.out.println("Date is : " + dateMark);
        System.out.print("Input number of mark: ");
        int mark = scanner.nextInt();
        MarkService markService = new MarkServiceIMPL();
        markService.addMarkToStudentBySubjectID(studentSpecializationID, teacherID, dateMark, mark);
    }

    public static void start82() {
        MarkService markService = new MarkServiceIMPL();
        System.out.println(markService.getAllMarks());
    }

    public static void start9() {
        System.out.print("Input subject ID: ");
        UUID subjectId = UUID.fromString(scanner.next());
        SubjectService subjectService = new SubjectServiceIMPL();
        subjectService.getSubjectByID(subjectId);
    }

    public static void start10() {
        FacultyService facultyService = new FacultyServiceIMPLJDBC();
        System.out.println(facultyService.getAllFaculties());
    }

    public static void start101() {
        System.out.print("Input name of faculty: ");
        String nameOfFaculty = scanner.next();
        FacultyService facultyService = new FacultyServiceIMPLJDBC();
        facultyService.addFaculty(nameOfFaculty);
        System.out.println(facultyService.getAllFaculties());
    }

    public static void start102() {
        System.out.println("Input ID of faculty :");
        UUID facultyID = UUID.fromString(scanner.next());
        System.out.println("Input number of Group : ");
        int numberOfGroup = scanner.nextInt();
        GroupService groupService = new GroupServiceIMPL();
        groupService.addGroupByFacultyID(facultyID, numberOfGroup);
    }

    public static void start13() {
        System.out.print("Input name of teacher: ");
        String firstNameOfTeacher = scanner.next();
        System.out.print("Input surname of teacher: ");
        String secondNameOfTeacher = scanner.next();
        System.out.print("Input subject id to teacher: ");
        UUID subjectID = UUID.fromString(scanner.next());
        TeacherService teacherService = new TeacherServiceIMPL();
        teacherService.addNewTeacher(firstNameOfTeacher, secondNameOfTeacher, subjectID);
    }

    public static void start131() {
        TeacherService teacherService = new TeacherServiceIMPL();
        System.out.println(teacherService.getAllTeachers());
    }

    public static void start14() {
        System.out.println("Input ID of faculty :");
        UUID facultyID = UUID.fromString(scanner.next());
        System.out.println("Input name of group : ");
        int nameOfGroup = scanner.nextInt();
        GroupService groupService = new GroupServiceIMPL();
        groupService.addGroupByFacultyID(facultyID, nameOfGroup);
    }
}
