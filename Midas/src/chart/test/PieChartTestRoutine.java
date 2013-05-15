/* ============================================================================
 * Nom du fichier   : PieChartTestRoutine.java
 * ============================================================================
 * Date de création : 15.05.2013
 * ============================================================================
 * Auteurs          : Biolzi Sébastien
 *                    Brito Carvalho Bruno
 *                    Decorvet Grégoire
 *                    Schweizer Thomas
 *                    Sinniger Marcel
 * ============================================================================
 */
package chart.test;

import java.awt.Component;

import javax.swing.JFrame;

import chart.PieChart;
import chart.dataset.PieValue;

/**
 * TODO
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 *
 */
public class PieChartTestRoutine {

   /**
    * @param args
    */
   public static void main(String[] args) {
      
      PieValue[] pieValues = new PieValue[2];
      pieValues[0] = new PieValue(4.0, "cat1");
      pieValues[1] = new PieValue(1.0, "cat2");
      
      PieChart pieChart = new PieChart("title", pieValues);   
      
      JFrame frame = new JFrame("First");
      frame.getContentPane().add(pieChart.getChartPanel());
      frame.pack();
      frame.setVisible(true);

   }

}
