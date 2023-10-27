import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.junit.jupiter.api.*;

import java.net.MalformedURLException;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import static io.appium.java_client.AppiumBy.*;

public class CalculatorTest {
    AppiumDriver phone;
    @BeforeEach
    public void openApp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName","UPB2023_Android9");
        capabilities.setCapability("platformVersion","9.0");
        capabilities.setCapability("appPackage","com.android.calculator2");
        capabilities.setCapability("appActivity","com.android.calculator2.Calculator");
        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("automationName","uiautomator2");

        phone = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
        phone.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @AfterEach
    public void closeApp(){
        phone.quit();
    }

    @Test
    public void verifyCalculatorTest() throws InterruptedException {
        phone.findElement(By.id("com.android.calculator2:id/digit_5")).click();
        phone.findElement(By.id("com.android.calculator2:id/op_add")).click();
        phone.findElement(By.id("com.android.calculator2:id/digit_7")).click();
        phone.findElement(By.id("com.android.calculator2:id/eq")).click();
        String expectedResult="12";
        String actualResult = phone.findElement(By.id("com.android.calculator2:id/result")).getText();
        Assertions.assertEquals(expectedResult,actualResult,"ERROR la suma esta mal");
        Thread.sleep(10000);
    }
}
