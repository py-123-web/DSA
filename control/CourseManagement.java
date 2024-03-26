package control;

import adt.SortedListInterface;
import adt.SortedArrayList;
import entity.Course;
import boundary.CourseUI;
import java.util.Iterator;
import utility.MessageUI;

/**
 *
 * @author pyhor
 */

//add
//delete
//amend
//search


public class CourseManagement {

    private SortedListInterface<Course> progList = new SortedArrayList<>();
    private SortedListInterface<Course> courseList = new SortedArrayList<>();
    private CourseUI courseUI = new CourseUI();

    //for add programme
      String stuProgramme;

      //for add course
       String stu_programme;
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
                addNewProgramme();
                break;

            case 3:
                 addNewCourse();

                break;

                 case 7 :
                listProg();
                    //productUI.listAllProducts(getAllProducts());
                break;

                case 8 :
                listCourse();
                   break;

                case 6 :
                courseUI.printCoursesProgramme(stuProgramme, course_code, course_name);
                break;

            default :
                 MessageUI.displayInvalidChoiceMessage();
                break;
     }
            // MessageUI.displayInvalidChoiceMessage();
                } while (choice != 0);
  }

    //add
    public void addNewProgramme() {
    courseUI.getAddProgHeader();

    // Get the input for the programme
    do {
        stuProgramme = courseUI.getProgrammeName();

        // Check if the programme already exists
        if (programmeExists(stuProgramme)) {
            courseUI.displayAddProgrammeExist(stuProgramme);
        } else {
            // If the programme doesn't exist, create a new programme
            createProg(stuProgramme);
             MessageUI.displayRecordSuccessful();
            break;
        }
    } while (true);
}

 public void addNewCourse() {
    courseUI.getAddCourseHeader();

    do {
         stuProgramme = courseUI.getProgrammeForCourse();

        if (!programmeExists(stuProgramme)) {
            courseUI.printProgNotExisted();
            break;
        }

      do{
          course_code =courseUI.getCourseCode();
           course_name =courseUI.getCourseName();

          createCourse(course_code, course_name, stuProgramme);

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

    //verify
        public boolean programmeExists(String stuProgramme) {
    Iterator<Course> iterator = progList.getIterator();

    while (iterator.hasNext()) {
        Course course = iterator.next();
        if (course.getProgramme().equals(stuProgramme)) {
            // If a course with the same program already exists, return true
            return true;
        }
    }
    // If no course with the same program is found, return false
    return false;
}

         public boolean programmeExistsForCourse(String stu_programme) {
    Iterator<Course> iterator = progList.getIterator();

    while (iterator.hasNext()) {
        Course course = iterator.next();
        if (course.getProgramme().equals(stu_programme)) {
            // If a program with the same program already exists, return true
            return true;
        }
    }
    // If no course with the same program is found, return false
    return false;
}

           public boolean courseCodeExists(String course_code) {
    Iterator<Course> iterator = courseList.getIterator();

    while (iterator.hasNext()) {
        Course course = iterator.next();
        if (course.getCourseCode().equals(course_code)) {
            // If a course with the same program already exists, return true
            return true;
        }
    }
    // If no course with the same program is found, return false
    return false;
}


        //create
      public Course createProg(String stuProgramme) {
        Iterator<Course> iterator = progList.getIterator();
   while (iterator.hasNext()) {
            Course group = iterator.next();
            if (group.getProgramme().equals(stuProgramme)) {
                return group;
            }
        }
        // If not found, create a new programme
        Course newProg = new Course(stuProgramme);
        progList.add(newProg);
        return newProg;
    }

      public Course createCourse(String course_code, String course_name, String stuProgramme) {
        Iterator<Course> iterator = courseList.getIterator();

        while (iterator.hasNext()) {
            Course group = iterator.next();
            if (group.getCourseCode().equals(course_code)) {
                return group;
            }
        }
        // If not found, create a new course
        Course newCourse = new Course(course_code, course_name, stuProgramme);

        courseList.add(newCourse);
        return newCourse;

    }
//
//      public Course createCourseName(String course_name) {
//        Iterator<Course> iterator = courseList.getIterator();
//
//        while (iterator.hasNext()) {
//            Course group = iterator.next();
//            if (group.getCourseName().equals(course_name)) {
//                return group;
//            }
//        }
//        // If not found, create a new course
//        Course newCourseName = new Course(course_name);
//        courseList.add(newCourseName);
//        return newCourseName;
//
//    }

//      //create course name
//      public Course createCourseName(String course_name) {
//        Iterator<Course> iterator = courseList.getIterator();
//   while (iterator.hasNext()) {
//            Course group = iterator.next();
//            if (group.getCourseName().equals(course_name)) {
//                return group;
//            }
//        }
//        // If not found, create a new course
//        Course newCourseName = new Course(course_name);
//        courseList.add(newCourseName);
//        return newCourseName;
//
//    }

     //list function
   public void listProg() {
    Iterator<Course> iterator = progList.getIterator();
    boolean found = false;

    while (iterator.hasNext()) {
        Course course = iterator.next();
        // Display the details of the programme saved in the array
        courseUI.printProgramme(course.getProgramme());
        found = true;
    }

    if (!found) {
        courseUI.displayListProgNotFound("No programmes found.");
    }
}

   public void listCourse() {
    Iterator<Course> iterator = courseList.getIterator();
    boolean found = false;

    while (iterator.hasNext()) {
        Course course = iterator.next();
        // Display the details of the programme saved in the array
        courseUI.printCourse(course.getCourseCode(),course.getCourseName());
        found = true;
    }

    if (!found) {
        courseUI.displayListProgNotFound("No courses found.");
    }
}

}
