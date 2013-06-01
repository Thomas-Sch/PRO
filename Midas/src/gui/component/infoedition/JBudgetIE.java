/* ============================================================================
 * Nom du fichier   : JBudgetIE.java
 * ============================================================================
 * Date de création : 1 juin 2013
 * ============================================================================
 * Auteurs          : Biolzi Sébastien
 *                    Brito Carvalho Bruno
 *                    Decorvet Grégoire
 *                    Schweizer Thomas
 *                    Sinniger Marcel
 * ============================================================================
 */
package gui.component.infoedition;

import gui.JInfoEditionPane;
import gui.component.JInfoEditionLabel;
import gui.component.JMoneyInfoEditionLabel;
import gui.utils.TextChangedListener;

import java.awt.Container;
import java.awt.GridLayout;
import java.util.LinkedList;

import javax.swing.JDialog;
import javax.swing.event.DocumentEvent;

import settings.Language.Text;
import core.MidasLogs;
import core.components.Budget;
import core.exceptions.NegativeLimit;

/**
 * Composant permettant d'éditer ou afficher simplement des champs d'information
 * pour un budget.
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 *
 */
public class JBudgetIE extends JInfoEditionPane<Budget> {

   /**
    * ID de sérialisation.
    */
   private static final long serialVersionUID = -4003398565236786611L;
   
   // Composants graphiques.
   private JInfoEditionLabel ielName;
   private JInfoEditionLabel ielAccountName;
   private JMoneyInfoEditionLabel mielLimit;
   private JMoneyInfoEditionLabel mielAmount;
   private JInfoEditionLabel ielDescription;
   

   /**
    * @param parent Fenêtre contenant le label.
    * @param data Compte à afficher.
    */
   public JBudgetIE(JDialog parent, Container container, JBudgetIE last, Budget data) {
      this(parent, container, last, data, false);
   }
   
   /**
    * Rien à afficher.
    */
   public JBudgetIE() {
      super();
   }
   
   public JBudgetIE(JDialog parent, Container container, JBudgetIE last, Budget data, boolean edition) {
      super(parent, container, last, data, edition);
   }


   /* (non-Javadoc)
    * @see gui.JInfoEditionPane#initListeners()
    */
   @Override
   public void initListeners() {
      ielName.addTextChangedListener(new TextChangedListener() {
         
         @Override
         public void textChanged(DocumentEvent event) {
            data.setName(ielName.getText());
         }
      });
      
      mielLimit.addTextChangedListener(new TextChangedListener() {
         
         @Override
         public void textChanged(DocumentEvent event) {
            try {
               data.setLimit(Double.valueOf(mielLimit.getText()));
            }
            catch(NumberFormatException e) {
               MidasLogs.errors.push("Not a valid number ! : Parsing to double failed");
            }
            catch (NegativeLimit e) {
               MidasLogs.errors.push(e.getMessage());
            }
         }
      });
      
      ielDescription.addTextChangedListener(new TextChangedListener() {
         
         @Override
         public void textChanged(DocumentEvent event) {
            data.setDescription(ielDescription.getText());
         }
      });
   }
   
   /* (non-Javadoc)
    * @see gui.JInfoEditionPane#initContent(java.lang.Object)
    */
   @Override
   public LinkedList<JInfoEditionLabel> initContent(Budget data) {
      LinkedList<JInfoEditionLabel> result = new LinkedList<>();

      // Définition des champs.
      ielName = new JInfoEditionLabel(Text.BUDGET_NAME_LABEL, data.getName());
      ielAccountName = new JInfoEditionLabel(Text.BUDGET_BINDED_ACCOUNT_NAME_LABEL, data.getBindedAccount().getName());
      mielLimit = new JMoneyInfoEditionLabel(Text.BUDGET_LIMIT_LABEL, String.valueOf(data.getLimit()));
      mielAmount = new JMoneyInfoEditionLabel(Text.BUDGET_BALANCE_LABEL,"TEMP UNTIL FIX");
      ielDescription = new JInfoEditionLabel(Text.ACCOUNT_DESCRIPTION_LABEL, data.getDescription());
      
      // Ajout des champs à la liste.
      result.add(ielName);
      result.add(mielLimit);
      result.add(ielDescription);
      return result;
   }

   /* (non-Javadoc)
    * @see gui.JInfoEditionPane#buildContent()
    */
   @Override
   public void buildContent() {
      setLayout(new GridLayout(5, 5));
      add(ielName);
      add(ielAccountName);
      add(mielLimit);
      add(mielAmount);
      add(ielDescription);
   }
}
