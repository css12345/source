package swip.ch12framework.v5;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.FluentWait;

import java.util.concurrent.TimeUnit;

public interface ExplicitWait {

    Element findElement(By by); // <1>

    default Element untilFound(By by) {  // <2>
        return new FluentWait<>(this)
                .withTimeout(30, TimeUnit.SECONDS)
                .pollingEvery(5, TimeUnit.MILLISECONDS)
                .ignoring(NoSuchElementException.class)
                .until((ExplicitWait e) -> findElement(by)); // <3>
    }
}
