/* ============================================================================
 * Nom du fichier   : Data.java
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
package gui.testdata;

import java.util.LinkedList;

/**
 * Classe temporaire pour stocker des données de test.
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 *
 */
public abstract class Data<E> {
   
   private LinkedList<E> data = new LinkedList<>();
   
   public void addItem(E e) {
      data.add(e);
   }
   
   public LinkedList<E> getList() {
      return data;
   }
   
   public E[] getTab() {
      @SuppressWarnings("unchecked")
      E[] es = (E[]) data.toArray();
      return es;
   }
   
}
