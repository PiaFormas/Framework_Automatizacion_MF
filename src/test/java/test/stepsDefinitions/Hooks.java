package test.stepsDefinitions;

import driverConfig.DriverContext;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Hooks {
    public WebDriver driver;
    private Scenario scenario;
    private static String takeEvidence = System.getProperty("evidence", "fullEvidence");

    public Hooks() {
    }

    @Before
    public void setUp(Scenario scenario) throws Throwable {
        this.scenario = scenario;
    }

    @After("@~db")
    public void tearDown(Scenario scenario) {
        DriverContext.quitDriver();
    }

    @AfterStep("@~db")
    public void capturarEvidencia() throws Exception {
        if (this.scenario.isFailed()) {
            this.generateEvidence("[FAIL] Scenario ScreenShots");
        } else if (takeEvidence.equalsIgnoreCase("fullEvidence")) {
            this.generateEvidence("[SUCCESS] Step ScreenShots");
        }

    }

    public void generateEvidence(String imageRefName) {
        byte[] screenShot = (byte[])((TakesScreenshot)DriverContext.getDriver()).getScreenshotAs(OutputType.BYTES);
        this.scenario.attach(screenShot, "image/png", imageRefName);
    }
}
