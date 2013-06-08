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

import core.Core;
import core.CoreComponent;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

/**
 * Modèle pour une liste d'éléments du coeur de l'application.
 * 
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 * @param <E>
 *           Type d'objet dans la liste.
 */
public abstract class ListTemplate<E> extends CoreComponent {

   private LinkedList<E> list = new LinkedList<>();

   /**
    * Constructeur.
    * 
    * @param core
    *           - le coeur logique de l'application.
    */
   public ListTemplate(Core core) {
      super(core);
   }

   /**
    * Ajout un élément à la liste.
    * 
    * @param item
    *           - l'élément ajouté.
    */
   public void addItem(E item) {
      list.add(item);
      setChangedAndNotifyObservers();
   }
   
   /**
    * Ajout un élément au début de la liste.
    * 
    * @param item
    *           - l'élément ajouté.
    */
   public void addFirst(E item) {
      list.addFirst(item);
      setChangedAndNotifyObservers();
   }
   
   /**
    * Ajoute l'élément donné, ou le met à jour s'il est déjà présent dans la
    * liste.
    * 
    * @param item
    *           - l'élément à ajouter.
    */
   public void addOrUpdate(E item) {
      int index = list.indexOf(item);

      if (index >= 0) {
         list.set(index, item);
      }
      else {
         list.add(item);
      }
   }
   
   /**
    * Enlève un élément de la liste.
    * 
    * @param item
    *           - l'élément que l'on veut enlever de la liste.
    */
   public void removeItem(E item) {
      list.remove(item);
      setChangedAndNotifyObservers();
   }   
   
   /**
    * Supprime le dernier item de la liste.
    */
   public void removeLast() {
      list.removeLast();
      setChangedAndNotifyObservers();
   }

   /**
    * Retourne l'élément situé à l'indice donné.
    * 
    * @param index
    *           - l'indice de l'élément voulu.
    * @return L'élément situé à l'indice donné.
    */
   public E getAt(int index) {
      return list.get(index);
   }

   /**
    * Renvoie une liste chaînée des données internes (sans tri).
    * 
    * @return La liste des éléments.
    */
   public LinkedList<E> getList() {
      return list;
   }

   /**
    * Retourne la totalité des enregistrements sous forme d'une liste triée
    * selon le comparateur donné.
    * 
    * @param comp
    *           - défini l'ordre des éléments rendus.
    * @return La liste triée des éléments.
    */
   public LinkedList<E> getAll(Comparator<E> comp) {

      LinkedList<E> result = new LinkedList<>();

      result.addAll(list);

      Collections.sort(result, comp);

      return result;
   }
   
   /**
    * Retourne le nombre d'éléments présents dans cette liste.
    * 
    * @return La taille de la liste.
    */
   public int size() {
      return list.size();
   }

   /**
    * Définit un nouveau contenu pour la liste, l'ancien sera effacé.
    * 
    * @param items
    *           - le nouveau contenu de la liste.
    */
   public void setItems(LinkedList<E> items) {
      list.clear();
      list.addAll(items);

      setChangedAndNotifyObservers();
   }

   /**
    * Test si l'élément donné est déjà présent dans la liste.
    * 
    * @param item
    *           - l'élément dont la présence doit être vérifiée.
    * @return True si la liste contient déjà cet item.
    */
   public boolean contains(E item) {
      return list.contains(item);
   }

   /**
    * Crée une fausse entrée dans la liste. Il s'agit des invites d'actions
    * relative à la liste.
    * 
    * @param name
    *           - le nom du message d'invite.
    * @return Un "faux" élément de type E.
    */
   public abstract E createFalseEntry(String name);

   /**
    * Retourne l'élément de la liste avec l'identifiant donné.
    * 
    * @param id
    *           - l'identifiant de l'élément.
    * @return L'élément correspondant à l'identifiant.
    */
   public abstract E get(int id);
}
