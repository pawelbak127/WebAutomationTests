import org.testng.annotations.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NewTest {

    private static final Logger logger = LoggerFactory.getLogger(NewTest.class);

    @Test
        public void runTest() {
            // Logowanie na różnych poziomach
            logger.info("Starting test...");
            logger.debug("Debug information...");
            logger.error("An error occurred!");
        }
}