package com.hexure.firelight.libraies;

public class FLException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public FLException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public FLException(String message)
    {
        super(message);
    }

    public FLException(Throwable cause)
    {
        super(cause);
    }
}
