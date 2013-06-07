/* ============================================================================
 * Nom du fichier   : JScrollPaneDefault.java
 * ============================================================================
 * Date de création : 7 juin 2013
 * ============================================================================
 * Auteurs          : Biolzi Sébastien
 *                    Brito Carvalho Bruno
 *                    Decorvet Grégoire
 *                    Schweizer Thomas
 *                    Sinniger Marcel
 * ============================================================================
 */
package gui.component;

import java.awt.Component;

import javax.swing.JScrollPane;

/**
 * Instancie un JScrollPane avec la barre horizontale désactivée et la barre
 * verticale active quand il y a besoin.
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 *
 */
public class JScrollPaneDefault extends JScrollPane {

   /**
    * ID de sérialisation.
    */
   private static final long serialVersionUID = -6851397457717041586L;
   
   /**
    * Ajoute une scroll barre verticale au composant.
    * @param c Le composant auqul nous voulons ajouter la scoll barre.
    */
   public JScrollPaneDefault(Component c) {
      super(c, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
   }

}
