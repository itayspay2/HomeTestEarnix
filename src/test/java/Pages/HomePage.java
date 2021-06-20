package Pages;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class HomePage {

    WebDriver driver;

    String priceValue;

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    @FindBy(how = How.LINK_TEXT, using = "SEARCH")
    public WebElement searchBox;

    @FindBy(how = How.LINK_TEXT, using = "PATTERN")
    public WebElement pattern;

    @FindBy(how = How.LINK_TEXT, using = "Retro")
    public WebElement retro;

    @FindBy(how = How.PARTIAL_LINK_TEXT, using = "BARS")
    public WebElement tieBars;

    @FindBy(name = "q")
    public WebElement searchBox2;

    @FindBy(partialLinkText = "BLACK POPLIN")
    public WebElement product;

    @FindBy(className = "Rte")
    public WebElement description;

    @FindBy(className = "ProductMeta__PriceList")
    public WebElement price;

    @FindBy(className = "ProductItem")
    public List<WebElement> retroSize;

    @FindBy(className = "ProductItem__PriceList")
    public List<WebElement> barsPrice;



    public void setSearch(String searchText) throws InterruptedException {
        searchBox.click();
        Thread.sleep(2000);
        searchBox2.sendKeys(searchText);
        Thread.sleep(2000);
        searchBox2.sendKeys(Keys.ENTER);
    }

    public int selectProduct() throws InterruptedException {

        product.click();
        Thread.sleep(2000);
        priceValue = price.getText().substring(1);
        System.out.println(priceValue);
        System.out.println(description.getText());

        return Integer.parseInt(priceValue);

    }

    public void selectCategory(WebElement category) throws InterruptedException {

        Actions action = new Actions(driver);
        if(category == pattern) {
            action.moveToElement(pattern).perform();
            action.moveToElement(retro).click().perform();
            Thread.sleep(5000);
        }else{
            action.moveToElement(tieBars).click().perform();
            Thread.sleep(5000);
        }
    }

    public float sumList(List<WebElement> list){
        float sum = 0;
        if(list == retroSize){
            java.util.Iterator<WebElement> i = list.iterator();
            while(i.hasNext()) {
                WebElement element = i.next();
                if (element.isDisplayed()) {
                     sum += Float.parseFloat(element.getText().substring(0,3));
                }
            }
        }
        if(list == barsPrice){
            java.util.Iterator<WebElement> i = list.iterator();
            while(i.hasNext()) {
                WebElement element = i.next();
                if (element.isDisplayed()) {
                    System.out.println(element.getText().substring(1));
                    sum += Float.parseFloat(element.getText().substring(1));
                }
            }
        }
        System.out.println(sum);
    return sum;
    }

}
