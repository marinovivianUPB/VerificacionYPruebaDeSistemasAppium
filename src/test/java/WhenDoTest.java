import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Random;

public class WhenDoTest {
    AppiumDriver phone;
    Random rand = new Random();
    @BeforeEach
    public void openApp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName","UPB2023_Android9");
        capabilities.setCapability("platformVersion","9.0");
        capabilities.setCapability("appPackage","com.vrproductiveapps.whendo");
        capabilities.setCapability("appActivity","com.vrproductiveapps.whendo.ui.HomeActivity");
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
        String titulo="EsteEsUnNuevoItem"+rand.nextInt(255);
        phone.findElement(By.id("com.vrproductiveapps.whendo:id/fab")).click();
        phone.findElement(By.id("com.vrproductiveapps.whendo:id/noteTextTitle")).sendKeys(titulo);
        phone.findElement(By.id("com.vrproductiveapps.whendo:id/noteTextNotes")).sendKeys("Notas "+titulo);
        phone.findElement(By.id("com.vrproductiveapps.whendo:id/saveItem")).click();
        Assertions.assertTrue(phone.findElement(By.xpath("//android.widget.TextView[@resource-id='com.vrproductiveapps.whendo:id/home_list_item_text'and @text='"+titulo+"']")).isDisplayed(),"ERROR no se creo el item");
        Thread.sleep(10000);
    }
}
