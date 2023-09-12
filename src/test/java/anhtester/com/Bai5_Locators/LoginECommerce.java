package anhtester.com.Bai5_Locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class LoginECommerce {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.http.factory", "jdk-http-client");
        //Khởi tạo browser với Chrome
        WebDriver driver;
        //WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //Mở trang eCommerce
        driver.get("https://demo.activeitzone.com/ecommerce/login");
        Thread.sleep(1000);

        //Điền Email - Tìm locator theo ID với By.id()
        driver.findElement(By.id("email")).sendKeys("admin@example.com");

        //Điền Password - Tìm locator theo Name với By.name()
        driver.findElement(By.name("password")).sendKeys("123456");

        //Click link Forgot password ? - By.linkText()
        //driver.findElement(By.linkText("Forgot password ?")).click();
        driver.findElement(By.partialLinkText("Forgot")).click();

        Thread.sleep(2000);
        //Tắt browser
        driver.quit();
    }

}
