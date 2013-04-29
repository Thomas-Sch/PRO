/* ============================================================================
 * Nom du fichier   : DisplayableTest.java
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
package core;

import java.util.Observable;

/**
 * ATTENTION : ne portera plus le même nom, mais aura la même fonction dès
 * l'update des objets du coeur.
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 *
 */
abstract public class DisplayableComponent extends Observable {
   
   public DisplayableComponent() {
      
   }
   
   public void setChangedAndNotifyObservers() {
      setChanged();
      notifyObservers();
   }
   

}
