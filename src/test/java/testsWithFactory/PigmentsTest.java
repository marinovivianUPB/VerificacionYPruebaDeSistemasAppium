package testsWithFactory;

import activities.pigments.*;
import io.appium.java_client.AppiumDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import session.Session;

import java.util.Random;

public class PigmentsTest {
    AppiumDriver phone;
    Menu menu = new Menu();
    Options options = new Options();
    OptionsTheme optionsTheme = new OptionsTheme();
    PlusPremium premium = new PlusPremium();
    Principal principal=new Principal();

    Tutorial tutorial = new Tutorial();
    Random rand = new Random();
    @BeforeEach
    public void openApp() {
        Session.getSession().setPackageAndActivity("com.sorincovor.pigments", "com.sorincovor.pigments.MainActivity");
    }

    @AfterEach
    public void closeApp(){
        options.theme.click();
        optionsTheme.light.click();
        Session.getSession().closeApp();
    }

    @Test
    public void verifyThemeChanged() throws InterruptedException {
        tutorial.skip.click();
        premium.equis.click();
        principal.menu.click();
        menu.options.click();
        options.theme.click();
        optionsTheme.dark.click();
        principal.menu.click();
        menu.options.click();
        Assertions.assertTrue(options.selectedThemeDark.isControlDisplayed(),"ERROR no se cambió el tema");
        Thread.sleep(10000);
    }
}
