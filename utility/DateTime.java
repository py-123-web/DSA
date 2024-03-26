
package utility;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author syhor
 */
public class DateTime {
    public static String currentDateTime() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String formattedDateTime = dtf.format(now);
        System.out.println("Generated Time : " + formattedDateTime); // Printing the formatted date and time
        return formattedDateTime; // Returning the formatted date and time
    }
}
