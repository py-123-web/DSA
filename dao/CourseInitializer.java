package dao;

import adt.SortedArrayList;
import adt.SortedListInterface;
import entity.Course;
import entity.Programme;
import java.util.Iterator;

/**
 *
 * @author Hor Pei Yu
 */
public class CourseInitializer {

    public SortedListInterface<Programme> progList = new SortedArrayList<>();
    public SortedListInterface<Course> courseList = new SortedArrayList<>();

    public void CourseInfo() { // Specify type arguments
        // Specify type arguments
        courseList.add(new Course("BACS2063", "DATA STRUCTURE AND ALGORITHM", "Lecture", "YEAR 3 SEM 3", 3, "FOCS", 777.00, "REI", "Main"));
        courseList.add(new Course("BAIT1093", "INTRODUCTION TO COMPUTER SECURITY", "Lecture", "YEAR 3 SEM 3", 3, "FOCS", 777.00, "REI", "Main"));
        courseList.add(new Course("BAIT1083", "VISUAL PROGRAMMING", "Lecture", "YEAR 3 SEM 2", 3, "FOCS", 777.00, "REI", "Repeat"));
        courseList.add(new Course("BACS2003", "ARTIFICIAL INTELLIGENCE", "Lecture", "YEAR 3 SEM 3", 3, "FOCS", 777.00, "RSW", "Main"));
        courseList.add(new Course("BACS2003", "ARTIFICIAL INTELLIGENCE", "Lecture", "YEAR 3 SEM 3", 3, "FOCS", 777.00, "RSD", "Main"));
    }

    public Iterator<Course> courseInit() {
        return courseList.iterator();

    }

    public void ProgrammeInfo() { // Specify type arguments
        // Specify type arguments
        progList.add(new Programme("REI", "Bachelor of Information Systems (Honours) in Enterprise Information Systems "));
        progList.add(new Programme("RSW", "Bachelor of Software Engineering (Honours)"));
        progList.add(new Programme("RSD", "Bachelor of Information Technology (Honours) in Software Systems Development"));
        progList.add(new Programme("RDS", "Bachelor of Computer Science (Honours) in Data Science"));
        progList.add(new Programme("RMM", "Bachelor of Science (Honours) in Management Mathematics with Computing"));

    }

    public Iterator<Programme> programmeInit() {
        return progList.iterator();
    }

}
