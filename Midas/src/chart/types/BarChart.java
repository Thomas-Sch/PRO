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
 * Représente un diagramme en barres, et permet de l'afficher graphiquement.
 * 
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 * 
 */
public class BarChart extends ChartWithAxis {

   private DefaultCategoryDataset dataset;

   /**
    * Crée un diagramme en barres selon les données spécifiées.
    * 
    * @param title
    *           - le titre du diagramme.
    * @param barValue
    *           - le tableau des entrées à afficher dans le diagramme.
    */
   public BarChart(String title, BarValue[] barValue) {
      super(title, "", "");

      this.dataset = createDataset(barValue);

      JFreeChart chart = ChartFactory.createBarChart(super.getTitle(),
            super.getX(), super.getY(), dataset, PlotOrientation.VERTICAL,
            super.getLegend(), super.getTooltip(), super.getUrl());

      super.setChart(chart);
   }

   /**
    * Crée et retourne les données graphiques utilisables par JFreeChart à
    * partir des entrées spécifiées.
    * 
    * @param barValues
    *           - les entrées pour le graphique en barres.
    * @return Les données du graphique utilisables par JFreeChart.
    */
   private DefaultCategoryDataset createDataset(BarValue[] barValues) {
      DefaultCategoryDataset data = new DefaultCategoryDataset();

      for (BarValue value : barValues) {
         data.setValue(value.getValue(), "Row", value.getColumn()); // "Row" is
                                                                    // not used
      }

      return data;
   }

   /**
    * Retourne les données du graphique utilisables par JFreeChart.
    * 
    * @return Les données du graphique.
    */
   public DefaultCategoryDataset getDataset() {
      return dataset;
   }

}
