/* ============================================================================
 * Nom du fichier   : UserAction.java
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

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import core.Core;

/**
 * Decrit une action réalisable par l'utilisateur à l'aide de l'interface
 * graphique.
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 *
 */
abstract public class UserAction implements ActionListener {
   
   private Core core;
   
   private Object[] dependencies = null;
   
   /**
    * 
    * @param core - le coeur à disposition de l'action.
    */
   public UserAction(Core core, Object ... dependencies) {
      this.core = core;
      this.dependencies = dependencies;
   }
   
   
   /**
    * Réalise l'action lors du déclenchement de celle-ci par l'utilisateur.
    * @param e - l'événement survenu.
    */
   public void actionPerformed(ActionEvent e) {
     execute(core, e, dependencies);
   }
   
   /**
    * Réalise les opérations à effectuer lors du déclenchement de l'action.
    * @param core - le coeur à disposition de l'action.
    * @param event - l'événément survenu.
    * @param dependencies - le tableau des dépendances éventuelles.
    */
   abstract protected void execute(Core core, ActionEvent event, Object[] dependencies);

}
