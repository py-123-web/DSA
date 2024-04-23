package entity;

import adt.*;

/**
 *
 * @author Lee Weng Yan
 */
public class RegisterCourse implements Comparable<RegisterCourse> {

    private SortedListInterface<Student> studentList = new SortedArrayList<>();
    private SortedListInterface<Course> courseList = new SortedArrayList<>();
    private double feesPaid;

    public RegisterCourse() {
    }

    public RegisterCourse(double feesPaid) {
        this.feesPaid = feesPaid;
    }

    public SortedListInterface<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(SortedListInterface<Student> studentList) {
        this.studentList = studentList;
    }

    public SortedListInterface<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(SortedListInterface<Course> courseList) {
        this.courseList = courseList;
    }

    public double getFeesPaid() {
        return feesPaid;
    }

    public void setFeesPaid(double feesPaid) {
        this.feesPaid = feesPaid;
    }

    @Override
    public String toString() {
        return String.format("%-8.2f\n", feesPaid);
    }

    @Override
    public int compareTo(RegisterCourse otherRegisterCourse) {
        // Compare based on feesPaid or any other attribute that defines the natural order
        return Double.compare(this.feesPaid, otherRegisterCourse.feesPaid); // sort based on feesPaid
    }
}