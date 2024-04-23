package entity;

import adt.*;
import java.util.Objects;

/**
 *
 * @author Lee Weng Yan,Low Jia Yu
 */
public class Student implements Comparable<Student> {

    private String studId;
    private String studName;
    private String ic;
    private String gender;
    private String contactNo;
    private String email;
    private String address;
    private SortedListInterface<RegisterCourse> registerCourseList = new SortedArrayList<>(); //one student, many register course

    public Student() {
    }

    public Student(String studId, String studName, String ic, String gender, String contactNo, String email, String address) {
        this.studId = studId;
        this.studName = studName;
        this.ic = ic;
        this.gender = gender;
        this.contactNo = contactNo;
        this.email = email;
        this.address = address;
    }

    public String getStudId() {
        return studId;
    }

    public void setStudId(String studId) {
        this.studId = studId;
    }

    public String getStudName() {
        return studName;
    }

    public void setStudName(String studName) {
        this.studName = studName;
    }

    public String getIc() {
        return ic;
    }

    public void setIc(String ic) {
        this.ic = ic;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public SortedListInterface<RegisterCourse> getRegisterCourseList() {
        return registerCourseList;
    }

    public void setRegisterCourseList(SortedListInterface<RegisterCourse> registerCourseList) {
        this.registerCourseList = registerCourseList;
    }

//     public SortedListInterface<TutorialGroup> getTutorialGroups() {
//        return tutorialGroups;
//    }
//
//    // Getters and setters
//    public void setTutorialGroups(SortedArrayList<TutorialGroup> tutorialGroups) {    
//        this.tutorialGroups = tutorialGroups;
//    }
//
//    // Method to add a TutorialGrp to the programme
//    public void addTutorialGroup(TutorialGroup tutorialGrp) {
//        tutorialGroups.add(tutorialGrp);
//    }
//
//    public void removeTutorialGroup(TutorialGroup tutorialGrp) {
//        tutorialGroups.remove(tutorialGrp);
//    }
    
    @Override
    public String toString() {
        return String.format("%-15s %-25s %-15s %-10s %-15s %-25s %-30s\n", studId, studName, ic, gender, contactNo, email, address);
    }

    @Override
    public int compareTo(Student otherStudent) {
        // Compare based on studId or any other attribute that defines the natural order
        return this.studName.compareTo(otherStudent.studName); //sort base on studName
    }

    @Override
    public boolean equals(Object o) {
        //this method is specifically designed to check if two Student objects are equal by comparing their student IDs (studId)
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Student student = (Student) o;
        return Objects.equals(studId, student.studId);
    }

    @Override
public int hashCode() {
    return Objects.hash(studId);
}
}