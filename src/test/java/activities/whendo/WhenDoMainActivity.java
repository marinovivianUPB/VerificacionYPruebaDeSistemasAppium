package activities.whendo;

import appiumControl.Button;
import appiumControl.TextBox;
import org.openqa.selenium.By;

public class WhenDoMainActivity {
    public Button newItem = new Button(By.id("com.vrproductiveapps.whendo:id/fab"));
    public Button itemCreated(String titulo){
        return new Button(By.xpath("//android.widget.TextView[@resource-id='com.vrproductiveapps.whendo:id/home_list_item_text'and @text='"+titulo+"']"));
    }
}
