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
package chart.types;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.time.Month;
import org.jfree.data.time.TimeSeries;
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

   TimeSeriesCollection dataset;
   
   /**
    * @param title
    */
   public TimeSeriesChart(String title, TimeSeriesValue[] varValues) {
      super(title);
      
      this.dataset = createDataset(varValues);
      
      JFreeChart chart = ChartFactory.createTimeSeriesChart(
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
      TimeSeries serie = new TimeSeries("titre-----");
      
      for (TimeSeriesValue value : pieValues) {
         serie.add(new Month(value.getDate().getMonth(), value.getDate().getYear()), value.getValue());
      }
      
      data.addSeries(serie);
      
      return data;
   }

}
