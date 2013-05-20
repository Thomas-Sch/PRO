/* ============================================================================
 * Nom du fichier   : Cache.java
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
package core.cache;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.lang.ref.SoftReference;
import core.IdentifiedComponent;

/**
 * Classe permettant la gestion d'un cache de références sur les objets du coeur
 * actuellement disponibles
 * 
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 * 
 */
public class Cache {
   
   /*
    * Usage d'une HashMap pour plusieurs raisons :
    *  - Une fois la référence insérée il faudrait beaucoup d'objets en mémoire
    *    pour qu'elle soit libérée par le ramasse-miettes. Ou encore vraiment
    *    peu de mémoire sur sa machine. La HashMap a un coût d'insertion,
    *    mais un coût faible en lecture qui sera sa principale activité.
    *  - Les identifiants étant uniques, il n'y aura pas de collision pour
    *    une même valeur, supprimant ainsi un problème des HashMap.
    *    
    *  - Si les insertion / suppression devaient venir nombreuses, l'usage
    *  d'arbre AVL serait préconisé.
    */

   private HashMap<Class<? extends IdentifiedComponent>,
                   HashMap<Integer,
                           SoftReference<? extends IdentifiedComponent>>> cache =
                                                               new HashMap<>();

   /**
    * Instancie un cache pour les objets du coeur.
    */
   public Cache() {

   }
   
   /**
    * Insère le composant identifiable dans le cache.
    * @param component - le composant à conserver dans le cache.
    */
   public <T extends IdentifiedComponent> void putToCache(T component) {
      HashMap<Integer, SoftReference<? extends IdentifiedComponent>> map = 
         cache.get(component.getClass());

      // Création de la table au besoin
      if (map == null) {
         map = new HashMap<>();
         cache.put(component.getClass(), map);
      }
      
      SoftReference<? extends IdentifiedComponent> reference =
         map.get(component.getId());

      // Création de la référence au besoin ou rafraîchissement de la référence 
      // si elle a été perdue.
      if (reference == null || reference.get() == null) {
         map.put(component.getId(), new SoftReference<>(component));
      }
      
   }
   
   /**
    * Retourne le composant identifiable de la classe donnée correspondant à
    * l'idenfiant passé en argument.
    * @param type - la classe du composant souhaité.
    * @param id - l'identifiant du composant souhaité.
    * @return le composant correspondant à la classe et à l'identifiant donné,
    * null s'il n'est pas présent dans le cache.
    */
   @SuppressWarnings("unchecked")
   public <T extends IdentifiedComponent> T getReference(Class<T> type, int id) {
      T ref = null;
      
      // Récupère la bonne table
      HashMap<Integer, SoftReference<? extends IdentifiedComponent>> map =
         cache.get(type);
      
      if (map != null) {
         // Récupère la référence voulue
         SoftReference<? extends IdentifiedComponent> softRef = map.get(id);
         
         if (softRef != null) {
            ref = (T)softRef.get();
            
            // Référence perdue => retirée du cache
            if (ref == null) {
               map.remove(id);
            }
         }
      }
      
      return ref;
   }
   
   /**
    * Retourne les composants identifiables de la classe donnée présents dans
    * le cache.
    * @param type - le type des composants voulus.
    * @return la liste des composants du type donné présents dans le cache.
    */
   public <T extends IdentifiedComponent> LinkedList<T> getAll(Class<T> type) {
      LinkedList<T> result = new LinkedList<>();
      
      // Récupère la bonne table
      HashMap<Integer, SoftReference<? extends IdentifiedComponent>> map =
                                                               cache.get(type);
      
      // Récupère toute les valeurs de la table
      Collection<SoftReference<? extends IdentifiedComponent>> values =
                                                                  map.values();
      
      // Ajoute les références encore existantes
      T ref;
      for (SoftReference<? extends IdentifiedComponent> softRef : values) {
         ref = (T)softRef.get();
         
         if (ref != null) {
            result.add(ref);
         }
      }
      
      return result;
   }

}
