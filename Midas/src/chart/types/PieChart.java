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
 * Cette classe permet de créer un diagramme en camembert
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
    * Le constructeur crée un diagramme en comembert complèt avec les données passées par argument
    * à l'aide de JFreeChart
    * @param title est le titre du diagramme
    * @param pieValues est un tableau de PieValue qui représente les données
    * qui sont prises en compte pour la visualisation 
    */
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

   /**
    * 
    * @param pieValues - un tableau de PieValue qui est utilisé pour dessiner le diagramme
    * @return un DefaultPieDataset le dataset utilisé dans JFreeChart
    */
   private DefaultPieDataset createDataset(PieValue[] pieValues) {
      DefaultPieDataset data = new DefaultPieDataset();
      
      for (PieValue value : pieValues) {
         data.setValue(value.getCategory(), value.getValue());
      }
      
      return data;
   }
   
}
