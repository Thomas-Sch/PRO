/* ============================================================================
 * Nom du fichier   : BadTimeSliceException.java
 * ============================================================================
 * Date de création : 7 juin 2013
 * ============================================================================
 * Auteurs          : Biolzi Sébastien
 *                    Brito Carvalho Bruno
 *                    Decorvet Grégoire
 *                    Schweizer Thomas
 *                    Sinniger Marcel
 * ============================================================================
 */
package gui.exception;


/**
 * Exception relevant d'une intervalle de temps incohérente.
 * 
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 * 
 */
public class BadTimeSliceException extends Exception {

   private static final long serialVersionUID = 30003L;

   /**
    * Crée une exception indiquant une intervalle incohérente.
    */
   public BadTimeSliceException() {
      super();
   }

   /**
    * Crée une exception indiquant une intervalle incohérente.
    * 
    * @param message
    *           - le message à joindre à l'exception.
    */
   public BadTimeSliceException(String message) {
      super(message);
   }

   /**
    * Crée une exception indiquant une intervalle incohérente.
    * 
    * @param cause
    *           - la cause de l'exception.
    */
   public BadTimeSliceException(Throwable cause) {
      super(cause);
   }

   /**
    * Crée une exception indiquant une intervalle incohérente.
    * 
    * @param message
    *           - le message à joindre à l'exception.
    * @param cause
    *           - la cause de l'exception.
    */
   public BadTimeSliceException(String message, Throwable cause) {
      super(message, cause);
   }
}
