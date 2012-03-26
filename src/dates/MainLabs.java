/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dates;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author k.Machine
 */
public class MainLabs {

     public static final long DAY_UNITS = 1000L * 60L * 60L * 24L;

     /**
      * @param args the command line arguments
      */
     public static void main(String[] args) {

          //lab1 
          Date d = new Date();
          String fmt = "MM/dd/yyyy hh:mm a";
          SimpleDateFormat sdf = new SimpleDateFormat(fmt);

          String fmtDate = sdf.format(d);
          System.out.println("Lab 1 output: " + fmtDate);


          //lab2
          Calendar c = Calendar.getInstance();
          d = c.getTime();
          fmtDate = sdf.format(d);
          System.out.println("Lab 2 output: " + fmtDate);


          //lab3
          Calendar d1 = Calendar.getInstance();
          Calendar d2 = Calendar.getInstance();
          d2.add(Calendar.DATE, -14);
          int diff = dateDiff(DAY_UNITS, d1, d2);
          System.out.println("Lab 3 output: " + diff);

          //lab4
          c = Calendar.getInstance();
          c.add(Calendar.DATE, 90);
          d = c.getTime();
          fmtDate = sdf.format(d);
          System.out.println("Lab 4 output: " + fmtDate);

          //lab5

     }

     public static int dateDiff(long dateUtilitiesUnitField, Calendar firstDate, Calendar secondDate)
             throws IllegalArgumentException {
          long diff = Math.abs(firstDate.getTimeInMillis() - secondDate.getTimeInMillis());
          double diffAmt = (double) diff / dateUtilitiesUnitField;

          return (int) Math.round(diffAmt);
     }
}
