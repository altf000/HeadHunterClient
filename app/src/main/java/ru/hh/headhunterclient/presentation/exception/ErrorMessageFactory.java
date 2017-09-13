package ru.hh.headhunterclient.presentation.exception;

import android.content.Context;

import ru.hh.headhunterclient.R;
import ru.hh.headhunterclient.data.exception.JsonParseException;
import ru.hh.headhunterclient.data.exception.NetworkConnectionException;
import ru.hh.headhunterclient.data.exception.NotFoundException;
import ru.hh.headhunterclient.data.exception.TimeoutException;

/**
 * Created by neox on 12/9/17.
 */

public class ErrorMessageFactory {

    public static String create(Context context, Throwable exception) {
        if (exception instanceof NetworkConnectionException) {
            return context.getString(R.string.no_connection_exception_error);
        } else if (exception instanceof JsonParseException) {
            return context.getString(R.string.json_parse_exception_error);
        } else if (exception instanceof TimeoutException) {
            return context.getString(R.string.timeout_error_exception_error);
        } else if (exception instanceof NotFoundException) {
            return context.getString(R.string.not_found_exception_error);
        }
        return context.getString(R.string.default_exception_error);
    }

}
