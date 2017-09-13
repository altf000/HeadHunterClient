package ru.hh.headhunterclient.data.exception;

/**
 * Created by neox on 12/9/17.
 */

public class TimeoutException extends Exception {

    public TimeoutException() {
    }

    public TimeoutException(String message) {
        super(message);
    }

    public TimeoutException(String message, Throwable cause) {
        super(message, cause);
    }

    public TimeoutException(Throwable cause) {
        super(cause);
    }
}
