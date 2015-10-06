package swip.ch03interacting;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import swip.ch07managingwebdriver.injecting.Config;
import swip.ch07managingwebdriver.injecting.WebDriverRunner;

import javax.inject.Inject;

@RunWith(WebDriverRunner.class)
@Config(exclude = {"browserName=safari", "browserName=htmlunit"})
public class WyswygInputPageObjectIT {

    @Inject
    private WebDriver driver;

    @Test
    public void enterTextIntoAWyswygEditor() throws Exception {

        driver.get("/wyswyg-editor.html");
        WyswygInput wyswygInput = new WyswygInput(driver);

        wyswygInput.setText("A paragraph of text, some of which is");
        wyswygInput.appendItalicText(" italics.");
    }
}
