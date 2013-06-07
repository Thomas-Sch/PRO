/* ============================================================================
 * Nom du fichier   : BadDateException.java
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
 * Exception relevant d'une date invalide.
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 *
 */
public class BadDateException extends Exception{
   /**
    * ID de sérialisation.
    */
   private static final long serialVersionUID = -8598398981080874380L;

   /**
    * Crée une exception indiquant une date invalide.
    */
   public BadDateException() {
      super();
   }

   /**
    * Crée une exception indiquant une date invalide.
    * 
    * @param message
    *           - le message à joindre à l'exception.
    */
   public BadDateException(String message) {
      super(message);
   }

   /**
    * Crée une exception indiquant une date invalide.
    * 
    * @param cause
    *           - la cause de l'exception.
    */
   public BadDateException(Throwable cause) {
      super(cause);
   }

   /**
    * Crée une exception indiquant une date invalide.
    * 
    * @param message
    *           - le message à joindre à l'exception.
    * @param cause
    *           - la cause de l'exception.
    */
   public BadDateException(String message, Throwable cause) {
      super(message, cause);
   }

}
