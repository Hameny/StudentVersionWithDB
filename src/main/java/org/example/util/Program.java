package org.example.util;

import java.text.ParseException;
import java.util.Scanner;

public class Program {
    public static void start() throws ParseException {
        Scanner scanner = new Scanner(System.in);
        int inputNumber = scanner.nextInt();
        do {
            System.out.println("""
                                   Enter a number from 0 to 9. If you enter the number :
                                   1 - print all students\s
                    -               11 - print information about student\s
                                   12 - print all delete students\s
                                   2 - add new student\s
                                   21 - add student to group\s
                                   22 - print all groups\s
                                   3 - delete student\s
                                   4 - add phone to student\s
                                   5 - find student by ID\s
                                   6 - add email to student\s
                                   7 - print all subjects\s
                                   71 - add subject to student\s
                                   8 - add new subject\s
                                   81 - add mark by subject to student\s
                                   82 - print all mark\s
                                   9 - get to know subject by ID\s
                                   10 - print all faculty\s
                                   101 - add new faculty\s
                                   13 - add new teacher\s
                                   131 - print all teachers\s
                                   0 - exit from program""");
        

            switch (inputNumber) {
                case 1 -> PrintFunction.start1();
                case 11 -> {}
                case 12 -> PrintFunction.start12();
                case 2 -> PrintFunction.start2();
                case 21 -> PrintFunction.start21();
                case 22 -> PrintFunction.start22();
                case 3 -> PrintFunction.start3();
                case 4 -> PrintFunction.start4();
                case 5 -> PrintFunction.start5();
                case 6 -> PrintFunction.start6();
                case 7 -> PrintFunction.start7();
                case 71 -> PrintFunction.start71();
                case 8 -> PrintFunction.start8();
                case 81 -> PrintFunction.start81();
                case 82 -> PrintFunction.start82();
                case 9 -> PrintFunction.start9();
                case 10 -> PrintFunction.start10();
                case 101 -> PrintFunction.start101();
                case 102 -> PrintFunction.start102();
                case 13 -> PrintFunction.start13();
                case 131 -> PrintFunction.start131();
                case 14 -> PrintFunction.start14();
                case 0 -> System.out.println("You entered a number " + inputNumber + ". PROGRAM EXIT");
                default -> System.out.println("Incorrect number.Inter number in the range  1-9 or 0 to EXIT");
            }
        }
        while (inputNumber != 0);
    }
    }

