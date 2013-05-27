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
package chart.types;

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

   /**
    * 
    * @param piebarValuesValues - un tableau de BarValue qui est utilisé pour dessiner le diagramme
    * @return un DefaultCategoryDataset le dataset utilisé dans JFreeChart
    */
   private DefaultCategoryDataset createDataset(BarValue[] barValues) {
      DefaultCategoryDataset data = new DefaultCategoryDataset();
      
      for (BarValue value : barValues) {
         data.setValue(value.getValue(), "Row", value.getColumn()); // "Row" is not used
      }
      
      return data;
   }
   
   /**
    * 
    * @return le/la/les dataset
    */
   public DefaultCategoryDataset getDataset() {
      return dataset;
   }

}
