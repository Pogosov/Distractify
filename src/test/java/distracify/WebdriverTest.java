package distracify;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;

/**
 * Created by pogosov on 30.04.2014.
 */
public class WebdriverTest {
    @Test
    public void preconditionTest()
    {
        WebDriver driver=new FirefoxDriver();
        driver.navigate().to(PropertyLoader.loadProperty("url1"));
        PropertyLoader.setProperty("url2", driver.findElement(By.xpath("//div[contains(@class,'b-main_double_columns')]/div/article[2]/a")).getAttribute("href"));
        PropertyLoader.setProperty("url3",driver.findElement(By.xpath("//div[contains(@class,'b-main_double_columns')]/div/article[3]/a")).getAttribute("href"));
        PropertyLoader.setProperty("url4",driver.findElement(By.xpath("//div[contains(@class,'b-main_double_columns')]/div/article[4]/a")).getAttribute("href"));
        System.out.println("URL 1 = " + PropertyLoader.loadProperty("url1"));
        System.out.println("URL 2 = "+PropertyLoader.loadProperty("url2"));
        System.out.println("URL 3 = "+PropertyLoader.loadProperty("url3"));
        System.out.println("URL 4 = "+PropertyLoader.loadProperty("url4"));
        PropertyLoader.wait(500);
        driver.close();
    }
}
