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

import java.util.Calendar;
import java.util.Date;

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
   
   /**
    * Retourne la date de début et de fin d'une date en fonction de l'intervalle
    * de temps choisie. Par exemple, si l'on choisi la date du 29.05.2013 et
    * une intervalle mensuelle, la fonction va retourner [0] => 01.05.2013 et
    * [1] => 31.05.2013 avec les jours et heures correctes.
    * @param slice Intervalle de temps souhaitée.
    * @param date Date contenue dans l'intervalle.
    * @return  Un tableau de deux cases de date. La première case [0] contient
    *          la date de début de l'intervalle et la deuxième case [1] contient
    *          la date de fin de l'intervalle.
    */
   public static Date[] getFirstAndLastDay(TimeSlice slice, Date date) {
      Date begin = null, end = null;
      
      Calendar cal = Calendar.getInstance();
      cal.setTime(date);
      cal.set(Calendar.HOUR_OF_DAY, cal.getActualMinimum(Calendar.HOUR_OF_DAY));
      cal.clear(Calendar.MINUTE);
      cal.clear(Calendar.SECOND);
      cal.clear(Calendar.MILLISECOND);
      
      switch (slice) {
         case ANNUAL:
            cal.set(Calendar.DAY_OF_YEAR, cal.getActualMinimum(Calendar.DAY_OF_YEAR));
            begin = cal.getTime();
            cal.set(Calendar.DAY_OF_YEAR, cal.getActualMaximum(Calendar.DAY_OF_YEAR));
            break;
         case DAILY:
            // Rien à faire de particulier dans ce cas.
            begin = cal.getTime();
            break;
         case MONTHLY:
            cal.set(Calendar.DAY_OF_MONTH, cal.getActualMinimum(Calendar.DAY_OF_MONTH));
            begin = cal.getTime();
            
            cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
            break;
         case WEEKLY:
            cal.set(Calendar.DAY_OF_WEEK, cal.getFirstDayOfWeek());
            begin = cal.getTime();
            
            cal.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
            break;
      }
      // Paramétrage de l'heure et envoi des résultats.
      cal.set(Calendar.HOUR, cal.getActualMaximum(Calendar.HOUR));
      cal.set(Calendar.MINUTE, cal.getActualMaximum(Calendar.MINUTE));
      cal.set(Calendar.SECOND, cal.getActualMaximum(Calendar.SECOND));
      cal.set(Calendar.MILLISECOND, cal.getActualMaximum(Calendar.MILLISECOND));
      end = cal.getTime();
      return new Date[] {begin, end};
   }
   
}