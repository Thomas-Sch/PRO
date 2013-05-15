/* ============================================================================
 * Nom du fichier   : PieChart.java
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
package chart;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

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
public class PieChart extends Chart {
   
   private DefaultPieDataset dataset;
   
   public PieChart(String title, PieValue[] pieValues) {
      super(title);
      
      this.dataset = createDataset(pieValues);
      
      JFreeChart chart = ChartFactory.createPieChart(
            super.getTitle(),
            dataset,
            super.getLegend(),
            super.getTooltip(),
            super.getUrl()
            );
      
      super.setChart(chart);
   }

   private DefaultPieDataset createDataset(PieValue[] pieValues) {
      DefaultPieDataset data = new DefaultPieDataset();
      
      for (PieValue value : pieValues) {
         data.setValue(value.getCategory(), value.getValue());
      }
      
      return data;
   }
   
}
