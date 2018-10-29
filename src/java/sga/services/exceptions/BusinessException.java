package sga.services.exceptions;

/**
 *
 * @author bleid
 */
public class BusinessException extends RuntimeException {
    
    public BusinessException (String mensaje, Exception e) {
        
        super(mensaje, e);
    }
}
