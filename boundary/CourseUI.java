package boundary;

import java.util.Scanner;

/**
 *
 * @author Hor Pei Yu
 */

public class CourseUI {
    int coursechoice;
    
    //ListInterface<Course> courseList = new SortedArrayList<>();
    Scanner scanner = new Scanner(System.in);
    
    public int getMenuChoice() {
         
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
   
   
    public void getAddProgHeader() {
        System.out.println("-------------------------------------------------");
        System.out.println("        Add a new programme");
        System.out.println("-------------------------------------------------");
    }
    
      //for input the programme
    public String getProgrammeCode() {
        System.out.print("Enter new prorgamme code : ");
        String programmeCode = scanner.nextLine();
        return programmeCode.toUpperCase();
    }
    
      //for input the programme
    public String getProgrammeName() {
        System.out.print("Enter new full name of prorgamme : ");
        String programmeName = scanner.nextLine();
        return programmeName.toUpperCase();
    }
    
    public void getAddCourseHeader() {
        System.out.println("-------------------------------------------------");
        System.out.println("        Add a new course");
        System.out.println("-------------------------------------------------");
    }
    
  
  //for input the programme name to add the course
    public String getProgrammeForCourse(){
        System.out.print("Enter programme to add course : ");
        String stu_programmeCode = scanner.nextLine();
        return stu_programmeCode.toUpperCase();
    }
    
    //to get new course code
     public String getCourseCode(){
        System.out.print("Enter a new course code : ");
        String course_code = scanner.nextLine();
        return course_code.toUpperCase();
    }
     
     //to get new course name
     public String getCourseName(){
          System.out.print("Enter a new course name : ");
        String course_name = scanner.nextLine();
        return course_name.toUpperCase();
     }
     
      public String getClassType(){
        System.out.print("Please enter class type: ");
        String class_type = scanner.nextLine();
        return class_type.toUpperCase();
    }
     
      public String getSemester(){
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
      
      
     public String getFaculty(){
        System.out.print("Please enter faculty: ");
        String course_faculty = scanner.nextLine();
        return course_faculty.toUpperCase();
    }
     
     
     //-----------------display-----------------------------
     
     public void programme_courseUI(){
          System.out.println();
         System.out.println("List all courses for a programme");
         System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------");
         System.out.printf("%-15s %-30s %-15s %-30s %-12s %-20s %-12s %-10s %-12s%n", "Programme Code","Programme Name","Course Code", "Course Name", "Class Type", "Semester", "Credit Hour", "Fees","Faculty");
       System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------");
     }
     
  public void printProgrammeCourse(String programmeCode, String programmeName, String courseCode, String courseName, String classType, String semester, Integer creditHour, Double fees, String faculty) {
    // Maximum characters per line for programmeName
    int maxCharsPerLine = 26;

    // Print the formatted output
    if (programmeName.length() > maxCharsPerLine && courseName.length() > maxCharsPerLine) {
        // Truncate programmeName if it's too long
        String firstLineProgrammeName = programmeName.substring(0, maxCharsPerLine);
        String firstLineCourseName = courseName.substring(0, maxCharsPerLine);
        System.out.printf("%-15s %-30s %-15s %-30s %-12s %-20s %-12d %-10.2f %-12s%n", programmeCode, firstLineProgrammeName, courseCode, firstLineCourseName, classType, semester, creditHour, fees, faculty);
        
        // Print the remaining part of programmeName on the next line
        String remainingProgrammeName = programmeName.substring(maxCharsPerLine);
        String remainingCourseName = courseName.substring(maxCharsPerLine);
            System.out.printf("%-15s %-30s %-15s %-30s%n", "", remainingProgrammeName,"",remainingCourseName);
        
    } else {
        // Print the formatted output
        System.out.printf("%-15s %-30s %-15s %-30s %-12s %-20s %-12d %-10.2f %-12s", programmeCode, programmeName, courseCode, courseName, classType, semester, creditHour, fees, faculty);
    }
}

    public void faculty_courseUI(){
          System.out.println();   
         System.out.println("The list of the courses that taken by different faculties");
         System.out.println("---------------------------------------------------------------------------------------------------------------------------------------");
         System.out.printf("%-10s %-15s %-35s %-12s %-20s %-12s %-10s %-6s%n", "Faculty","Course Code", "Course Name", "Class Type", "Semester", "Credit Hour","Fees(RM)","Programme Code");
       System.out.println("---------------------------------------------------------------------------------------------------------------------------------------");
     }

  public void printFacultyCourse(String faculty, String courseCode, String courseName, String classType, String semester, Integer creditHour, Double fees, String programmeCode) {  
  // Maximum characters per line for programmeName
    int maxCharsPerLine = 33;

    // Print the formatted output
    if (courseName.length() > maxCharsPerLine) {
        String firstLineCourseName = courseName.substring(0, maxCharsPerLine);
        System.out.printf("%-10s %-15s %-35s %-12s %-20s %-12d %-10.2f %-6s%n", faculty, courseCode, firstLineCourseName, classType, semester, creditHour, fees, programmeCode);
              
        String remainingCourseName = courseName.substring(maxCharsPerLine);
        System.out.printf("%-10s %-15s %-35s", "","",remainingCourseName);
        
    } else {
        // Print the formatted output
       System.out.printf("%-10s %-15s %-35s %-12s %-20s %-12d %-10.2f %-6s", faculty, courseCode, courseName, classType, semester, creditHour, fees, programmeCode);
    }
  }

     public static void displayAddProgrammeExist(String programme){
        System.out.println("Programme "+ programme +" already existed");    
    }
    
      public void displayAddCourseExist(String course_code){
        System.out.println("Programme "+ course_code +" already existed");    
    }
    
     public static void printProgNotExisted(){
        System.out.println("\u001B[31mThe programme is not existed.\u001B[0m");
        System.out.println("\u001B[31mPlease enter programme in the programme function.\u001B[0m");
    }
    
//     public static void displayListProgNotFound(String Programme) {
//        System.out.println("Programme " + Programme + " not found.");
//    }
     
      public static void displayListCourseNotFound(String Course) {
        System.out.println( Course);
    }
      
      //remove-------------------
      
      public void removeProgHeader() {
        System.out.println("-------------------------------------------------");
        System.out.println("        Remove a programme");
        System.out.println("-------------------------------------------------");
    }
      
      public String removeProg_Course(){
          System.out.print("Enter course code to remove programme :");
          String remove_courseProg = scanner.nextLine();
          return remove_courseProg;
      }
      
      public String removeCourse_Prog(){
          System.out.println("Enter programme code to remove course :");
          String remove_progCourse = scanner.nextLine();
          return remove_progCourse;
      }
     
      //for remove the programme
    public String removeProgramme() {
        System.out.print("Enter prorgamme code to remove: ");
        String remove_programme = scanner.nextLine();
        return remove_programme;
    }
    
    //---------------------------------------------------
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
     
    public boolean confirmAction(String message) {
        String input;
        boolean validInput = false;

        do {
            System.out.print(message + " (y/n): ");
            input = scanner.nextLine().trim().toLowerCase();
            if (input.equals("y") || input.equals("n")) {
                validInput = true;
            } else {
                System.out.println("Invalid input. Please enter 'y' or 'n'.");
            }
        } while (!validInput);

        return input.equals("y");
    }
    
    
    // Find course
    public String findCourseUI() {
        System.out.println("\nSearch Courses");
        System.out.println("=====================");
        String courseCode = courseCodeUI();
        System.out.println("=====================");
        return courseCode;
    }
     
    }
    
    
    
    
    
    

     

        
       
        
    

