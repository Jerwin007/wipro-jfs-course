package com.mile1.main;

import java.util.Scanner;

import com.mile1.bean.Student;
import com.mile1.exception.NullMarksArrayException;
import com.mile1.exception.NullNameException;
import com.mile1.exception.NullStudentObjectException;
import com.mile1.service.StudentReport;
import com.mile1.service.StudentService;

public class StudentMain {

    static Student data[] = new Student[4];

    // Constructor
    public StudentMain() {

        Scanner sc = new Scanner(System.in);

        System.out.println("===== Student Grade Calculation =====");

        for (int i = 0; i < data.length; i++) {

            System.out.println("\nStudent " + (i + 1));

            // Check whether the student object should be null
            System.out.print("Do you want to create this student? (yes/no): ");
            String choice = sc.nextLine();

            if (choice.equalsIgnoreCase("no")) {
                data[i] = null;
                continue;
            }

            // Get student name
            System.out.print("Enter student name (enter null for no name): ");
            String name = sc.nextLine();

            if (name.equalsIgnoreCase("null")) {
                name = null;
            }

            // Get marks
            System.out.print("Enter 3 marks separated by spaces (enter null for no marks): ");
            String marksInput = sc.nextLine();

            int[] marks = null;

            if (!marksInput.equalsIgnoreCase("null")) {

                String[] values = marksInput.split(" ");

                marks = new int[values.length];

                for (int j = 0; j < values.length; j++) {
                    marks[j] = Integer.parseInt(values[j]);
                }
            }

            data[i] = new Student(name, marks);
        }

        StudentReport studentReport = new StudentReport();

        System.out.println("\n===== Student Results =====");

        // Validate all Student objects
        for (int i = 0; i < data.length; i++) {

            System.out.println("\nStudent " + (i + 1) + ":");

            try {

                String result = studentReport.validate(data[i]);

                if (result.equals("VALID")) {

                    String grade = studentReport.findGrades(data[i]);

                    System.out.println("Name: " + data[i].getName());
                    System.out.println("Grade: " + grade);
                }

            } catch (NullNameException e) {
                e.printStackTrace();

            } catch (NullMarksArrayException e) {
                e.printStackTrace();

            } catch (NullStudentObjectException e) {
                e.printStackTrace();
            }
        }

        // Create StudentService object
        StudentService studentService = new StudentService();

        System.out.println("\n===== Student Data Summary =====");

        // Count students with null marks array
        System.out.println(
            "Number of students with null marks array: "
            + studentService.findNumberOfNullMarksArray(data)
        );

        // Count students with null name
        System.out.println(
            "Number of students with null name: "
            + studentService.findNumberOfNullName(data)
        );

        // Count null Student objects
        System.out.println(
            "Number of null Student objects: "
            + studentService.findNumberOfNullObjects(data)
        );
    }

    public static void main(String[] args) {

        new StudentMain();
    }
}