package com.kevin.framework.error;

/**
 * Created by spirit on 2015/10/8.
 */
public class ApiException extends RuntimeException {

    private static final long serialVersionUID = 1824171233603511793L;

    /**
     * ´íÎóÂë
     */
    private int errorCode = ApiErrorCodes.UNKNOWN.getValue();

    public ApiException() {
        super();
    }

    public ApiException(String message) {
        super(message);
    }

    public ApiException(Throwable cause) {
        super(cause);

        setCause(cause);
    }

    private void setCause(Throwable cause) {
        if(cause instanceof ApiException) {
            this.errorCode = ((ApiException) cause).getErrorCode();
        }
    }

    public ApiException(String message, Throwable cause) {
        super(message, cause);

        setCause(cause);
    }

    public ApiException(int errorCode, String message, Throwable cause) {
        super(message, cause);

        this.errorCode = errorCode;
    }

    public ApiException(int errorCode, String message) {

        super(message);

        this.errorCode = errorCode;
    }

    public ApiException(ApiErrorCodes error, String message) {
        this(error.getValue(), message);
    }

    public ApiException(ApiErrorCodes error, String message, Throwable cause) {
        this(error.getValue(), message, cause);
    }

    /**
     * ´íÎóÂë.
     */
    public int getErrorCode() {
        return errorCode;
    }

}