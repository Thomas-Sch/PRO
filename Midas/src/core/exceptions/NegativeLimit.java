/* ============================================================================
 * Nom du fichier   : NegativeLimit.java
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
public class NegativeLimit extends CoreComponentException {

   private static final long serialVersionUID = 30002L;
   
   /**
    * Crée une exception indiquant un mauvais choix de limite.
    */
   public NegativeLimit() {
      super();
   }

   /**
    * Crée une exception indiquant un mauvais choix de limite.
    * 
    * @param message
    *           - le message à joindre à l'exception.
    */
   public NegativeLimit(String message) {
      super(message);
   }

   /**
    * Crée une exception indiquant un mauvais choix de limite.
    * 
    * @param cause
    *           - la cause de l'exception.
    */
   public NegativeLimit(Throwable cause) {
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
   public NegativeLimit(String message, Throwable cause) {
      super(message, cause);
   }

}
