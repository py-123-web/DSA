package boundary;

import control.CourseManagement;
import java.util.Scanner;
import utility.MessageUI;

/**
 * MenuConsole class handles the console menu for the university system.
 * 
 * @author syhor
 */
public class MenuUI {
    int choice; // Variable to store user's choice
    
    Scanner scanner = new Scanner(System.in);
    
    // Method to display the menu and get user's choice
    public int getMenuChoice() {
        System.out.println("\n=== UNIVERSITY SYSTEM ===");
        System.out.println("");
        
        System.out.println("=========================");
        System.out.println("==      MAIN MENU      ==");
        System.out.println("=========================");
        
        System.out.println("1. Course Management Subsystem (HOR PEI YU)");
        System.out.println("2. Student Registration Management (LEE WENG YAN)");
        System.out.println("3. Tutorial Group Management (LOW JIA YU)");
        System.out.println("4. Teaching Assignment Subsystem (KHONG SHU YEN)");
        System.out.println("5. Assignment Team Management (WONG YEN JUN)");
        System.out.println("0. Quit");
        
        System.out.println("");
        
        System.out.print("Enter the number of subsystem: ");
        choice = scanner.nextInt(); // Read user's choice
        scanner.nextLine(); // Consume newline character
        
        return choice;
    }
    
    // Method to run the selected subsystem
    public void runSubsystem() {
        do {
            choice = getMenuChoice(); // Get user's choice
            switch(choice) {
                case 0:
                    MessageUI.displayExitMessage();
                    break;
                case 1:  
                   connectCourse();
                    break;
                case 2:
                    // Call method to run Student Registration Management subsystem
                    break;
                case 3:
                    // Call method to run Tutorial Group Management subsystem
                    break;
                case 4:
                    // Call method to run Teaching Assignment Subsystem
                    break;
                case 5:
                    // Call method to run Assignment Team Management subsystem
                    break;
                default:
                    MessageUI.displayInvalidChoiceMessage();
                    break;
            } 
            
        } while (choice != 0);
    }
    
//    to connect course management subsystem
    public static void connectCourse(){
        CourseManagement courseManagement = new CourseManagement();
        courseManagement.runCourseSubsystem(); // Start the menu subsystem
    }
    
    //to connect student management subsystem
    
    
    
    //to connect tutorial management subsystem
    
    
    
    
    //to connect teaching management subsystem
    
    
    
    //to connect assignment management subsystem
    
    
    
    
    public static void main(String[] args) {
        
        MenuUI menuConsole = new MenuUI();
        menuConsole.runSubsystem(); // Start the menu subsystem
    }
}
