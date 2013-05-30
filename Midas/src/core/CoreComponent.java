/* ============================================================================
 * Nom du fichier   : CoreComponent.java
 * ============================================================================
 * Date de création : 25 avr. 2013
 * ============================================================================
 * Auteurs          : Biolzi Sébastien
 *                    Brito Carvalho Bruno
 *                    Decorvet Grégoire
 *                    Schweizer Thomas
 *                    Sinniger Marcel
 * ============================================================================
 */
package core;

import java.util.Observable;


/**
 * Représente un composant du coeur, observable de l'extérieur.
 * 
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 *
 */
abstract public class CoreComponent extends Observable {
   
   protected Core core;
   
   /**
    * Crée un composant du coeur.
    * @param core - coeur logique du programme.
    */
   public CoreComponent(Core core) {
     this.core = core;
   }
   
   /**
    * Force une notification des observateurs.
    */
   public void setChangedAndNotifyObservers() {
      setChanged();
      notifyObservers();
   }
}
