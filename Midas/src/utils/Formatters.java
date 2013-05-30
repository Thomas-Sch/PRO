/* ============================================================================
 * Nom du fichier   : Formatters.java
 * ============================================================================
 * Date de création : 15 avr. 2013
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

/**
 * Met à disposition des méthodes statiques permettant de formatter certains
 * affichages sous forme textuelle.
 * 
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 * 
 */
public class Formatters {

   public enum DateFormat {
      DD_MM_YYYY, MM_DD_YYYY, YYYY_MM_DD
   };

   /**
    * Crée une instance de la classe. Ce constructeur est privé pour empêcher
    * l'instanciation de cette classe, ne proposant que des méthodes statiques.
    */
   private Formatters() {

   }

   /**
    * Retourne la date correspondant aux valeurs données en paramètres selon le
    * format souhaité.
    * 
    * @param year
    *           - l'année.
    * @param month
    *           - le mois.
    * @param day
    *           - le jour.
    * @param format
    *           - le format voulu.
    * @return La date donnée au format demandé.
    */
   public static String date(int year, int month, int day, DateFormat format) {

      String separator = "-";
      String yyyy = String.format("%04d", year);
      String mm = String.format("%02d", month);
      String dd = String.format("%02d", day);

      switch (format) {
         case MM_DD_YYYY:
            return mm + separator + dd + separator + yyyy;

         case YYYY_MM_DD:
            return yyyy + separator + mm + separator + dd;

         case DD_MM_YYYY:
         default:
            return dd + separator + mm + separator + yyyy;

      }

   }

   /**
    * Retourne la date correspondant à la valeur donnée en paramètre selon le
    * format souhaité.
    * 
    * @param time
    *           - la date en millisecondes depuis le 1er janvier 1970, 00:00:00
    *           GMT.
    * @param format
    *           - le format voulu.
    * @return La date donnée au format demandé.
    */
   public static String date(long time, DateFormat format) {
      Calendar date = Calendar.getInstance();
      date.setTime(new Date(time));

      return date(date.get(Calendar.YEAR), date.get(Calendar.MONTH),
            date.get(Calendar.DAY_OF_MONTH), Formatters.DateFormat.YYYY_MM_DD);

   }

   /**
    * Retourne l'heure au format HH:MM:SS.
    * 
    * @param hours
    *           - les heures.
    * @param minutes
    *           - les minutes.
    * @param secondes
    *           - les secondes.
    * @return L'heure au format standard.
    */
   public static String time(int hours, int minutes, int secondes) {

      String separator = ":";
      String hh = String.format("%02d", hours);
      String mm = String.format("%02d", minutes);
      String ss = String.format("%02d", secondes);

      return hh + separator + mm + separator + ss;

   }

   /**
    * Retourne l'heure du jour actuel au format HH:MM:SS à partir du nombre de
    * millisecondes depuis le 1er janvier 1970, 00:00:00 GMT.
    * 
    * @param time
    *           - le nombre de millisecondes.
    * @return L'heure du jour actuel au format standard.
    */
   public static String time(long time) {
      Calendar date = Calendar.getInstance();
      date.setTime(new Date(time));

      return time(date.get(Calendar.HOUR_OF_DAY), date.get(Calendar.MINUTE),
            date.get(Calendar.SECOND));

   }

}
