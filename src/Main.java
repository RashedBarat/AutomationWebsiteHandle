import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {

    public static WebDriver driver; // Setting Global WebDriver Object

    public static void main(String[] args) {

        String currentDir = System.getProperty("user.dir");

        System.out.println(currentDir);
        String path = currentDir + "\\Resources\\chromedriver.exe";
        System.out.println(path);

        // Set Path //

        System.setProperty("webdriver.chrome.driver",path);

        driver = new ChromeDriver();
        driver.get("https://chaldal.com/"); // Calling the website

        driver.manage().window().maximize(); // Expand the open window



    }
}