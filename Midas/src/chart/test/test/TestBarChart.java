/* ============================================================================
 * Nom du fichier   : TestBarChart.java
 * ============================================================================
 * Date de création : 14.05.2013
 * ============================================================================
 * Auteurs          : Biolzi Sébastien
 *                    Brito Carvalho Bruno
 *                    Decorvet Grégoire
 *                    Schweizer Thomas
 *                    Sinniger Marcel
 * ============================================================================
 */
package chart.test.test;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 * TODO
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 *
 */
public class TestBarChart {

   /**
    * @param args
    */
   public static void main(String[] args) {
      DefaultCategoryDataset dataset = new DefaultCategoryDataset();
      dataset.addValue(1.0, "Row 1", "Column 1");
      dataset.addValue(5.0, "Row 1", "Column 2");
      dataset.addValue(3.0, "Row 1", "Column 3");
      //dataset.addValue(2.0, "Row 2", "Column 1");
      //dataset.addValue(3.0, "Row 2", "Column 2");
      //dataset.addValue(2.0, "Row 2", "Column 3");
      
      JFreeChart chart = ChartFactory.createBarChart(
            "Bar Chart Demo", // chart title
            "Category", // domain axis label
            "Value", // range axis label
            dataset, // data
            PlotOrientation.VERTICAL, // orientation
            true, // include legend
            true, // tooltips?
            false // URLs?
            );
      
      ChartFrame frame = new ChartFrame("title", chart);
      frame.pack();
      frame.setVisible(true);
      
   }

}
