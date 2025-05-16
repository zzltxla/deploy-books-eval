package fr.zzltxla.deploy_books.exception;

/**
 * 
 * @author Jack Daniel's
 *
 */
public class ServiceForbiddenException extends RuntimeException {
    public ServiceForbiddenException() {
        super();
    }

    public ServiceForbiddenException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
        super(arg0, arg1, arg2, arg3);
    }

    public ServiceForbiddenException(String arg0, Throwable arg1) {
        super(arg0, arg1);
    }

    public ServiceForbiddenException(String arg0) {
        super(arg0);
    }

    public ServiceForbiddenException(Throwable arg0) {
        super(arg0);
    }

    private static final long serialVersionUID = 1L;

}
