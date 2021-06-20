package Tests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class TestBase {

    public static WebDriver driver = null;

    @BeforeAll
    static void initHomePage(){
        //Set the path to chrome driver relatively to your machine.
        System.setProperty("webdriver.chrome.driver","C:\\chromeDriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://skinnyties.com/");


    }

    @AfterAll
    static void closeTest(){

        driver.quit();

    }

}
