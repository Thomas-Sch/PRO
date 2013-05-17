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
 * TODO
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
   
   public Chart(String title) {
      this.title = title;
      this.legend = false;
      this.tooltip = false;
      this.url = false;      
   }
   
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
    * @param chart the chart to set
    */
   protected void setChart(JFreeChart chart) {
      this.chart = chart;
   }

   /**
    * @return the title
    */
   protected String getTitle() {
      return title;
   }

   /**
    * @return the legend
    */
   protected Boolean getLegend() {
      return legend;
   }

   /**
    * @return the tooltip
    */
   protected Boolean getTooltip() {
      return tooltip;
   }

   /**
    * @return the url
    */
   protected Boolean getUrl() {
      return url;
   }
   
}