/* ============================================================================
 * Nom du fichier   : LimitNegative.java
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
 * Exeption en cas d'un mauvais argument de limite
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 *
 */
public class LimitNegative extends CoreComponentException {

   private static final long serialVersionUID = 30002L;
   
   /**
    * @param msgError - le message d'erreur
    */
   public LimitNegative(String msgError) {
      super(msgError);
   }

}
