package ru.hh.headhunterclient.data.exception;

import com.google.gson.JsonSyntaxException;

import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

/**
 * Created by neox on 12/9/17.
 */

public class ExceptionFactory {

    public static Throwable getException(Throwable exception) {
        if (exception instanceof JsonSyntaxException) {
            return new JsonParseException(exception);
        } else if (exception instanceof UnknownHostException || exception instanceof ConnectException) {
            return new NetworkConnectionException(exception);
        } else if (exception instanceof SocketTimeoutException) {
            return new TimeoutException(exception);
        }
        return exception;
    }

}
