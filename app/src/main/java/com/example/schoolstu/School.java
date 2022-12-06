package com.example.schoolstu;

public class School {

    String schoolName;
    String yearOfStudies;
    String degree;
    String group;

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getYearOfStudies() {
        return yearOfStudies;
    }

    public void setYearOfStudies(String yearOfStudies) {
        this.yearOfStudies = yearOfStudies;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String toString(){
        return schoolName+yearOfStudies+degree+group;
    }


}
