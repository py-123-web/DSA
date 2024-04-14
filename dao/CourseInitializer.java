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

    private static SortedListInterface<Programme> progList = new SortedArrayList<>();
    public static SortedListInterface<Course> courseList = new SortedArrayList<>();

    public void CourseInfo() { // Specify type arguments
        // Specify type arguments
        courseList.add(new Course("BACS2003 (L)", "DATA STRUCTURE AND ALGORITHM", "Lecture", "YEAR 3 SEM 3", 3, "FOCS", 777.00, "REI"));
        courseList.add(new Course("BAIT1093 (L)", "INTRODUCTION TO COMPUTER SECURITY", "Lecture", "YEAR 3 SEM 3", 3, "FOCS", 777.00, "REI"));
    }

    public Iterator<Course> courseInit() {
        return courseList.iterator();

    }

    public void ProgrammeInfo() { // Specify type arguments
        // Specify type arguments
        progList.add(new Programme("REI", "Bachelor of Information Systems (Honours) in Enterprise Information Systems "));

        // Specify type arguments
    }

    public Iterator<Programme> programmeInit() {
        return progList.iterator();
    }

}
