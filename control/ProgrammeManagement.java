package control;

import adt.SortedListInterface;
import adt.SortedArrayList;
//import entity.Course;
import entity.Programme;
import boundary.CourseUI;
import java.util.Iterator;
//import utility.DateTime;
import utility.MessageUI;
//import dao.CourseInitializer;
//import dao.ProgrammeInitializer;

/**
 *
 * @author pyhor
 */
public class ProgrammeManagement {
    
     private SortedListInterface<Programme> progList = new SortedArrayList<>();
    
     private CourseUI courseUI = new CourseUI();
     
     //for add programme
      String programme_code;
      String programme_name;
      
        public ProgrammeManagement(){
        courseUI = new CourseUI();
    }
        
          public void addNewProgramme() {
          //Iterator<Programme> progIterator = progList.getIterator();   
    courseUI.getAddProgHeader();

    // Get the input for the programme
    do {
       programme_code = courseUI.getProgrammeCode();
       programme_name = courseUI.getProgrammeName();

        // Check if the programme already exists
        if (programmeExists(programme_code)) {
            courseUI.displayAddProgrammeExist(programme_code);
        } else {
            // If the programme doesn't exist, create a new programme
            createProg(programme_code,programme_name);
             MessageUI.displayRecordSuccessful();
            break;
        }
    } while (true);
}
          
          //verify
        public boolean programmeExists(String programme_code) {
    Iterator<Programme> progIterator = progList.getIterator();

    while (progIterator.hasNext()) {
        Programme programme = progIterator.next();
        if (programme.getProgrammeCode().equals(programme_code)) {
            // If a course with the same program already exists, return true
            return true;
        }
    }
    // If no course with the same program is found, return false
    return false;
}
             public Programme createProg(String programme_code,String programme_name) {
        Iterator<Programme> progIterator = progList.getIterator();
   while (progIterator.hasNext()) {
            Programme group = progIterator.next();
            if (group.getProgrammeCode().equals(programme_code)) {
                return group;
            }
        }
        // If not found, create a new programme
        Programme newProg = new Programme(programme_code,programme_name);
        progList.add(newProg);
        return newProg;
    }
        
}
