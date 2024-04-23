package boundary;

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
        initializer.CourseInfo();
//        initializer.ProgrammeInfo();

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
        System.out.println("\nCourse List");
        System.out.println("-----------------------------------------------------------");
        System.out.printf("%-15s %-35s %n", "Course Code", "Course Name");
        System.out.printf("-----------------------------------------------------------\n");

    }

    public void courseList(String courseCode, String courseName) {
        courseCode = courseCode.toUpperCase();
        courseName = courseName.toUpperCase();
        System.out.printf("%-15s %-35s %n", courseCode, courseName);

    }

    public void programmeListUI() {
        System.out.println();
        System.out.println("Programme List");
        System.out.println("-------------------------------------------------------------------------------------------");
        System.out.printf("%-15s %-80s %n", "Programme Code", "Programme Name");
        System.out.println("-------------------------------------------------------------------------------------------");
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
        System.out.print("-------------------------------------------------\n");
    }

    //for input the programme name to add the course
    public String getCourseForProgramme() {
        System.out.print("Enter course to add programme : ");
        String stu_codeProg = scanner.nextLine().toUpperCase();
        System.out.println(); // Add this line if you want a newline after input        
        return stu_codeProg;
    }

    //for input the programme
    public String getProgrammeCode() {
        String programmeCode;
        do {
            System.out.print("Enter new programme code : ");
            programmeCode = scanner.nextLine(); // trim to remove leading and trailing whitespace
            if (programmeCode.isEmpty()) {
                System.out.println("[Error Message]: Code cannot be empty. Please try again.");
            }
        } while (programmeCode.isEmpty()); // Keep asking until a non-empty value is provided
        return programmeCode.toUpperCase(); // Convert to uppercase
    }

    //for input the programme
    public String getProgrammeName() {
        String programmeName;
        do {
            System.out.print("Enter new full name of programme: ");
            programmeName = scanner.nextLine(); // trim to remove leading and trailing whitespace
            if (programmeName.isEmpty()) {
                System.out.println("[Error Message]: Name cannot be empty. Please try again.");
            }
        } while (programmeName.isEmpty()); // Keep asking until a non-empty value is provided
        return programmeName.toUpperCase(); // Convert to uppercase
    }

    public void getAddCourseHeader() {
        System.out.println("-------------------------------------------------");
        System.out.println("        Add a new course");
        System.out.println("-------------------------------------------------");

    }

    public String getProgrammeForCourse() {
        String stu_programmeCode;
        do {
            System.out.print("Enter programme to add course : ");
            stu_programmeCode = scanner.nextLine();
            System.out.printf("---------------------------------------------------------\n");
            if (stu_programmeCode == null || stu_programmeCode.trim().isEmpty()) {
                System.out.println("Please enter a valid programme code.");
            } else {
                break;
            }
        } while (true);
        return stu_programmeCode.toUpperCase();
    }

    //to get new course code
    public String getCourseCode() {
        String course_code;
        do {
            System.out.print("Enter new course code: ");
            course_code = scanner.nextLine(); // trim to remove leading and trailing whitespace
            if (course_code.isEmpty()) {
                System.out.println("[Error Message]: Code cannot be empty. Please try again.");
            }
        } while (course_code.isEmpty());

        return course_code.toUpperCase();
    }

    //to get new course name
    public String getCourseName() {

        String course_name;
        do {
            System.out.print("Enter new full name of course name: ");
            course_name = scanner.nextLine(); // trim to remove leading and trailing whitespace
            if (course_name.isEmpty()) {
                System.out.println("[Error Message]: Name cannot be empty. Please try again.");
            }
        } while (course_name.isEmpty());
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
        int course_creditHour = 0; // Initialize course_creditHour variable

        // Prompt the user until a non-empty input is provided
        do {
            System.out.print("Please enter new programme credit hour: ");
            String input = scanner.nextLine().trim(); // Read user input and trim leading/trailing whitespace

            // Check if the input is empty
            if (input.isEmpty()) {
                System.out.println("[Error Message]: Credit hour cannot be empty. Please try again.");
                continue; // Prompt the user again
            }

            try {
                course_creditHour = Integer.parseInt(input); // Parse input to integer
                if (course_creditHour <= 0) {
                    System.out.println("[Error Message]: Credit hour must be a positive integer. Please try again.");
                    continue; // Prompt the user again
                }
            } catch (NumberFormatException e) {
                System.out.println("[Error Message]: Please enter a valid integer for credit hour.");
                continue; // Prompt the user again
            }
        } while (course_creditHour <= 0); // Repeat until a valid input is provided

        return course_creditHour;
    }

    public double getFees() {
        double course_fees = 0.00; // Initialize course_fees variable
        boolean loop = true;

        do {
            System.out.print("Please enter new programme fees: ");
            String input = scanner.nextLine().trim(); // Read user input and trim leading/trailing whitespace

            // Check if the input is empty
            if (input.isEmpty()) {
                System.out.println("[Error Message]: Fees cannot be empty. Please try again.");
                continue; // Prompt the user again
            }

            try {
                course_fees = Double.parseDouble(input); // Parse input to double
                loop = false; // Exit the loop if input is successful

            } catch (NumberFormatException ex) {
                System.out.println("[Error Message]: Only accept numeric input. Please try again.");
            }
        } while (loop);

        return course_fees; // Return the entered course fees
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

    public void printProgrammeUI() {
        System.out.println();
        System.out.println("List all courses for a programme");
        System.out.println("------------------------------------------------------------------------------------------------");
        System.out.printf("| %-15s | %-15s | %-35s | %n", "Programme Code", "Course Code", "Course Name");
        System.out.println("------------------------------------------------------------------------------------------------");
    }

    public void printProgramme(String programmeCode, String courseCode, String courseName) {
        printProgrammeUI();
        programmeCode = programmeCode.toUpperCase();
        courseCode = courseCode.toUpperCase();
        courseName = courseName.toUpperCase();
        // Print the formatted output
        System.out.printf("| %-15s | %-15s | %-35s | %n", programmeCode, courseCode, courseName);
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
        System.out.println("Please enter course code in the course list. Please try again");
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
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%-15s %-35s %-12s %-20s %-12s %-10s %-10s %-10s%n", "Course Code", "Course Name", "Class Type", "Semester", "Credit Hour", "Fees(RM)", "Programme Code", "Faculty");
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
            System.out.printf(" %-15s %-35s %-12s %-20s %-12d %-10.2f %-15s %-10s%n", courseCode, firstLineCourseName, classType, semester, creditHour, fees, status, faculty);

            String remainingCourseName = courseName.substring(maxCharsPerLine);
            System.out.printf("%-10s %-15s %-35s", "", "", remainingCourseName);

        } else {
            // Print the formatted output
            System.out.printf("%-15s %-35s %-12s %-20s %-12d %-10.2f %-15s %-10s", courseCode, courseName, classType, semester, creditHour, fees, status, faculty);
        }
    }

    //for input the programme name to add the course
    public String getProgCode_course() {
        System.out.print("\nEnter programme code to amend course : ");
        String getprogCode = scanner.nextLine();
        return getprogCode.toUpperCase();
    }

    public String getProgCodeCourse() {
        System.out.print("\nEnter programme code to remove course : ");
        String getprogCode = scanner.nextLine();
        return getprogCode.toUpperCase();
    }

    public String getCode_course() {
        System.out.print("\n\nEnter course code to amend course (x to cancel) : ");
        String getcourseCode = scanner.nextLine();
        return getcourseCode.toUpperCase();
    }

    public String getCodecourse() {
        System.out.print("\n\nEnter course code to remove (x to cancel) : ");
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

        System.out.println("\nCourse Name -->        1");
        System.out.println("Class Type -->        2");
        System.out.println("Semester -->          3");
        System.out.println("Credit Hour -->       4");
        System.out.println("Faculty -->           5");
        System.out.println("Fees -->              6");
        System.out.println("Programme Code -->    7");

        System.out.println("\nCourse code is not allow to amend.");

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

//        Iterator<Course> courseIterator = initializer.courseList.iterator();
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

    //=========================================================
    //report
    public void courseReportUI() {
        System.out.println("=================================================================================================================================================================");

        System.out.printf("%-30s %-30s %n", "", "TUNKU ABDUL RAHMAN UNIVERSITY OF MANAGEMENT AND TECHNOLOGY UNIVERSITY SYSTEM - COURSE SUMMARY REPORT", "");

        System.out.printf("%-50s %-50s %-30s%n", "", "------------------------------------------------------------", "");

        DateTime.currentDateTime();
        System.out.println();
        System.out.printf("%-5s %-25s %-25s %-15s %-10s %-17s %-10s %n", "", "COURSE CODE", "COURSE NAME", "SEMESTER", "CREDIT HOUR", "TUITION FEES (RM)", "FACULTY");
        System.out.printf("%-5s %-25s %-25s %-15s %-10s %-17s %-10s %n", "", "-----------", "-----------", "-----------", "-----------", "----------------", "-------"); // Adjust the length of each separator as per the corresponding title width
    }

    public void courseReport(int no, String courseCode, String courseName, String semester, int creditHour, double fees, String faculty) {
        courseCode = courseCode.toUpperCase();
        courseName = courseName.toUpperCase();
        semester = semester.toUpperCase();
        faculty = faculty.toUpperCase();
        System.out.printf("%-5d %-12s %-35s %-22s %-10d %-15.2f %-10s %n", no, courseCode, courseName, semester, creditHour, fees, faculty);

    }

    public int reportSelection() {
        int select = 0;
        boolean loop = true;

        System.out.println("\nREPORT SELECTION\nPlease choose the report.\n----------------");
        System.out.println("1. Course Summary Report ");
        System.out.println("2. Programme Summary Report");

        do {
            try {
                System.out.print("\nEnter your selection: ");
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

    public void progReportUI() {
        System.out.println("=========================================================================================================================================================================================");

        System.out.printf("%-30s %-30s %n", "", "TUNKU ABDUL RAHMAN UNIVERSITY OF MANAGEMENT AND TECHNOLOGY UNIVERSITY SYSTEM - PROGRAMME SUMMARY REPORT", "");

        System.out.printf("%-50s %-50s %-30s%n", "", "------------------------------------------------------------", "");

        DateTime.currentDateTime();
        System.out.println();
        System.out.printf("%-5s %-15s %-78s %-15s %-35s %-10s%n", "", "PROGRAMME CODE", "PROGRAMME NAME", "COURSE CODE", "COURSE NAME", "STATUS");
        System.out.printf("%-5s %-15s %-78s %-15s %-35s %-10s%n", "", "--------------", "--------------", "-----------", "-----------", "------"); // Adjust the length of each separator as per the corresponding title width
    }

    public void progReport(int no, String progCode, String progName, String courseName, String courseCode, String status) {
        progCode = progCode.toUpperCase();
        progName = progName.toUpperCase();
        courseName = courseName.toUpperCase();
        courseCode = courseCode.toUpperCase();
        status = status.toUpperCase();
        System.out.printf("%-5d %-15s %-78s %-15s %-35s %-10s%n", no, progCode, progName, courseCode, courseName, status);
    }

    public void totalCourse(int total, int hourTotal, double totalFees) {
        System.out.printf("Total %d Course : Total %d Credit Hours, Total RM %.2f Tuition Fees%n", total, hourTotal, totalFees);
        System.out.printf("\n------------------------------------------------------------\n", "");

    }

    public void averageCourse(double aveHourTotal, double aveTotalFees,double highestFees) {
        System.out.printf("Average Total Credit Hour: %.2f\n", aveHourTotal);
        System.out.printf("Average Total Tuition Fees (RM): %.2f\n", aveTotalFees);
        System.out.printf("Highest Tuition Fees (RM): %.2f\n", highestFees);

        System.out.println();
    }

    public void countProg(int totalDiploma, int totalBachelor, String highestTertiary, double percentMain, double percentResit, double percentRepeat) {
        System.out.printf("Total Number of Diploma Level : %d\n", totalDiploma);
        System.out.printf("Total Number of Bachelor Level : %d\n", totalBachelor);
        System.out.printf("Highest Tertiary Level : %s\n", highestTertiary);

        System.out.println();

        System.out.printf("Percentage of Main Status of Overall Course : %.2f%%\n", percentMain);
        System.out.printf("Percentage of Resit Status Overall Course : %.2f%%\n", percentResit);
        System.out.printf("Percentage of Repeat Status Overall Course : %.2f%%\n", percentRepeat);
        System.out.println();

    }

    public void totalProg(int total, int mainTotal, int repeatTotal, int resitTotal) {
        System.out.println("\nTotal " + total + " Course : " + mainTotal + " Main ," + repeatTotal + " Repeat ," + resitTotal + " Resit");
        System.out.printf("\n------------------------------------------------------------\n", "");
    }

    public void endprogReportUI() {
        System.out.printf("\n%-30s %-30s %-30s%n", "", "END OF THE PROGRAMME REPORT", "");
        System.out.println("=========================================================================================================================================================================================");
    }

    public void endcourseReportUI() {
        System.out.printf("\n%-30s %-30s %-30s%n", "", "END OF THE COURSE REPORT", "");
        System.out.println("=================================================================================================================================================================");

    }

    public static void pressEnterToContinue() {
        System.out.println("\nPress Enter to continue...");
        try {
            System.in.read(); // Wait for the user to press Enter
        } catch (Exception e) {
            e.printStackTrace(); // Handle any exceptions that might occur
        }
    }

    public String getUserInput() {
        Scanner scanner = new Scanner(System.in);

        // Ask the user if they want to add the programme as new data
        System.out.println("Programme with the same code and name already exists.");
        System.out.println("Do you want to add it as new data? (yes/no)");

        return scanner.nextLine().toLowerCase(); // Convert the user input to lowercase
    }

}
