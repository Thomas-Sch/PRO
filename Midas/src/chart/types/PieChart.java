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
package chart.types;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

import chart.dataset.PieValue;

/**
 * Représente un graphique de type "camembert".
 * 
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 * 
 */
public class PieChart extends Chart {

   private DefaultPieDataset dataset;

   /**
    * Crée le graphique de type "camembert" à partir des valeurs données.
    * 
    * @param title
    *           - le titre du graphique.
    * @param pieValues
    *           - les entrées du graphique.
    */
   public PieChart(String title, PieValue[] pieValues) {
      super(title);

      this.dataset = createDataset(pieValues);

      JFreeChart chart = ChartFactory.createPieChart(super.getTitle(), dataset,
            super.getLegend(), super.getTooltip(), super.getUrl());

      super.setChart(chart);
   }

   /**
    * Crée et retourne les données graphiques utilisables par JFreeChart à
    * partir des entrées spécifiées.
    * 
    * @param pieValues
    *           - les entrées pour le graphique de type "camembert".
    * @return Les données du graphique utilisables par JFreeChart.
    */
   private DefaultPieDataset createDataset(PieValue[] pieValues) {
      DefaultPieDataset data = new DefaultPieDataset();

      for (PieValue value : pieValues) {
         data.setValue(value.getCategory(), value.getValue());
      }

      return data;
   }

}
