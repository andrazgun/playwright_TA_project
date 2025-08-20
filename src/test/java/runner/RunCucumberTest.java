package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.slf4j.Logger;
import org.testng.TestNG;
import org.testng.annotations.DataProvider;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;
import support.LogUtil;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.Properties;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = "step_definitions",
        tags = "@smoke and not @ignore",
        plugin = {"pretty", "json:target/cucumber.json", "html:target/cucumber-report.html"}
)
public class RunCucumberTest extends AbstractTestNGCucumberTests {

    private static final Logger logger = LogUtil.getLogger(RunCucumberTest.class);
    private static final Properties properties = new Properties();

    static {
        Path configPath = Paths.get(System.getProperty("config.path", Paths.get(System.getProperty("user.dir"),
                "src", "main", "resources", "config.properties").toString()));
        try (InputStream input = java.nio.file.Files.newInputStream(configPath)) {
            properties.load(input);
        } catch (IOException e) {
            logger.error("Failed to load config.properties", e);
            throw new RuntimeException("Unable to load configuration", e);
        }
    }

    public static void main(String[] args) {

        TestNG testNG = new TestNG();
        XmlSuite suite = new XmlSuite();

        int threadCount = getThreadCount();
        logger.info("Configured thread count: {}", threadCount);

        suite.setDataProviderThreadCount(threadCount);

        suite.setThreadCount(threadCount);

        XmlTest test = new XmlTest(suite);
        test.setName("Cucumber tests"); //setting tests name
        test.setXmlClasses(Collections.singletonList(new XmlClass(RunCucumberTest.class))); //add the test class to the test

        //disable default listeners (will disable TestNG reports from being generated)
        testNG.setUseDefaultListeners(false);

        //add the suite to the TestNG instance
        testNG.setXmlSuites(Collections.singletonList(suite));

        //run TestNG with the configured suite
        testNG.run();
    }

    private static int getThreadCount() {
        /**
         * Resolves the thread count to be used for test execution.
         *
         * Resolution order:
         * 1. Jenkins parameter "THREAD_COUNT" – if provided in the CI pipeline, this value is used.
         * 2. Configuration property "thread.count" – if no Jenkins parameter is found,
         *    the system falls back to the config file property.
         * 3. Default value "1" – if neither is defined, the system defaults to a single thread.
         */

        String threadCountString = System.getProperty("THREAD_COUNT", properties.getProperty("thread.count", "1"));
        try {
            return Integer.parseInt(threadCountString);
        } catch (NumberFormatException e) {
            logger.warn("Invalid thread count value: '{}'. Falling back to 1.", threadCountString);
            return 1;
        }
    }

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
