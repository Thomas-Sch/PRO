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
 * La classe d'exception principale pour les objects du core
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 */
public class CoreComponentException extends Exception {

   private static final long serialVersionUID = 30000L;

   public CoreComponentException(String msgError) {
	     super("Core.Component : " +  msgError);
	   }
}

