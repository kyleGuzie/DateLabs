package dates;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 *
 * @author jlombardo
 */
public class Example1 {
    public static void main(String[] args) {
        // Create a date object using java.util.Date
        // Produces current date, time (military time) and North American time zone
        Date date = new Date();
        System.out.println("1 - The date output via toString(): " + date);

        // This works too, but is deprecated -- shouldn't be used!!!!
        // Note the strike thru indicating deprecated status.
        // This produces a specific date, but no time value is 00:00:00,
        // meaning midnight.
        date = new Date(2000,3,21);
        System.out.println("2 - The date output via toString(): " + date);

        // Here's the correct way to create a specific date using the
        // Calendar class (an abstract class with some static methods)
        Calendar c = Calendar.getInstance();
        c.set(2000, 3, 21);
        // When we print it, Calendar provides more information than Date
        System.out.println("3 -The date output via toString(): " + c);
        // Use the Calendar object to produce a Date instance
        date = c.getTime();
        //Compare this output to Date
        System.out.println("4 - The date output via toString(): " + date);

        // Now let's do some Date arithmentic...

        // Add days to an existing date (starts at April 21, 2000)
        // NOTE: "DATE" means day of the month; there are other constants
        // for MONTH and YEAR
        c.add(Calendar.DATE, 44);
        date = c.getTime();
        //Notice the new date is 44 days past the old date
        System.out.println("5 - The date output via toString(): " + date);
        // We can also go back in time using a negative number
        // Let's go back two years...
        c.add(Calendar.YEAR, -2);
        date = c.getTime();
        //Notice the new date is 2 years before the old date
        System.out.println("6 - The date output via toString(): " + date);

        // There are many other ways to manipulate Calendar objects. Read the
        // JavaDoc for the Calendar class and experiment. Also, read the
        // JavaDoc for the concrete implementation of Calendar --
        // GregorianCalendar. Notice the sample code for manipulating
        // dates. NOTE: you only need to use GregorianCalendar when you
        // want to use features NOT provided by Calendar.

        // Now let's demonstrate some conversion techniques...

        // First we'll convert a Date to a formatted String
        // We'll use java.text.SimpleDateFormat to help. Please read the
        // JavaDoc for info on how to create format strings.
        String format = "MM/dd/yyyy hh:mm a";
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        // Get current date/time and convert to a Date object because
        // SimpleDateFormat only works with Date objects
        c = Calendar.getInstance();
        date = c.getTime();
        // Now format the date object as a String
        String formattedDate = sdf.format(date);
        System.out.println("7 - formatted Date as String: " + formattedDate);
        // Now let's remove the leader zeros...
        sdf = new SimpleDateFormat("M/d/yyyy h:mm a");
        formattedDate = sdf.format(date);
        System.out.println("8 - formatted Date as String: " + formattedDate);

        // Next, we'll convert a legal, formatted date String back into a
        // Date object. NOTE: you can't just convert any string to a Date.
        // Only strings that have legal formats will work:

        // Here's a legal format:
        String sDate = "12/01/2010 11:30 PM";
        // Note: parse throws a checked exception so we must try-catch
        try {
        date = sdf.parse(sDate);
        } catch(ParseException pe) {
            System.out.println("Could not parse date string -- illegal format");
        }
        System.out.println("9 - parse String to Date: " + date);

        // Now experiment on your own. Be sure to carefully read the
        // JavaDoc for SimpleDateFormat class and DateFormat class parsing
    }
}
