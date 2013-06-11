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
 * Définit un panneau avec l'ascenseur horizontal désactivé et le vertical
 * activé quand il y a besoin.
 * 
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
    * Crée le panneau avec un ascenseur vertical.
    * 
    * @param c
    *           - le composant auquel nous voulons ajouter l'ascenseur.
    */
   public JScrollPaneDefault(Component c) {
      super(c, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
            JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
   }

}
