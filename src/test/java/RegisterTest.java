import com.sun.deploy.cache.BaseLocalApplicationProperties;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RegisterTest {
    private WebDriver driver;


    @Before
    public void initDriver() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Ignore
    @Test
    public void account() {
        driver.get("http://testfasttrackit.info/selenium-test/");
        driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label")).click();
        driver.findElement(By.cssSelector("#header-account > div > ul > li:nth-child(5) > a")).click();
        driver.findElement(By.cssSelector("#firstname")).sendKeys("Sabadus");
        driver.findElement(By.cssSelector("#lastname")).sendKeys("Calin");
        driver.findElement(By.cssSelector("#email_address")).sendKeys("sabadus.calinYUGnn@mailinator.com");
        driver.findElement(By.cssSelector("#password")).sendKeys("123456");
        driver.findElement(By.cssSelector("#confirmation")).sendKeys("123456");
        driver.findElement(By.cssSelector("#is_subscribed")).click();
        driver.findElement(By.cssSelector("#form-validate > div.buttons-set > button > span > span")).click();
        WebElement thankYouMess = driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col2-left-layout > div > div.col-main > div.my-account > div > ul > li > ul > li > span"));
        Assert.assertEquals("Thank you for registering with Madison Island.", thankYouMess.getText());


    }

    @Test
    public void wrongPass() {
        driver.get("http://testfasttrackit.info/selenium-test/");
        driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label")).click();
        driver.findElement(By.cssSelector("#header-account > div > ul > li:nth-child(5) > a")).click();
        driver.findElement(By.cssSelector("#firstname")).sendKeys("Sabadus");
        driver.findElement(By.cssSelector("#lastname")).sendKeys("Calin");
        driver.findElement(By.cssSelector("#email_address")).sendKeys("sabadus.calinYUGnn@mailinator.com");
        driver.findElement(By.cssSelector("#password")).sendKeys("123456");
        driver.findElement(By.cssSelector("#confirmation")).sendKeys("1fsgger6");
        driver.findElement(By.cssSelector("#is_subscribed")).click();
        driver.findElement(By.cssSelector("#form-validate > div.buttons-set > button > span > span")).click();
        driver.findElement(By.cssSelector("#advice-validate-cpassword-confirmation")).isDisplayed();
        Assert.assertTrue(true);

    }

    @Test
    public void register() {
        driver.get("http://testfasttrackit.info/selenium-test/");
        driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label")).click();
        driver.findElement(By.cssSelector("#header-account > div > ul > li:nth-child(5) > a")).isDisplayed();
        Assert.assertTrue(true);
    }

    @Test
    public void instructions() {
        driver.get("http://testfasttrackit.info/selenium-test/");
        driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label")).click();
        driver.findElement(By.cssSelector("#header-account > div > ul > li:nth-child(5) > a")).click();
        driver.findElement(By.cssSelector("#form-validate > div.fieldset > p.form-instructions")).isDisplayed();
        WebElement info = driver.findElement(By.cssSelector("#form-validate > div.fieldset > p.form-instructions"));
        Assert.assertEquals("Please enter the following information to create your account.", info.getText());
        driver.quit();
    }
public void close(){
        driver.quit();
}
}