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
package data;

import java.util.LinkedList;

/**
 * Contient les données de test pour les auteurs.
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 *
 */
public class AuthorData {
   LinkedList<String> data = new LinkedList<>();
   
   /**
    * Crée un modèle de donnée de test.
    */
   public AuthorData() {
      String[] ss = new String[] {"Thomas", "Dieu", "Jo", "Platon"};
      
      for(String s : ss) {
         data.add(s);
      }
   }
   
   public LinkedList<String> getAuthors() {
      return data;
   }
}
