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

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.ContainerEvent;
import java.awt.event.ContainerListener;
import java.util.Observable;
import java.util.Observer;

import gui.component.JQuickExpense;
import gui.menu.JMainMenu;
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
public class QuickExpense extends Controller{
   
   JQuickExpense quickExpense;
   
   /**
    * 
    */
   public QuickExpense(Core core) {
      super(core);
      
   }
   
   @Override
   protected void initComponents() {
      quickExpense = new JQuickExpense(this);
   }
   
   @Override
   protected void initListeners() {
      quickExpense.getValidateButton().addActionListener(new ActionListener() {
         
         @Override
         public void actionPerformed(ActionEvent arg0) {
            MidasLogs.messages.push("Validation d'un dépense !");
         }
      });
   }
   
   
   public JQuickExpense getJComponent() {
      return quickExpense;
   }

   @Override
   public Component getGraphicalComponent() {
      return null;
   }
}
