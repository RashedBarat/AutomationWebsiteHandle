import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class WebsiteExceptionHandle {

    public static WebDriver driver; // Setting Global WebDriver Object

    public static void main(String[] args) throws InterruptedException {

        String currentDir = System.getProperty("user.dir");
        String path = currentDir + "\\Resources\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver",path);

        ChromeOptions options = new ChromeOptions();

        Map<String,Object> prefs = new HashMap<String,Object>();
        Map<String,Object> profile = new HashMap<String,Object>();
        Map<String,Integer> contentSettings = new HashMap<String,Integer>();

        contentSettings.put("notifications",2);
        contentSettings.put("geolocation",2);
        profile.put("managed_default_content_settings",contentSettings);
        prefs.put("profile",profile);
        options.setExperimentalOption("prefs",prefs);
        driver = new ChromeDriver(options);
        driver.get("https://chaldal.com/");
        driver.manage().window().maximize();
        //Thread.sleep(5000);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // Max wait 10s but find and hit asap


        //driver.findElement(By.xpath("/html/body/div[2]/div/div[3]/div/div[2]/div/div/div[2]/div[1]/div/div/div[2]/h5")).click(); //Absolute Type XPath
        driver.findElement(By.xpath("/html/body/div[2]/div/div[3]/div/div[2]/div/div/div[2]/div[1]/div/div/div[3]/h5")).click();
        //*[@id="page"]/div/div[3]/div/div[2]/div/div/div[2]/div[1]/div/div/div[2]/h5  -- Relative Type XPath

        ArrayList<String> alltabs = new ArrayList<String>(driver.getWindowHandles());


        //Thread.sleep(5000);
        driver.switchTo().window(alltabs.get(0));

        driver.findElement(By.xpath("/html/body/div[2]/div/div[3]/div/div[1]/div[1]/form/div/div[1]/input")).sendKeys("egg");
       // Thread.sleep(3000);

        driver.findElement(By.xpath("/html/body/div[2]/div/div[3]/div/div[1]/div[1]/form/div/div[1]/input")).sendKeys(Keys.ENTER);
        //Thread.sleep(3000);
        driver.findElement(By.xpath("/html/body/div[2]/div/div[6]/section/div/div/div/div/section/div[3]/div[2]/div[1]/div/section/p")).click();

      //  WebDriverWait wait=new WebDriverWait(driver, 20); // must need to input when calling Explicit wait

        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.  // Wait for a particular element
           //     xpath( "/html/body/div[2]/div/div[6]/section/div/div/div/div/section/div[3]/div[2]/div[1]/div/section/p")));

        //driver.switchTo().window(alltabs.get(0));

        driver.navigate().back();

        String text = driver.findElement(By.
                xpath("/html/body/div[2]/div/div[6]/section/div/div/div[1]/div/div/h2/span[2]")).getText();

        System.out.println(text);

    }
}
