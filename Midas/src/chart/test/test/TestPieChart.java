/* ============================================================================
 * Nom du fichier   : TestChart.java
 * ============================================================================
 * Date de création : 13.05.2013
 * ============================================================================
 * Auteurs          : Biolzi Sébastien
 *                    Brito Carvalho Bruno
 *                    Decorvet Grégoire
 *                    Schweizer Thomas
 *                    Sinniger Marcel
 * ============================================================================
 */
package chart.test.test;

/**
 * TODO
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 *
 */
import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
/**
* A simple introduction to using JFreeChart. This demo is described in the
* JFreeChart Developer Guide.
*/
public class TestPieChart {
   /**
   * The starting point for the demo.
   *
   * @param args ignored.
   */
   public static void main(String[] args) {
      // create a dataset...
      DefaultPieDataset data = new DefaultPieDataset();
      data.setValue("Category 1", 43.2);
      data.setValue("Category 2", 27.9);
      data.setValue("Category 3", 79.5);
      // create a chart...
      JFreeChart chart = ChartFactory.createPieChart(
         "Sample Pie Chart",
         data,
         true, // legend?
         true, // tooltips?
         false // URLs?
      );
      // create and display a frame...
      //ChartFrame frame = new ChartFrame("First", chart);
      ChartPanel chartPanel = new ChartPanel(chart);
      JFrame frame = new JFrame("First");
      frame.getContentPane().add(chartPanel);
      frame.pack();
      frame.setVisible(true);
   }
}




