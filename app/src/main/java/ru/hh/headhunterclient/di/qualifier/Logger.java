package ru.hh.headhunterclient.di.qualifier;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;

/**
 * Created by neox on 12/9/17.
 */

@Retention(RetentionPolicy.RUNTIME)
@Qualifier
public @interface Logger {
}
