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
package core.components;

import java.util.Observable;

import core.Core;

/**
 * Cette classe une classe parente pour les objets du core
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 *
 */
public class CoreComponent extends Observable {
   
   /**
    * coeur logique du programme 
    */
   protected Core core;
   
   /**
    * constructeur
    * @param core - coeur logique du programme 
    */
   public CoreComponent(Core core) {
     this.core = core;
   }
   
   public void setChangedAndNotifyObservers() {
      setChanged();
      notifyObservers();
   }
}
