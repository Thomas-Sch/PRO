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

import java.util.Calendar;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.data.time.Month;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;

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

   /**
    * 
    * @param timeSeriesValue - un tableau de TimeSeriesValue qui est utilisé pour dessiner le diagramme
    * @return un TimeSeriesCollection le dataset utilisé dans JFreeChart
    */
   private TimeSeriesCollection createDataset(TimeSeriesValue[] timeSeriesValue) {
      TimeSeriesCollection data = new TimeSeriesCollection();
      TimeSeries serie = new TimeSeries("titre-----");
      
      for (TimeSeriesValue value : timeSeriesValue) {
         Calendar date = Calendar.getInstance();
         date.setTimeInMillis(value.getDate().getTime());
         //serie.add(new Month(value.getDate().getMonth(), value.getDate().getYear()), value.getValue());
         serie.add(new Month(date.get(Calendar.MONTH), date.get(Calendar.YEAR)), value.getValue());
      }
      
      data.addSeries(serie);
      
      return data;
   }

}
