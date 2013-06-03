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
 * Classe qui représente une violation de contrainte de la base de données.
 * 
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 * 
 */
public class DatabaseConstraintViolation extends Exception {

   /**
    * Imposé par le parent pour la sérialisation.
    */
   private static final long serialVersionUID = 7724110393758568140L;

   /**
    * Crée une exception pour une violation de contrainte.
    * 
    * @param message
    *           - le message associé à l'exception.
    */
   public DatabaseConstraintViolation(String message) {
      super(message);
   }

}
