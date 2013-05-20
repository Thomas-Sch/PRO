/* ============================================================================
 * Nom du fichier   : ListTemplate.java
 * ============================================================================
 * Date de création : 13 mai 2013
 * ============================================================================
 * Auteurs          : Biolzi Sébastien
 *                    Brito Carvalho Bruno
 *                    Decorvet Grégoire
 *                    Schweizer Thomas
 *                    Sinniger Marcel
 * ============================================================================
 */
package core.components;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

import core.Core;
import core.CoreComponent;

/**
 * Modèle pour une liste d'éléments du coeur de l'application.
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 * @param <E> Type d'objet dans la liste.
 */
public abstract class ListTemplate<E> extends CoreComponent {
   
   private LinkedList<E> list = new LinkedList<>();

   /**
    * @param core Référence sur le coeur logique de l'application.
    */
   public ListTemplate(Core core) {
      super(core);
   }

   public void addItem(E item) {
      list.add(item);
      setChanged();
      notifyObservers();
   }
   
   public void removeItem(E item) {
      list.remove(item);
   }
   
   public E getAt(int index) {
      return list.get(index);
   }
   
   public LinkedList<E> getList() {
      return list;
   }
   public LinkedList<E> getAll(Comparator<E> comp) {
      
      LinkedList<E> result = new LinkedList<>();
      
      result.addAll(list);
      
      Collections.sort(result, comp);

      return result;
   }
   
   public void setItems(LinkedList<E> items) {
      list.clear();
      list.addAll(items);
      
      setChanged();
      notifyObservers();
   }
   
// public Account get(int userId) {
// for(Account account : accounts) {
//    if (account.getId() == userId) {
//       return account;
//    }
// }
// return null;
//}
   
   public abstract E createFalseEntry(String name);
   
   public abstract E get(int id);
}
