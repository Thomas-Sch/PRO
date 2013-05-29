/* ============================================================================
 * Nom du fichier   : CoreComponentException.java
 * ============================================================================
 * Date de création : 22 mai 2013
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
 * La classe d'exception principale pour les objets du coeur.
 * 
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 */
public class CoreComponentException extends Exception {

   private static final long serialVersionUID = 30000L;

   /**
    * Crée une exception portant sur un composant du coeur.
    */
   public CoreComponentException() {
      super();
   }

   /**
    * Crée une exception portant sur un composant du coeur.
    * 
    * @param message
    *           - le message à joindre à l'exception.
    */
   public CoreComponentException(String message) {
      super(message);
   }

   /**
    * Crée une exception portant sur un composant du coeur.
    * 
    * @param cause
    *           - la cause de l'exception.
    */
   public CoreComponentException(Throwable cause) {
      super(cause);
   }

   /**
    * Crée une exception portant sur un composant du coeur.
    * 
    * @param message
    *           - le message à joindre à l'exception.
    * @param cause
    *           - la cause de l'exception.
    */
   public CoreComponentException(String message, Throwable cause) {
      super(message, cause);
   }
}
