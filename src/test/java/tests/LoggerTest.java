package tests;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

public class LoggerTest {
    Logger logger = LogManager.getLogger(LoggerTest.class);
    Logger loggerFile = LogManager.getLogger("File");

    @Test
    public void loggerTest() {
        logger.trace("Trace Message: ...");
        logger.debug("Debug Message: ...");
        logger.info("Info Message: ...");
        logger.warn("Warning Message: ...");
        logger.error("Error Message: ...");
        logger.fatal("Fatal Message: ...");

        loggerFile.error("Error Message: ...");
        loggerFile.fatal("Fatal Message: ...");
    }

}
