package loggers;

import java.util.logging.Level;
import java.util.logging.Logger;

public class LoggerManager {

    Logger logger;

    private static final Logger LOGGER = Logger.getLogger( LoggerManager.class.getName() );

    private static Logger getLOGGER() {
        return LOGGER;
    }

    public static void logError(String message) {
        getLOGGER().log(Level.SEVERE, message);
    }
}
