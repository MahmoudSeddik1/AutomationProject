package base;

import com.google.common.io.Files;
import enums.Enums;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;
import pages.SubscriptionPage;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class BaseTests {
    private WebDriver driver;
    protected SoftAssert softly;
    protected SubscriptionPage subscriptionPage;


    @BeforeMethod(alwaysRun = true)
    protected void Setup(){
        WebDriverManager.chromedriver().clearDriverCache();
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver(options());
        subscriptionPage = new SubscriptionPage(driver);
        softly = new SoftAssert();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://subscribe.stctv.com/sa-en");
    }


    @AfterMethod(alwaysRun = true)
    protected void isFailureRecord(ITestResult result, Method m){
        if(ITestResult.FAILURE == result.getStatus()) {
            var camera = (TakesScreenshot) driver;
            File screenshot = camera.getScreenshotAs(OutputType.FILE);
            LocalDateTime currentDateTime = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
            String formattedDateTime = currentDateTime.format(formatter);
            try{
                Files.move(screenshot,
                        new File(System.getProperty("user.dir")+"/src/main/resources/screenshots/" +formattedDateTime+"_"+ result.getName() +".png"));
                System.out.println("Screenshot taken and saved to "+ formattedDateTime+"_"+ result.getName()+".png");
            }catch (IOException e){
                e.printStackTrace();
            }

        } else{
            System.out.println(m.getName()+" Executed Successfully");
        }

    }


    @AfterMethod(alwaysRun = true, dependsOnMethods = "isFailureRecord")
    protected void closeAll(){
        driver.quit();
    }






    private ChromeOptions options(){

        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        prefs.put("useAutomationExtension", false);
        options.setExperimentalOption("prefs", prefs);

        return options;
    }


}
