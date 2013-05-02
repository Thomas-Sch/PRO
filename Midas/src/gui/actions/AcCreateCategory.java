/* ============================================================================
 * Nom du fichier   : AcCreateAccount.java
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
package gui.actions;

import java.awt.event.ActionEvent;

import settings.Language.Text;

import core.components.Category;
import core.Core;
import gui.UserAction;
import gui.views.CategoryView;

/**
 * Exemple d'action utilisateur => A supprimer dans un futur proche.
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 *
 */
public class AcCreateCategory extends UserAction {
   
   /**
    * Instancie l'action souhaitée.
    * @param core - le coeur pouvant être utilisé pour réaliser l'action.
    */
   public AcCreateCategory(Core core) {
      super(core);
   }
   
   
   public void execute(Core core, ActionEvent event, Object[] dependencies) {
      
      // Récupération du modèle
      Category modele = core.createCategory();
      
      // Vue
      CategoryView createCategoryView = new CategoryView(Text.ACCOUNT_NAME_LABEL.toString(), 20, 20, 150, 200, modele);
      
      // Enregistrer la vue et le modèle
      modele.addObserver(createCategoryView);
      
      modele.setChangedAndNotifyObservers(); // Force l'actualisation au lancement
      
      createCategoryView.setVisible(true);
   }

}
