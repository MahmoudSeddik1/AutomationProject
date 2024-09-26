package pages;

import enums.Enums;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import enums.Enums.*;

import java.util.concurrent.Flow;

public class SubscriptionPage  extends BasePages{
    private WebDriver driver;

    /*-----------------------------------------------------------------*/
    private final By changeCountryBtn = By.id("country-name");
    private final By bahrainBtn = By.id("bh-contry-lable");
    private final By ksaBtn = By.id("sa-contry-lable");
    private final By kuwaitBtn = By.id("kw-contry-lable");
    /*-----------------------------------------------------------------*/
    private final By name_LitePlan = By.id("name-lite");
    private final By name_ClassicPlan = By.id("name-classic");
    private final By name_PremiumPlan = By.id("name-premium");
    private final By price_LitePlan = By.id("currency-lite");
    private final By price_ClassicPlan = By.id("currency-classic");
    private final By price_PremiumPlan = By.id("currency-premium");





    public SubscriptionPage(WebDriver driver){
        super(driver);
        this.driver=driver;
    }

    public SubscriptionPage changeCountryTo (Country country) {
        String currentCountry = driver.findElement(changeCountryBtn).getText();

        if (!currentCountry.equals(country.getValue())) {
            clickElement(changeCountryBtn);
            switch (country) {
                case KSA -> clickElement(ksaBtn);
                case Kuwait -> clickElement(kuwaitBtn);
                case Bahrain -> clickElement(bahrainBtn);
            }
            return this;
        }else
            return this;
    }

    public String getSubscriptionName(Subscription subscription){
        switch (subscription){
            case Lite -> {
                return driver.findElement(name_LitePlan).getText();
            }
            case Classic -> {
                return driver.findElement(name_ClassicPlan).getText();
            }
            case Premium -> {
                return driver.findElement(name_PremiumPlan).getText();
            }
            default ->{
                return null;
            }
        }
    }

    public String getSubscriptionPrice(Subscription subscription){
        switch (subscription){
            case Lite -> {
                return driver.findElement(price_LitePlan).getText();
            }
            case Classic -> {
                return driver.findElement(price_ClassicPlan).getText();
            }
            case Premium -> {
                return driver.findElement(price_PremiumPlan).getText();
            }
            default ->{
                return null;
            }
        }
    }

    public String getCurrency(String text){
        int spaceIndex = text.indexOf(' ');
        int slashIndex = text.indexOf('/');

        String currency = text.substring(spaceIndex + 1, slashIndex);

        return currency;
    }
    public String getAmount(String text){
        int spaceIndex = text.indexOf(' ');
        String amount = text.substring(0, spaceIndex);

        return amount;
    }

    public String getFrequency(String text){
        int slashIndex = text.indexOf('/');
        String frequency = text.substring(slashIndex);
        return frequency;
    }


}
