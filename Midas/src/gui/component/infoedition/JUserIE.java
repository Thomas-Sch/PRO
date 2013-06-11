/* ============================================================================
 * Nom du fichier   : JUserIE.java
 * ============================================================================
 * Date de création : 25 mai 2013
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
import gui.utils.TextChangedListener;

import java.awt.Container;
import java.awt.GridLayout;
import java.util.LinkedList;

import javax.swing.event.DocumentEvent;

import settings.Language.Text;
import core.components.User;

/**
 * Panneau représentant les informations d'un utilisateur.
 * 
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 * 
 */
public class JUserIE extends JInfoEditionPane<User> {

   /**
    * ID de sérialisation.
    */
   private static final long serialVersionUID = 7787382732040268350L;

   private JInfoEditionLabel ielName;

   /**
    * Crée un panneau pour l'affichage des informations d'un utilisateur.
    * 
    * @param parent
    *           - la fenêtre parente.
    * @param container
    *           - le conteneur de ce panneau.
    * @param last
    *           - le précédent panneau.
    * @param data
    *           - le compte à afficher.
    */
   public JUserIE(JManageFrame parent, Container container, JUserIE last,
         User data) {
      this(parent, container, last, data, false);
   }

   /**
    * Crée un panneau lors qu'il n'y a rien à afficher.
    */
   public JUserIE() {
      super();
   }

   /**
    * Crée un panneau pour l'affichage des informations d'un utilisateur.
    * 
    * @param parent
    *           - la fenêtre parente.
    * @param container
    *           - le conteneur de ce panneau.
    * @param last
    *           - le précédent panneau.
    * @param data
    *           - le compte à afficher.
    * @param edition
    *           - si les informations sont éditables ou non.
    */
   public JUserIE(JManageFrame parent, Container container, JUserIE last,
         User data, boolean edition) {
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
   }

   @Override
   public void buildContent() {
      setLayout(new GridLayout(1, 5));
      add(ielName);
   }

   @Override
   public LinkedList<JInfoEditionLabel> initContent(User data) {
      LinkedList<JInfoEditionLabel> result = new LinkedList<>();

      // Définition des champs.
      ielName = new JInfoEditionLabel(Text.USER_NAME_LABEL, data.getName());

      // Ajout du champs à la liste.
      result.add(ielName);
      return result;
   }
   
   @Override
   public void saveItem() {
      data.setName(ielName.getText());
   }

   /**
    * Vérifie que l'objet complété par l'utilisateur peut être sauvegardé dans
    * la base de données.
    */
   private void checkItemIntegrity() {
      boolean checkResult;
      checkResult = ielName.isValidData();
      setEnabledValidateButton(checkResult);
   }

   

}
