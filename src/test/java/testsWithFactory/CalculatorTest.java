package testsWithFactory;
import activities.calculator.CalculatorActivities;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.junit.jupiter.api.*;

import java.net.MalformedURLException;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import session.Session;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import static io.appium.java_client.AppiumBy.*;

public class CalculatorTest {
    AppiumDriver phone;
    CalculatorActivities calc = new CalculatorActivities();
    @BeforeEach
    public void openApp() {
        Session.getSession().setPackageAndActivity("com.android.calculator2", "com.android.calculator2.Calculator");
    }

    @AfterEach
    public void closeApp(){
        Session.getSession().closeApp();
    }

    @Test
    public void verifyCalculatorTest() throws InterruptedException {
        calc.fiveButton.click();
        calc.addButton.click();
        calc.sevenButton.click();
        calc.equalButton.click();
        String actualResult= calc.resultLabel.getText();
        String expectedResult="12";
        Assertions.assertEquals(expectedResult,actualResult,"ERROR la suma esta mal");
        Thread.sleep(10000);
    }
}
