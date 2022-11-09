package anhtester.com.Bai5_Locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class LoginHRM {
    public static void main(String[] args) throws InterruptedException {

        //Khởi tạo browser với Chrome
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //Mở trang eCommerce
        driver.get("https://app.hrsale.com/");
        Thread.sleep(1000);

        driver.findElement(By.xpath("/html/body/div/div/div/div/div[2]/div/form/div[1]/div[1]/input")).sendKeys("frances.burns");
        driver.findElement(By.xpath("/html/body/div/div/div/div/div[2]/div/form/div[1]/div[2]/input")).sendKeys("frances.burns");
        driver.findElement(By.xpath("/html/body/div/div/div/div/div[2]/div/form/div[3]/div[1]/button")).click();

        Thread.sleep(6000);
        //Tắt browser
        driver.quit();
    }
}
