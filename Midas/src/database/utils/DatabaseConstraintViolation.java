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

public class DatabaseConstraintViolation extends Exception {

   public DatabaseConstraintViolation(String message) {
      super(message);
   }
   
   private static final long serialVersionUID = 7724110393758568140L;

}
