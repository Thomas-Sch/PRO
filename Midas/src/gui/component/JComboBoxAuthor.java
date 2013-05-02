/* ============================================================================
 * Nom du fichier   : ComboBoxAuthor.java
 * ============================================================================
 * Date de création : 16 avr. 2013
 * ============================================================================
 * Auteurs          : Biolzi Sébastien
 *                    Brito Carvalho Bruno
 *                    Decorvet Grégoire
 *                    Schweizer Thomas
 *                    Sinniger Marcel
 * ============================================================================
 */
package gui.component;

import gui.controller.Controller;
import gui.testdata.AuthorData;

import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

/**
 * Représente les éléments graphiques compris pour la sélection d'un auteur.
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 * @param <E> Représentation des auteurs.
 *
 */
public class JComboBoxAuthor extends JComboBox<Object> {
   private static final long serialVersionUID = 1L;
   
   Controller controller;

   /**
    * Constructeur de la liste déroulante.
    */
   public JComboBoxAuthor(Controller controller) {
      this.controller = controller;
      
      ArrayList<String> al = new ArrayList<>();
      AuthorData ad = new AuthorData();
      
      al.add("Sélectionner un auteur");
      for (String s : ad.getList()) {
         al.add(s);
      }
      
      al.add("Nouvel auteur...");      
      setModel(new DefaultComboBoxModel<Object>(al.toArray()));
   }   
}
