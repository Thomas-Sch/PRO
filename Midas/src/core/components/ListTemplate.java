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
    * Constructeur.
    * @param core Référence sur le coeur logique de l'application.
    */
   public ListTemplate(Core core) {
      super(core);
   }

   /**
    * Ajout un item à la liste.
    * @param item Item ajouté.
    */
   public void addItem(E item) {
      list.add(item);
      setChanged();
      notifyObservers();
   }
   
   /**
    * Enlève un item de la liste.
    * @param item Elément que l'on veut enlever de la liste.
    */
   public void removeItem(E item) {
      list.remove(item);
   }
   
   /**
    * Récupère l'élément situé à l'index index.
    * @param index emplacement de l'élément cherché.
    * @return l'élément situé à l'index index.
    */
   public E getAt(int index) {
      return list.get(index);
   }
   
   /**
    * Renvoie la linkedlist des données internes (sans tri).
    * @return
    */
   public LinkedList<E> getList() {
      return list;
   }
   
   /**
    * Récuère la totalité des enregistrements sous forme de linkedlist triée
    * @param comp défini l'ordre des éléments rendus.
    * @return La linkedlist de E.
    */
   public LinkedList<E> getAll(Comparator<E> comp) {
      
      LinkedList<E> result = new LinkedList<>();
      
      result.addAll(list);
      
      Collections.sort(result, comp);

      return result;
   }
   
   /**
    * Affecte un nouveau contenu à la liste.
    * @param items Nouveau contenu de la liste.
    */
   public void setItems(LinkedList<E> items) {
      list.clear();
      list.addAll(items);
      
      setChanged();
      notifyObservers();
   }
   
   /**
    * Regarde si nous avons déjà item dans la liste.
    * @param item L'item dont on veut savoir s'il est déjà ajouté à la liste.
    * @return True si la liste contient déjà cet item.
    */
   public boolean contains(E item) {
      return list.contains(item);
   }
   
   /**
    * Crée une fausse entrée dans la liste. Il s'agit des invites d'actions
    * relative à la liste.
    * @param name Nom du message d'invite.
    * @return Un "faux" élement de type E.
    */
   public abstract E createFalseEntry(String name);
   
   /**
    * Retourne l'élément de la liste avec l'id id.
    * @param id identifiant de l'élément.
    * @return l'élément avec l'identifiant id.
    */
   public abstract E get(int id);
}
