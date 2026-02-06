package com.klu.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Student {

    @Value("31807")
    private int stId;

    @Value("Akshaya")
    private String stuName;

    private String courseName;
    
    private int yr;
    
    public Student(@Value("Full Stack") String courseName) {
        this.courseName = courseName;
    }
    @Value("2")
    public void setSemester(int yr) {
        this.yr = yr;
    }

    public void display() {
        System.out.println("ID: " + stId);
        System.out.println("Name: " + stuName);
        System.out.println("CourseName: " + courseName);
        System.out.println("Year: " + yr);
    }
}
