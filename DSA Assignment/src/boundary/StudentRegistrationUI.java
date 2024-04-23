package boundary;

import java.util.Scanner;
import utility.DateTime;

/**
 *
 * @author Lee Weng Yan
 */
public class StudentRegistrationUI {

    Scanner scanner = new Scanner(System.in);

    public int getMenuChoice() {
        System.out.println("\nSTUDENT REGISTRARION MANAGEMENT SUBSYSTEM");
        System.out.println("=========================================");
        System.out.println("1.  List all students");
        System.out.println("2.  Add new students");
        System.out.println("3.  Remove a student");
        System.out.println("4.  Amend student details");
        System.out.println("5.  Search students for registered courses");
        System.out.println("6.  Add students to a few courses & Calculate fee paid");
        System.out.println("7.  Remove a student from a course registration");
        System.out.println("8.  Filters students for courses based on citeria");
        System.out.println("9.  Student Age Analysis Summary Report");
        System.out.println("10. Student Course Enrollment Status and Total Fees Collection Summary Report");
        System.out.println("0.  Quit");
        System.out.print("Enter choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        System.out.println();
        return choice;
    }

    //=== 0.List Student ===
    public void printStudentDetailsHeader() {
        System.out.println("\n=== STUDENT DETAILS ===");
        System.out.println("\n------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Student ID      Student Name              IC              Gender     Contact No      Email                     Address        ");
        System.out.println("------------------------------------------------------------------------------------------------------------------------------");
    }

    public void printStudentDetails(String studId, String studName, String ic, String gender, String contactNo, String email, String address) {
        // Print the formatted output
        System.out.printf("%-15s %-25s %-15s %-10s %-15s %-25s %-30s\n", studId, studName, ic, gender, contactNo, email, address);
        System.out.println("");
    }

    //=== 1.Add Student ===
    public void printAddStudentHeader() {
        System.out.println("\nAdd New Student");
        System.out.println("===============");
    }

    //=== 2.Remove Student === for new ver
    public void printRemoveStudentHeader() {
        System.out.println("\nRemove Student");
        System.out.println("==============");
    }

    //=== 3.Amend Student ===
    public void printAmendStudentHeader() {
        System.out.println("\nAmend Student");
        System.out.println("=============");
    }

    //=== 4.Search Student for Registered Course ===
    public void printSearchStudentHeader() {
        System.out.println("\nSearch Student for Registered Courses");
        System.out.println("=====================================");
    }

    public void printCourseDeatilsHeader() {
        System.out.println("\n=== COURSE DETAILS ===");
        System.out.println("\n------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Course Code  Course Name                            Class Type  Semester    Credit  Faculty Fees     Programme  Status");
        System.out.println("------------------------------------------------------------------------------------------------------------------------------");
    }

    //=== 5.Add Student to Courses ===
    public void printAddStudentToCoursesHeader() {
        System.out.println("\nAdd Student to Courses");
        System.out.println("======================");
    }

    //=== 6.Remove Student from Course ===
    public void printRemoveStudentFromCourseHeader() {
        System.out.println("\nRemove Student from Course");
        System.out.println("==========================");
    }

    //=== 8.Filters Students for Course Citeria ===
    public void printFiltersStudentsForCourseCiteriaHeader() {
        System.out.println("\nFilters Students for Course Citeria");
        System.out.println("===================================");
    }

    public void printFilterStudentHeader() {
        //System.out.println("\n=== COURSE DETAILS ===");
        System.out.println("------------------------------------------");
        System.out.println("Student ID      Student Name              ");
        System.out.println("------------------------------------------");
    }

    //=== 9.Summary Report 1 ===
    public void printReportHeader1() {
        System.out.println("\n=====================================================================================================================================");
        System.out.println("                               TUNKU ABDUL RAHMAN UNIVERSITY OF MANAGEMENT AND TECHNOLOGY");
        System.out.println("                                      STUDENT REGISTRATION MANAGEMENT SUBSYSTEM");
        System.out.println("\n                                       STUDENT AGE ANALYSIS SUMMARY REPORT");
        System.out.println(  "                                       -----------------------------------");
        DateTime.currentDateTime();   
    }
    
    //=== 9.Summary Report 2 ===
    public void printReportHeader2() {
        System.out.println("\n=====================================================================================================================================");
        System.out.println("                               TUNKU ABDUL RAHMAN UNIVERSITY OF MANAGEMENT AND TECHNOLOGY");
        System.out.println("                                      STUDENT REGISTRATION MANAGEMENT SUBSYSTEM");
        System.out.println("\n                       STUDENT COURSE ENROLLMENT STATUS & TOTAL FEES COLLECTION SUMMARY REPORT");
        System.out.println(  "                       -----------------------------------------------------------------------");
        DateTime.currentDateTime();
        System.out.println("\n-----------------------------------------------------------------------------");
        System.out.println(  "Student ID   Main Courses   Repeat Courses   Resit Courses   Elective Courses");
        System.out.println(  "-----------------------------------------------------------------------------");
    }

    public void printReportFooter() {
        System.out.println("\n                                          END OF THE STUDENT SUMMARY REPORT");
        System.out.println("=====================================================================================================================================");
    }
}