package com.mile1.bean;

public class Student {
	public Student(String name, int[] marks) {
	    this.name = name;
	    this.marks = marks;
	}

    // Instance variables
    private String name;
    private int marks[];
    private String grade;

    // Default constructor
    public Student() {
    }

    // Parameterized constructor
    public Student(String grade, int[] marks, String name) {
        this.grade = grade;
        this.marks = marks;
        this.name = name;
    }

    // Getters and Setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int[] getMarks() {
        return marks;
    }

    public void setMarks(int[] marks) {
        this.marks = marks;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}