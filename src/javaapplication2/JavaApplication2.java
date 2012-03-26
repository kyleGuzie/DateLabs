/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author kguzikowski
 */
public class JavaApplication2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Date date1 = new Date();
       
        
        SimpleDateFormat sdf =  new SimpleDateFormat("m/d/yyyy");
        SimpleDateFormat sdf1 =  new SimpleDateFormat("m/d/yyyy");
        
         System.out.println(sdf);
         
         Calendar c = Calendar.getInstance();
         
         
         Calendar caliClock = Calendar.getInstance();
         caliClock.set(2012, Calendar.JUNE, 22);
         Date dsds = caliClock.getTime();
         System.out.println(dsds.toString());
         
         Date date = c.getTime();
         System.out.println(c.toString());
        // TODO code appli cation logic here
    }
}
