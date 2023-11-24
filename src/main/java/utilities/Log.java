package utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log {
    private static Logger log = LogManager.getLogger(Log.class.getName());

    public static void startTestCase(String sTestCaseName) {
        log.info("*****************************************************************");
        log.info("**********" + sTestCaseName + "************");
        log.info("******************************************************************");
    }

    public static void endTestCase() {
        log.info("XXX---------" + "E-N-D" + "--------------XXX");
        log.info("X");
        log.info("X");
    }

}
