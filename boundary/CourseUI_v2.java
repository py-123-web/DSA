package boundary;

import adt.SortedArrayList;
import adt.SortedListInterface;
import dao.CourseInitializer;
import entity.*;
import utility.*;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author Hor Pei Yu
 */
public class CourseUI {

    CourseInitializer initializer = new CourseInitializer();

    int coursechoice;

    //ListInterface<Course> courseList = new SortedArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public int getMenuChoice() {
        // initializer.CourseInfo();
        // initializer.ProgrammeInfo();

        int coursechoice = -1;

        System.out.println("\nCourse Management Subsystem\n");
        System.out.println("Main Menu");
        System.out.println("1. Add a new programme to courses");
        System.out.println("2. Add a new course to programmes");
        System.out.println("3. Remove a programme from a course ");
        System.out.println("4. Remove a course from a programme");
        System.out.println("5. Search courses offered in a semester");
        System.out.println("6. Amend course details for a programme");
        System.out.println("7. List courses taken by different faculties");
        System.out.println("8. List all courses for a programme");
        System.out.println("9. Generate summary reports");
        System.out.println("0. Quit");

        boolean loop = true;

        do {
            System.out.print("\nEnter choice:");

            try {
                coursechoice = scanner.nextInt(); // Read user's choice
                scanner.nextLine(); // Consume newline character
                loop = false; // Exit the loop if input is successful
            } catch (Exception ex) {
                System.out.println("[Error Message]: Only accept numeric input. Please try again.");
                scanner.nextLine(); // Clear the invalid input from the scanner
            }
        } while (loop);

        return coursechoice;
    }

    public void courseListUI() {
        System.out.printf("%-15s %-30s %n", "Course Code", "Course Name");
        System.out.println("----------------------------------------------------------------------------------------------------------------------");

    }

    public void courseList(String courseCode, String courseName) {
        courseCode = courseCode.toUpperCase();
        courseName = courseName.toUpperCase();
        // Print the formatted output
        System.out.printf("%-15s %-30s %n", courseCode, courseName);

    }

    public void programmeListUI() {
        System.out.println();
        System.out.println("Programme List");
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%-15s %-80s %n", "Programme Code", "Programme Name");
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------");

    }

    public void programmeList(String programmeCode, String programmeName) {
        programmeCode = programmeCode.toUpperCase();
        programmeName = programmeName.toUpperCase();

        // Print the formatted output
        System.out.printf("%-15s %-80s %n", programmeCode, programmeName);

    }

    public void getAddProgHeader() {
        System.out.println("-------------------------------------------------");
        System.out.println("        Add a new programme");
        System.out.println("-------------------------------------------------");
    }

    //for input the programme name to add the course
    public String getCourseForProgramme() {
        System.out.print("Enter course to add programme : ");
        String stu_codeProg = scanner.nextLine();
        return stu_codeProg.toUpperCase();
    }

    //for input the programme
    public String getProgrammeCode() {
        System.out.print("Enter new programme code : ");
        String programmeCode = scanner.nextLine();
        return programmeCode.toUpperCase();
    }

    //for input the programme
    public String getProgrammeName() {
        System.out.print("Enter new full name of programme : ");
        String programmeName = scanner.nextLine();
        return programmeName.toUpperCase();
    }

    public void getAddCourseHeader() {
        System.out.println("-------------------------------------------------");
        System.out.println("        Add a new course");
        System.out.println("-------------------------------------------------");

    }

    //for input the programme name to add the course
    public String getProgrammeForCourse() {
        System.out.print("Enter programme to add course : ");
        String stu_programmeCode = scanner.nextLine();
        return stu_programmeCode.toUpperCase();
    }

    //to get new course code
    public String getCourseCode() {
        System.out.print("Enter a new course code : ");
        String course_code = scanner.nextLine();
        return course_code.toUpperCase();
    }

    //to get new course name
    public String getCourseName() {
        System.out.print("Enter a new course name : ");
        String course_name = scanner.nextLine();
        return course_name.toUpperCase();
    }

    public String getClassType() {
        System.out.print("Please enter class type: ");
        String class_type = scanner.nextLine();
        return class_type.toUpperCase();
    }

    public String getSemester() {
        System.out.print("Please enter semester: ");
        String course_semester = scanner.nextLine();
        return course_semester.toUpperCase();
    }

    public int getCreditHour() {
        int course_creditHour = 0; // Declare course_creditHour outside the try block
        boolean loop = true;

        do {
            System.out.print("Please enter new programme credit hour: ");

            try {
                course_creditHour = scanner.nextInt(); // Read user's choice
                scanner.nextLine(); // Consume newline character
                loop = false; // Exit the loop if input is successful

            } catch (Exception ex) {
                System.out.println("[Error Message]: Only accept numeric input. Please try again.");
                scanner.nextLine(); // Clear the invalid input from the scanner
            }
        } while (loop);

        return course_creditHour; // Added for the case when the loop exits without returning a value
    }

    public double getFees() {
        double course_fees = 0.00; // Declare course_creditHour outside the try block
        boolean loop = true;

        do {
            System.out.print("Please enter new programme fees: ");

            try {
                course_fees = scanner.nextDouble(); // Read user's choice
                scanner.nextLine(); // Consume newline character
                loop = false; // Exit the loop if input is successful

            } catch (Exception ex) {
                System.out.println("[Error Message]: Only accept numeric input. Please try again.");
                scanner.nextLine(); // Clear the invalid input from the scanner
            }
        } while (loop);

        return course_fees; // Added for the case when the loop exits without returning a value
    }

    public String getFaculty() {
        System.out.print("Please enter faculty: ");
        String course_faculty = scanner.nextLine();
        return course_faculty.toUpperCase();
    }

    public String getStatus() {
        System.out.print("Please enter status: ");
        String course_status = scanner.nextLine();
        return course_status.toUpperCase();
    }

    //-----------------display-----------------------------
    public void programme_courseUI() {
        System.out.println();
        System.out.println("List all courses for a programme");
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%-15s %-80s %-15s %-30s %n", "Programme Code", "Programme Name", "Course Code", "Course Name");
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------");
    }

    public void printProgrammeCourse(String programmeCode, String programmeName, String courseCode, String courseName) {
        programmeCode = programmeCode.toUpperCase();
        programmeName = programmeName.toUpperCase();
        courseCode = courseCode.toUpperCase();
        courseName = courseName.toUpperCase();

        // Print the formatted output
        System.out.printf("%-15s %-80s %-15s %-30s %n", programmeCode, programmeName, courseCode, courseName);
    }
    
     public void printProgramme(String programmeCode,  String courseCode, String courseName) {
        programmeCode = programmeCode.toUpperCase();
        courseCode = courseCode.toUpperCase();
        courseName = courseName.toUpperCase();

        // Print the formatted output
        System.out.printf("%-15s %-15s %-30s %n", programmeCode, courseCode, courseName);
    }
    

    public void faculty_courseUI() {
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%-10s %-15s %-35s %-12s %-20s %-12s %-10s %-15s %-10s%n", "Faculty", "Course Code", "Course Name", "Class Type", "Semester", "Credit Hour", "Fees(RM)", "Programme Code", "Status");
        System.out.print("-----------------------------------------------------------------------------------------------------------------------------------------------");
    }

    public void printFacultyCourse(String faculty, String courseCode, String courseName, String classType, String semester, Integer creditHour, Double fees, String programmeCode, String status) {
        // Maximum characters per line for programmeName
        int maxCharsPerLine = 33;
        faculty = faculty.toUpperCase();
        courseCode = courseCode.toUpperCase();
        courseName = courseName.toUpperCase();
        classType = classType.toUpperCase();
        semester = semester.toUpperCase();
        programmeCode = programmeCode.toUpperCase();
        status = status.toUpperCase();

        // Print the formatted output
        if (courseName.length() > maxCharsPerLine) {
            String firstLineCourseName = courseName.substring(0, maxCharsPerLine);
            System.out.printf("%-10s %-15s %-35s %-12s %-20s %-12d %-10.2f %-15s %-10s %n", faculty, courseCode, firstLineCourseName, classType, semester, creditHour, fees, programmeCode, status);

            String remainingCourseName = courseName.substring(maxCharsPerLine);
            System.out.printf("%-10s %-15s %-35s", "", "", remainingCourseName);

        } else {
            // Print the formatted output
            System.out.printf("%-10s %-15s %-35s %-12s %-20s %-12d %-10.2f %-15s %-10s", faculty, courseCode, courseName, classType, semester, creditHour, fees, programmeCode, status);
        }
    }

    public static void displayAddProgrammeExist(String programmeCode) {
        System.out.println("Programme Code " + programmeCode + " already existed");
    }

    public void displayAddCourseExist(String course_code) {
        System.out.println("Course Code " + course_code + " already existed");
    }

    public static void printProgNotExisted() {
        System.out.println("The programme is not existed.");
        System.out.println("Please enter programme in the programme list.");
    }

    public static void printCourseNotExisted() {
        System.out.println("The course code is not existed.");
        System.out.println("Please enter course code in the course list.");
    }

    public static void displayListCourseNotFound(String Course) {
        System.out.println(Course);
    }

    //remove-------------------
    public void removeProgHeader() {
        System.out.println("-------------------------------------------------");
        System.out.println("        Remove a programme");
        System.out.println("-------------------------------------------------");
    }

    public String removeProg_Course() {
        System.out.print("Enter course code to remove programme (x to cancel):");
        String remove_courseProg = scanner.nextLine();
        return remove_courseProg.toUpperCase();
    }

    //for remove the programme
    public String removeProgramme() {
        System.out.print("Enter prorgamme code to remove (x to cancel) : ");
        String remove_programme = scanner.nextLine();
        return remove_programme.toUpperCase();
    }

    public String removeCourse_Prog() {
        System.out.println("Enter programme code to remove course (x to cancel):");
        String remove_progCourse = scanner.nextLine();
        return remove_progCourse.toUpperCase();
    }

    public String removeCourse() {
        System.out.println("Enter course code to remove (x to cancel):");
        String remove_course = scanner.nextLine();
        return remove_course.toUpperCase();
    }

    //for remove the programme
    public String removeCourseUI() {
        System.out.println("\nRemove Course");
        System.out.println("=====================");

        String courseCode = courseCodeUI();
        if (courseCode == null) {
            return null; // User canceled input
        }

        System.out.println("=====================");
        return courseCode;
    }

    public String courseCodeUI() {
        String courseCode;
        do {
            System.out.print("Enter course code (press 'x' to cancel): ");
            courseCode = scanner.nextLine().trim().toUpperCase();
            if (courseCode.equalsIgnoreCase("x")) {
                return null; // User canceled input
            }
            if (courseCode.isEmpty()) {
                System.out.println("Course code cannot be empty. Please try again or press 'x' to cancel.");
            } else if (!Character.isLetter(courseCode.charAt(0))) {
                System.out.println("Course code must start with a letter. Please try again or press 'x' to cancel.");
            }
        } while (courseCode.isEmpty() || !Character.isLetter(courseCode.charAt(0)));
        return courseCode;
    }

//    public boolean confirmAction(String message) {
//        String input;
//        boolean validInput = false;
//
//        do {
//            System.out.print(message + " (y/n): ");
//            input = scanner.nextLine().trim().toUpperCase();
//            if (input.equals("y") || input.equals("n")) {
//                validInput = true;
//            } else {
//                System.out.println("Invalid input. Please enter 'y' or 'n'.");
//            }
//        } while (!validInput);
//
//        return input.equals("y");
//    }
    // Find course
    public void search_header() {
        System.out.println("\nSearch Courses");
        System.out.println("=====================");
    }

    //to get new course code
    public String courseCodeSearch() {
        System.out.print("Enter a course code to search (x to cancel): ");
        String course_code = scanner.nextLine();
        return course_code.toUpperCase();
    }

    public void searchOutputUI() {
        System.out.println("\nSearch courses offered in a semester");
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.printf("%-15s %-50s %-20s %n", "Course Code", "Course Name", "Semester");
        System.out.println("-----------------------------------------------------------------------------------------");
    }

    public void searchOutput(String courseCode, String courseName, String semester) {

        // Maximum characters per line for programmeName
//        int maxCharsPerLine = 33;
        courseCode = courseCode.toUpperCase();
        courseName = courseName.toUpperCase();

        semester = semester.toUpperCase();

        // Print the formatted output
        System.out.printf("%-15s %-50s %-20s %n", courseCode, courseName, semester);

    }

    //=========================================================================
    public void amendCourse() {
        System.out.println("-------------------------------------------------");
        System.out.println("       Amend a course");
        System.out.println("-------------------------------------------------");

    }

    public void amendCourseUI() {
        System.out.println();
        System.out.println("The list of the courses that taken by different faculties");
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf(" %-15s %-35s %-12s %-20s %-12s %-10s %-6s %-10s%n", "Course Code", "Course Name", "Class Type", "Semester", "Credit Hour", "Fees(RM)", "Programme Code", "Faculty");
        System.out.printf("---------------------------------------------------------------------------------------------------------------------------------------");

    }

    public void amendCourseList(String courseCode, String courseName, String classType, String semester, Integer creditHour, Double fees, String status, String faculty) {
        // Maximum characters per line for programmeName
        int maxCharsPerLine = 33;

        courseCode = courseCode.toUpperCase();
        courseName = courseName.toUpperCase();
        classType = classType.toUpperCase();
        semester = semester.toUpperCase();
        status = status.toUpperCase();
        faculty = faculty.toUpperCase();

        // Print the formatted output
        if (courseName.length() > maxCharsPerLine) {
            String firstLineCourseName = courseName.substring(0, maxCharsPerLine);
            System.out.printf(" %-15s %-35s %-12s %-20s %-12d %-10.2f %-6s %-10s%n", courseCode, firstLineCourseName, classType, semester, creditHour, fees, status, faculty);

            String remainingCourseName = courseName.substring(maxCharsPerLine);
            System.out.printf("%-10s %-15s %-35s", "", "", remainingCourseName);

        } else {
            // Print the formatted output
            System.out.printf("%-15s %-35s %-12s %-20s %-12d %-10.2f %-6s %-10s", courseCode, courseName, classType, semester, creditHour, fees, status, faculty);
        }
    }

    //for input the programme name to add the course
    public String getProgCode_course() {
        System.out.print("\nEnter programme code to amend course : ");
        String getprogCode = scanner.nextLine();
        return getprogCode.toUpperCase();
    }

    public String getCode_course() {
        System.out.print("\n\nEnter course code to amend course : ");
        String getcourseCode = scanner.nextLine();
        return getcourseCode.toUpperCase();
    }

    //to amend new course code
    public String courseCode_amend() {
        System.out.print("Enter a new course code : ");
        String courseCodeAmend = scanner.nextLine();
        return courseCodeAmend.toUpperCase();
    }

    //to amend new course name
    public String CourseName_amend() {
        System.out.print("Enter a new course name : ");
        String coursenameAmend = scanner.nextLine();
        return coursenameAmend.toUpperCase();
    }

    public String ClassType_amend() {
        System.out.print("Please enter class type: ");
        String classtypeAmend = scanner.nextLine();
        return classtypeAmend.toUpperCase();
    }

    public String Semester_amend() {
        System.out.print("Please enter semester: ");
        String coursesemesterAmend = scanner.nextLine();
        return coursesemesterAmend.toUpperCase();
    }

    public int CreditHour_amend() {
        int creditHourAmend = 0; // Declare course_creditHour outside the try block
        boolean loop = true;

        do {
            System.out.print("Please enter new programme credit hour: ");

            try {
                creditHourAmend = scanner.nextInt(); // Read user's choice
                scanner.nextLine(); // Consume newline character
                loop = false; // Exit the loop if input is successful

            } catch (Exception ex) {
                System.out.println("[Error Message]: Only accept numeric input. Please try again.");
                scanner.nextLine(); // Clear the invalid input from the scanner
            }
        } while (loop);

        return creditHourAmend; // Added for the case when the loop exits without returning a value
    }

    public double Fees_amend() {
        double coursefeesAmend = 0.00; // Declare course_creditHour outside the try block
        boolean loop = true;

        do {
            System.out.print("Please enter new programme fees: ");

            try {
                coursefeesAmend = scanner.nextDouble(); // Read user's choice
                scanner.nextLine(); // Consume newline character
                loop = false; // Exit the loop if input is successful

            } catch (Exception ex) {
                System.out.println("[Error Message]: Only accept numeric input. Please try again.");
                scanner.nextLine(); // Clear the invalid input from the scanner
            }
        } while (loop);

        return coursefeesAmend; // Added for the case when the loop exits without returning a value
    }

    public String Faculty_amend() {
        System.out.print("Please enter faculty: ");
        String coursefacultyAmend = scanner.nextLine();
        return coursefacultyAmend.toUpperCase();
    }

    public String Status_amend() {
        System.out.print("Please enter status: ");
        String coursestatusAmend = scanner.nextLine();
        return coursestatusAmend.toUpperCase();
    }

//   public void faculty_courseUI() {
//        System.out.println();
//        System.out.println("The list of the courses that taken by different faculties");
//        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------");
//        System.out.printf("%-10s %-15s %-35s %-12s %-20s %-12s %-10s %-6s%n", "Faculty", "Course Code", "Course Name", "Class Type", "Semester", "Credit Hour", "Fees(RM)", "Programme Code");
//        System.out.printf("---------------------------------------------------------------------------------------------------------------------------------------");
//    }
//
    public void amendcourseList(String courseCode) {
        courseCode = courseCode.toUpperCase();

        // Print the formatted output
        System.out.printf("%-15s %-30s %n", courseCode);

    }

    public void listCourseUI() {
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%-15s %-35s %-12s %-20s %-12s %-10s %-15s %-10s %-10s%n", "Course Code", "Course Name", "Class Type", "Semester", "Credit Hour", "Fees(RM)", "Programme Code", "Status", "Faculty");
        System.out.print("-----------------------------------------------------------------------------------------------------------------------------------------------");
    }

    public void printCourse(String courseCode, String courseName, String classType, String semester, Integer creditHour, Double fees, String programmeCode, String faculty) {
        // Maximum characters per line for programmeName
        int maxCharsPerLine = 33;
        faculty = faculty.toUpperCase();
        courseCode = courseCode.toUpperCase();
        courseName = courseName.toUpperCase();
        classType = classType.toUpperCase();
        semester = semester.toUpperCase();
        programmeCode = programmeCode.toUpperCase();

        // Print the formatted output
        if (courseName.length() > maxCharsPerLine) {
            String firstLineCourseName = courseName.substring(0, maxCharsPerLine);
            System.out.printf("%-15s %-35s %-12s %-20s %-12d %-10.2f %-6s %-10s%n", courseCode, firstLineCourseName, classType, semester, creditHour, fees, programmeCode, faculty);

            String remainingCourseName = courseName.substring(maxCharsPerLine);
            System.out.printf("%-10s %-15s %-35s", "", "", remainingCourseName);

        } else {
            // Print the formatted output
            System.out.printf("%-15s %-35s %-12s %-20s %-12d %-10.2f %-6s %-10s", courseCode, courseName, classType, semester, creditHour, fees, programmeCode, faculty);
        }
    }

    public void printProg(String progCode, String progName) {
        // Maximum characters per line for programmeName
        int maxCharsPerLine = 33;
        progCode = progCode.toUpperCase();
        progName = progName.toUpperCase();

        // Print the formatted output
        // Print the formatted output
        System.out.printf("-10%s -50%s", progCode, progName);
    }

    public int selectToAmend() {
        int selection = 0;
        boolean loop = true;

        System.out.println("\nCourse Name --> 1");
        System.out.println("Class Type --> 2");
        System.out.println("Semester --> 3");
        System.out.println("Credit Hour --> 4");
        System.out.println("Faculty --> 5");
        System.out.println("Fees --> 6");
        System.out.println("Programme Code --> 7 ");

        System.out.println("\nCourse code not allow to amend.");

        do {
            try {
                System.out.print("Enter your selection: ");
                selection = scanner.nextInt();
                scanner.nextLine(); // Consume newline character
                loop = false;
            } catch (Exception ex) {
                System.out.println("[Error Message]: Only accept numeric input for selection. Please try again.");
                scanner.nextLine(); // Clear the invalid input from the scanner
            }
        } while (loop);

        return selection;
    }

    //=========================================================
    //report
    public void courseReportUI() {

        System.out.println("Course Summary Report");
        System.out.println("==============================");
        DateTime.currentDateTime();

        System.out.println();
        System.out.println("The list of the courses taken by different faculties");
        System.out.printf("%-11s %-35s %-12s %-20s %-12s %-10s %-6s %-10s%n", "Course Code", "Course Name", "Class Type", "Semester", "Credit Hour", "Fees(RM)", "Programme Code", "Faculty");
        System.out.printf("%-11s %-35s %-12s %-20s %-12s %-10s %-6s %-10s%n", "-----------", "-----------", "-----------", "-----------", "-----------", "-----------", "-----------", "-----------");

        System.out.println("");
        System.out.printf("\n%-20s %-30s %-20s", "", "END OF THE COURSE SUMMARY REPORT", "");
        System.out.println("\n====================================================================================================================");

    }

    public int reportSelection() {
        int select = 0;
        boolean loop = true;

        System.out.println("\n1. Course Summary Report ");
        System.out.println("2. Programme Summary Report");

        do {
            try {
                System.out.print("Enter your selection: ");
                select = scanner.nextInt();
                scanner.nextLine(); // Consume newline character
                loop = false;
            } catch (Exception ex) {
                System.out.println("[Error Message]: Only accept numeric input for selection. Please try again.");
                scanner.nextLine(); // Clear the invalid input from the scanner
            }
        } while (loop);

        return select;
    }

    public void list_CourseUI() {
        System.out.println("-------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%-12s %-35s %-12s %-20s %-12s %-10s %-10s%n", "Course Code", "Course Name", "Class Type", "Semester", "Credit Hour", "Fees(RM)", "Faculty");
        System.out.println("-------------------------------------------------------------------------------------------------------------------");
    }

    public void print_Course(String courseCode, String courseName, String classType, String semester, Integer creditHour, Double fees, String faculty) {
        // Maximum characters per line for courseName
        int maxCharsPerLine = 35;

        // Convert strings to uppercase
        faculty = faculty.toUpperCase();
        courseCode = courseCode.toUpperCase();
        courseName = courseName.toUpperCase();
        classType = classType.toUpperCase();
        semester = semester.toUpperCase();

        // Print the formatted output
        if (courseName.length() > maxCharsPerLine) {
            String firstLineCourseName = courseName.substring(0, maxCharsPerLine);
            System.out.printf("%-12s %-35s %-12s %-20s %-12d %-10.2f %-10s%n", courseCode, firstLineCourseName, classType, semester, creditHour, fees, faculty);

            String remainingCourseName = courseName.substring(maxCharsPerLine);
            System.out.printf("%-12s %-35s %-12s %-20s %-12s %-10s %-10s%n", "", remainingCourseName, "", "", "", "", "");
        } else {
            System.out.printf("%-12s %-35s %-12s %-20s %-12d %-10.2f %-10s%n", courseCode, courseName, classType, semester, creditHour, fees, faculty);
        }
    }

    public void listCourse(Iterator<Course> courseIterator) {
        list_CourseUI();

        // Iterator<Course> courseIterator = initializer.courseList.iterator();
        boolean foundData = false; // Initialize foundData flag to track if any data is found

        while (courseIterator.hasNext()) {
            Course course = courseIterator.next();
            print_Course(course.getCourseCode(), course.getCourseName(), course.getClassType(), course.getSemester(), course.getCreditHour(), course.getFees(), course.getFaculty());
            foundData = true;

        }
        System.out.println();

        // Check if no data is found
        if (!foundData && initializer.courseList.isEmpty()) {
            displayListCourseNotFound("No courses found.");
        }
    }
    
//    public void printProgramme(String programmeCode, String courseCode, String courseName) {
//        programmeCode = programmeCode.toUpperCase();
//        courseCode = courseCode.toUpperCase();
//        courseName = courseName.toUpperCase();
//
//        // Print the formatted output
//        System.out.printf("%-15s %-15s %-30s %n", programmeCode,courseCode, courseName);
//    }
//    
    
    
    
    
}
