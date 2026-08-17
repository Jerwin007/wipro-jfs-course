package com.mile1.service;

import com.mile1.bean.Student;
import com.mile1.exception.NullMarksArrayException;
import com.mile1.exception.NullNameException;
import com.mile1.exception.NullStudentObjectException;

public class StudentReport {

    public String findGrades(Student studentObject) {

        int[] marks = studentObject.getMarks();

        // If any mark is less than 35, grade is F
        for (int mark : marks) {
            if (mark < 35) {
                return "F";
            }
        }

        // Find the sum of all marks
        int sum = 0;

        for (int mark : marks) {
            sum += mark;
        }

        // Calculate grade based on sum
        if (sum < 150) {
            return "C";
        } else if (sum < 200) {
            return "B";
        } else if (sum < 250) {
            return "A";
        } else {
            return "A+";
        }
    }

    public String validate(Student s)
            throws NullNameException, NullMarksArrayException, NullStudentObjectException {

        // Check if Student object itself is null
        if (s == null) {
            throw new NullStudentObjectException();
        }

        // Check if name is null
        if (s.getName() == null) {
            throw new NullNameException();
        }

        // Check if marks array is null
        if (s.getMarks() == null) {
            throw new NullMarksArrayException();
        }

        // All data is valid
        return "VALID";
    }
}