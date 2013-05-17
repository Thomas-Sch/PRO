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

import java.util.Date;

import javax.swing.JFrame;

import org.jfree.data.xy.XYDataset;


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
      

      TimeSeriesValue[] dataset = {new TimeSeriesValue(5.0, new Date(2012, 05, 20)),
                                   new TimeSeriesValue(1.0, new Date(2012, 06, 21)),
                                   new TimeSeriesValue(15.0, new Date(2012, 10, 22))}; 
      
      TimeSeriesChart chart = new TimeSeriesChart("titre", dataset);
      
      JFrame frame = new JFrame("Time Series Chart");
      frame.getContentPane().add(chart.getChartPanel());
      frame.pack();
      frame.setVisible(true);

   }

}
