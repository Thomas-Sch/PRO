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
import gui.component.JInfoEditionLabel;
import gui.utils.TextChangedListener;

import java.awt.Container;
import java.awt.GridLayout;
import java.util.LinkedList;

import javax.swing.JDialog;
import javax.swing.event.DocumentEvent;

import settings.Language.Text;
import core.components.User;

/**
 * Représente les informations d'un utilisateur.
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
    * @param parent Fenêtre contenant le label.
    * @param data Compte à afficher.
    */
   public JUserIE(JDialog parent, Container container, JUserIE last, User data) {
      this(parent, container, last, data, false);
   }
   
   /**
    * Rien à afficher.
    */
   public JUserIE() {
      super();
   }
   
   public JUserIE(JDialog parent, Container container, JUserIE last, User data, boolean edition) {
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
   }

   /* (non-Javadoc)
    * @see gui.JInfoEditionPane#buildContent()
    */
   @Override
   public void buildContent() {
      setLayout(new GridLayout(1, 5));
      add(ielName);
   }

   /* (non-Javadoc)
    * @see gui.JInfoEditionPane#initContent(java.lang.Object)
    */
   @Override
   public LinkedList<JInfoEditionLabel> initContent(User data) {
      LinkedList<JInfoEditionLabel> result = new LinkedList<>();
      
      // Définition des champs.
      ielName = new JInfoEditionLabel(Text.USER_NAME_LABEL, data.getName());

      // Ajout du champs à la liste.
      result.add(ielName);
      return result;
   }

}
