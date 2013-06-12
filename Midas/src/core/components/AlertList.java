/* ============================================================================
 * Nom du fichier   : AlertList.java
 * ============================================================================
 * Date de création : 7 juin 2013
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

/**
 * Représente une liste d'alertes.
 * 
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 *
 */
public class AlertList extends ListTemplate<Alert> {

   /**
    * Crée une liste d'alertes, notifiant ses observateurs lorsqu'elle est mise
    * à jour.
    * 
    * @param core
    *           - le coeur logique du programme.
    */
   public AlertList(Core core) {
      super(core);
   }

   @Override
   public Alert createFalseEntry(String name) {
      return null;
   }

   @Override
   public Alert get(int id) {
      for (Alert alert : getList()) {
         if (alert.getId() == id) {
            return alert;
         }
      }
      return null;
   }
}