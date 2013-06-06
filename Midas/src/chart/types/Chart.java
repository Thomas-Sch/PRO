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
 * Représente un graphique et met à dispositions les fonctionnalités de base.
 * 
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
    * Crée un graphique et initialise les propriétés nécessaires pour
    * JFreeChart.
    * 
    * @param title
    *           - le titre du graphique.
    */
   public Chart(String title) {
      this.title = title;
      this.legend = false;
      this.tooltip = false;
      this.url = false;
   }

   /**
    * Retourne le panneau affichant le graphique.
    * 
    * @return Le panneau affichant le graphique.
    */
   public JPanel getChartPanel() {
      return new ChartPanel(chart);
   }

   /**
    * Retourne le graphique.
    * 
    * @return Le graphique.
    */
   public JFreeChart getChart() {
      return chart;
   }

   /**
    * Définit le graphique à utiliser.
    * 
    * @param chart
    *           - le graphique à utiliser.
    */
   protected void setChart(JFreeChart chart) {
      this.chart = chart;
   }

   /**
    * Retourne le titre du graphique.
    * 
    * @return Le titre du graphique.
    */
   protected String getTitle() {
      return title;
   }

   /**
    * Retourne s'il faut ou non une légende.
    * 
    * @return Vrai s'il faut une légende, Faux le cas échéant.
    */
   protected Boolean getLegend() {
      return legend;
   }

   /**
    * Retourne s'il faut ou non générer les texte d'indications au survol de la
    * souris.
    * 
    * @return Vrai s'il faut les générer, Faux le cas échéant.
    */
   protected Boolean getTooltip() {
      return tooltip;
   }

   /**
    * Retourne s'il faut ou non générer les URL lors de la création du
    * graphique.
    * 
    * @return Vrai s'il faut les générer, Faux le cas échéant.
    */
   protected Boolean getUrl() {
      return url;
   }

}