/* ============================================================================
 * Nom du fichier   : DatabaseConsraintViolation.java
 * ============================================================================
 * Date de création : 02.05.2013
 * ============================================================================
 * Auteurs          : Biolzi Sébastien
 *                    Brito Carvalho Bruno
 *                    Decorvet Grégoire
 *                    Schweizer Thomas
 *                    Sinniger Marcel
 * ============================================================================
 */
package database.utils;

/**
 * Classe qui représente une violation de contrainte
 * TODO
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 *
 */
public class DatabaseConstraintViolation extends Exception {

   /**
    * Exception dans le cas d'une violation de contrainte
    * @param message
    */
   public DatabaseConstraintViolation(String message) {
      super(message);
   }
   
   /**
    * imposé par le parent pour la séralisation
    */
   private static final long serialVersionUID = 7724110393758568140L;

}
