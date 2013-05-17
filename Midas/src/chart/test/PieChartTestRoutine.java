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


import chart.dataset.PieValue;
import chart.types.PieChart;

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
           
      PieValue[] pieValues = {new PieValue(4.0, "cat1"), new PieValue(1.0, "cat2")};
      
      PieChart pieChart = new PieChart("title", pieValues);   
      
      JFrame frame = new JFrame("Pie Chart");
      frame.getContentPane().add(pieChart.getChartPanel());
      frame.pack();
      frame.setVisible(true);

   }

}
