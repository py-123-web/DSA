package dao;

import adt.SortedArrayList;
import adt.SortedListInterface;
import entity.Course;
//import java.util.Iterator;

/**
 * Initializes the course list and map.
 */
public class CourseInitializer {
    
    // Using interfaces to allow flexibility in implementations
    public static SortedListInterface<Course> courseInitializer() {
        SortedListInterface<Course> courseList = new SortedArrayList<>(); // Initialize the list with Course type
        
        // Adding courses
        courseList.add(new Course("BACS2003", "DSA", "L/T/P", "YEAR SEM 3",3, "FOCS"));
        // Add other courses similarly...
        
        return courseList; // Return the initialized course list
    }
}
