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

import javax.swing.JFrame;

import org.jfree.data.xy.XYDataset;

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
      XYDataset dataset
      
      
      JFrame frame = new JFrame("Time Series Chart");
      frame.getContentPane().add(barChart.getChartPanel());
      frame.pack();
      frame.setVisible(true);

   }

}
