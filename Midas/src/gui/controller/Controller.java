/* ============================================================================
 * Nom du fichier   : Controller.java
 * ============================================================================
 * Date de création : 25 avr. 2013
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

import core.Core;

/**
 * Modèle pour tous les contrôleurs graphiques.
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 *
 */
public abstract class Controller {
   private Core core;
   
   /**
    * Crée un contrôleur.
    * @param core - le coeur du programme.
    */
   protected Controller(Core core) {
      this.core = core;
      
      initComponents();
      initListeners();
   }
   
   /**
    * Initialise les composants internes du contrôleurs. Cette fonction ne doit
    * pas être appelée, elle est gérée automatiquement par le constructeur.
    */
   protected abstract void initComponents();
   
   /**
    * Initialise les listeners du contrôleur. Cette fonction ne doit
    * pas être appelée, elle est gérée automatiquement par le constructeur.
    */
   protected abstract void initListeners();
   
   /**
    * Renvoie le coeur.
    * @return La partie logique de l'application.
    */
   public Core getCore() {
      return core;
   }
   
   /**
    * Retourne le composant graphique associé au contrôleur.
    * @return le composant graphique, null s'il n'y en a pas.
    */
   public abstract Component getGraphicalComponent();
}
