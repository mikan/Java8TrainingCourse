/*
 * Copyright (c) 2015. Yutaka Kato. All rights reserved.
 * https://github.com/mikan/Java8TrainingCourse
 */

package local.js8ri.ch03.ex01;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.MissingResourceException;
import java.util.Objects;
import java.util.function.BooleanSupplier;
import java.util.function.Supplier;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author mikan
 */
public class MyLogger extends Logger {

    /**
     * Construct my logger with {@link Level#ALL}.
     *
     * @param name               A name for the logger
     * @param resourceBundleName name of ResourceBundle to be used for localizing messages for this logger
     * @throws MissingResourceException if the resourceBundleName is non-null and no corresponding resource can be found.
     */
    public MyLogger(@Nullable String name, @Nullable String resourceBundleName) {
        super(name, resourceBundleName);
        setParent(Logger.getLogger(name, resourceBundleName));
        setUseParentHandlers(true);
        setLevel(Level.ALL);
    }

    /**
     * Log a message, which is only to be constructed if the logging level is such that the message will actually be
     * logged.
     *
     * @param level       One of the message level identifiers, e.g., SEVERE
     * @param condition   Log condition when logger is loggable
     * @param msgSupplier A function, which when called, produces the desired log message
     * @return logged
     * @throws NullPointerException if the supplier is null
     */
    public boolean logIf(@Nonnull Level level, @Nonnull BooleanSupplier condition, @Nonnull Supplier<String> msgSupplier) {
        Objects.requireNonNull(condition);
        if (isLoggable(level) && condition.getAsBoolean()) {
            log(level, msgSupplier);
            return true;
        }
        return false;
    }
}
