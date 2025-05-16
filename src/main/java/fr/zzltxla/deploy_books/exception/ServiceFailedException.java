package fr.zzltxla.deploy_books.exception;

/**
 * 
 * @author zzltxla
 *
 */
public class ServiceFailedException extends RuntimeException {

    /**
     * 
     */
    private static final long serialVersionUID = -374517481885007946L;

    /**
     * Construit une nouvelle instance de la classe.
     *
     */
    public ServiceFailedException() {
        super();
    }

    public ServiceFailedException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
        super(arg0, arg1, arg2, arg3);
    }

    /**
     * Construit une nouvelle instance de la classe.
     *
     * @param message
     *            la description de l'erreur rencontrée.
     * @param cause
     *            la cause de l'erreur rencontrée.
     *
     */
    public ServiceFailedException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Construit une nouvelle instance de la classe.
     *
     * @param message
     *            la description de l'erreur rencontrée.
     *
     */
    public ServiceFailedException(String message) {
        super(message);
    }

    /**
     * Construit une nouvelle instance de la classe.
     *
     * @param cause
     *            la cause de l'erreur rencontrée.
     *
     */
    public ServiceFailedException(Throwable cause) {
        super(cause);
    }

}
