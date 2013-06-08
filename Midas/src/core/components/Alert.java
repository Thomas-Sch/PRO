/* ============================================================================
 * Nom du fichier   : Alert.java
 * ============================================================================
 * Date de création : 8 juin 2013
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
import core.IdentifiedComponent;

import settings.Language.Text;

/**
 * Cette classe représente une transaction financière et met à disposition un
 * moyen d'obtenir certaines informations associées à ladite transaction.
 * 
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 * 
 */

public class Alert extends CoreComponent implements IdentifiedComponent {

   private Budget budget;

   /**
    * Crée une alerte.
    * 
    * @param core
    *           - coeur logique du programme.
    * 
    */
   public Alert(Core core, Budget budget) {
      super(core);
      this.budget = budget;
   }

   /**
    * Retourne le montant déficitaire.
    * 
    * @return Le montant déficitaire.
    */
   public double getDeficit() {
      return budget.getRemainingAmount();
   }

   /**
    * Affichage des transactions financières.
    */
   public String toString() {
      String result = "[" + budget.getName() + "] " + getDeficit()
            + Text.SWISS_FRANC_ACRONYM.toString();
      return result;
   }

   @Override
   public int getId() {
      // Une alerte par budget => l'id de l'alerte est la même que celle du
      // budget
      return budget.getId();
   }
}
