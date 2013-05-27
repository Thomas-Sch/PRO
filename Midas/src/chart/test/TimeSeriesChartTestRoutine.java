/* ============================================================================
 * Nom du fichier   : TimeSeriesChartTestRoutine.java
 * ============================================================================
 * Date de création : 16.05.2013
 * ============================================================================
 * Auteurs          : Biolzi Sébastien
 *                    Brito Carvalho Bruno
 *                    Decorvet Grégoire
 *                    Schweizer Thomas
 *                    Sinniger Marcel
 * ============================================================================
 */
package chart.test;

import java.util.Calendar;
import java.util.Date;
import javax.swing.JFrame;
import chart.dataset.TimeSeriesValue;
import chart.types.TimeSeriesChart;

/**
 * TODO
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 *
 */
public class TimeSeriesChartTestRoutine {

   /**
    * @param args
    */
   public static void main(String[] args) {
      
      Calendar date = Calendar.getInstance();
      date.setTime(new Date(0));

      Calendar temp1 = Calendar.getInstance();
      Calendar temp2 = Calendar.getInstance();
      Calendar temp3 = Calendar.getInstance();
      temp1.set(2012, 01, 19);
      temp2.set(2012, 06, 21);
      temp3.set(2012, 10, 22);
      
      TimeSeriesValue[] dataset = {new TimeSeriesValue(5.0, new Date(temp1.getTimeInMillis())),
                                   new TimeSeriesValue(1.0, new Date(temp2.getTimeInMillis())),
                                   new TimeSeriesValue(15.0, new Date(temp3.getTimeInMillis()))}; 
      
      TimeSeriesChart chart = new TimeSeriesChart("titre", dataset);
      
      JFrame frame = new JFrame("Time Series Chart");
      frame.getContentPane().add(chart.getChartPanel());
      frame.pack();
      frame.setVisible(true);

   }

}
