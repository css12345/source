package swip.ch18datepicker.tests;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import swip.ch15pageflow.framework.Browser;
import swip.ch15pageflow.framework.BrowserRunner;
import swip.ch18datepicker.bootstrap.BootstrapDatepickerPage;
import swip.framework.TestTimer;

import javax.inject.Inject;

import static java.time.Month.APRIL;
import static org.junit.Assert.assertEquals;


@RunWith(BrowserRunner.class)
public class BootstrapDatepickerIT extends TestTimer {

    @Inject
    private Browser browser;
    private BootstrapDatepickerPage bootstrapDatepickerPage;

    @Before
    public void setup() {
        browser.get("/bootstrap-datepicker.html");
        bootstrapDatepickerPage = new BootstrapDatepickerPage(browser);
    }

    @Test
    public void pickADate() {
        bootstrapDatepickerPage.pick(APRIL, 1, 2015);
        assertEquals("01-04-2015", bootstrapDatepickerPage.getDate());
    }

}
