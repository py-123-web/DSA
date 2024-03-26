
package utility;

/**
 *
 * @author syhor
 */
public class MessageUI {
   
    public static void displayExitMessage() {
        System.out.println("\nExiting system...\n");
    }
     
     public static void displayRecordSuccessful() {
    System.out.println("");
    System.out.println("\u001B[32mData record successful.\u001B[0m");
}

    
     // Method to display invalid choice message
    public static void displayInvalidChoiceMessage() {
        System.out.println("");
       System.out.println("\u001B[31mInvalid choice. Please try again\u001B[0m");
    }
     
}
