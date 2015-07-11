/*
 * Copyright (c) 2015. Yutaka Kato. All rights reserved.
 * https://github.com/mikan/Java8TrainingCourse
 */

package local.js8ri.ch03.ex01;

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
     * Protected method to construct a logger for a named subsystem.
     * <p>
     * The logger will be initially configured with a null Level
     * and with useParentHandlers set to true.
     * </p>
     *
     * @param name               A name for the logger.  This should
     *                           be a dot-separated name and should normally
     *                           be based on the package name or class name
     *                           of the subsystem, such as java.net
     *                           or javax.swing.  It may be null for anonymous Loggers.
     * @param resourceBundleName name of ResourceBundle to be used for localizing
     *                           messages for this logger.  May be null if none
     *                           of the messages require localization.
     * @throws MissingResourceException if the resourceBundleName is non-null and
     *                                  no corresponding resource can be found.
     */
    public MyLogger(String name, String resourceBundleName) {
        super(name, resourceBundleName);
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
    public boolean logIf(Level level, BooleanSupplier condition, Supplier<String> msgSupplier) {
        Objects.requireNonNull(condition);
        if (isLoggable(level) && condition.getAsBoolean()) {
            log(level, msgSupplier);
            return true;
        }
        return false;
    }
}
