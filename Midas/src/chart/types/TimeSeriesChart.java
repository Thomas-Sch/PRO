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
 * Représente un graphique de progression en fonction du temps.
 * 
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 * 
 */
public class TimeSeriesChart extends ChartWithAxis {

   private TimeSeriesCollection dataset;

   /**
    * Crée le graphique temporel à partir des valeurs données.
    * 
    * @param title
    *           - le titre du graphique.
    * @param timeSeriesValues
    *           - les entrées du graphique.
    */
   public TimeSeriesChart(String title, TimeSeriesValue[] timeSeriesValues) {
      super(title, "", "");

      this.dataset = createDataset(timeSeriesValues);

      JFreeChart chart = ChartFactory.createTimeSeriesChart(super.getTitle(),
            super.getX(), super.getY(), dataset, super.getLegend(),
            super.getTooltip(), super.getUrl());

      super.setChart(chart);
   }

   /**
    * Crée et retourne les données graphiques utilisables par JFreeChart à
    * partir des entrées spécifiées.
    * 
    * @param timeSeriesValue
    *           - les entrées pour le graphique temporel.
    * @return Les données du graphique utilisables par JFreeChart.
    */
   private TimeSeriesCollection createDataset(TimeSeriesValue[] timeSeriesValue) {
      TimeSeriesCollection data = new TimeSeriesCollection();
      TimeSeries serie = new TimeSeries("titre-----");

      for (TimeSeriesValue value : timeSeriesValue) {
         Calendar date = Calendar.getInstance();
         date.setTimeInMillis(value.getDate().getTime());
         serie.add(
               new Month(date.get(Calendar.MONTH), date.get(Calendar.YEAR)),
               value.getValue());
      }

      data.addSeries(serie);

      return data;
   }

}
