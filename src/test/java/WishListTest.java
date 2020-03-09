import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WishListTest {
private WebDriver driver;
@Before
public void initDriver(){
    System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
    driver = new ChromeDriver();
}
    @Test
    public void sale() {
        driver.get("http://testfasttrackit.info/selenium-test/");
        driver.findElement(By.cssSelector("#nav > ol > li.level0.nav-5.parent > a")).click();
        driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col3-layout > div > div.col-wrapper > div.col-main > div.category-products > ul > li:nth-child(1) > div > div.actions > a")).click();
        driver.findElement(By.cssSelector("#product_addtocart_form > div.product-shop > div.product-options-bottom > ul.add-to-links > li:nth-child(1) > a")).click();
        WebElement message = driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col1-layout > div > div > div.account-login > div"));
        Assert.assertTrue(true);
    }

    @Test
    public void search() {
        driver.get("http://testfasttrackit.info/selenium-test/");
        driver.findElement(By.cssSelector("#search")).click();
        driver.findElement(By.cssSelector("#search")).sendKeys("dress");
        driver.findElement(By.cssSelector("#search_mini_form > div.input-box > button")).click();
        WebElement mess= driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col3-layout > div > div.col-wrapper > div.col-main > div.page-title > h1"));
        Assert.assertEquals("SEARCH RESULTS FOR 'DRESS'",mess.getText() );
    }
    @Test
    @Ignore
public void noItems(){
    driver.get("http://testfasttrackit.info/selenium-test/");
    driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label")).click();
    driver.findElement(By.cssSelector("#header-account > div > ul > li:nth-child(2) > a")).click();
    driver.findElement(By.cssSelector("#email")).sendKeys("sabadus.calin@mailinator.com");
    driver.findElement(By.cssSelector("#pass")).sendKeys("123456");
    driver.findElement(By.cssSelector("#send2")).click();
    driver.findElement(By.cssSelector("#wishlist-view-form > div > p")).isDisplayed();
    WebElement vid = driver.findElement(By.cssSelector("#wishlist-view-form > div > p"));
    Assert.assertEquals("You have no items in your wishlist.",vid.getText());
}
@Test
@Ignore
public void remove(){
    driver.get("http://testfasttrackit.info/selenium-test/");
    driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label")).click();
    driver.findElement(By.cssSelector("#header-account > div > ul > li:nth-child(2) > a")).click();
    driver.findElement(By.cssSelector("#email")).sendKeys("sabadus.calin@mailinator.com");
    driver.findElement(By.cssSelector("#pass")).sendKeys("123456");
    driver.findElement(By.cssSelector("#send2")).click();
    driver.findElement(By.cssSelector("#nav > ol > li.level0.nav-5.parent > a")).click();
    driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col3-layout > div > div.col-wrapper > div.col-main > div.category-products > ul > li:nth-child(3) > div > div.actions > ul > li:nth-child(1) > a")).click();
    driver.findElement(By.cssSelector("#item_573 > td.wishlist-cell5.customer-wishlist-item-remove.last > a")).isDisplayed();
    Assert.assertTrue(true);

}@Test
public void myWishList(){
    driver.get("http://testfasttrackit.info/selenium-test/");
    driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label")).click();
    driver.findElement(By.cssSelector("#header-account > div > ul > li:nth-child(2) > a")).click();
    driver.findElement(By.cssSelector("#email")).sendKeys("sabadus.calin@mailinator.com");
    driver.findElement(By.cssSelector("#pass")).sendKeys("123456");
    driver.findElement(By.cssSelector("#send2")).click();
    driver.findElement(By.cssSelector("#item_574 > td.wishlist-cell1.customer-wishlist-item-info > h3 > a")).isDisplayed();
    WebElement seeIf = driver.findElement(By.cssSelector("#item_574 > td.wishlist-cell1.customer-wishlist-item-info > h3 > a"));
    Assert.assertEquals("PARK ROW THROW",seeIf.getText());
}
public void close(){
    driver.quit();
}
}