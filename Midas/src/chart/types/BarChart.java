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
 * Cette classe permet de créer un diagramme en bar
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 *
 */
public class BarChart extends ChartWithAxes {

   private DefaultCategoryDataset dataset;
   
   /**
    * Le constructeur crée un diagramme en bar complèt avec les données passées par argument
    * à l'aide de JFreeChart
    * @param title est le titre du diagramme
    * @param barValue est un tableau de BarValue qui représente les données
    * qui sont prises en compte pour la visualisation 
    */
   public BarChart(String title, BarValue[] barValue) {
      super(title);
      
      this.dataset = createDataset(barValue);
      
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
