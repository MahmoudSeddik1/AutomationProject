package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

public class BasePages {
    private WebDriver driver;

    public BasePages(WebDriver driver){
        this.driver=driver;

    }

    /**
     * This method clicks an element using its By locator
     * @param element
     */
    protected void clickElement(By element){
        myWait().until(ExpectedConditions.elementToBeClickable(driver.findElement(element))).click();
    }

    /**
     * This method enters a text to an element using its By locator
     * @param element
     * @param text
     */
    protected void typeElement(By element,String text){
        driver.findElement(element).sendKeys(text);
    }

    /**
     * My detailed fluent wait
     * @return
     */
    protected Wait<WebDriver> myWait(){
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(20)) // Maximum wait time
                .pollingEvery(Duration.ofMillis(500)) // Polling interval
                .ignoring(org.openqa.selenium.NoSuchElementException.class);
        return wait;
    }

}
