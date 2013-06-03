/* ============================================================================
 * Nom du fichier   : Chart.java
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

import javax.swing.JPanel;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;

/**
 * Cette classe définit les propriétés communes des diagrammes
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 *
 */
abstract public class Chart {

   private String title;
   private Boolean legend;
   private Boolean tooltip;
   private Boolean url;
   private JFreeChart chart;
   
   /**
    * Ce constructeur définit le titre du diagramme et les propriétés non-modifiable
    * depuis l'extérieur mais qui sont nécessaires pour JFreeChart.
    * @param title est le titre du diagramme
    */
   public Chart(String title) {
      this.title = title;
      this.legend = false;
      this.tooltip = false;
      this.url = false;      
   }
   
   /**
    * 
    * @return le diagramme sous la forme d'un JPanel
    */
   public JPanel getChartPanel() {
      return new ChartPanel(chart);
   }

   /**
    * @return le/la/les chart
    */
   public JFreeChart getChart() {
      return chart;
   }

   /**
    * @param chart - la nouvelle valeur pour l'attribut chart
    */
   protected void setChart(JFreeChart chart) {
      this.chart = chart;
   }

   /**
    * @return le/la/les title
    */
   protected String getTitle() {
      return title;
   }

   /**
    * @return le/la/les legend
    */
   protected Boolean getLegend() {
      return legend;
   }

   /**
    * @return le/la/les tooltip
    */
   protected Boolean getTooltip() {
      return tooltip;
   }

   /**
    * @return le/la/les url
    */
   protected Boolean getUrl() {
      return url;
   }
   
}