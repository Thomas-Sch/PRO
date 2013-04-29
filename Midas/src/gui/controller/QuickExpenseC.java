/* ============================================================================
 * Nom du fichier   : QuickExpenseC.java
 * ============================================================================
 * Date de création : 29 avr. 2013
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
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.ContainerEvent;
import java.awt.event.ContainerListener;
import java.util.Observable;
import java.util.Observer;

import gui.component.QuickExpense;
import core.Core;
import core.MidasLogs;

/**
 * Controleur pour le panel d'ajout de dépenses rapides.
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 *
 */
public class QuickExpenseC extends Controller{
   
   QuickExpense quickExpense;
   
   /**
    * 
    */
   public QuickExpenseC(Core core) {
      super(core);
      quickExpense = new QuickExpense(this);
      initActionListeners();
   }

   /* (non-Javadoc)
    * @see gui.controller.Controller#initActionListeners()
    */
   @Override
   protected void initActionListeners() {
      quickExpense.getValidateButton().addActionListener(new ActionListener() {
         
         @Override
         public void actionPerformed(ActionEvent arg0) {
            MidasLogs.messages.push("Validation d'un dépense !");
         }
      });
   }
   
   
   public QuickExpense getJComponent() {
      return quickExpense;
   }
}
