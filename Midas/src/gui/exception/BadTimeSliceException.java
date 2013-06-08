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
 * Exception relevant d'un intervalle de temps incohérent.
 * 
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 * 
 */
public class BadTimeSliceException extends Exception {

   /**
    * ID de sérialisation.
    */
   private static final long serialVersionUID = -5281539967699282826L;

   /**
    * Crée une exception indiquant un intervalle incohérent.
    */
   public BadTimeSliceException() {
      super();
   }

   /**
    * Crée une exception indiquant un intervalle incohérent.
    * 
    * @param message
    *           - le message à joindre à l'exception.
    */
   public BadTimeSliceException(String message) {
      super(message);
   }

   /**
    * Crée une exception indiquant un intervalle incohérent.
    * 
    * @param cause
    *           - la cause de l'exception.
    */
   public BadTimeSliceException(Throwable cause) {
      super(cause);
   }

   /**
    * Crée une exception indiquant un intervalle incohérent.
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
