/* ============================================================================
 * Nom du fichier   : View.java
 * ============================================================================
 * Date de création : 22 avr. 2013
 * ============================================================================
 * Auteurs          : Biolzi Sébastien
 *                    Brito Carvalho Bruno
 *                    Decorvet Grégoire
 *                    Schweizer Thomas
 *                    Sinniger Marcel
 * ============================================================================
 */
package gui;

import java.util.Observer;

/**
 * Indique que l'objet peut s'enregister auprès d'un modèle observable et être
 * prévenu lorsque celui-ci change un ou plusieurs de ses paramètres.
 * <p>
 * Il s'agit actuellement d'un renommage de l'interface Observer.
 * 
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 * 
 * @see java.util.Observer
 */
public interface View extends Observer {

}
