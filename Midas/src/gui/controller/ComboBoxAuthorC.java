/* ============================================================================
 * Nom du fichier   : ComboBoxAuthorC.java
 * ============================================================================
 * Date de création : 28 avr. 2013
 * ============================================================================
 * Auteurs          : Biolzi Sébastien
 *                    Brito Carvalho Bruno
 *                    Decorvet Grégoire
 *                    Schweizer Thomas
 *                    Sinniger Marcel
 * ============================================================================
 */
package gui.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gui.NewAuthorFrame;
import gui.component.ComboBoxAuthor;
import core.Core;
import core.MidasLogs;

/**
 * Contrôleur de la liste déroulante d'auteurs.
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 *
 */
public class ComboBoxAuthorC extends Controller {
   
   ComboBoxAuthor authors = new ComboBoxAuthor(this);
   /**
    * 
    */
   public ComboBoxAuthorC(Core core) {
      super(core);
      initActionListeners();
   }

   /* (non-Javadoc)
    * @see gui.controller.Controller#initActionListeners()
    */
   @Override
   protected void initActionListeners() {
      authors.addActionListener(new ActionListener() {
         
         @Override
         public void actionPerformed(ActionEvent e) {
            if(authors.getSelectedIndex() == authors.getItemCount() - 1) {
               MidasLogs.messages.push("J'envoie un nouvel auteur !");
               new NewAuthorFrame(authors);
            }
            else if ( authors.getSelectedIndex() == 0) {
               MidasLogs.messages.push("Aucun auteur seléctionné !");
            }
            else {
               MidasLogs.messages.push("Auteur seléctionné.");
            }
         }
      });
   }
   
   public ComboBoxAuthor getGraphicalComponent() {
      return authors;
   }

}
