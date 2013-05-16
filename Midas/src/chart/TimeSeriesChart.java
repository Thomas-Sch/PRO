/* ============================================================================
 * Nom du fichier   : TimeSeriesChart.java
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
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;

import chart.dataset.TimeSeriesValue;

/**
 * TODO
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 *
 */
public class TimeSeriesChart extends ChartWithAxes {

   
   
   /**
    * @param title
    */
   public TimeSeriesChart(String title, TimeSeriesValue[] varValue) {
      super(title);
      
      this.dataset = createDataset(varValue);
      
      JFreeChart chart = ChartFactory.createBarChart(
            super.getTitle(),
            super.getX(),
            super.getY(),
            dataset,
            super.getLegend(),
            super.getTooltip(),
            super.getUrl()
            );
      
      super.setChart(chart);
   }

   private TimeSeriesCollection createDataset(TimeSeriesValue[] pieValues) {
      TimeSeriesCollection data = new TimeSeriesCollection();
      
      for (TimeSeriesValue value : pieValues) {
         data.setSeries(value.getValue(), "Row", value.getColumn()); // "Row" is not used
      }
      
      return data;
   }

}
