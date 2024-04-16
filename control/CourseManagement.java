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

/**
 *
 * @author Hor Pei Yu
 */
public class CourseManagement {

    private static SortedListInterface<Programme> progList = new SortedArrayList<>();
    private static SortedListInterface<Course> courseList = new SortedArrayList<>();

    CourseInitializer initializer = new CourseInitializer();

    private CourseUI courseUI = new CourseUI();

    boolean foundData = false;

    //SortedListInterface<Programme> progInit = CourseInitializer.CourseInfo();
    public void runCourseSubsystem() {
        int choice;

        initializer.CourseInfo();
        initializer.ProgrammeInfo();

        do {
            choice = courseUI.getMenuChoice();

            switch (choice) {

                case 0:
                    MessageUI.displayExitMessage();
                    break;

                case 1:
                    addNewProgramme();

                    break;
                case 2:
                    addNewCourse();
                    break;

                case 3:
//                 removeProg();
                    break;

                case 4:
//              removeCourse();
                    break;

                case 6:

                    break;

                case 7:
                    listProgCourse();
                    break;

                case 8:
                    listFacultyCourse();
                    break;

                default:
                    MessageUI.displayInvalidChoiceMessage();
                    break;
            }
            // MessageUI.displayInvalidChoiceMessage();
        } while (choice != 0);
    }
    //--------------------------------- add fucntion --------------------------
    //----------------------------- add course-----------------------------

    private void addNewCourse() {
        // Display header for adding a course
        courseUI.getAddCourseHeader();

        boolean courseAdded = false;
        boolean progExist;
        String stu_programmeCode;

        do {
            do {
                progExist = false; // Reset progExist for each iteration
                stu_programmeCode = courseUI.getProgrammeForCourse(); // Initialize stu_programmeCode

                // Check if the program exists
                Programme inputProgramme = new Programme(stu_programmeCode);
                int progIndex = progList.contains(inputProgramme);
                if (progIndex == -1) {
                    courseUI.printProgNotExisted();

                    stu_programmeCode = courseUI.getProgrammeForCourse();
                    break;
                }
            } while (progExist);

            // Get details for the new course
            String inputProgramme=courseUI.getProgrammeCode();
            String course_code = courseUI.getCourseCode();
            String course_name = courseUI.getCourseName(); 
            String class_type = courseUI.getClassType();
            String course_semester = courseUI.getSemester();
            int course_creditHour = courseUI.getCreditHour();
            String course_faculty = courseUI.getFaculty();
            double course_fees = courseUI.getFees();
          String course_status = courseUI.getStatus();

            // Check if the course with the same code already exists in the program
            Course newCourse = new Course(course_code, course_name, class_type, course_semester, course_creditHour, course_faculty, course_fees, inputProgramme,course_status);
//            int courseIndex = courseList.contains(newCourse);
//            if (courseIndex != -1) {
//                courseUI.displayAddCourseExist(course_code);
//            } else {
            // Add the new course to the course list
            courseList.add(newCourse);
            MessageUI.displayRecordSuccessful();
            courseAdded = true; // Set courseAdded to true to exit the loop
//            }
        } while (!courseAdded);
    }

//----------------------------------- add programme ---------------------------------------
    private void addNewProgramme() {
        String programme_code;
        String programme_name;
        boolean programmeAdded = false;

        courseUI.getAddProgHeader();

        do {
            programme_code = courseUI.getProgrammeCode();
            programme_name = courseUI.getProgrammeName();
            programmeAdded = false;

            if (programme_code.isEmpty()) {
                System.out.println("[Error Message]: Code cannot be empty. Please try again.");

            }

            if (programme_name.isEmpty()) {
                System.out.println("[Error Message]: Name cannot be empty. Please try again.");
            }

            // Check if the programme already exists
            Programme newProg = new Programme(programme_code, programme_name);
            int index = progList.contains(newProg);
            if (index != -1) {
                courseUI.displayAddProgrammeExist(programme_code);
                break;
            }

            // If the programme does not exist, add it to the list
            progList.add(newProg);
            MessageUI.displayRecordSuccessful();
            programmeAdded = true;

        } while (!programmeAdded); // Continue looping until a programme is added successfully

    }

    //--------------------------------- remove function -------------------------------   
//    public void removeCourse() {
//        String courseCode = courseUI.removeCourseUI();
//
//        if (courseCode != null) {
//            Course courseToRemove = findCourseByCode(courseCode);
//            if (courseToRemove != null) {
//                if (courseUI.confirmAction("Are you sure you want to remove this course?")) {
//                    courses.remove(courseCode);
//                    MessageUI.displaySuccessMessage("Course Removed!");
//                } else {
//                    MessageUI.displaySuccessMessage("Course Not Removed.");
//                }
//            }
//        } else {
//            MessageUI.displayErrorMessage("Action Cancelled!");
//        }
//    }
//
//    public Course findCourseByCode(String courseCode) {
//        if (courseCode == null) {
//            courseCode = courseUI.findCourseUI();
//            if (courseCode != null) {
//                if (Course.contains(courseCode)) {
//                    Course course = courses.get(courseCode);
//                    System.out.println(course.toString());
//                    return course;
//                } else {
//                    MessageUI.displayErrorMessage("Course Not Found!");
//                }
//            } else {
//                MessageUI.displayErrorMessage("Action Cancelled!");
//                return null;
//            }
//        }
//        return courses.get(courseCode);
//    }
//    public void removeProg() {
//    String remove_progInput;
//    boolean programmeFound = false;
//    
//    do {
//        remove_progInput = courseUI.removeProg_Course();
//        
////        // Check if the user wants to cancel
////        if (remove_progInput.equals("0")) {
////            courseUI.displayExitMessage();
////            return; // Exit the method
////        }
//        
//        Iterator<Programme> progIterator = progList.getIterator();
//        
//        while (progIterator.hasNext()) {
//            Programme program = progIterator.next();
//            if (program.getProgrammeCode().equals(remove_progInput)) {
//                progIterator.remove(); // Remove using iterator
//                MessageUI.displayRecordSuccessful();
//                programmeFound = true;
//                break; // Exit the loop if found and removed
//            }
//        }
//        
//        if (!programmeFound) {
//            courseUI.displayListCourseNotFound("Programme not found.");
//        }
//
//    } while (!programmeFound); // Repeat until a program is found and removed
//}
//
//
//    //remove course
//public void removeCourse() {
//    String remove_courseInput;
//    boolean courseFound = false;
//    
//    do {
//        remove_courseInput = courseUI.removeCourse_Prog();
//        
////        // Check if the user wants to cancel
////        if (remove_courseInput.equals("0")) {
////            courseUI.displayExitMessage();
////            return; // Exit the method
////        }
//        
//        Iterator<Course> courseIterator = courseList.getIterator();
//
//        while (courseIterator.hasNext()) {
//            Course course = courseIterator.next();
//            if (course.getCourseCode().equals(remove_courseInput)) {
//                courseIterator.remove(); // Remove using iterator
//                MessageUI.displayRecordSuccessful();
//                courseFound = true;
//                break; // Exit the loop if found and removed
//            }
//        }
//        
//        if (!courseFound) {
//            courseUI.displayListCourseNotFound("Course not found.");
//        }
//
//    } while (!courseFound); // Repeat until a course is found and removed
//}
    //-----------------------list function-----------------------------
     private void listProgCourse() {
        // Display UI related to programme courses
        courseUI.programme_courseUI();

        Iterator<Course> hardcodedIterator = initializer.courseInit();
        Iterator<Programme> hardcodedIteratorProg = initializer.programmeInit();
        Iterator<Course> inputIterator = courseList.iterator();
        Iterator<Programme> inputProgIterator = progList.iterator();

        // Display all courses and programmes
        // while (hardcodedIterator.hasNext() || hardcodedIteratorProg.hasNext()) {
        //     if (hardcodedIterator.hasNext()) {
        //         Course course = hardcodedIterator.next();
        //         Programme programme = hardcodedIteratorProg.next();
        //         if (course.getProgrammeCode().equals(programme.getProgrammeCode())) {
        //           System.out.println("asd-loop1-hasNext-programeCode===programmeCode");
        //             courseUI.printProgrammeCourse(programme.getProgrammeCode(), programme.getProgrammeName(), course.getCourseCode(), course.getCourseName(), course.getClassType(), course.getSemester(), course.getCreditHour(), course.getFees(), course.getFaculty(), course.getStatus());
        //             System.out.println();
        //             foundData = true;
        //             break;
        //         }
        //     }
        // }

        // Display all courses and programmes
        // while (hardcodedIterator.hasNext()) {
        //   Iterator<Programme> hardcodedIteratorProg = initializer.programmeInit();
        //   Course course = hardcodedIterator.next();

        //   // Search for course's programme
        //   while(hardcodedIteratorProg.hasNext()) {
        //     Programme programme = hardcodedIteratorProg.next();

        //     // Programme found
        //     if (course.getProgrammeCode().equals(programme.getProgrammeCode())) {
        //       courseUI.printProgrammeCourse(programme.getProgrammeCode(), programme.getProgrammeName(), course.getCourseCode(), course.getCourseName(), course.getClassType(), course.getSemester(), course.getCreditHour(), course.getFees(), course.getFaculty(), course.getStatus());
        //       System.out.println();
        //       foundData = true;
        //       break;
        //     }
        //     // Programme not found
        //     else {
        //       foundData = false;
        //     }
        //   }
        // }

        // Display all courses and programmes
        while (hardcodedIterator.hasNext() || hardcodedIteratorProg.hasNext() || inputIterator.hasNext() || inputProgIterator.hasNext()) {

            while (hardcodedIterator.hasNext()) {
                //Iterator<Programme> hardcodedIteratorProg = initializer.programmeInit();
                Course course = hardcodedIterator.next();

                // Search for course's programme
                while (hardcodedIteratorProg.hasNext()) {
                    Programme programme = hardcodedIteratorProg.next();

                    // Programme found
                    if (course.getProgrammeCode().equals(programme.getProgrammeCode())) {
                        courseUI.printProgrammeCourse(programme.getProgrammeCode(), programme.getProgrammeName(), course.getCourseCode(), course.getCourseName(), course.getClassType(), course.getSemester(), course.getCreditHour(), course.getFees(), course.getFaculty(), course.getStatus());
                        System.out.println();
                        foundData = true;
                        break;
                    } // Programme not found
                    else {
                        foundData = false;
                    }
                }
            }

            while (inputIterator.hasNext() || inputProgIterator.hasNext()) {
                if (inputIterator.hasNext()) {
                    Course course = inputIterator.next();
                    Programme programme = inputProgIterator.next();
                    if (course.getProgrammeCode().equals(programme.getProgrammeCode())) {
                        courseUI.printProgrammeCourse(programme.getProgrammeCode(), programme.getProgrammeName(), course.getCourseCode(), course.getCourseName(), course.getClassType(), course.getSemester(), course.getCreditHour(), course.getFees(), course.getFaculty(), course.getStatus());
                        System.out.println();
                        foundData = true;
                        break;
                    }
                }
            }

        }

        // Check if no data is found
        if (!foundData) {
            courseUI.displayListCourseNotFound("No courses found.");
        }
    }

    private void listFacultyCourse() {

        // Display UI related to faculty courses
        courseUI.faculty_courseUI();

        // Get iterators for both hardcoded and input data
        Iterator<Course> hardcodedIterator = initializer.courseInit();
        Iterator<Course> inputIterator = courseList.iterator();

        // boolean foundData = false;
        while (hardcodedIterator.hasNext() || inputIterator.hasNext()) {
            if (hardcodedIterator.hasNext()) {
                Course course = hardcodedIterator.next();
                courseUI.printFacultyCourse(course.getFaculty(), course.getCourseCode(), course.getCourseName(), course.getClassType(), course.getSemester(), course.getCreditHour(), course.getFees(), course.getProgrammeCode());
                foundData = true;
                System.out.println("");
            }

            if (inputIterator.hasNext()) {
                Course course = inputIterator.next();
                courseUI.printFacultyCourse(course.getFaculty(), course.getCourseCode(), course.getCourseName(), course.getClassType(), course.getSemester(), course.getCreditHour(), course.getFees(), course.getProgrammeCode());
                foundData = true;
                System.out.println("");
            }

            // Break out of the loop if both iterators have no more elements
            if (!inputIterator.hasNext() && !hardcodedIterator.hasNext()) {
                break;
            }
        }

        // Check if no data is found
        if (!foundData) {
            courseUI.displayListCourseNotFound("No courses found.");
        }
    }

    //----------------- search function -------------
    //binary search // Iterative implementation
}
