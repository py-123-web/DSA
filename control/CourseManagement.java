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

//SortedListInterface<Programme> progInit = CourseInitializer.CourseInfo();
    private CourseUI courseUI = new CourseUI();

    public void runCourseSubsystem() {
        int choice;

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

        String stu_programmeCode;

        do {
            stu_programmeCode = courseUI.getProgrammeForCourse();

            if (!stu_programmeCode.isEmpty()) {

                // Check if the program exists
                if (!programmeExistsForCourse(stu_programmeCode)) {
                    courseUI.printProgNotExisted();
                }

            }

        } while (!programmeExistsForCourse(stu_programmeCode)); // Continue until a valid program code is entered

        // Get details for the new course
        String course_code = courseUI.getCourseCode();

        // Check if the course with the same code already exists in the program
        if (courseCodeExists(course_code, stu_programmeCode)) {
            courseUI.displayAddCourseExist(course_code);
        } else {
            String course_name = courseUI.getCourseName(); // do the verification of .isempty() for each input
            String class_type = courseUI.getClassType();
            String course_semester = courseUI.getSemester();
            int course_creditHour = courseUI.getCreditHour();
            String course_faculty = courseUI.getFaculty();
            double course_fees = courseUI.getFees();

            // Create and add the new course
            Course newCourse = new Course(course_code, course_name, class_type, course_semester, course_creditHour, course_faculty, course_fees, stu_programmeCode);
            courseList.add(newCourse);
            MessageUI.displayRecordSuccessful();
        }

    }

    //----------------------------------- add programme ---------------------------------------
    private void addNewProgramme() {
        String programme_code;
        String programme_name;
        boolean programmeAdded = false;

        courseUI.getAddProgHeader();

        do {
            programme_code = courseUI.getProgrammeCode();
            if (!programme_code.isEmpty()) {
                do {
                    programme_name = courseUI.getProgrammeName();
                    if (!programme_name.isEmpty()) {
                        if (programmeExists(programme_code)) {
                            courseUI.displayAddProgrammeExist(programme_code);
                        } else {
                            // Initialize iterator inside the loop
                            Iterator<Programme> progIterator = progList.iterator();
                            boolean found = false;
                            while (progIterator.hasNext()) {
                                Programme group = progIterator.next();
                                if (group.getProgrammeCode().equals(programme_code)) {
                                    found = true;
                                    break;
                                }
                            }
                            if (!found) {
                                Programme newProg = new Programme(programme_code, programme_name);
                                progList.add(newProg);
                                MessageUI.displayRecordSuccessful();
                                programmeAdded = true;
                            }
                            break; // Break out of the loop after adding a programme
                        }
                    } else {
                        System.out.println("[Error Message]: Name cannot be empty. Please try again.");
                    }
                } while (!programmeAdded); // Continue looping until a programme is added successfully

            } else {
                System.out.println("[Error Message]: Code cannot be empty. Please try again.");
            }
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
    // private CourseInitializer courseArray = new CourseInitializer();
    // SortedListInterface<Course> courses = CourseInitializer.courseList;
    //list course by programme
    private void listProgCourse() {
        // Initialize hardcoded data
        CourseInitializer initializer = new CourseInitializer();
        initializer.CourseInfo();
        initializer.ProgrammeInfo();

        courseUI.programme_courseUI();

        // Get iterators for courses and programmes
        Iterator<Course> hardcodedIterator = initializer.courseInit();
        Iterator<Course> inputCourseIterator = courseList.iterator();

        Iterator<Programme> inputProgIterator = progList.iterator();
        Iterator<Programme> hardcodedIteratorProg = initializer.programmeInit();

        boolean foundData = false;

        // Display all courses and programmes
        while (inputCourseIterator.hasNext()|| hardcodedIterator.hasNext() ) {
            Course course = hardcodedIterator.next();
            // Reset program iterator for each course
            inputProgIterator = progList.iterator();
            while (inputProgIterator.hasNext()||hardcodedIteratorProg.hasNext()) {
                Programme programme = inputProgIterator.next();
                if (course.getProgrammeCode().equals(programme.getProgrammeCode())) {
                    courseUI.printProgrammeCourse(programme.getProgrammeCode(), programme.getProgrammeName(), course.getCourseCode(), course.getCourseName(), course.getClassType(), course.getSemester(), course.getCreditHour(), course.getFees(), course.getFaculty());
                    System.out.println();
                    foundData = true;
                    break; // Stop searching for programmes once a match is found
                }
            }
        }

        // Check if no data is found
        if (!foundData) {
            courseUI.displayListCourseNotFound("No courses found.");
        }
    

    // Check if no data is found
    if (!foundData) {
        courseUI.displayListCourseNotFound("No courses found.");
    }
}

//private CourseInitializer initializer;

// Constructor to initialize hardcoded data
//public CourseManagement() {
//    // Initialize hardcoded data only once
//    initializer = new CourseInitializer();
//    initializer.CourseInfo();
//}

 private void listFacultyCourse() {
        // Initialize hardcoded data
        CourseInitializer initializer = new CourseInitializer();
        initializer.CourseInfo();

        // Display UI related to faculty courses
        courseUI.faculty_courseUI();

        // Get iterators for both hardcoded and input data
        Iterator<Course> hardcodedIterator = initializer.courseInit();
        Iterator<Course> inputIterator = courseList.iterator();

        boolean foundData = false;

        while (inputIterator.hasNext() || hardcodedIterator.hasNext()) {
            if (inputIterator.hasNext()) {
                Course course = inputIterator.next();
                courseUI.printFacultyCourse(course.getFaculty(), course.getCourseCode(), course.getCourseName(), course.getClassType(), course.getSemester(), course.getCreditHour(), course.getFees(), course.getProgrammeCode());
                foundData = true;
                System.out.println("");
            }

            if (hardcodedIterator.hasNext()) {
                Course course = hardcodedIterator.next();
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

//-------------------------- verification -------------------------------------
//verification for if is the programme is existing to add new course
    private boolean programmeExistsForCourse(String stu_programmeCode) {
        Iterator<Programme> progIterator = progList.iterator();

        while (progIterator.hasNext()) {
            Programme programme = progIterator.next();
            if (programme.getProgrammeCode().equals(stu_programmeCode)) {
                return true;
            }
        }
        return false;
    }

//verification for if the course is already existed
    private boolean courseCodeExists(String course_code, String stu_programmeCode) {
        Iterator<Course> courseIterator = courseList.iterator();

        while (courseIterator.hasNext()) {
            Course course = courseIterator.next();
            if (course.getCourseCode().equals(course_code) && course.getProgrammeCode().equals(stu_programmeCode)) {
                return true;
            }
        }
        return false;
    }

//verification for if the programme is already existed
    private boolean programmeExists(String programme_code) {
        Iterator<Programme> progIterator = progList.iterator();

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
    //----------------- search function -------------
    //binary search // Iterative implementation

}
