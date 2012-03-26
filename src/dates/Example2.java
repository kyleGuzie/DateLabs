package dates;

import java.util.*;
import java.text.*;

/**
 * Sample code using Date and Calendar classes
 */
public class Example2 {

    public static void main(String[] args) {
        
        // Date has been mostly deprecated in favor of using Calendar.
        // However, the Date class is still needed by many API classes
        
        // Date returns year = year - 1900 ... don't use this!
        Date date = new Date();
        int year = date.getYear();
        System.out.println("Year returned by Date.getYear() method: " + year);
        
        // Use calendar instead for correct year without calculations
        Calendar c = Calendar.getInstance();
        year = c.get(Calendar.YEAR);
        System.out.println("Year returned by Calendar.get() method: " + year);
        
        /*
         * The first thing you need to do is create a Calendar object. To do this,
         * use the static method getInstance() of the Calendar class. But wait!
         * How can this create an instance of the Calendar class if Calendar is abstract?
         * It doesn't. It creates an instance of the GregorianCalendar class, whose
         * super class is Calendar. So this instance IS a Calendar TYPE object. The
         * variable calendar now contains an internationalized type of date structure
         * (a Calendar object) that contains the current date, time, timezone, etc. for
         * the default locale (US in this case).
         */
        Calendar calendar = Calendar.getInstance();

        /*
         * If all we need is the current date we are done. But if we want to create
         * a Calendar object that can be set to some other date, then we need to use
         * the set method. Here we set the month to April.
         */
        calendar.set(Calendar.MONTH,Calendar.APRIL); // Calendar.APRIL = 3 because numbering is zero-based
        // or, you could do this to use eliminate zero-based numbering!
        //calendar.set(Calendar.MONTH,Calendar.APRIL + 1);

        /////  HOW TO DO SOME SIMPLE FORMATTING /////

        /*
         * TYPICAL FOR BEGINNERS - BUT WRONG!!!
         * It's not uncommon to want to extract the date information from our Calendar
         * object as a String. The best way to do this is using the SimpleDateFormat class
         * (see below). However, you can do it manually using String concatentation if you
         * understand how to interpret the data. The Calendar class uses a zero-based numbering
         * system for numeric date values represented as constants. We need to decide whether
         * or not these numbers are satisfactory. If not, we may need to add one to the numbers.
         */
        int mm = calendar.get(Calendar.MONTH); // zero-based value
        int dd = calendar.get(Calendar.DAY_OF_MONTH); // one-based value
        int yyyy = calendar.get(Calendar.YEAR); // one-based value
        String currentDate = "" + mm + "/" + dd + "/" + yyyy; // format manually
        System.out.println("The current date has the wrong month value: " + currentDate); // The month will be one less than what we want
        // To solve this problem, we could add one to the month...
        mm += 1;
        currentDate = "" + mm + "/" + dd + "/" + yyyy; // format manually
        System.out.println("The current date has corrected month value: " + currentDate); // The month will be one less than what we want

        /*
         * A BETTER WAY (FOR ENLIGHTENED PROGRAMMERS)
         * Here's a better way to format dates stored in Calendar objects.
         * Use the SimpleDateFormat class, passing a formatting string (see API)
         * to indicate the desired format. Doing it this way we do not need to worry
         * about zero-based numbering.
         *
         * The technique is to first retrieve a Date object from the calendar object,
         * then use that as a parameter to the format() method of the SimpleDateFormat
         * class. To retrieve the a Date from a Calendar object, you use the getTime()
         * method of the Calendar class. The name of this method is misleading. You
         * are not getting the clock time, you are getting a time value measured in milliseconds,
         * which represents the date,time, timezone, etc.
         */
        date = calendar.getTime(); // first retrieve the Date object.
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy"); // now create a format object
        String formattedDate = sdf.format(date); // now use that format object to format the date
        System.out.println("A Formatted Date: " + formattedDate);
        
        /*
         * Now let's do the reverse ... convert a String to a Date
         */
        
        // One type of date format ... others possible
        // Make sure the format you use is parseable by the DateFormat class
        String strDate = "07/10/03 4:50 PM, CST";
        date = null;

        // Choice of factory method makes a big difference in what
        // you can do when parse is executed below
        DateFormat df = DateFormat.getInstance(); // SHORT style
        //DateFormat df = DateFormat.getDateInstance( DateFormat.LONG) // LONG stle

        try {
                // now parse the String "strDate" into a date object
                date = df.parse(strDate);
        } catch (ParseException pe) {
                System.out.println("Couldn't parse the date. Reason: " + pe);
                System.out.println("\nA typical date format would look like this:");
                System.out.println(new Date());
        }

        System.out.println(date);

    }

}
