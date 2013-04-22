/* ============================================================================
 * Nom du fichier   : AuthorExempleData.java
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
package gui.data;


/**
 * Contient les données de test pour les auteurs.
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 *
 */
public class AuthorData extends Data<String>{
   
   /**
    * Crée un modèle de donnée de test.
    */
   public AuthorData() {
      addItem("Thomas");
      addItem("Dieu");
      addItem("Jo");
      addItem("Platon");
      addItem("Bob l'éponge");
   }
}
