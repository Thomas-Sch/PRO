/* ============================================================================
 * Nom du fichier   : CoreComponentException.java
 * ============================================================================
 * Date de création : 22 mai 2013
 * ============================================================================
 * Auteurs          : Biolzi Sébastien
 *                    Brito Carvalho Bruno
 *                    Decorvet Grégoire
 *                    Schweizer Thomas
 *                    Sinniger Marcel
 * ============================================================================
 */
package core.components;

/**
 * Les classes d'exceptions pour les objects du core
 * @author Biolzi Sébastien
 * @author Brito Carvalho Bruno
 * @author Decorvet Grégoire
 * @author Schweizer Thomas
 * @author Sinniger Marcel
 */
public class CoreComponentException extends Exception {

   private static final long serialVersionUID = 30000L;

   public CoreComponentException(String msgError) {
	     super("Core.Component : " +  msgError);
	   }
}

/**
 * Exeption lors d'un montant invalide
 */
class AmountUnavailable extends CoreComponentException {

   private static final long serialVersionUID = 30001L;
   public static final String msgError = "amount available on the account to make the debit";
   
   public AmountUnavailable() {
        super(msgError);
    }
}

/**
 * Exeption lorsque la limite de découverte est negative
 */
class LimitNegativeOverdraft extends CoreComponentException {
   private static final long serialVersionUID = 30002L;
   public static final String msgError = "the overdraft can not be a negative number";
   
   public LimitNegativeOverdraft() {
        super(msgError);
    }
}

/**
 * Exeption lorsque la limite du budget est negative
 */
class BudgetLimitNegative extends CoreComponentException {
   private static final long serialVersionUID = 30003L;
   public static final String msgError = "the overdraft can not be a negative number";
   
   public BudgetLimitNegative() {
        super(msgError);
    }
}

/**
 * Exeption d'une incoherence entre deux date d'un point vue temporelle
 */
class IncorrectDate extends CoreComponentException {
   private static final long serialVersionUID = 30004L;
   public static final String msgError = "Error between two dates: a start date can not " +
   		                                 "be before end date or end date can not be " +
   		                                 "before start date";
   
   public IncorrectDate() {
        super(msgError);
    }
}

