package ru.hh.headhunterclient.data.exception;

/**
 * Created by neox on 23.09.17.
 */

public class NoDataException extends Exception {

    public NoDataException() {
    }

    public NoDataException(String message) {
        super(message);
    }

    public NoDataException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoDataException(Throwable cause) {
        super(cause);
    }
}
