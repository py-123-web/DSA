//package control;
//
//import dao.*;
//import adt.*;
//import entity.*;
//import java.util.Scanner;
//
///**
// *
// * @author USER Low Jia Yu
// */
//public class TutorialGroupController {
//    
//    private SortedListInterface<Course> programmeList = new SortedArrayList<>();
//    private SortedListInterface<Student> studentList = new SortedArrayList<>();
//    private SortedListInterface<TutorialGroup> tutorialGrpList = new SortedArrayList<>();
//    private CourseInitializer CourseInitializer;
//    private StudentInitializer StudentInitializer;
//    private TutorialGrpInitializer tutorialGrpInitializer;
//    
//    public TutorialGroupController() {
//        this.CourseInitializer = new CourseInitializer();
//        this.CourseInitializer.ProgrammeInfo();
//        this.programmeList = ProgrammeInfo.getProgrammeList();  // Initialize programmeList from DAO
//
//        this.tutorialGrpInitializer = new TutorialGrpInitializer();
//        this.tutorialGrpInitializer.insertSampleData(); // Insert sample data into TutorialGrpInitializer
//        this.tutorialGrpList = tutorialGrpInitializer.getTutorialGrpList();
//        
//        this.studentDAO = new StudentInitializer();
//        this.studentDAO.initializeStudent();
//        this.studentList = studentDAO.getStudentList();
//         Add sample tutorial groups to programmes
//        addSampleTutorialGrpsToProgrammes();
//        addSampleStudenttoTutorialGrps();
//    }
//    
//            private void addSampleTutorialGrpsToProgrammes() {
//                for (Programme programme : programmeList) {
//                    for (TutorialGroup tutorialGrp : tutorialGrpList) {
//                        programme.addTutorialGroup(tutorialGrp);
//                    }
//                }
//            }  
//            
//            private boolean isDuplicateTutorialGroupName(String tutorialGroupName) {
//                    for (TutorialGroup tutorialGrp : tutorialGrpList) {
//                        if (tutorialGrp.getTutorialGroupName().equalsIgnoreCase(tutorialGroupName)) {
//                            return true; // Duplicate name found
//                        }
//                    }
//                    return false; // No duplicate name found
//                }
//
//            public String getFirstThreeCharacters(String input) {
//                if (input == null || input.length() < 3) {
//                    return input; // Return input if it's null or has less than 3 characters
//                }
//                return input.substring(0, 3); // Extract the first three characters
//            }
//
//            public void displayProgrammeList() {
//                 System.out.println("\nAvailable Programmes:");
//                 System.out.println("-------------------------------------------------");
//                 for (Programme programme : programmeList) {
//                     System.out.println(programme.getProgCode() + " - " + programme.getProgName());
//                 }
//     }
//
//        public void addTutorialGrpToProgramme(Programme programme, TutorialGroup tutorialGrp) {
//            programme.addTutorialGroup(tutorialGrp);
//            tutorialGrpList.add(tutorialGrp); // Assuming tutorialGrpList is accessible here
//        }   
//        
//    public void addTutorialGroup() {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("-------------------------------------------------");
//        System.out.println("        Add New Tutorial Group");
//        System.out.println("-------------------------------------------------");
//
//        boolean addAgain = true;
//        while (addAgain) {
//             Collect input data for the new tutorial group
//            System.out.print("Enter Tutorial Group Name: ");
//            String tutorialGroupName = scanner.nextLine();
//            
//             Check if tutorial group name already exists
//            if (isDuplicateTutorialGroupName(tutorialGroupName)) {
//                System.out.println("Error: Tutorial Group Name already exists.");
//                System.out.print("Do you want to add a new tutorial group? (Yes/No): ");
//                String response = scanner.nextLine();
//                if (!response.equalsIgnoreCase("yes")) {
//                    addAgain = false; // Exit the loop if user doesn't want to add again
//                }
//                continue; // Restart the loop to ask for new input
//            }
//
//            int groupNo = 0;
//            boolean validInput = false;
//            while (!validInput) {
//                System.out.print("Enter Group Number: ");
//                try {
//                    groupNo = Integer.parseInt(scanner.nextLine());
//                    validInput = true;
//                } catch (NumberFormatException e) {
//                    System.out.println("Error: Invalid input. Please enter a valid integer for Group Number.");
//                }
//            }
//
//             Display available programs for selection
//            displayProgrammeList();
//            System.out.print("\nEnter Programme Code to Add Tutorial Group: ");
//            String programmeCode = scanner.nextLine();
//
//            Programme selectedProgramme = findProgrammeByCode(programmeCode);
//            if (selectedProgramme != null) {
//                TutorialGroup newTutorialGrp = new TutorialGroup(tutorialGroupName, groupNo);
//                addTutorialGrpToProgramme(selectedProgramme, newTutorialGrp);
//                System.out.println("Tutorial group added successfully to the programme!");
//            } else {
//                System.out.println("Error: Programme not found.");
//            }
//
//            System.out.print("Do you want to add another tutorial group? (Yes/No): ");
//            String response = scanner.nextLine();
//            if (!response.equalsIgnoreCase("Yes")) {
//                addAgain = false; // Exit the loop if user doesn't want to add again
//            }
//        }
//    }
//
//       public void listTutorialGrpBasedOnProgrammes() {
//                Scanner scanner = new Scanner(System.in);
//                System.out.println("-------------------------------------------------");
//                System.out.println("\nList Tutorial Groups Based on Programmes");
//                System.out.println("-------------------------------------------------");
//
//                boolean viewOtherPrograms = true;
//
//                while (viewOtherPrograms) {
//                     Display available programmes for the user to choose from
//                    displayProgrammeList();
//
//                    System.out.print("\nEnter Programme Code to display tutorial groups: ");
//                    String programmeCode = scanner.nextLine();
//
//                      if (!isValidProgrammeCode(programmeCode)) {
//                        System.out.println("Error: Invalid programme code. Please enter a valid code.");
//                        continue; // Restart the loop to prompt for another programme code
//                    }
//                      
//                     Get the first three characters of the input programmeCode
//                    String firstThreeProgrammeCode = getFirstThreeCharacters(programmeCode);
//
//                    Programme selectedProgramme = null;
//                    for (Programme programme : programmeList) {
//                        if (programme.getProgCode().equals(programmeCode)) {
//                            selectedProgramme = programme;
//                            break;
//                        }
//                    }
//
//                    if (selectedProgramme != null) {
//                        System.out.println("\nTutorial Groups for Programme " + selectedProgramme.getProgCode() + ":");
//                        SortedListInterface<TutorialGroup> associatedTutorialGrps = tutorialGrpList;
//
//                        if (associatedTutorialGrps.isEmpty()) {
//                            System.out.println("No tutorial groups available for this programme.");
//                            continue; // Restart the loop to prompt for another programme code
//                        }
//
//                         Sort the associated tutorial groups based on your sorting criteria
//                        SortedListInterface<TutorialGroup> sortedTutorialGrps = sortTutorialGroups(associatedTutorialGrps);
//
//                         Display the sorted tutorial groups
//                        System.out.printf("%-20s %-15s\n", "Tutorial Group Name", "Group No");
//                        for (TutorialGroup tutorialGrp : sortedTutorialGrps) {
//                             Check if the tutorial group name starts with the first 3 characters of the selected programme code
//                            if (tutorialGrp.getTutorialGroupName().startsWith(programmeCode.substring(0, 3).toUpperCase())) {
//                                System.out.printf("%-20s %-15d\n",
//                                        tutorialGrp.getTutorialGroupName(), tutorialGrp.getGroupNo());
//                            }
//                        }
//                        System.out.println("----------------------------------------------");
//                    } else {
//                        System.out.println("Error: Programme not found.");
//                    }
//
//                    System.out.print("Do you want to see tutorial groups for other programmes? (Yes/No): ");
//                    String viewOther = scanner.nextLine().toLowerCase();
//                    viewOtherPrograms = viewOther.equals("yes");
//                }
//            }
//
//         private boolean isValidProgrammeCode(String programmeCode) {
//        return programmeCode.length() == 3 && programmeCode.matches("[A-Z]{3}");
//    }
//         Method to sort tutorial groups
//        private SortedListInterface<TutorialGroup> sortTutorialGroups(SortedListInterface<TutorialGroup> tutorialGroups) {
//            SortedListInterface<TutorialGroup> sortedTutorialGrps = new SortedArrayList<>();
//            for (TutorialGroup tutorialGrp : tutorialGroups) {
//                sortedTutorialGrps.add(tutorialGrp);
//            }
//            return sortedTutorialGrps;
//        }
//
//    public void deleteTutorialGroup() {
//    Scanner scanner = new Scanner(System.in);
//    System.out.println("-------------------------------------------------");
//    System.out.println("        Delete Tutorial Group");
//    System.out.println("-------------------------------------------------");
//
//    boolean deleteAgain = true;
//    while (deleteAgain) {
//        displayProgrammeList();
//
//        System.out.print("\nEnter Programme Code to Delete Tutorial Group: ");
//        String programmeCode = scanner.nextLine().trim(); // Trim input
//
//         if (!isValidProgrammeCode(programmeCode)) {
//                        System.out.println("Error: Invalid programme code. Please enter a valid code.");
//                        continue; // Restart the loop to prompt for another programme code
//                    }
//        Programme selectedProgramme = null;
//        for (Programme programme : programmeList) {
//            if (programme.getProgCode().equals(programmeCode)) {
//                selectedProgramme = programme;
//                break;
//            }
//        }
//
//        if (selectedProgramme != null) {
//            System.out.println("\nTutorial Groups for Programme " + selectedProgramme.getProgCode() + ":");
//            SortedListInterface<TutorialGroup> associatedTutorialGrps = new SortedArrayList<>();
//
//             Add tutorial groups to the sorted list
//            for (TutorialGroup tutorialGrp : tutorialGrpList) {
//                if (tutorialGrp.getTutorialGroupName().startsWith(programmeCode.substring(0, 3).toUpperCase())) {
//                    associatedTutorialGrps.add(tutorialGrp);
//                }
//            }
//
//            if (associatedTutorialGrps.isEmpty()) {
//                System.out.println("No tutorial groups available for this programme.");
//                continue; // Restart the loop to prompt for another programme code
//            }
//
//            System.out.printf("%-20s %-15s\n", "Tutorial Group Name", "Group No");
//            for (TutorialGroup tutorialGrp : associatedTutorialGrps) {
//                System.out.printf("%-20s %-15d\n",
//                        tutorialGrp.getTutorialGroupName(), tutorialGrp.getGroupNo());
//            }
//            System.out.println("----------------------------------------------");
//
//            System.out.print("Enter Tutorial Group Name to Delete: ");
//            String tutorialGroupName = scanner.nextLine().trim(); // Trim input
//
//            TutorialGroup tutorialGroupToDelete = null;
//            for (TutorialGroup tutorialGrp : associatedTutorialGrps) {
//                if (tutorialGrp.getTutorialGroupName().equalsIgnoreCase(tutorialGroupName)) {
//                    tutorialGroupToDelete = tutorialGrp;
//                    break;
//                }
//            }
//
//            if (tutorialGroupToDelete != null) {
//                associatedTutorialGrps.remove(tutorialGroupToDelete); // Use remove method from SortedArrayList
//                System.out.println("Tutorial group deleted successfully.");
//
//                Update tutorialGrpList after deletion
//                tutorialGrpList = new SortedArrayList<>();
//                for (TutorialGroup tutorialGrp : associatedTutorialGrps) {
//                    tutorialGrpList.add(tutorialGrp);
//                }
//            } else {
//                System.out.println("Error: Tutorial group not found or name mismatch.");
//            }
//        } else {
//            System.out.println("Error: Programme not found.");
//        }
//
//        deleteAgain = false; // Exit the loop after deleting one tutorial group
//
//        System.out.print("Do you want to delete another tutorial group? (Yes/No): ");
//        String response = scanner.nextLine();
//        if (response.equalsIgnoreCase("Yes")) {
//            deleteAgain = true; // Set deleteAgain to true if the user wants to delete more
//        }
//    }
//}
//
//
//public void amendTutorialGroup() {
//    Scanner scanner = new Scanner(System.in);
//    System.out.println("-------------------------------------------------");
//    System.out.println("        Amend Tutorial Group");
//    System.out.println("-------------------------------------------------");
//
//    boolean amendAgain = true;
//    while (amendAgain) {
//        displayProgrammeList();
//
//        System.out.print("\nEnter Programme Code to Amend Tutorial Group: ");
//        String programmeCode = scanner.nextLine().trim(); // Trim input
//
//        Programme selectedProgramme = null;
//        for (Programme programme : programmeList) {
//            if (programme.getProgCode().equals(programmeCode)) {
//                selectedProgramme = programme;
//                break;
//            }
//        }
//
//        if (selectedProgramme != null) {
//            System.out.println("\nTutorial Groups for Programme " + selectedProgramme.getProgCode() + ":");
//            SortedListInterface<TutorialGroup> associatedTutorialGrps = new SortedArrayList<>();
//
//             Add tutorial groups to the sorted list
//            for (TutorialGroup tutorialGrp : tutorialGrpList) {
//                if (tutorialGrp.getTutorialGroupName().startsWith(programmeCode.substring(0, 3).toUpperCase())) {
//                    associatedTutorialGrps.add(tutorialGrp);
//                }
//            }
//
//            if (associatedTutorialGrps.isEmpty()) {
//                System.out.println("No tutorial groups available for this programme.");
//                continue; // Restart the loop to prompt for another programme code
//            }
//
//            System.out.printf("%-20s %-15s\n", "Tutorial Group Name", "Group No");
//            for (TutorialGroup tutorialGrp : associatedTutorialGrps) {
//                System.out.printf("%-20s %-15d\n",
//                        tutorialGrp.getTutorialGroupName(), tutorialGrp.getGroupNo());
//            }
//            System.out.println("----------------------------------------------");
//
//            System.out.print("Enter Tutorial Group Name to Amend: ");
//            String tutorialGroupName = scanner.nextLine().trim(); // Trim input
//
//            TutorialGroup tutorialGroupToAmend = null;
//            for (TutorialGroup tutorialGrp : associatedTutorialGrps) {
//                if (tutorialGrp.getTutorialGroupName().equalsIgnoreCase(tutorialGroupName)) {
//                    tutorialGroupToAmend = tutorialGrp;
//                    break;
//                }
//            }
//
//            if (tutorialGroupToAmend != null) {
//                 Amend the tutorial group details
//                String newTutorialGroupName = null;
//                boolean isValidNewGroupName = false;
//
//                 Prompt for a new tutorial group name and check for duplicates
//                while (!isValidNewGroupName) {
//                    System.out.print("Enter New Tutorial Group Name (leave blank to keep original): ");
//                    newTutorialGroupName = scanner.nextLine().trim();
//                    if (newTutorialGroupName.isEmpty()) {
//                        newTutorialGroupName = tutorialGroupToAmend.getTutorialGroupName();
//                    }
//
//                     Check if the new name is not a duplicate
//                    if (!isDuplicateTutorialGroupName(newTutorialGroupName)) {
//                        isValidNewGroupName = true; // Exit the loop if the name is valid
//                    } else {
//                        System.out.println("Error: Tutorial Group Name already exists.");
//                        System.out.print("Do you want to enter a different name? (Yes/No): ");
//                        String response = scanner.nextLine();
//                        if (!response.equalsIgnoreCase("yes")) {
//                            isValidNewGroupName = true; // Exit the loop if the user doesn't want to enter a different name
//                        }
//                    }
//                }
//
//                System.out.print("Enter New Group Number (leave blank to keep original): ");
//                String newGroupNoInput = scanner.nextLine().trim();
//                int newGroupNo;
//                if (newGroupNoInput.isEmpty()) {
//                    newGroupNo = tutorialGroupToAmend.getGroupNo();
//                } else {
//                    newGroupNo = Integer.parseInt(newGroupNoInput);
//                }
//
//                tutorialGroupToAmend.setTutorialGroupName(newTutorialGroupName);
//                tutorialGroupToAmend.setGroupNo(newGroupNo);
//
//                System.out.println("Tutorial group amended successfully.");
//            } else {
//                System.out.println("Error: Tutorial group not found or name mismatch.");
//            }
//        } else {
//            System.out.println("Error: Programme not found.");
//        }
//
//        amendAgain = false; // Exit the loop after amending one tutorial group
//
//        System.out.print("Do you want to amend another tutorial group? (Yes/No): ");
//        String response = scanner.nextLine();
//        if (response.equalsIgnoreCase("Yes")) {
//            amendAgain = true; // Set amendAgain to true if the user wants to amend more
//        }
//    }
//}
//       
//public void addStudentToTutorialGroup() {
//    Scanner scanner = new Scanner(System.in);
//    System.out.println("-------------------------------------------------");
//    System.out.println("    Add Student to Tutorial Group");
//    System.out.println("-------------------------------------------------");
//
//    boolean viewOtherTutorialGrp = true;
//    while (viewOtherTutorialGrp) {
//        displayProgrammeList();
//
//        System.out.print("\nEnter Programme Code to select the programme: ");
//        String programmeCode = scanner.nextLine().trim(); // Trim input for whitespace
//
//         Check if the programme code is in the correct format (e.g., ABC)
//        if (!programmeCode.matches("[A-Za-z]{3}")) {
//            System.out.println("Error: Programme code must be in the format ABC.");
//            continue; // Restart the loop to prompt for another programme code
//        }
//
//        Programme selectedProgramme = findProgrammeByCode(programmeCode);
//
//        System.out.println("\nTutorial Groups for Programme " + selectedProgramme.getProgCode() + ":");
//        SortedListInterface<TutorialGroup> associatedTutorialGrps = new SortedArrayList<>();
//
//        for (TutorialGroup tutorialGrp : tutorialGrpList) {
//            if (tutorialGrp.getTutorialGroupName().startsWith(programmeCode.substring(0, 3).toUpperCase())) {
//                associatedTutorialGrps.add(tutorialGrp);
//            }
//        }
//
//        if (associatedTutorialGrps.isEmpty()) {
//            System.out.println("No tutorial groups available for this programme.");
//            continue;
//        }
//
//        System.out.printf("%-20s %-15s %-15s\n", "Tutorial Group Name", "Group No", "Number of students");
//        for (TutorialGroup tutorialGrp : associatedTutorialGrps) {
//            System.out.printf("%-20s %-15d %-15d\n",
//                    tutorialGrp.getTutorialGroupName(), tutorialGrp.getGroupNo(), tutorialGrp.getNoOfStudent());
//        }
//        System.out.println("----------------------------------------------");
//
//        System.out.print("\nEnter Tutorial Group Name to add student: ");
//        String tutorialGroupName = scanner.nextLine();
//
//        TutorialGroup selectedTutorialGrp = findTutorialGroupByName(associatedTutorialGrps, tutorialGroupName);
//        if (selectedTutorialGrp == null) {
//            System.out.println("Error: Tutorial group not found in this programme.");
//            continue;
//        }
//
//         Input validation for number of students
//        int noOfStudents;
//        do {
//            System.out.print("Enter Number of Students: ");
//            while (!scanner.hasNextInt()) {
//                System.out.println("Error: Invalid input. Please enter a valid number.");
//                scanner.next(); // Consume invalid input
//            }
//            noOfStudents = scanner.nextInt();
//            scanner.nextLine(); // Consume newline character after reading int
//        } while (noOfStudents <= 0); // Validate that the number of students is positive
//
//         Update the selected tutorial group with the new number of students
//        selectedTutorialGrp.setNoOfStudent(noOfStudents);
//
//        System.out.println("Student added successfully to the tutorial group.");
//
//        System.out.print("Do you want to add student to another Tutorial Group? (Yes/No): ");
//        String viewOther = scanner.nextLine().toLowerCase();
//        viewOtherTutorialGrp = viewOther.equals("yes");
//    }
//}
//
//
//public void deleteStudentFromTutorialGroup() {
//    Scanner scanner = new Scanner(System.in);
//    System.out.println("-------------------------------------------------");
//    System.out.println("   Delete Student from Tutorial Group");
//    System.out.println("-------------------------------------------------");
//
//    StudentInitializer studentInitializer = new StudentInitializer();
//
//    boolean viewOtherTutorialGrp = true;
//    while (viewOtherTutorialGrp) {
//        displayProgrammeList();
//
//        System.out.print("\nEnter Programme Code to select the programme: ");
//        String programmeCode = scanner.nextLine().trim();
//        
//         Check if the programme code is in the correct format (e.g., ABC)
//        if (!programmeCode.matches("[A-Za-z]{3}")) {
//            System.out.println("Error: Programme code must be in the format ABC.");
//            continue; // Restart the loop to prompt for another programme code
//        }
//
//        Programme selectedProgramme = findProgrammeByCode(programmeCode);
//
//        if (selectedProgramme != null) {
//            System.out.println("\nTutorial Groups for Programme " + selectedProgramme.getProgCode() + ":");
//            SortedListInterface<TutorialGroup> associatedTutorialGrps = tutorialGrpList;
//
//            if (associatedTutorialGrps.isEmpty()) {
//                System.out.println("No tutorial groups available for this programme.");
//                continue;
//            }
//
//            System.out.printf("%-20s %-15s %-15s\n", "Tutorial Group Name", "Group No", "Number of Students");
//            for (TutorialGroup tutorialGrp : associatedTutorialGrps) {
//                if (tutorialGrp.getTutorialGroupName().startsWith(programmeCode.substring(0, 3).toUpperCase())) {
//                    System.out.printf("%-20s %-15d %-15d\n",
//                            tutorialGrp.getTutorialGroupName(), tutorialGrp.getGroupNo(), tutorialGrp.getNoOfStudent());
//                }
//            }
//            System.out.println("----------------------------------------------");
//
//            System.out.print("\nEnter Tutorial Group Name to delete student: ");
//            String tutorialGroupName = scanner.nextLine().trim();
//
//            TutorialGroup selectedTutorialGrp = null;
//            for (TutorialGroup tutorialGrp : associatedTutorialGrps) {
//                if (tutorialGrp.getTutorialGroupName().equalsIgnoreCase(tutorialGroupName)) {
//                    selectedTutorialGrp = tutorialGrp;
//                    break;
//                }
//            }
//
//            if (selectedTutorialGrp != null) {
//                 Get the existing student list from the selected tutorial group
//                SortedListInterface<Student> studentList = studentInitializer.initializeStudent();
//
//                if (!studentList.isEmpty()) {
//                    for (Student student : selectedTutorialGrp.getEnrolledStudents()) {
//                        System.out.println(student);
//                    }
//                    int noOfStudents = selectedTutorialGrp.getNoOfStudent();
//                    if (noOfStudents > 0) {
//                        System.out.println("\nStudents in Tutorial Group " + selectedTutorialGrp.getTutorialGroupName() + ":");
//                        System.out.printf("%-10s  %-20s %-15s %10s  %-15s %-30s %-50s\n",
//                                "ID", "Name", "IC", "Gender", "Contact No", "Email", "Address");
//
//                        int count = 0;
//                        for (Student student : studentList) {
//                            if (count < noOfStudents) {
//                                System.out.println(student);
//                                count++;
//                            } else {
//                                break;
//                            }
//                        }
//
//                        System.out.println("\nTotal Students in Tutorial Group " + selectedTutorialGrp.getTutorialGroupName() + ": " + selectedTutorialGrp.getNoOfStudent());
//                        String studentIdToDelete;
//                        boolean validIdFormat = false;
//
//                        do {
//                            System.out.print("\nEnter Student ID to delete: ");
//                            studentIdToDelete = scanner.nextLine().trim();
//
//                             Validate student ID format
//                            if (!studentIdToDelete.matches("\\d{2}[A-Z]{3}\\d{5}")) {
//                                System.out.println("Error: Invalid student ID format. Please enter a student ID like '20WMR23003'.");
//                            } else {
//                                validIdFormat = true;
//                            }
//                        } while (!validIdFormat);
//
//                         Create a new student object with the ID to delete
//                        Student studentToRemove = new Student(studentIdToDelete, "", "", "", "", "", "");
//                        int indexOfStudent = studentList.contains(studentToRemove);
//                        if (indexOfStudent != -1) {
//                            boolean studentRemoved = studentList.remove(studentToRemove);
//                            if (studentRemoved) {
//                                System.out.println("Student with ID " + studentIdToDelete + " deleted successfully from " + selectedTutorialGrp.getTutorialGroupName());
//                                selectedTutorialGrp.setNoOfStudent(selectedTutorialGrp.getNoOfStudent() - 1);
//
//                                 Update the tutorial group in tutorialGrpList
//                                for (int i = 0; i < tutorialGrpList.getNumberOfEntries(); i++) {
//                                    TutorialGroup tutorialGroup = tutorialGrpList.getEntry(i);
//                                    if (tutorialGroup.equals(selectedTutorialGrp)) {
//                                        tutorialGrpList.replace(tutorialGroup, selectedTutorialGrp); // Replace the old tutorial group with the updated one
//                                        break;
//                                    }
//                                }
//                            } else {
//                                System.out.println("Error: Failed to delete student.");
//                            }
//                        } else {
//                            System.out.println("Error: Student not found in " + selectedTutorialGrp.getTutorialGroupName());
//                        }
//                    } else {
//                        System.out.println("No students enrolled in Tutorial Group " + selectedTutorialGrp.getTutorialGroupName());
//                    }
//                } else {
//                    System.out.println("Error: No students in " + selectedTutorialGrp.getTutorialGroupName());
//                }
//            } else {
//                System.out.println("Error: Tutorial Group not found in this programme.");
//            }
//        } else {
//            System.out.println("Error: Programme not found.");
//        }
//
//        System.out.print("Do you want to delete a student from another Tutorial Group? (Yes/No): ");
//        String viewOther = scanner.nextLine().toLowerCase();
//        viewOtherTutorialGrp = viewOther.equals("yes");
//    }
//}
//
//
//
//  private Programme findProgrammeByCode(String programmeCode) {
//    for (int i = 0; i < programmeList.getNumberOfEntries(); i++) {
//        if (programmeList.getEntry(i).getProgCode().contains(programmeCode.toUpperCase())) {
//            return programmeList.getEntry(i);
//        }
//    }
//    return null;
//}
//
//private TutorialGroup findTutorialGroupByName(SortedListInterface<TutorialGroup> tutorialGroups, String tutorialGroupName) {
//    for (int i = 0; i < tutorialGroups.getNumberOfEntries(); i++) {
//        if (tutorialGroups.getEntry(i).getTutorialGroupName().contains(tutorialGroupName.toUpperCase())) {
//            return tutorialGroups.getEntry(i);
//        }
//    }
//    return null;
//}
//
//    public void mergeTutorialGroup() {
//    Scanner scanner = new Scanner(System.in);
//    System.out.println("-------------------------------------------------");
//    System.out.println("   Merge Tutorial Groups");
//    System.out.println("-------------------------------------------------");
//
//    boolean continueMerging = true;
//    while (continueMerging) {
//        displayProgrammeList();
//
//        System.out.print("\nEnter Programme Code to select the programme: ");
//        String programmeCode = scanner.nextLine().trim();
//
//        Programme selectedProgramme = findProgrammeByCode(programmeCode);
//
//        if (selectedProgramme != null) {
//            System.out.println("\nTutorial Groups for Programme " + selectedProgramme.getProgCode() + ":");
//            SortedListInterface<TutorialGroup> associatedTutorialGrps = tutorialGrpList;
//
//            if (associatedTutorialGrps.isEmpty()) {
//                System.out.println("No tutorial groups available for this programme.");
//                continue;
//            }
//
//            System.out.printf("%-20s %-15s\n", "Tutorial Group Name", "Number of Students");
//            for (TutorialGroup tutorialGrp : associatedTutorialGrps) {
//                String tutorialGroupName = tutorialGrp.getTutorialGroupName().replace(" ", "&"); // Replace spaces with '&'
//                if (tutorialGrp.getTutorialGroupName().startsWith(programmeCode.substring(0, 3).toUpperCase())) {
//                    System.out.printf("%-20s %-15d\n",
//                            tutorialGrp.getTutorialGroupName(), tutorialGrp.getNoOfStudent());
//                }
//            }
//            System.out.println("----------------------------------------------");
//
//            System.out.print("\nEnter the names of the Tutorial Groups to merge (comma-separated): ");
//            String tutorialGroupNamesInput = scanner.nextLine().trim();
//            String[] tutorialGroupNames = tutorialGroupNamesInput.split(",");
//
//            SortedListInterface<TutorialGroup> tutorialGroupsToMerge = new SortedArrayList<>();
//
//            for (String tutorialGroupName : tutorialGroupNames) {
//                TutorialGroup selectedTutorialGrp = findTutorialGroupByName(associatedTutorialGrps, tutorialGroupName.trim());
//                if (selectedTutorialGrp != null) {
//                    tutorialGroupsToMerge.add(selectedTutorialGrp);
//                } else {
//                    System.out.println("Error: Tutorial Group '" + tutorialGroupName.trim() + "' not found in this programme.");
//                }
//            }
//            
//            if (tutorialGroupsToMerge.getNumberOfEntries() < 2) {
//                System.out.println("Error: You need to select at least two Tutorial Groups to merge.");
//            } 
//            else 
//            {
//                 Merge the selected tutorial groups
//                TutorialGroup mergedTutorialGroup = mergeTutorialGroups(tutorialGroupsToMerge);
//                String newName = "";
//                
//                if (mergedTutorialGroup != null) {
//                   System.out.println("Tutorial Groups merged successfully!");
//                   System.out.print("Merged Tutorial Group Name: ");
//                   boolean isFirst = true;
//                   for (TutorialGroup group : tutorialGroupsToMerge) {
//                        if (!isFirst) {
//                            newName +="&";
//                        }
//                        newName += group.getTutorialGroupName();
//                        isFirst = false;
//                    }
//                   System.out.println(newName);
//                    System.out.println();
//                    System.out.println("Updated Number of Students: " + mergedTutorialGroup.getNoOfStudent());
//
//                    mergedTutorialGroup.setTutorialGroupName(newName);
//                     Update tutorialGrpList after successful merge
//                    tutorialGrpList.add(mergedTutorialGroup);
//
//                     Remove old tutorial groups from the selected programme
//                    for (TutorialGroup oldGroup : tutorialGroupsToMerge) {
//                        tutorialGrpList.remove(oldGroup);
//                    }
//                    
//                    
//                } else {
//                    System.out.println("Error: Failed to merge tutorial groups.");
//                }
//            } 
//        } else {
//            System.out.println("Error: Programme not found.");
//        }
//
//        System.out.print("Do you want to merge Tutorial Groups in another Programme? (Yes/No): ");
//        String continueOption = scanner.nextLine().toLowerCase();
//        continueMerging = continueOption.equals("yes");
//    }
//}
//public void listStudentsInEachTutorialGrp() {
//    Scanner scanner = new Scanner(System.in);
//    System.out.println("-------------------------------------------------");
//    System.out.println("List Students in Each Tutorial Group");
//    System.out.println("-------------------------------------------------");
//
//    StudentInitializer studentInitializer = new StudentInitializer();
//
//    boolean viewOtherTutorialGrp = true;
//    while (viewOtherTutorialGrp) {
//        displayProgrammeList();
//
//        System.out.print("\nEnter Programme Code to display tutorial groups: ");
//        String programmeCode = scanner.nextLine();
//
//        String firstThreeProgrammeCode = getFirstThreeCharacters(programmeCode);
//
//        Programme selectedProgramme = null;
//        for (Programme programme : programmeList) {
//            if (programme.getProgCode().equals(programmeCode)) {
//                selectedProgramme = programme;
//                break;
//            }
//        }
//
//        if (selectedProgramme != null) {
//            System.out.println("\nTutorial Groups for Programme " + selectedProgramme.getProgCode() + ":");
//            SortedListInterface<TutorialGroup> associatedTutorialGrps = tutorialGrpList;
//
//            if (associatedTutorialGrps.isEmpty()) {
//                System.out.println("No tutorial groups available for this programme.");
//                continue;
//            }
//
//            boolean foundGroup = false;
//            for (TutorialGroup tutorialGrp : tutorialGrpList) {
//                String firstThreeTutorialGrpCode = getFirstThreeCharacters(tutorialGrp.getTutorialGroupName());
//                if (firstThreeTutorialGrpCode.equals(firstThreeProgrammeCode)) {
//                    foundGroup = true;
//                    break;
//                }
//            }
//
//            if (foundGroup) {
//                System.out.printf("%-20s %-15s %-15s\n", "Tutorial Group Name", "Group No","Number of Students");
//                for (TutorialGroup tutorialGrp : tutorialGrpList) {
//                    String tutorialGroupName = tutorialGrp.getTutorialGroupName().replace(" ", "&"); // Replace spaces with '&'
//                    if (tutorialGrp.getTutorialGroupName().startsWith(programmeCode.substring(0, 3).toUpperCase())) {
//                        System.out.printf("%-20s %-15d %-15d\n",
//                                tutorialGrp.getTutorialGroupName(),tutorialGrp.getGroupNo(), tutorialGrp.getNoOfStudent());
//                    }
//                }
//                System.out.println("----------------------------------------------");
//            } else {
//                System.out.println("Error: No tutorial group found for the selected programme.");
//            }
//
//            System.out.print("\nEnter Tutorial Group Name to display students: ");
//            String tutorialGroupName = scanner.nextLine();
//            
//             Update the tutorial group name with '&' separators
//            String mergedTutorialGroupName = tutorialGroupName.replace(" ", "&");
//            
//            TutorialGroup selectedTutorialGrp = null;
//            for (TutorialGroup tutorialGrp : tutorialGrpList) {
//                if (tutorialGrp.getTutorialGroupName().equalsIgnoreCase(tutorialGroupName)) {
//                    selectedTutorialGrp = tutorialGrp;
//                    break;
//                }
//            }
//
//            if (selectedTutorialGrp != null) {
//                SortedListInterface<Student> studentList = studentInitializer.initializeStudent();
//                System.out.println("\nUpdated Students in Tutorial Group " + selectedTutorialGrp.getTutorialGroupName() + ":");
//                System.out.printf("%-10s  %-20s %-15s %10s  %-15s %-30s %-50s\n",
//                        "ID", "Name", "IC", "Gender", "Contact No", "Email", "Address");
//                for (Student student : selectedTutorialGrp.getEnrolledStudents()) {
//                    System.out.println(student);
//                }
//                int noOfStudents = selectedTutorialGrp.getNoOfStudent();
//                if (noOfStudents > 0) {
//                    System.out.println("\nStudents in Tutorial Group " + selectedTutorialGrp.getTutorialGroupName() + ":");
//                    System.out.printf("%-10s  %-20s %-15s %10s  %-15s %-30s %-50s\n",
//                            "ID", "Name", "IC", "Gender", "Contact No", "Email", "Address");
//
//                    int count = 0;
//                    for (Student student : studentList) {
//                        if (count < noOfStudents) {
//                            System.out.println(student);
//                            count++;
//                        } else {
//                            break;
//                        }
//                    }
//
//                    System.out.println("\nTotal Students in Tutorial Group " + selectedTutorialGrp.getTutorialGroupName() + ": " + noOfStudents);
//                } else {
//                    System.out.println("No students enrolled in Tutorial Group " + selectedTutorialGrp.getTutorialGroupName());
//                }
//            } else {
//                System.out.println("Error: Tutorial Group not found in this programme.");
//            }
//        } else {
//            System.out.println("Error: Programme not found.");
//        }
//
//        System.out.print("Do you want to see students for other Tutorial Group? (Yes/No): ");
//        String viewOther = scanner.nextLine().toLowerCase();
//        viewOtherTutorialGrp = viewOther.equals("yes");
//    }
//}
//
//    private TutorialGroup mergeTutorialGroups(SortedListInterface<TutorialGroup> tutorialGroupsToMerge) {
//       
//        
//        if (tutorialGroupsToMerge.isEmpty() || tutorialGroupsToMerge.getNumberOfEntries() < 2) {
//            System.out.println("Error: At least two Tutorial Groups are required to merge.");
//            return null;  
//        }
//        
//        TutorialGroup mergedTutorialGroup = new TutorialGroup("Merged Group", 0, 0); // Initialize merged group
//        for (TutorialGroup tutorialGrp : tutorialGroupsToMerge) {
//            SortedListInterface<Student> enrolledStudents = tutorialGrp.getEnrolledStudents();
//            for (Student student : enrolledStudents) {
//                mergedTutorialGroup.addStudent(student); // Add each student to the merged group
//            }
//        }
//        
//        SortedListInterface<Student> a = mergedTutorialGroup.getEnrolledStudents();
//        for(int i = 0; i < mergedTutorialGroup.getNoOfStudent();i++){
//            
//        }
//        
//        return mergedTutorialGroup;
//    }
//    
//     public void amendStudentOfTutorialGroup() {
//            Scanner scanner = new Scanner(System.in);
//            System.out.println("-------------------------------------------------");
//            System.out.println("        Amend Tutorial Group");
//            System.out.println("-------------------------------------------------");
//
//            boolean amendAgain = true;
//            while (amendAgain) {
//                displayProgrammeList();
//
//                System.out.print("\nEnter Programme Code to Amend Student in Tutorial Group: ");
//                String programmeCode = scanner.nextLine().trim(); // Trim input
//
//                Programme selectedProgramme = null;
//                for (Programme programme : programmeList) {
//                    if (programme.getProgCode().equals(programmeCode)) {
//                        selectedProgramme = programme;
//                        break;
//                    }
//                }
//
//                if (selectedProgramme != null) {
//                    System.out.println("\nTutorial Groups for Programme " + selectedProgramme.getProgCode() + ":");
//                    SortedListInterface<TutorialGroup> associatedTutorialGrps = tutorialGrpList;
//
//                    if (associatedTutorialGrps.isEmpty()) {
//                        System.out.println("No tutorial groups available for this programme.");
//                        continue; // Restart the loop to prompt for another programme code
//                    }
//
//                    System.out.printf("%-20s %-15s %-15s\n", "Tutorial Group Name", "GroupNo", "Number of Students");
//                    for (TutorialGroup tutorialGrp : associatedTutorialGrps) {
//                        if (tutorialGrp.getTutorialGroupName().startsWith(programmeCode.substring(0, 3).toUpperCase())) {
//                            System.out.printf("%-20s %-15d %-15d\n",
//                                    tutorialGrp.getTutorialGroupName(), tutorialGrp.getGroupNo(), tutorialGrp.getNoOfStudent());
//                        }
//                    }
//                    System.out.println("----------------------------------------------");
//
//                    System.out.print("Enter Tutorial Group Name to Amend: ");
//                    String tutorialGroupName = scanner.nextLine().trim(); // Trim input
//
//                    TutorialGroup tutorialGroupToAmend = null;
//                    for (TutorialGroup tutorialGrp : associatedTutorialGrps) {
//                         Match tutorial group name case-insensitively
//                        if (tutorialGrp.getTutorialGroupName().equalsIgnoreCase(tutorialGroupName)) {
//                            tutorialGroupToAmend = tutorialGrp;
//                            break; // Exit loop after finding the tutorial group to amend
//                        }
//                    }
//
//                    if (tutorialGroupToAmend != null) {
//                       System.out.print("Enter New Number of Student (leave blank to keep original): ");
//                        String newNoofStudentInput = scanner.nextLine().trim();
//                        int newNoOfStudent;
//                        if (newNoofStudentInput.isEmpty()) {
//                            newNoOfStudent = tutorialGroupToAmend.getNoOfStudent();
//                        } else {
//                            newNoOfStudent = Integer.parseInt(newNoofStudentInput);
//                        }
//                        tutorialGroupToAmend.setNoOfStudent(newNoOfStudent);
//
//                        System.out.println("Tutorial group amended successfully.");
//                    } else {
//                        System.out.println("Error: Tutorial group not found or name mismatch.");
//                    }
//                } else {
//                    System.out.println("Error: Programme not found.");
//                }
//
//                amendAgain = false; // Exit the loop after amending one tutorial group
//
//                System.out.print("Do you want to amend another tutorial group? (Yes/No): ");
//                String response = scanner.nextLine();
//                if (response.equalsIgnoreCase("Yes")) {
//                    amendAgain = true; // Set amendAgain to true if the user wants to amend more
//                }
//            }
//        }
//     
//public void changeStudentOfTutorialGroup() {
//    Scanner scanner = new Scanner(System.in);
//    System.out.println("-------------------------------------------------");
//    System.out.println("    Change Student of Tutorial Group");
//    System.out.println("-------------------------------------------------");
//
//    StudentInitializer studentInitializer = new StudentInitializer();
//    displayProgrammeList();
//
//    boolean viewOtherTutorialGrp = true;
//    while (viewOtherTutorialGrp) {
//        System.out.print("\nEnter Programme Code to select the programme: ");
//        String programmeCode = scanner.nextLine().trim();
//
//         Check if the programme code is in the correct format (e.g., ABC)
//        if (!programmeCode.matches("[A-Za-z]{3}")) {
//            System.out.println("Error: Programme code must be in the format ABC.");
//            continue; // Restart the loop to prompt for another programme code
//        }
//        
//        Programme selectedProgramme = findProgrammeByCode(programmeCode);
//
//        if (selectedProgramme != null) {
//            System.out.println("\nTutorial Groups for Programme " + selectedProgramme.getProgCode() + ":");
//            SortedListInterface<TutorialGroup> associatedTutorialGrps = tutorialGrpList;
//
//            if (associatedTutorialGrps.isEmpty()) {
//                System.out.println("No tutorial groups available for this programme.");
//                continue;
//            }
//
//            System.out.printf("%-20s %-15s %-15s\n", "Tutorial Group Name", "GroupNo", "Number of Students");
//            for (TutorialGroup tutorialGrp : associatedTutorialGrps) {
//                if (tutorialGrp.getTutorialGroupName().startsWith(programmeCode.substring(0, 3).toUpperCase())) {
//                    System.out.printf("%-20s %-15d %-15d\n",
//                            tutorialGrp.getTutorialGroupName(), tutorialGrp.getGroupNo(), tutorialGrp.getNoOfStudent());
//                }
//            }
//            System.out.println("----------------------------------------------");
//
//            System.out.print("\nEnter Tutorial Group Name to move student from: ");
//            String sourceTutorialGroupName = scanner.nextLine().trim();
//
//            TutorialGroup sourceTutorialGrp = null;
//            for (TutorialGroup tutorialGrp : associatedTutorialGrps) {
//                if (tutorialGrp.getTutorialGroupName().equalsIgnoreCase(sourceTutorialGroupName)) {
//                    sourceTutorialGrp = tutorialGrp;
//                    break;
//                }
//            }
//
//            if (sourceTutorialGrp != null) {
//                SortedListInterface<Student> studentList = studentInitializer.initializeStudent();
//
//                int noOfStudents = sourceTutorialGrp.getNoOfStudent();
//                if (noOfStudents > 0) {
//                    System.out.println("\nStudents in Tutorial Group " + sourceTutorialGrp.getTutorialGroupName() + ":");
//                    System.out.printf("%-10s  %-20s %-15s %10s  %-15s %-30s %-50s\n",
//                            "ID", "Name", "IC", "Gender", "Contact No", "Email", "Address");
//
//                    int count = 0;
//                    for (Student student : studentList) {
//                        if (count < noOfStudents) {
//                            System.out.println(student);
//                            count++;
//                        } else {
//                            break;
//                        }
//                    }
//                    System.out.println("\nTotal Students in Tutorial Group " + sourceTutorialGrp.getTutorialGroupName() + ": " + sourceTutorialGrp.getNoOfStudent());
//                    String studentIdToMove;
//
//                    boolean validIdFormat = false;
//                    do {
//                        System.out.print("\nEnter Student ID to move: ");
//                        studentIdToMove = scanner.nextLine().trim(); // Trim the input
//
//                         Validate student ID format
//                        if (!studentIdToMove.matches("\\d{2}[A-Z]{3}\\d{5}")) {
//                            System.out.println("Error: Invalid student ID format. Please enter a student ID like '20WMR23003'.");
//                        } else {
//                            validIdFormat = true;
//                        }
//                    } while (!validIdFormat);
//
//                     Check if the entered student ID matches any student's ID in the source tutorial group
//                    Student studentToRemove = new Student(studentIdToMove, "", "", "", "", "", "");
//                    int indexOfStudent = studentList.contains(studentToRemove);
//                    if (indexOfStudent != -1) {
//                        studentToRemove = studentList.getEntry(indexOfStudent);
//                    }
//
//                    if (studentToRemove != null) {
//                         Remove the student from the source tutorial group
//                        studentList.remove(studentToRemove);
//
//                         Prompt for the destination tutorial group
//                        System.out.print("\nEnter Tutorial Group Name to move student to: ");
//                        String destinationTutorialGroupName = scanner.nextLine().trim();
//
//                        TutorialGroup destinationTutorialGrp = null;
//                        for (TutorialGroup tutorialGrp : associatedTutorialGrps) {
//                            if (tutorialGrp.getTutorialGroupName().equalsIgnoreCase(destinationTutorialGroupName)) {
//                                destinationTutorialGrp = tutorialGrp;
//                                break;
//                            }
//                        }
//
//                        if (destinationTutorialGrp != null) {
//                             Add the student to the destination tutorial group
//                            destinationTutorialGrp.getEnrolledStudents().add(studentToRemove);
//                            destinationTutorialGrp.setNoOfStudent(destinationTutorialGrp.getNoOfStudent() + 1);
//
//                            System.out.println("Student with ID " + studentIdToMove + " moved successfully to " + destinationTutorialGrp.getTutorialGroupName());
//                             Remove the student from the source tutorial group after moving
//                            sourceTutorialGrp.getEnrolledStudents().remove(studentToRemove);
//                            sourceTutorialGrp.setNoOfStudent(sourceTutorialGrp.getNoOfStudent() - 1);
//                        } else {
//                            System.out.println("Error: Destination Tutorial Group not found in this programme.");
//                        }
//                    } else {
//                        System.out.println("Error: Student not found in " + sourceTutorialGrp.getTutorialGroupName());
//                    }
//                } else {
//                    System.out.println("Error: No students in " + sourceTutorialGrp.getTutorialGroupName());
//                }
//            } else {
//                System.out.println("Error: Source Tutorial Group not found in this programme.");
//            }
//        } else {
//            System.out.println("Error: Programme not found.");
//        }
//
//        System.out.print("Do you want to move a student from another Tutorial Group? (Yes/No): ");
//        String viewOther = scanner.nextLine().toLowerCase();
//        viewOtherTutorialGrp = viewOther.equals("yes");
//    }
//
//}
//
//public void generateTutorialGroupSummaryReport() {
//    SortedListInterface<Programme> programmeList = ProgrammeInitializer.programmeList;
//    SortedListInterface<TutorialGroup> tutorialGrpList = TutorialGrpInitializer.tutorialGrpList;
//
//    System.out.println("----------------------------------------------------------------------");
//    System.out.println("        Tutorial Group Summary Report");
//    System.out.println("----------------------------------------------------------------------");
//    System.out.printf("%-20s %-20s %-10s\n", "Programme Code", "Tutorial Groups", "Group Names");
//    System.out.println("----------------------------------------------------------------------");
//
//    int minTutorialGroups = Integer.MAX_VALUE;
//    String minTutorialGroupsProgramme = "";
//    int maxTutorialGroups = Integer.MIN_VALUE;
//    String maxTutorialGroupsProgramme = "";
//
//    for (Programme programme : programmeList) {
//        String programmeCode = programme.getProgCode();
//        int tutorialGroupCount = 0;
//        StringBuilder tutorialGroupNames = new StringBuilder();
//
//        for (TutorialGroup tutorialGrp : tutorialGrpList) {
//            if (tutorialGrp.getTutorialGroupName().startsWith(programmeCode.substring(0, 3).toUpperCase())) {
//                tutorialGroupCount++;
//                tutorialGroupNames.append(tutorialGrp.getTutorialGroupName()).append(", ");
//            }
//        }
//
//        System.out.printf("%-20s %-20d %s\n", programmeCode, tutorialGroupCount, tutorialGroupNames.toString());
//
//        if (tutorialGroupCount < minTutorialGroups) {
//            minTutorialGroups = tutorialGroupCount;
//            minTutorialGroupsProgramme = programmeCode;
//        }
//        if (tutorialGroupCount > maxTutorialGroups) {
//            maxTutorialGroups = tutorialGroupCount;
//            maxTutorialGroupsProgramme = programmeCode;
//        }
//    }
//
//    System.out.println("----------------------------------------------------------------------------");
//    System.out.println("Minimum Number of Tutorial Groups: " + minTutorialGroups + " (Programme: " + minTutorialGroupsProgramme + ")");
//    System.out.println("Maximum Number of Tutorial Groups: " + maxTutorialGroups + " (Programme: " + maxTutorialGroupsProgramme + ")");
//}
//public void generateStudentInTutorialGroupSummaryReport() {
//    SortedListInterface<TutorialGroup> tutorialGrpList = TutorialGrpInitializer.tutorialGrpList;
//    SortedListInterface<TutorialGroup> tgStudentList = TutorialGrpInitializer.tgStudentList;
//
//    System.out.println("-------------------------------------------------");
//    System.out.println("   Student in Tutorial Group Summary Report");
//    System.out.println("--------------------------------------------------");
//    System.out.printf("%-20s %-10s %-15s\n", "Tutorial Group", "Group No", "Number of Students");
//
//
//    String currentPrefix = null;
//    int minStudents = Integer.MAX_VALUE;
//    String minStudentsTutorialGroup = "";
//    int maxStudents = Integer.MIN_VALUE;
//    String maxStudentsTutorialGroup = "";
//
//    for (TutorialGroup tutorialGrp : tutorialGrpList) {
//        String prefix = tutorialGrp.getTutorialGroupName().substring(0, 3);
//        if (currentPrefix == null || !currentPrefix.equals(prefix)) {
//            System.out.println("---------------------------------------------------------------");
//            currentPrefix = prefix;
//        }
//
//        int numberOfStudents = tutorialGrp.getNoOfStudent(); // Get the number of students directly from the TutorialGroup object
//        System.out.printf("%-20s %-10d %-15d\n", tutorialGrp.getTutorialGroupName(), tutorialGrp.getGroupNo(), numberOfStudents);
//
//         Compare and update min and max students
//        if (numberOfStudents < minStudents) {
//            minStudents = numberOfStudents;
//            minStudentsTutorialGroup = tutorialGrp.getTutorialGroupName();
//        }
//        if (numberOfStudents > maxStudents) {
//            maxStudents = numberOfStudents;
//            maxStudentsTutorialGroup = tutorialGrp.getTutorialGroupName();
//        }
//    }
//
//    System.out.println("---------------------------------------------------------------------");
//    System.out.println("Minimum Number of Students: " + minStudents + " (Tutorial Group: " + minStudentsTutorialGroup + ")");
//    System.out.println("Maximum Number of Students: " + maxStudents + " (Tutorial Group: " + maxStudentsTutorialGroup + ")");
//    }
//}
