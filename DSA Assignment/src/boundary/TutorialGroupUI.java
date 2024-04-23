//package boundary;
//
//import java.util.Scanner;
//import control.*;
//import dao.*;
//
//public class TutorialGroupUI {
//    public static void main(String[] args) {
//        TutorialGroupController tutorialGroupSystem = new TutorialGroupController(); // Initialize TutorialGroupController
//        TutorialGrpInitializer tutorialGrpInitializer = new TutorialGrpInitializer(); // Create an instance of TutorialGrpInitializer
//        
//        Scanner scanner = new Scanner(System.in);
//        int choice;
//
//               do {
//            // Display menu options
//            System.out.println("");
//            System.out.println("===============================================");
//            System.out.println("+         TUTORIAL GROUP MENU                 +");
//            System.out.println("===============================================");
//            System.out.println("+     1. Add New Tutorial Group               +");
//            System.out.println("+     2. Delete Tutorial Group                +");
//            System.out.println("+     3. Amend Tutorial Group                 +");
//            System.out.println("+     4. Merge Tutorial Group                 +");
//            System.out.println("+     5. List All Tutorial Group              +");
//            System.out.println("+     6. Tutorial Group Report                +");
//            System.out.println("+     7. Add Student in Tutorial Group        +");
//            System.out.println("+     8. Delete Student in Tutorial Group     +");
//            System.out.println("+     9. Amend Student in Tutorial Group      +");
//            System.out.println("+     10. Change Student of Tutorial Group    +");
//            System.out.println("+     11. List All Student in Tutorial Group  +");
//            System.out.println("+     12. Student Tutorial Group Report       +");
//            System.out.println("+     0. Quit                                 +");
//            System.out.println("===============================================");
//            System.out.print("\n Enter choice: ");
//
//            
//            
//            choice = scanner.nextInt();
//            scanner.nextLine(); // Consume newline character
//
//            switch (choice) {
//                case 1:
//                   tutorialGroupSystem.addTutorialGroup();
//                        break;
//                case 2:
//                    tutorialGroupSystem.deleteTutorialGroup();
//                    break;
//                case 3:
//                   tutorialGroupSystem.amendTutorialGroup();
//                    break;
//                case 4:
//                    tutorialGroupSystem.mergeTutorialGroup();
//                    break;
//                case 5:
//                     tutorialGroupSystem.listTutorialGrpBasedOnProgrammes();
//                    break;
//                case 6:
//                    tutorialGroupSystem.generateTutorialGroupSummaryReport();
//                    break;
//                case 7:
//                    tutorialGroupSystem.addStudentToTutorialGroup();
//                    break;
//                case 8:
//                     tutorialGroupSystem.deleteStudentFromTutorialGroup();
//                    break;
//                case 9:
//                    tutorialGroupSystem.amendStudentOfTutorialGroup();
//                    break;
//                case 10:
//                    tutorialGroupSystem.changeStudentOfTutorialGroup();
//                    break;
//                case 11:
//                    tutorialGroupSystem.listStudentsInEachTutorialGrp();
//                    break;
//                case 12:
//                    tutorialGroupSystem.generateStudentInTutorialGroupSummaryReport();
//                case 0:
//                    System.out.println("Exiting program...");
//                    break;
//                default:
//                    System.err.println("Invalid choice. Please choose a valid option.");
//            }
//        } while (choice != 0);
//
//               
//        // Close scanner after use
//        scanner.close();
//    }
//}
//
//
//
