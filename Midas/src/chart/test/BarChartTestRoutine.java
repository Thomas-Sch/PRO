/* ============================================================================
 * Nom du fichier   : BarChartTestRoutine.java
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

import chart.BarChart;
import chart.dataset.BarValue;

/**
 * TODO
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 *
 */
public class BarChartTestRoutine {

   /**
    * @param args
    */
   public static void main(String[] args) {
           
      BarValue[] BarValues = {new BarValue(0.5, "cat1"), new BarValue(1.0, "cat2")};
      
      BarChart barChart = new BarChart("title", BarValues);   
      
      JFrame frame = new JFrame("Bar Chart");
      frame.getContentPane().add(barChart.getChartPanel());
      frame.pack();
      frame.setVisible(true);

   }


}
