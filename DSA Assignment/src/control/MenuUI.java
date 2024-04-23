package control;

import java.util.Scanner;
import utility.MessageUI;

public class MenuUI {

   public static void MainMenu(CourseManagement courseCtrl) {
        StudentRegistration studentCtrl = new StudentRegistration();
        
        runMain(courseCtrl, studentCtrl);
    }

    public static void runMain(CourseManagement courseCtrl, StudentRegistration studentCtrl) {
        // Initialize hardcoded data
        courseCtrl.initialize();
        studentCtrl.initialize(courseCtrl.initializer);


        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n=== UNIVERSITY SYSTEM ===\n");
            System.out.println("=========================");
            System.out.println("==      MAIN MENU      ==");
            System.out.println("=========================");
            System.out.println("1. Course Management Subsystem (HOR PEI YU)");
            System.out.println("2. Student Registration Management (LEE WENG YAN)");
            System.out.println("3. Tutorial Group Management (LOW JIA YU)");
            System.out.println("4. Teaching Assignment Subsystem (KHONG SHU YEN)");
            System.out.println("5. Assignment Team Management (WONG YEN JUN)");
            System.out.println("0. Quit\n");

            System.out.print("Enter the number of subsystem: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            System.out.println();

            switch (choice) {
                case 0:
                    MessageUI.displayExitMessage();
                    break;
                case 1:
                    courseCtrl.runCourseSubsystem();
                    break;
                case 2:
                    studentCtrl.runStudentRegistration();
                    break;
                case 3:
                    // Add logic for Tutorial Group Management
                    break;
                case 4:
                    // Add logic for Teaching Assignment Subsystem
                    break;
                case 5:
                    // Add logic for Assignment Team Management
                    break;
                default:
                    MessageUI.displayInvalidChoiceMessage();
            }
        } while (choice != 0);
        
        scanner.close();
    }
    
    public static void main(String[] args) {
        CourseManagement courseCtrl = new CourseManagement(); // Create instance of CourseManagement
        MainMenu(courseCtrl);
    }
}
