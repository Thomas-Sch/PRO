/* ============================================================================
 * Nom du fichier   : InconsistencyDate.java
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
 * Exception relevant d'une incohérence temporelle entre deux dates.
 * 
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 * 
 */
public class InconsistencyDate extends CoreComponentException {

   private static final long serialVersionUID = 30003L;

   /**
    * Crée une exception indiquant une incohérence temporelle.
    */
   public InconsistencyDate() {
      super();
   }

   /**
    * Crée une exception indiquant une incohérence temporelle.
    * 
    * @param message
    *           - le message à joindre à l'exception.
    */
   public InconsistencyDate(String message) {
      super(message);
   }

   /**
    * Crée une exception indiquant une incohérence temporelle.
    * 
    * @param cause
    *           - la cause de l'exception.
    */
   public InconsistencyDate(Throwable cause) {
      super(cause);
   }

   /**
    * Crée une exception indiquant une incohérence temporelle.
    * 
    * @param message
    *           - le message à joindre à l'exception.
    * @param cause
    *           - la cause de l'exception.
    */
   public InconsistencyDate(String message, Throwable cause) {
      super(message, cause);
   }
}
