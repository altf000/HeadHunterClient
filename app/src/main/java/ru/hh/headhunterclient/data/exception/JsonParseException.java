package ru.hh.headhunterclient.data.exception;

/**
 * Created by neox on 12/9/17.
 */

public class JsonParseException extends Exception {

    public JsonParseException() {
    }

    public JsonParseException(String message) {
        super(message);
    }

    public JsonParseException(String message, Throwable cause) {
        super(message, cause);
    }

    public JsonParseException(Throwable cause) {
        super(cause);
    }
}
