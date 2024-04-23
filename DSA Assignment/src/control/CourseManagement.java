package control;

//import adt.*;
import entity.Course;
import entity.Programme;
import boundary.CourseUI;
import java.util.Iterator;
import utility.*;
import dao.CourseInitializer;
import java.util.Scanner;

/**
 *
 * @author Hor Pei Yu
 */
public class CourseManagement {

//    private SortedListInterface<Programme> progList = new SortedArrayList<>();
//    private SortedListInterface<Course> courseList = new SortedArrayList<>();
    CourseInitializer initializer = new CourseInitializer();

    CourseUI courseUI = new CourseUI();

    boolean foundData = false;
    Scanner scanner = new Scanner(System.in);

    public void initialize() {
      initializer.CourseInfo();
      initializer.ProgrammeInfo();
    }

    public void runCourseSubsystem() {
        int choice;
        // initializer.CourseInfo();
        // initializer.ProgrammeInfo();

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
                    removeProg();
                    break;

                case 4:
                    removeCourse();
                    break;

                case 5:
                    search();
                    break;

                case 6:
                    amendCourse();
                    break;

                case 7:
                    listFacultyCourse();
                    break;

                case 8:
                    listProgCourse();
                    break;
                case 9:
                    Report();
                    break;
                default:
                    MessageUI.displayInvalidChoiceMessage();
                    break;
            }
            // MessageUI.displayInvalidChoiceMessage();
        } while (choice != 0);
    }

    //--------------------------------- add function --------------------------
    //----------------------------- add course-----------------------------
    private void addNewCourse() {
        courseUI.getAddCourseHeader();
        courseUI.programmeListUI();

        Iterator<Programme> inputIteratorProg = initializer.progList.iterator();

        while (inputIteratorProg.hasNext()) {
            Programme programme = inputIteratorProg.next();
            courseUI.programmeList(programme.getProgCode(), programme.getProgName());
        }

        System.out.println("\nPlease select one programme to add new course\n");

        String programmeCode;
        int progIndex;

        do {
            programmeCode = courseUI.getProgrammeForCourse();
            Programme inputProgramme = new Programme(programmeCode);
            progIndex = initializer.progList.contains(inputProgramme);

            if (progIndex == -1) {
                courseUI.printProgNotExisted();
                continue; // Prompt the user to select a program again
            }

            boolean courseAdded = false;
            boolean exists;

            do {
                exists = false;

                // Collect course information
                String courseCode = courseUI.getCourseCode();

                // Check if the course already exists
                for (Course course : initializer.courseList) {
                    if (course.getCourseCode().equals(courseCode)) {
                        exists = true;
                        break;
                    }
                }

                if (exists) {
                    courseUI.displayAddProgrammeExist(courseCode);
                } else {
                    String courseName = courseUI.getCourseName();
                    String classType = courseUI.getClassType();
                    String semester = courseUI.getSemester();
                    int creditHour = courseUI.getCreditHour();
                    String faculty = courseUI.getFaculty();
                    double fees = courseUI.getFees();
                    String status = courseUI.getStatus();

                    // Create a new course object
                    Course newCourse = new Course(courseCode, courseName, classType, semester, creditHour, faculty, fees, programmeCode, status);

                    // Add the new course to the course list
                    initializer.courseList.add(newCourse);
                    MessageUI.displayRecordSuccessful();
                    courseAdded = true;
                    courseUI.pressEnterToContinue();

                }
            } while (!courseAdded);
            break;
        } while (true); // Continue until a new course is added
    }

    private void addNewProgramme() {
        boolean progAdded = false;

        do {
            courseUI.getAddProgHeader();

            // Collect programme information
            String programmeCode = courseUI.getProgrammeCode();
            String programmeName = courseUI.getProgrammeName();

            // Validate input
            if (programmeCode.isEmpty()) {
                System.out.println("[Error Message]: Code cannot be empty. Please try again.");
                continue;
            }

            if (programmeName.isEmpty()) {
                System.out.println("[Error Message]: Name cannot be empty. Please try again.");
                continue;
            }

// Check if the programme is match with the hardcode or also can add new programme that not exist in hardcode
            boolean exists = false;
            for (Programme prog : initializer.progList) {
                if (prog.getProgCode().contains(programmeCode)) {
                    exists = true;
                    break;
                }
            }

            if (exists) {
                courseUI.displayAddProgrammeExist(programmeCode);
            } else {
                // Display list of courses
                courseUI.courseListUI();
                for (Course course : initializer.courseList) {
                    courseUI.courseList(course.getCourseCode(), course.getCourseName());
                }

                System.out.println("\n\nPlease select one course to add a programme\n");
                String courseCode = courseUI.getCourseForProgramme();
                Course selectedCourse = null;

                // Find the selected course in the course list
                for (Course course : initializer.courseList) {
                    if (course.getCourseCode().equals(courseCode)) {
                        selectedCourse = course;
                        break;
                    }
                }

                if (selectedCourse != null) {
                    // Add programme code to the selected course
                    selectedCourse.setProgrammeCode(programmeCode);

                    // Create new programme and add it to the list
                    Programme newProg = new Programme(programmeCode, programmeName);
                    initializer.progList.add(newProg);

                    // Display success message
                    MessageUI.displayRecordSuccessful();
                    progAdded = true;
                    courseUI.pressEnterToContinue();
                } else {
                    courseUI.printCourseNotExisted();
                }
            }

        } while (!progAdded); // Continue looping until a programme is added successfully
    }

    //--------------------------------- remove function -------------------------------   
    public void removeCourse() {
        listCourseProg_remove();
        String courseCode = courseUI.getCodecourse(); // Get the course code
        Course oldCourse = findCourseByCode(courseCode);

        if (oldCourse != null) {
            System.out.printf("Sure remove course? (y for yes, n for no) : ");
            String confirm = scanner.nextLine();

            if (confirm != null) {
                if (confirm.equalsIgnoreCase("Y")) {
                    // Replace the old course with the updated one in the courseList (assuming initializer is defined elsewhere)
                    initializer.courseList.remove(oldCourse);
                    System.out.println("Course removed successfully.");
                } else if (confirm.equalsIgnoreCase("N")) {
                    System.out.println("Cancelled.");
                }
            } else {
                System.out.println("Invalid input. Cancelling operation.");
            }
        } else {
            System.out.println("Course not found.");
        }
    }

    //------------------remove prog----------------------------
    public void removeProg() {//

        boolean foundData = false;
        Iterator<Course> courseIterator = initializer.courseList.iterator();

        courseUI.listCourse(courseIterator);
        String remove_courseProg = courseUI.removeProg_Course();

        if (remove_courseProg.isEmpty()) {
            System.out.println("[Error Message]: Code cannot be empty. Please try again.");
            return;
        } else if (remove_courseProg.equalsIgnoreCase("X")) {
            return;
        }

        // Initialize foundData flag to track if any data is found
        courseIterator = initializer.courseList.iterator();
        while (courseIterator.hasNext()) {
            Course course = courseIterator.next();

            // Check if the current course's program code matches the remove_courseProg
            if (course.getCourseCode().equals(remove_courseProg)) {
                // Print the course associated with the program
                courseUI.printProgramme(course.getProgrammeCode(), course.getCourseCode(), course.getCourseName());
                foundData = true;

            }
        }

        // Check if no data is found
        if (!foundData) {
            courseUI.displayListCourseNotFound("\nNo courses found.");
        }

        Scanner scanner = new Scanner(System.in); // Uncommented scanner initialization
        System.out.println();
        String remove_programme = courseUI.removeProgramme(); // Get the course code
        Course progToRemove = findProgByCode(remove_programme, remove_courseProg);

        if (progToRemove != null) {
            System.out.printf("Are you sure you want to remove this program? (Y/N): ");
            String confirm = scanner.nextLine();

            if (confirm != null) {
                if (confirm.equalsIgnoreCase("Y")) {
                    // Update the program code of the course to empty string
                    progToRemove.setProgrammeCode("");

                    System.out.println("Course details updated successfully.");
                } else {
                    System.out.println("Operation cancelled.");
                }
            }

            if (remove_programme.isEmpty()) {
                System.out.println("[Error Message]: Code cannot be empty. Please try again.");
                return;
            } else if (remove_programme.equalsIgnoreCase("X")) {
                return; // Exit the search method after running the course subsystem
            }
        }
    }

    //-----------------------list function-----------------------------
    private void listProgCourse() {
        System.out.println();
        // Display UI related to programme courses
        courseUI.programme_courseUI();

        boolean foundData = false;

        Iterator<Programme> inputIteratorProg = initializer.progList.iterator();

        while (inputIteratorProg.hasNext()) {
            Programme programme = inputIteratorProg.next();
            // Reset the iterator for programs for each course
            Iterator<Course> inputIterator = initializer.courseList.iterator();
            // Search for course's programme in progList
            while (inputIterator.hasNext()) {
                Course course = inputIterator.next();
                if (course.getProgrammeCode().contains(programme.getProgCode())) {
                    courseUI.printProgrammeCourse(programme.getProgCode(), programme.getProgName(), course.getCourseCode(), course.getCourseName());
                    foundData = true;

                }
            }
        }

        // Check if no data is found
        if (!foundData) {
            courseUI.displayListCourseNotFound("No courses found.");
        }

        courseUI.pressEnterToContinue();
    }

    private void listFacultyCourse() {
        System.out.println();
        System.out.println("The list of the courses that taken by different faculties");
        // Display UI related to faculty courses
        courseUI.faculty_courseUI();

        Iterator<Course> inputIterator = initializer.courseList.iterator();

        boolean foundData = false; // Initialize foundData flag to track if any data is found

        while (inputIterator.hasNext()) {
            // if (inputIterator.hasNext()) {
            Course course = inputIterator.next();
            System.out.println();
            courseUI.printFacultyCourse(course.getFaculty(), course.getCourseCode(), course.getCourseName(), course.getClassType(), course.getSemester(), course.getCreditHour(), course.getFees(), course.getProgrammeCode(), course.getStatus());

            foundData = true;

        }
        System.out.println();

        // Check if no data is found
        if (!foundData && initializer.courseList.isEmpty()) {
            courseUI.displayListCourseNotFound("No courses found.");
        }
        courseUI.pressEnterToContinue();

    }
//----------------- search function -------------
//binary search // Iterator implementation

    private void search() {
        // Display UI related to faculty courses
        courseUI.search_header();

        String search_courseCode;
        boolean courseFound = false;

        do {
            search_courseCode = courseUI.courseCodeSearch();
            if (search_courseCode.isEmpty()) {
                System.out.println("[Error Message]: Code cannot be empty. Please try again.");
            } else {
                if (search_courseCode.equalsIgnoreCase("X")) {

                    return; // Exit the search method after running the course subsystem
                }

                courseUI.searchOutputUI();
                Iterator<Course> inputIterator = initializer.courseList.iterator();

                while (inputIterator.hasNext()) {
                    Course course = inputIterator.next();
                    if (course.getCourseCode().contains(search_courseCode)) {
                        courseUI.searchOutput(course.getCourseCode(), course.getCourseName(), course.getSemester());
                        courseFound = true;
                    }

                }

                if (!courseFound) {
                    System.out.println("[Error Message]: Course with code " + search_courseCode + " not found.");
                }
            }
        } while (!courseFound);
        courseUI.pressEnterToContinue();
    }

    //==========================Amend==========================
    public void amendCourse() {
        Scanner scanner = new Scanner(System.in);
        listCourse_Prog();
        String courseCode = courseUI.getCode_course(); // Get the course code
        Course oldCourse = findCourseByCode(courseCode);

        if (oldCourse != null) {
            // Create a new course object and initialize it with the values of the old course
            Course newCourse = new Course(oldCourse.getCourseCode(), oldCourse.getCourseName(), oldCourse.getClassType(),
                    oldCourse.getSemester(), oldCourse.getCreditHour(), oldCourse.getFaculty(),
                    oldCourse.getFees(), oldCourse.getProgrammeCode(), oldCourse.getStatus());

            // Call selectToAmend after finding the course
            int selection = courseUI.selectToAmend();

            // Ensure courseUI is defined
            switch (selection) {
                case 1:
                    System.out.printf("Enter New Course Name: ");
                    String newCourseName = scanner.nextLine();
                    newCourse.setCourseName(newCourseName);
                    break;
                case 2:
                    System.out.println("Enter New Class Type: ");
                    String newClassType = scanner.nextLine();
                    newCourse.setClassType(newClassType);
                    break;
                case 3:
                    System.out.println("Enter New Semester: ");
                    String newSemester = scanner.nextLine();
                    newCourse.setSemester(newSemester);
                    break;
                case 4:
                    System.out.println("Enter New Credit Hour: ");
                    int newCreditHour = 0;
                    boolean loop = true;

                    do {
                        System.out.print("Please enter new programme credit hour: ");
                        try {
                            newCreditHour = scanner.nextInt();
                            scanner.nextLine();
                            loop = false;
                        } catch (Exception ex) {
                            System.out.println("[Error Message]: Only accept numeric input. Please try again.");
                            scanner.nextLine();
                        }
                    } while (loop);
                    newCourse.setCreditHour(newCreditHour);
                    break;
                case 5:
                    System.out.println("Enter New Faculty: ");
                    String newFaculty = scanner.nextLine();
                    newCourse.setFaculty(newFaculty);
                    break;
                case 6:
                    System.out.println("Enter New Programme Code: ");
                    String newProgrammeCode = scanner.nextLine();
                    newCourse.setProgrammeCode(newProgrammeCode);
                    break;
                case 7:
                    System.out.println("Enter New Fees: ");
                    double newFees = 0.00;
                    loop = true;

                    do {
                        System.out.print("Please enter new programme fees: ");
                        try {
                            newFees = scanner.nextDouble();
                            scanner.nextLine();
                            loop = false;
                        } catch (Exception ex) {
                            System.out.println("[Error Message]: Only accept numeric input. Please try again.");
                            scanner.nextLine();
                        }
                    } while (loop);
                    newCourse.setFees(newFees);
                    break;
                case 8:
                    System.out.println("Enter New Status: ");
                    String newStatus = scanner.nextLine();
                    newCourse.setStatus(newStatus);
                    break;
                default:
                    System.out.println("Invalid choice.");
            }

            // Replace the old course with the updated one in the courseList (assuming initializer is defined elsewhere)
            initializer.courseList.replace(oldCourse, newCourse);

            System.out.println("Course details updated successfully.");
        } else if (courseCode.equalsIgnoreCase("X")) {
            System.out.println("Cancelled."); // Exit the search method after running the course subsystem
        } else {
            System.out.println("Course not found.");
        }
    }

//    //------------------------Report---------------------------------------
//    //do a report refer ms sent
    private void Report() {
        // Assuming courseUI.reportSelection() returns an int
        int reportSelection = courseUI.reportSelection();

        // Assuming -1 indicates no selection made
        if (reportSelection != -1) {
            switch (reportSelection) {
                case 1:
                    courseReport();
                    break;
                case 2:
                    progReport();
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } else {
            System.out.println("No selection made.");
        }
    }

    private void courseReport() {
        // Call the courseReportUI method to initialize the report
        courseUI.courseReportUI();

        // Initialize variables
        int no = 0;
        int totalCourse = 0;
        double totalFees = 0;
        int totalCredit = 0;
        double highestFees = 0;

        Iterator<Course> inputIterator = initializer.courseList.iterator();
        // Loop through the courses to generate the report
        while (inputIterator.hasNext()) {
            Course course = inputIterator.next();
            // Increment the sequential number
            no++;
            // Call the courseReport method with course details and sequential number
            courseUI.courseReport(no, course.getCourseCode(),
                    course.getCourseName(),
                    course.getSemester(),
                    course.getCreditHour(),
                    course.getFees(),
                    course.getFaculty());

            // Accumulate total course count, total fees, and total credit hours
            totalCourse++;
            totalFees += course.getFees();
            totalCredit += course.getCreditHour();

            // Update highest fees if the current course's fees are higher
            if (course.getFees() > highestFees) {
                highestFees = course.getFees();
            }
        }

        // Calculate average credit hours and fees
        double aveCredit = (double) totalCredit / totalCourse;
        double aveFees = totalFees / totalCourse;

        System.out.println();
        // Display total course count
        courseUI.totalCourse(totalCourse, totalCredit, totalFees);
        courseUI.averageCourse(aveCredit, aveFees, highestFees);

        // Call endReportUI method after the loop ends
        courseUI.endcourseReportUI();

        courseUI.pressEnterToContinue();
    }

    private void progReport() {
        int no = 1;
        int totalMain = 0;
        int totalRepeat = 0;
        int totalResit = 0;
        int totalCourse = 0;
        int totalDiploma = 0;
        int totalBachelor = 0;
        double percentMain = 0;
        double percentResit = 0;
        double percentRepeat = 0;
        String highestLevel = "";
        courseUI.progReportUI();

        // Reset foundData flag
        boolean foundData;

        Iterator<Programme> inputIteratorProg = initializer.progList.iterator();

        while (inputIteratorProg.hasNext()) {
            Programme programme = inputIteratorProg.next();
            // Reset the iterator for programs for each course
            Iterator<Course> inputIterator = initializer.courseList.iterator();

            foundData = false; // Reset foundData for each programme

            // Search for course's programme in progList
            while (inputIterator.hasNext()) {
                Course course = inputIterator.next();
                if (course.getProgrammeCode().contains(programme.getProgCode())) {
                    courseUI.progReport(no, programme.getProgCode(), programme.getProgName(), course.getCourseName(), course.getCourseCode(), course.getStatus());
                    foundData = true;
                    no++; // Incrementing 'no' for the next report
                    totalCourse++;

                    // Increment counters based on programme type
                    if (programme.getProgCode().startsWith("D")) {
                        totalDiploma++;
                    } else if (programme.getProgCode().startsWith("R")) {
                        totalBachelor++;
                    }

                    // Increment counters based on course status
                    if ("Main".equalsIgnoreCase(course.getStatus())) {
                        totalMain++;
                    } else if ("Repeat".equalsIgnoreCase(course.getStatus())) {
                        totalRepeat++;
                    } else if ("Resit".equalsIgnoreCase(course.getStatus())) {
                        totalResit++;
                    }
                }
            }
        }

        // Determine highest level
        if (totalDiploma > totalBachelor) {
            highestLevel = "DIPLOMA";
        } else if (totalBachelor > totalDiploma) {
            highestLevel = "BACHELOR";
        }

        // Calculate percentages
        if (totalCourse > 0) {
            percentMain = (double) totalMain / totalCourse * 100;
            percentResit = (double) totalResit / totalCourse * 100;
            percentRepeat = (double) totalRepeat / totalCourse * 100;
        }

        // Pass total counts to the UI
        courseUI.totalProg(totalCourse, totalMain, totalRepeat, totalResit);
        courseUI.countProg(totalDiploma, totalBachelor, highestLevel, percentMain, percentResit, percentRepeat);
        courseUI.endprogReportUI();
        courseUI.pressEnterToContinue(); // Call the function to wait for user input
    }

    //=======================================================================================
    //----------------------------------Additional function-----------------------------------
    //without courseUI.pressEnterToContinue(); 
    public void listCourse_Prog() {//used by amend 

        listProg_Course();
        String getProgCode_course = courseUI.getProgCode_course();

        Iterator<Course> inputIterator = initializer.courseList.iterator();
        if (getProgCode_course.isEmpty()) {
            System.out.println("[Error Message]: Code cannot be empty. Please try again.");
            return; // Removed return null;
        } else if (getProgCode_course.equalsIgnoreCase("X")) {

            return; // Removed return null;
        }

        boolean foundData = false; // Initialize foundData flag to track if any data is found

        courseUI.amendCourseUI();

        while (inputIterator.hasNext()) {
            Course course = inputIterator.next();
            if (course.getProgrammeCode().equalsIgnoreCase(getProgCode_course)) {
                // Found the course with the matching code

                // Display UI related to faculty courses
                System.out.println();
                courseUI.amendCourseList(
                        course.getCourseCode(),
                        course.getCourseName(),
                        course.getClassType(),
                        course.getSemester(),
                        course.getCreditHour(),
                        course.getFees(),
                        course.getProgrammeCode(),
                        course.getFaculty()
                );
                foundData = true;
            }
        }

        // Check if no data is found
        if (!foundData) {
            courseUI.displayListCourseNotFound("\nNo courses found.");

        }
    }

    public void listCourseProg_remove() { //used by remove

        listProg_Course();
        String getProgCodeCourse = courseUI.getProgCodeCourse();

        Iterator<Course> inputIterator = initializer.courseList.iterator();
        if (getProgCodeCourse.isEmpty()) {
            System.out.println("[Error Message]: Code cannot be empty. Please try again.");
            return; // Removed return null;
        } else if (getProgCodeCourse.equalsIgnoreCase("X")) {

            return; // Removed return null;
        }

        boolean foundData = false; // Initialize foundData flag to track if any data is found

        courseUI.amendCourseUI();

        while (inputIterator.hasNext()) {
            Course course = inputIterator.next();
            if (course.getProgrammeCode().equalsIgnoreCase(getProgCodeCourse)) {
                // Found the course with the matching code

                // Display UI related to faculty courses
                System.out.println();
                courseUI.amendCourseList(
                        course.getCourseCode(),
                        course.getCourseName(),
                        course.getClassType(),
                        course.getSemester(),
                        course.getCreditHour(),
                        course.getFees(),
                        course.getProgrammeCode(),
                        course.getFaculty()
                );
                foundData = true;
            }
        }

        // Check if no data is found
        if (!foundData) {
            courseUI.displayListCourseNotFound("\nNo courses found.");

        }
    }

    private void listProg_Course() {
        System.out.println();
        // Display UI related to programme courses
        courseUI.programme_courseUI();

        boolean foundData = false;

        Iterator<Programme> inputIteratorProg = initializer.progList.iterator();

        while (inputIteratorProg.hasNext()) {
            Programme programme = inputIteratorProg.next();
            // Reset the iterator for programs for each course
            Iterator<Course> inputIterator = initializer.courseList.iterator();
            // Search for course's programme in progList
            while (inputIterator.hasNext()) {
                Course course = inputIterator.next();
                if (course.getProgrammeCode().equalsIgnoreCase(programme.getProgCode())) {
                    courseUI.printProgrammeCourse(programme.getProgCode(), programme.getProgName(), course.getCourseCode(), course.getCourseName());
                    foundData = true;

                }
            }
        }

        // Check if no data is found
        if (!foundData) {
            courseUI.displayListCourseNotFound("No courses found.");
        }
    }

    public void listCourseProg() { //used by remove
        listProgCourse();
        String getProgCode_course = courseUI.getProgCode_course();

        Iterator<Course> inputIterator = initializer.courseList.iterator();
        if (getProgCode_course.isEmpty()) {
            System.out.println("[Error Message]: Code cannot be empty. Please try again.");
            return; // Removed return null;
        } else if (getProgCode_course.equalsIgnoreCase("X")) {

            return; // Removed return null;
        }

        boolean foundData = false; // Initialize foundData flag to track if any data is found

        System.out.println("\nThe list of the courses that taken by different faculties");
        courseUI.faculty_courseUI();

        while (inputIterator.hasNext()) {
            Course course = inputIterator.next();
            if (course.getProgrammeCode().equalsIgnoreCase(getProgCode_course)) {
                // Found the course with the matching code

                // Display UI related to faculty courses
                System.out.println();
                courseUI.printCourse(
                        course.getCourseCode(),
                        course.getCourseName(),
                        course.getClassType(),
                        course.getSemester(),
                        course.getCreditHour(),
                        course.getFees(),
                        course.getProgrammeCode(),
                        course.getFaculty()
                );
                foundData = true;
                courseUI.pressEnterToContinue();
            }
        }

        // Check if no data is found
        if (!foundData) {
            courseUI.displayListCourseNotFound("\nNo courses found.");
        }
    }

    public Course findCourseByCode(String courseCode) { //used by remove & amend
        if (courseCode.isEmpty()) {
            System.out.println("[Error Message]: Code cannot be empty. Please try again.");
            return null;
        } else if (courseCode.equalsIgnoreCase("X")) {

            return null; // Exit the search method after running the course subsystem
        }

        Iterator<Course> courseIterator = initializer.courseList.iterator();
        while (courseIterator.hasNext()) {
            Course course = courseIterator.next();
            if (course.getCourseCode().equalsIgnoreCase(courseCode)) {
                return course; // Found the course with the matching code
            }

        }
        System.out.println("[Error Message]: Course with code " + courseCode + " not found.");
        return null;// Course not found
    }

    public Course findProgByCode(String remove_programme, String remove_courseProg) {

        boolean foundData = false;

        // Iterate through the course list to find a course with the given program code
        Iterator<Course> courseIterator = initializer.courseList.iterator();
        while (courseIterator.hasNext()) {
            Course course = courseIterator.next();
            if (course.getProgrammeCode().equalsIgnoreCase(remove_programme)
                    && course.getCourseCode().equalsIgnoreCase(remove_courseProg)) {
                return course; // Found the course with the matching program code
            }
        }
        System.out.println("[Error Message]: Programme with code " + remove_programme + " not found.");
        return null; // Course not found
    }
}
