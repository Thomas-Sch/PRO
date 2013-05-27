/* ============================================================================
 * Nom du fichier   : TimeSlice.java
 * ============================================================================
 * Date de création : 27 mai 2013
 * ============================================================================
 * Auteurs          : Biolzi Sébastien
 *                    Brito Carvalho Bruno
 *                    Decorvet Grégoire
 *                    Schweizer Thomas
 *                    Sinniger Marcel
 * ============================================================================
 */
package utils;

import settings.Language.Text;

public enum TimeSlice { 
   DAILY(1, Text.DAILY_LABEL), 
   WEEKLY(7, Text.WEEKLY_LABEL),
   MONTHLY(31, Text.MONTHLY_LABEL), 
   ANNUAL(365, Text.ANNUAL_LABEL);
   
   private int lengthIdentifier;
   private Text name;
   
   /**
    * Constructeur d'une intervalle de temps.
    * @param id Nombre identifiant la longueur de temps.
    * @param name Nom de l'intervalle.
    */
   private TimeSlice(int id, Text name) {
      lengthIdentifier = id;
      this.name = name;
   }
   
   /**
    * @return Le nom de l'intervalle de temps.
    */
   public String getName() {
      return name.toString();
   }
   
   /**
    * @return l'identifiant de longueur du timeslice.
    */
   public int getInterval() {
      return lengthIdentifier;
   }
   
   /**
    * Renvoie le premier TimeSlice possédant le nom name.
    * @param name Nom du TimeSlice recherché.
    * @return Le premier TimeSlice possédant le nom name (null si rien trouvé).
    */
   public static TimeSlice getTimeSlice(String name) {
      for(TimeSlice slice : TimeSlice.values()) {
         if(slice.getName().equals(name)) {
            return slice;
         }
      }
      return null;
   }
   
}