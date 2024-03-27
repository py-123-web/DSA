package dao;

import adt.SortedArrayList;
import adt.SortedListInterface;
import entity.Programme;
//import java.util.Iterator;

/**
 * Initializes the course list and map.
 */
public class ProgrammeInitializer {
    
    // Using interfaces to allow flexibility in implementations
    public static SortedListInterface<Programme> programmeInitializer() {
        SortedListInterface<Programme> progList = new SortedArrayList<>(); // Initialize the list with Course type
        
        // Adding courses
        progList.add(new Programme("RSW", "BACHELOR OF SOFTWARE ENGINEERING (HONOURS)"));
        
        
        return progList; // Return the initialized course list
    }
}
