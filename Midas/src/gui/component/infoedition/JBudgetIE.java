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
import gui.JManageFrame;
import gui.component.JInfoEditionLabel;
import gui.component.JMoneyInfoEditionLabel;
import gui.utils.TextChangedListener;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.util.LinkedList;

import javax.swing.event.DocumentEvent;

import settings.Language.Text;
import core.MidasLogs;
import core.components.Budget;
import core.exceptions.NegativeLimitException;

/**
 * Composant permettant d'éditer ou afficher simplement des champs
 * d'informations pour un budget.
 * 
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
   private JInfoEditionLabel ielIsOK;
   private JMoneyInfoEditionLabel mielAmountLeft;
   private JInfoEditionLabel ielDescription;

   /**
    * Crée un panneau pour l'affichage des informations d'un budget.
    * 
    * @param parent
    *           - la fenêtre parente.
    * @param container
    *           - le conteneur de ce panneau.
    * @param last
    *           - le précédent panneau.
    * @param data
    *           - le budget à afficher.
    */
   public JBudgetIE(JManageFrame parent, Container container, JBudgetIE last,
         Budget data) {
      this(parent, container, last, data, false);
   }

   /**
    * Crée un panneau s'il n'y a rien à afficher.
    */
   public JBudgetIE() {
      super();
   }

   /**
    * Crée un panneau pour l'affichage des informations d'un budget.
    * 
    * @param parent
    *           - la fenêtre parente.
    * @param container
    *           - le conteneur de ce panneau.
    * @param last
    *           - le précédent panneau.
    * @param data
    *           - le budget à afficher.
    * @param edition
    *           - si les informations sont éditables ou non.
    */
   public JBudgetIE(JManageFrame parent, Container container, JBudgetIE last,
         Budget data, boolean edition) {
      super(parent, container, last, data, edition);
   }

   @Override
   public void initListeners() {
      ielName.addTextChangedListener(new TextChangedListener() {

         @Override
         public void textChanged(DocumentEvent event) {
            checkItemIntegrity();
         }
      });

      mielLimit.addTextChangedListener(new TextChangedListener() {

         @Override
         public void textChanged(DocumentEvent event) {
            try {
               Double.valueOf(mielLimit.getText());
               mielLimit.setValid();
            }
            catch (NumberFormatException e) {
               MidasLogs.errors
                     .push("Not a valid number ! : Parsing to double failed");
               mielLimit.setInvalid();
            }
            checkItemIntegrity();
         }
      });
   }

   @Override
   public LinkedList<JInfoEditionLabel> initContent(Budget data) {
      LinkedList<JInfoEditionLabel> result = new LinkedList<>();

      // Définition des champs.
      ielName = new JInfoEditionLabel(Text.BUDGET_NAME_LABEL, data.getName());
      ielAccountName = new JInfoEditionLabel(
            Text.BUDGET_BINDED_ACCOUNT_NAME_LABEL, data.getBindedAccount()
                  .getName());
      mielLimit = new JMoneyInfoEditionLabel(Text.BUDGET_LIMIT_LABEL,
            String.valueOf(data.getLimit()));
      mielAmount = new JMoneyInfoEditionLabel(Text.BUDGET_BALANCE_LABEL,
            String.valueOf(data.getTotalOutgoings()));
      ielIsOK = new JInfoEditionLabel(Text.BUDGET_IS_OK_LABEL,
            (data.isPositive() ? Text.BUDGET_POSITIVE_LABEL.toString()
                  : Text.BUDGET_NEGATIVE_LABEL.toString()));
      mielAmountLeft = new JMoneyInfoEditionLabel(Text.BUDGET_AMOUNT_LEFT,
            String.valueOf(data.getRemainingAmount()));
      ielDescription = new JInfoEditionLabel(Text.ACCOUNT_DESCRIPTION_LABEL,
            data.getDescription());

      // Si le budget n'est pas tenu, on doit modifier l'affichage de
      // certains champs.
      if (!data.isPositive()) {
         ielIsOK.setColor(Color.RED);
         mielAmount.setColor(Color.RED);
         mielAmountLeft.setText("0"); // Il peut encore dépenser 0.-
      }

      // Ajout des champs à la liste.
      result.add(ielName);
      result.add(mielLimit);
      result.add(ielDescription);
      return result;
   }

   @Override
   public void buildContent() {
      setLayout(new GridLayout(7, 1));
      add(ielName);
      add(ielAccountName);
      add(mielLimit);
      add(mielAmount);
      add(ielIsOK);
      add(mielAmountLeft);
      add(ielDescription);
   }

   /**
    * Vérifie que l'objet complété par l'utilisateur est sauvegardable dans la
    * base de donnée.
    */
   private void checkItemIntegrity() {
      boolean checkResult;
      checkResult = ielName.isValidData() && mielLimit.isNumber()
            && mielLimit.isPositive();
      setEnabledValidateButton(checkResult);
   }

   @Override
   public void saveItem() {
      try {
         data.setLimit(Double.valueOf(mielLimit.getText()));
         mielLimit.setValid();
      }
      catch (NegativeLimitException e) {
         MidasLogs.errors.push(e.getMessage());
         mielLimit.setInvalid();
      }
      data.setName(ielName.getText());
      data.setDescription(ielDescription.getText());
   }
}
