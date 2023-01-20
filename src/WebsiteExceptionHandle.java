import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;

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
        Thread.sleep(5000);
    }
}