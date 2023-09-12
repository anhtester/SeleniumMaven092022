package anhtester.com.Bai5_Locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class LoginHRM {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.http.factory", "jdk-http-client");
        //Khởi tạo browser với Chrome
        WebDriver driver;
        //WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //Mở trang eCommerce
        driver.get("https://hrm.anhtester.com/");
        Thread.sleep(1000);

        driver.findElement(By.xpath("/html/body/div/div/div/div/div[2]/div/form/div[1]/div[1]/input")).sendKeys("admin_example");
        driver.findElement(By.xpath("/html/body/div/div/div/div/div[2]/div/form/div[1]/div[2]/input")).sendKeys("123456");
        driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[2]/button[1]")).click();

        Thread.sleep(6000);
        //Tắt browser
        driver.quit();
    }
}
