package com.myapp.samli.elearning;

public class Course {
    int courseID, courseCredit;
    String courseUniversity, courseArea, courseTitle,courseProfessor,courseTime;

    public Course(int courseID, String courseTitle, int courseCredit, String courseProfessor, String courseTime) {
        this.courseID = courseID;
        this.courseTitle = courseTitle;
        this.courseCredit = courseCredit;
        this.courseProfessor = courseProfessor;
        this.courseTime = courseTime;

    }

    public Course(int courseID, String courseUniversity, String courseArea, String courseTitle, int courseCredit, String courseProfessor, String courseTime) {
        this.courseID = courseID;
        this.courseUniversity = courseUniversity;
        this.courseArea = courseArea;
        this.courseTitle = courseTitle;
        this.courseCredit = courseCredit;
        this.courseProfessor = courseProfessor;
        this.courseTime = courseTime;
    }

    public int getCourseID() {
        return courseID;
    }
    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    public String getCourseUniversity() {
        return courseUniversity;
    }
    public void setCourseUniversity(String courseUniversity) {
        this.courseUniversity = courseUniversity; }

    public String getCourseArea() {
        return courseArea;
    }
    public void setCourseArea(String courseArea) {
        this.courseArea = courseArea;
    }

    public String getCourseTitle() {
        return courseTitle;
    }
    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public int getCourseCredit() {
        return courseCredit;
    }
    public void setCourseCredit(int courseCredit) {
        this.courseCredit = courseCredit;
    }

    public String getCourseProfessor() {
        return courseProfessor;
    }
    public void setCourseProfessor(String courseProfessor) {
        this.courseProfessor = courseProfessor;
    }

    public String getCourseTime() {
        return courseTime;
    }
    public void setCourseTime(String courseTime) {
        this.courseTime = courseTime;
    }

    public Course(int courseID, String courseTitle, int courseCredit) {
        this.courseID = courseID;
        this.courseTitle = courseTitle;
        this.courseCredit = courseCredit;

    }


}
