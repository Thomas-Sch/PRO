/* ============================================================================
 * Nom du fichier   : HasXMLName.java
 * ============================================================================
 * Date de création : 18 avr. 2013
 * ============================================================================
 * Auteurs          : Biolzi Sébastien
 *                    Brito Carvalho Bruno
 *                    Decorvet Grégoire
 *                    Schweizer Thomas
 *                    Sinniger Marcel
 * ============================================================================
 */
package utils.xml;

/**
 * Indique la présence d'un nom utilisable pour les fichiers xml.
 * 
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 * 
 */
public interface HasXMLName {

   /**
    * Retourne le nom à utiliser comme noeud xml.
    * 
    * @return Le nom xml de l'objet.
    */
   public String getXMLName();

}
