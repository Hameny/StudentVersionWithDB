package org.example;

import org.example.DTO.Teacher;

import java.util.*;
import java.util.stream.Collectors;

public class TeacherExample {
    public static void main(String[] args) {

        List<Teacher>teacherList = new ArrayList<>();
        teacherList.add(new Teacher("Elena","Vladimirovna",
                UUID.fromString("01ddef36-a313-11ed-a8fc-0242ac120002")));
        teacherList.add(new Teacher("Veranika","Adamovna",
                UUID.fromString("01ddef31-a313-11ed-a8fc-0242ac120002")));
        teacherList.add(new Teacher("Pavel","Khamenia",
                UUID.fromString("04dcef51-a313-11ed-a8fc-0242ac120002")));

//        Set<Teacher> list = teacherList
        Map<UUID, Teacher> collect = teacherList.stream()
//                .filter(teacher -> teacher.getFirstNameOfTeacher().toLowerCase().contains("v"))
                .filter(t -> t.getSecondNameOfTeacher().startsWith("A"))
                .peek(teacher -> System.out.println(teacher))
                .sorted(Comparator.comparing(Teacher::getSubjectID))
                .collect(Collectors.toMap(teacher -> teacher.getId(), teacher -> teacher));

//        .allMatch(teacher -> teacher.getFirstNameOfTeacher().equals("Pavel"));
//        list.forEach(System.out::println);
        collect.entrySet().forEach(System.out::println);
    }
}
