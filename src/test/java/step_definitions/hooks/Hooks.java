package step_definitions.hooks;

import browser.BrowserManager;
import io.cucumber.java.*;
import org.slf4j.Logger;
import support.LogUtil;

public class Hooks {

    private static final Logger staticLogger = LogUtil.getLogger(Hooks.class); // for static methods
    private final Logger logger = LogUtil.getLogger(this.getClass()); // for instance methods
    private final BrowserManager browserManager;

    public Hooks(BrowserManager browserManager) { //constructor using PicoContainer for DI
        this.browserManager = browserManager;
    }

    @BeforeAll
    public static void beforeAll() {
        staticLogger.info("Executing test suite");
    }

    @AfterAll
    public static void afterAll() {
        staticLogger.info("Finished executing the test suite");
    }

    @Before
    public void setUp() {
        browserManager.setUp();
        logger.info("setUp()");
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            byte[] screenshot = browserManager.takeScreenshot();
            if (screenshot != null && screenshot.length > 0) {
                scenario.attach(screenshot, "image/png", "screenshot");
            } else {
                logger.warn("Screenshot not attached; no valid screenshot data.");
            }
        }
        browserManager.tearDown();
        logger.info("tearDown()");
    }


}
