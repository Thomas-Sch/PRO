/* ============================================================================
 * Nom du fichier   : AmountUnavailableException.java
 * ============================================================================
 * Date de création : 26 mai 2013
 * ============================================================================
 * Auteurs          : Biolzi Sébastien
 *                    Brito Carvalho Bruno
 *                    Decorvet Grégoire
 *                    Schweizer Thomas
 *                    Sinniger Marcel
 * ============================================================================
 */
package core.exceptions;

/**
 * Exception indiquant une manipulation invalide d'un montant.
 * 
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 * 
 */
public class AmountUnavailableException extends CoreComponentException {

   private static final long serialVersionUID = 30001L;

   /**
    * Crée une exception indiquant une manipulation invalide d'un montant.
    */
   public AmountUnavailableException() {
      super();
   }

   /**
    * Crée une exception indiquant une manipulation invalide d'un montant.
    * 
    * @param message
    *           - le message à joindre à l'exception.
    */
   public AmountUnavailableException(String message) {
      super(message);
   }

   /**
    * Crée une exception indiquant une manipulation invalide d'un montant.
    * 
    * @param cause
    *           - la cause de l'exception.
    */
   public AmountUnavailableException(Throwable cause) {
      super(cause);
   }

   /**
    * Crée une exception indiquant une manipulation invalide d'un montant.
    * 
    * @param message
    *           - le message à joindre à l'exception.
    * @param cause
    *           - la cause de l'exception.
    */
   public AmountUnavailableException(String message, Throwable cause) {
      super(message, cause);
   }

}
