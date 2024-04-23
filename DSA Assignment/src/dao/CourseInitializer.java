package dao;

import adt.SortedArrayList;
import adt.SortedListInterface;
import entity.Course;
import entity.Programme;
//import java.util.Iterator;

/**
 *
 * @author Hor Pei Yu
 */
public class CourseInitializer {

    public SortedListInterface<Programme> progList = new SortedArrayList<>();
    public SortedListInterface<Course> courseList = new SortedArrayList<>();

    public void CourseInfo() { // Specify type arguments
        // Specify type arguments
        courseList.add(new Course("BACS2063", "DATA STRUCTURE AND ALGORITHM", "Tutorial", "YEAR 3 SEMESTER 3", 3, "FOCS", 777.00, "REI", "Main"));
        courseList.add(new Course("BAIT1093", "INTRODUCTION TO COMPUTER SECURITY", "Lecture", "YEAR 3 SEMESTER 3", 3, "FOCS", 777.00, "REI", "Main"));
        courseList.add(new Course("BAIT1083", "VISUAL PROGRAMMING", "Practical", "YEAR 3 SEMESTER 2", 3, "FOCS", 777.00, "REI", "Repeat"));
        courseList.add(new Course("BACS2003", "ARTIFICIAL INTELLIGENCE", "Tutorial", "YEAR 3 SEMESTER 3", 3, "FOCS", 777.00, "RSD", "Main"));
        courseList.add(new Course("BBFA3024", "STRATEGIC BUSINESS REPORTING", "Lecture", "YEAR 3 SEMESTER 2", 4, "FAFB", 90.00, "RFN", "Resit"));
        courseList.add(new Course("BBFA1043 ", "PRINCIPLES OF ACCOUNTING", "Lecture", "YEAR 3 SEMESTER 2", 3, "FAFB", 777.00, "RAC", "Main"));
        courseList.add(new Course("AACS2034", "FUNDAMENTALS OF COMPUTER NETWORKS", "Tutorial", "YEAR 3 SEMESTER 2", 4, "FOCS", 777.00, "DCS", "Main"));
        courseList.add(new Course("AACS3064", "COMPUTER SYSTEMS ARCHITECTURE", "Practical", "YEAR 3 SEMESTER 2", 4, "FOCS", 90.00, "DIS", "Resit"));
        courseList.add(new Course("BBDM2103", "FRANCHISE MANAGEMENT", "Lecture", "YEAR 3 SEMESTER 2", 3, "FAFB", 777.00, "RPA", "Main"));
        courseList.add(new Course("BACS2063", "DATA STRUCTURE AND ALGORITHM", "Tutorial", "YEAR 3 SEMESTER 3", 3, "FOBE", 777.00, "RSW", "Main"));

    }

    public SortedListInterface<Course> getCourseList() {
        return courseList;

    }

    public void ProgrammeInfo() { // Specify type arguments
        // Specify type arguments
        progList.add(new Programme("REI", "Bachelor of Information Systems (Honours) in Enterprise Information Systems"));
        progList.add(new Programme("RSW", "Bachelor of Software Engineering (Honours)"));
        progList.add(new Programme("RSD", "Bachelor of Information Technology (Honours) in Software Systems Development"));
        progList.add(new Programme("RDS", "Bachelor of Computer Science (Honours) in Data Science"));
        progList.add(new Programme("RMM", "Bachelor of Science (Honours) in Management Mathematics with Computing"));
        progList.add(new Programme("RFN", "Bachelor of Finance"));
        progList.add(new Programme("RAC", "Bachelor of Accounting"));
        progList.add(new Programme("DCS", "Diploma in Computer Science"));
        progList.add(new Programme("DIS", "Diploma in Information Systems"));
        progList.add(new Programme("RPA", "Bachelor of Commerce"));
    }

    public SortedListInterface<Programme> getProgrammeList() {
        return progList;
    }

}
