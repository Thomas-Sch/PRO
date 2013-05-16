/* ============================================================================
 * Nom du fichier   : IdentifiedComponent.java
 * ============================================================================
 * Date de création : 16 mai 2013
 * ============================================================================
 * Auteurs          : Biolzi Sébastien
 *                    Brito Carvalho Bruno
 *                    Decorvet Grégoire
 *                    Schweizer Thomas
 *                    Sinniger Marcel
 * ============================================================================
 */
package core;

/**
 * Indique que la classe possède un identifiant de type int récupérable.
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 *
 */
public interface IdentifiedComponent {
   
   /**
    * Retourne l'identifiant unique et de valeur entière de l'objet.
    * @return l'identifiant unique entier.
    */
   public int getId();

}
