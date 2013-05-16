/* ============================================================================
 * Nom du fichier   : BarChart.java
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
package chart;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

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
public class BarChart extends ChartWithAxes {

   private DefaultCategoryDataset dataset;
   
   public BarChart(String title, BarValue[] varValue) {
      super(title);
      
      this.dataset = createDataset(varValue);
      
      JFreeChart chart = ChartFactory.createBarChart(
            super.getTitle(),
            super.getX(),
            super.getY(),
            dataset,
            PlotOrientation.VERTICAL,
            super.getLegend(),
            super.getTooltip(),
            super.getUrl()
            );
      
      super.setChart(chart);
   }

   private DefaultCategoryDataset createDataset(BarValue[] pieValues) {
      DefaultCategoryDataset data = new DefaultCategoryDataset();
      
      for (BarValue value : pieValues) {
         data.setValue(value.getValue(), "Row", value.getColumn()); // "Row" is not used
      }
      
      return data;
   }
   
   public DefaultCategoryDataset getDataset() {
      return dataset;
   }

}
