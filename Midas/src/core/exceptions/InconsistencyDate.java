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
 *  Exeption d'une incoherence entre deux date d'un point vue temporelle
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
    * @param msgError - message d'erreur
    */
   public InconsistencyDate(String msgError) {
      super(msgError);
   }

}
