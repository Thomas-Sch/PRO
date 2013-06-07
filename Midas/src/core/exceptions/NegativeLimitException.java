/* ============================================================================
 * Nom du fichier   : NegativeLimitException.java
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
 * Exception indiquant un mauvais choix de limite.
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 *
 */
public class NegativeLimitException extends CoreComponentException {

   private static final long serialVersionUID = 30002L;
   
   /**
    * Crée une exception indiquant un mauvais choix de limite.
    */
   public NegativeLimitException() {
      super();
   }

   /**
    * Crée une exception indiquant un mauvais choix de limite.
    * 
    * @param message
    *           - le message à joindre à l'exception.
    */
   public NegativeLimitException(String message) {
      super(message);
   }

   /**
    * Crée une exception indiquant un mauvais choix de limite.
    * 
    * @param cause
    *           - la cause de l'exception.
    */
   public NegativeLimitException(Throwable cause) {
      super(cause);
   }

   /**
    * Crée une exception indiquant un mauvais choix de limite.
    * 
    * @param message
    *           - le message à joindre à l'exception.
    * @param cause
    *           - la cause de l'exception.
    */
   public NegativeLimitException(String message, Throwable cause) {
      super(message, cause);
   }

}
