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
package gui;

import core.Core;

import java.awt.Component;

/**
 * Modèle pour tous les contrôleurs graphiques.
 * 
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
    * 
    * @param core
    *           - le coeur du programme.
    */
   protected Controller(Core core) {
      this.core = core;
      initComponents();
      initListeners();
   }

   /**
    * Initialise les composants internes du contrôleur.
    * <p>
    * Cette fonction <u>ne doit pas être appelée</u>, elle est gérée
    * automatiquement par le constructeur.
    */
   protected abstract void initComponents();

   /**
    * Initialise les listeners du contrôleur.
    * <p>
    * Cette fonction <u>ne doit pas être appelée</u>, elle est gérée
    * automatiquement par le constructeur.
    */
   protected abstract void initListeners();

   /**
    * Retourne le coeur de l'application.
    * 
    * @return La partie logique de l'application.
    */
   public Core getCore() {
      return core;
   }

   /**
    * Retourne le composant graphique associé au contrôleur.
    * 
    * @return Le composant graphique, null s'il n'y en a pas.
    */
   public abstract Component getGraphicalComponent();
}
