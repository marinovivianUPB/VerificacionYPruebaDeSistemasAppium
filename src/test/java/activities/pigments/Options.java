package activities.pigments;

import appiumControl.Button;
import appiumControl.Label;
import org.openqa.selenium.By;

public class Options {
    public Button theme = new Button(By.xpath("//android.widget.TextView[@text=\"Theme\"]/.."));
    public Label selectedThemeDark = new Label(By.xpath("//android.widget.Spinner[@text=\"Dark\"]"));
}
