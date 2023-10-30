package testsWithFactory;
import activities.calculator.CalculatorActivities;
import activities.calendar.CalendarActivities;
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
import java.util.Random;

import static io.appium.java_client.AppiumBy.*;

public class CalendarTest {
    AppiumDriver phone;
    CalendarActivities cal = new CalendarActivities();
    Random rand = new Random();
    @BeforeEach
    public void openApp() {
        Session.getSession().setPackageAndActivity("com.simplemobiletools.calendar", "com.simplemobiletools.calendar.activities.MainActivity");
    }

    @AfterEach
    public void closeApp(){
        Session.getSession().closeApp();
    }

    @Test
    public void verifyCalculatorTest() throws InterruptedException {
        String titulo="EsteEsUnNuevoItem"+rand.nextInt(255);
        cal.plusButton.click();
        cal.titleEvent.setText(titulo);
        cal.descriptionEvent.setText("hola");
        cal.saveButton.click();
        cal.changeView.click();
        cal.eventList.click();
        Assertions.assertTrue(cal.eventCreated(titulo).isControlDisplayed(),"ERROR no se creó el evento");
        Thread.sleep(10000);
    }
}
