package activities.notepad;

import appiumControl.Button;
import appiumControl.Label;
import appiumControl.TextBox;
import org.openqa.selenium.By;

public class CreacionNota {
    public TextBox titulo = new TextBox(By.id("com.atomczak.notepat:id/textNoteTitleEdit"));
    public TextBox cuerpo = new TextBox(By.id("com.atomczak.notepat:id/textNoteContentEdit"));
    public Button save = new Button(By.id("com.atomczak.notepat:id/action_save_note"));
    public Button atras = new Button(By.xpath("//android.widget.ImageButton[@content-desc=\"Navigate up\"]"));
}
