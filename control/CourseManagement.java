package control;

import adt.SortedListInterface;
import adt.SortedArrayList;

import entity.Course;
import entity.Programme;
import boundary.CourseUI;
import java.util.Iterator;
import utility.DateTime;
import utility.MessageUI;
import dao.CourseInitializer;
import dao.ProgrammeInitializer;

/**
 *
 * @author pyhor
 */

//add
//delete
//amend
//search


public class CourseManagement {

    private SortedListInterface<Programme> progList = new SortedArrayList<>();
    private SortedListInterface<Course> courseList = new SortedArrayList<>();
    
    private CourseUI courseUI = new CourseUI();

      //for add course
       String stu_programmeCode;
       String course_code;
       String course_name;

    public CourseManagement(){
        courseUI = new CourseUI();
    }

    public void runCourseSubsystem(){
        int choice;

        do{
            choice = courseUI.getMenuChoice();

            switch(choice) {

            case 0:
                MessageUI.displayExitMessage();
            break;

            case 1 :
              ProgrammeManagement programmeManagement = new ProgrammeManagement();
                programmeManagement.addNewProgramme();

                break;

            case 3:
                 addNewCourse();

                break;

                 case 7 :
                listProgCourse();
                    //productUI.listAllProducts(getAllProducts());
                break;

                case 8 :
//                listCourse();
                   break;

                case 6 :
                
                break;

            default :
                 MessageUI.displayInvalidChoiceMessage();
                break;
     }
            // MessageUI.displayInvalidChoiceMessage();
                } while (choice != 0);
  }
    

 public void addNewCourse() {
      Iterator<Course> courseIterator = courseList.getIterator();
    courseUI.getAddCourseHeader();

    do {
         stu_programmeCode = courseUI.getProgrammeForCourse();

        if (!programmeExistsForCourse(stu_programmeCode)) {
            courseUI.printProgNotExisted();
            break;
        }

      do{
          course_code =courseUI.getCourseCode();
           course_name =courseUI.getCourseName();

          createCourse(course_code, course_name);

          if (!courseCodeExists(course_code)) {
            courseUI.displayAddCourseExist(course_code);
            break;

        } else {
            MessageUI.displayRecordSuccessful();
            break;
        }

      }while(true);

    } while (false);
}

         public boolean programmeExistsForCourse(String stu_programmeCode) {
    Iterator<Programme> progIterator = progList.getIterator();

    while (progIterator.hasNext()) {
        Programme programme = progIterator.next();
        if (programme.getProgrammeCode().equals(stu_programmeCode)) {
          
            return true;
        }
    }
    return false;
}

           public boolean courseCodeExists(String course_code) {
    Iterator<Course> courseIterator = courseList.getIterator();

    while (courseIterator.hasNext()) {
        Course course = courseIterator.next();
        if (course.getCourseCode().equals(course_code)) {
            // If a course with the same program already exists, return true
            return true;
        }
    }
    // If no course with the same program is found, return false
    return false;
}

      public Course createCourse(String course_code, String course_name) {
        Iterator<Course> courseIterator = courseList.getIterator();
        

        while (courseIterator.hasNext()) {
            Course group = courseIterator.next();
            if (group.getCourseCode().equals(course_code)) {
                return group;
            }
        }
        // If not found, create a new course
        Course newCourse = new Course(course_code, course_name);
        courseList.add(newCourse);
        return newCourse;

      }

    //list function
public void listProgCourse() {
    SortedListInterface<Course> courseList = CourseInitializer.courseInitializer();
    SortedListInterface<Programme> progList = ProgrammeInitializer.programmeInitializer();
    
    Iterator<Course> courseIterator = courseList.getIterator();
    Iterator<Programme> progIterator = progList.getIterator();
    
    boolean foundData = false;

    // Display all courses and programmes
    while (courseIterator.hasNext() && progIterator.hasNext()) {
        Programme programme = progIterator.next();
        Course course = courseIterator.next();
        courseUI.printCoursesProgramme(programme.getProgrammeCode(), programme.getProgrammeName(), course.getCourseCode(), course.getCourseName());
        foundData = true;
    }

    // Check if no data is found
    if (!foundData) {
        courseUI.displayListCourseNotFound("No courses found.");
    }

    // Print date and time
    DateTime.currentDateTime();
}

}
