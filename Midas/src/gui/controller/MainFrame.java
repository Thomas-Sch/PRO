<<<<<<< HEAD
/* ============================================================================
 * Nom du fichier   : MainFrameC.java
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

import gui.Controller;
import gui.utils.Positions;
import gui.views.JMainFrame;

import java.awt.Component;

import javax.swing.JFrame;

import settings.Language.Text;
import settings.Settings;
import core.Core;

/**
 * Contrôleur du contenu de la fenêtre principale.
 * 
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 * 
 */
public class MainFrame extends Controller {

   JMainFrame mainFrame;

   /**
    * Crée le contrôleur du contenu de la fenêtre principale.
    * 
    * @param core - le coeur logique du programme.
    */
   public MainFrame(Core core) {
      super(core);
   }

   @Override
   protected void initComponents() {
      mainFrame = new JMainFrame(this, Text.APP_TITLE.toString());
      mainFrame.setSize(Settings.mainFrame.width, Settings.mainFrame.height);
      Positions.setPositionOnScreen(mainFrame, Settings.mainFrame.anchor);
      mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      mainFrame.setVisible(true);
   }

   @Override
   protected void initListeners() {
      // Nous n'écoutons rien sur cette fenêtre.
   }

   @Override
   public Component getGraphicalComponent() {
      return null;
   }
}
=======
/* ============================================================================
 * Nom du fichier   : MainFrameC.java
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

import gui.Controller;
import gui.utils.Positions;
import gui.views.JMainFrame;

import java.awt.Component;

import javax.swing.JFrame;

import settings.Language.Text;
import settings.Settings;
import core.Core;

/**
 * Contrôleur du contenu de la fenêtre principale.
 * 
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 * 
 */
public class MainFrame extends Controller {

   JMainFrame mainFrame;

   /**
    * Crée le contrôleur du contenu de la fenêtre principale.
    * 
    * @param core - le coeur logique du programme.
    */
   public MainFrame(Core core) {
      super(core);
   }

   @Override
   protected void initComponents() {
      mainFrame = new JMainFrame(this, Text.APP_TITLE.toString());
      mainFrame.setSize(Settings.mainFrame.width, Settings.mainFrame.height);
      Positions.setPositionOnScreen(mainFrame, Settings.mainFrame.anchor);
      mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      mainFrame.setVisible(true);
   }

   @Override
   protected void initListeners() {
      // Nous n'écoutons rien sur cette fenêtre.
   }

   @Override
   public Component getGraphicalComponent() {
      return null;
   }
}
>>>>>>> branch 'master' of https://github.com/Thomas-Sch/PRO.git
