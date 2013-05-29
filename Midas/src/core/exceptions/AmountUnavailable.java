/* ============================================================================
 * Nom du fichier   : AmountUnavailable.java
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
public class AmountUnavailable extends CoreComponentException {

   private static final long serialVersionUID = 30001L;

   /**
    * Crée une exception indiquant une manipulation invalide d'un montant.
    */
   public AmountUnavailable() {
      super();
   }

   /**
    * Crée une exception indiquant une manipulation invalide d'un montant.
    * 
    * @param message
    *           - le message à joindre à l'exception.
    */
   public AmountUnavailable(String message) {
      super(message);
   }

   /**
    * Crée une exception indiquant une manipulation invalide d'un montant.
    * 
    * @param cause
    *           - la cause de l'exception.
    */
   public AmountUnavailable(Throwable cause) {
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
   public AmountUnavailable(String message, Throwable cause) {
      super(message, cause);
   }

}
