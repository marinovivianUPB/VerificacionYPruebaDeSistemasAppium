package activities.pigments;

import appiumControl.Button;
import appiumControl.Label;
import org.openqa.selenium.By;

public class OptionsTheme {
    public Button dark = new Button(By.xpath("//android.widget.CheckedTextView[@text=\"Dark\"]"));
    public Button light = new Button(By.xpath("//android.widget.CheckedTextView[@text=\"Light\"]"));
}
