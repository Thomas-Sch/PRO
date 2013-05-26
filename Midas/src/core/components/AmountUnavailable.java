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
package core.components;

/**
 * Exeption lors d'un montant invalide
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
    * @param msgError - message d'erreur
    */
   public AmountUnavailable(String msgError) {
      super(msgError);
   }

}
