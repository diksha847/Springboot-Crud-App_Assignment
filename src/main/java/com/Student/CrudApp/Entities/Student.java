package com.Student.CrudApp.Entities;

import jakarta.persistence.*;




@Entity
@Table(name = "Students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int stuId;

    private String stuName;

    private String city;

    private int marks;

    private String courseName;

    private String yearOfEnrollment;

    public int getStuId() {
        return stuId;
    }

    public void setStuId(int stuId) {
        this.stuId = stuId;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getYearOfEnrollment() {
        return yearOfEnrollment;
    }

    public void setYearOfEnrollment(String yearOfEnrollment) {
        this.yearOfEnrollment = yearOfEnrollment;
    }

    public Student(int stuId, String stuName, String city, int marks, String courseName, String yearOfEnrollment) {
        this.stuId = stuId;
        this.stuName = stuName;
        this.city = city;
        this.marks = marks;
        this.courseName = courseName;
        this.yearOfEnrollment = yearOfEnrollment;
    }

    @Override
    public String toString() {
        return "Student [stuId=" + stuId + ", stuName=" + stuName + ", city=" + city + ", marks=" + marks
                + ", courseName=" + courseName + ", yearOfEnrollment=" + yearOfEnrollment + "]";
    }

    public Student() {
    }



    



   
}