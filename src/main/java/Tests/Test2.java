package Tests;

import Pages.HomePage;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.PageFactory;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Test2 extends TestBase{
//Test Part 2
    //A.
    @Test
    public void initTest1() throws Exception {
        HomePage webSite = PageFactory.initElements(driver, HomePage.class);
        Thread.sleep(2000);
        webSite.selectCategory(webSite.pattern);
        assertTrue(webSite.sumList(webSite.retroSize) > 4);
        //waiting before closing test
        Thread.sleep(5000);
    }
    //B.
    @Test
    public void initTest2() throws Exception {
        HomePage webSite = PageFactory.initElements(driver, HomePage.class);
        Thread.sleep(2000);
        webSite.selectCategory(webSite.pattern);
        assertTrue(webSite.sumList(webSite.barsPrice) > 20);
        //waiting before closing test
        Thread.sleep(5000);
    }
}
