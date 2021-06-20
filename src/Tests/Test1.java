package Tests;

import Pages.HomePage;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.PageFactory;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Test1 extends TestBase{
//Test Part 1
    @Test
    public void initTest() throws Exception{

        HomePage webSite = PageFactory.initElements(driver,HomePage.class);
        Thread.sleep(2000);
        webSite.setSearch("BLACK POPLIN SKINNY TIE");
        Thread.sleep(5000);
        assertTrue(webSite.selectProduct() > 10);
        //waiting before closing test
        Thread.sleep(5000);

    }

}
