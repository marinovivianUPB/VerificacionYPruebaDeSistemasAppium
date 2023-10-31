package activities.whendo;

import appiumControl.Button;
import appiumControl.TextBox;
import org.openqa.selenium.By;

public class AddTaskScreenActivity {
    public TextBox setTitle = new TextBox(By.id("com.vrproductiveapps.whendo:id/noteTextTitle"));
    public TextBox setNotes = new TextBox(By.id("com.vrproductiveapps.whendo:id/noteTextNotes"));
    public Button save = new Button(By.id("com.vrproductiveapps.whendo:id/saveItem"));
}
