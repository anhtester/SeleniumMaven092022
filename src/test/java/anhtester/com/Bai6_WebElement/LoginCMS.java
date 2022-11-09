package anhtester.com.Bai6_WebElement;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class LoginCMS {

    public static void main(String[] args) throws InterruptedException {

        //Khởi tạo browser với Chrome
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //Login CMS
        driver.get("https://demo.activeitzone.com/ecommerce/login");

        //Bắt WebElement Email (object)
        WebElement inputEmail = driver.findElement(By.id("email"));
        inputEmail.sendKeys("admin@example.com");

        System.out.println("Lấy Text của ô Email: " + inputEmail.getText());
        System.out.println("Name ô Email: " + inputEmail.getAttribute("name"));
        System.out.println("Class ô Email: " + inputEmail.getAttribute("class"));

        driver.findElement(By.id("password")).sendKeys("123456");

        Thread.sleep(1000);
        //inputEmail.clear();

        WebElement checkboxRemember1 = driver.findElement(By.id("remember"));
        System.out.println("Đã chọn: " + checkboxRemember1.isSelected());

        driver.findElement(By.xpath("//span[normalize-space()='Remember Me']")).click();
        Thread.sleep(1000);
        WebElement checkboxRemember2 = driver.findElement(By.id("remember"));
        System.out.println("Đã chọn: " + checkboxRemember1.isSelected());


        //Get Text của tiêu đề H1
        WebElement tieude = driver.findElement(By.xpath("//div[@class='card-body']//h1"));
        System.out.println(tieude.getText());

        WebElement buttonCopy = driver.findElement(By.xpath("//button[normalize-space()='Copy']"));
        System.out.println("Trạng thái nút Copy: " + buttonCopy.isDisplayed());

        WebElement buttonLogin = driver.findElement(By.xpath("//button[normalize-space()='Login']"));

        Dimension dimensions = buttonLogin.getSize();
        System.out.println("Height: " + dimensions.height);
        System.out.println("Width: " + dimensions.width);

        Point point = buttonLogin.getLocation();
        System.out.println("X: " + point.x);
        System.out.println("Y: " + point.y);

        System.out.println(buttonLogin.getCssValue("background-color")); //Trả về mã màu RGBA

        if (buttonCopy.isDisplayed() == true) {
            //buttonLogin.click();
            buttonLogin.submit();
        }


        Thread.sleep(1000);

        //Tắt browser
        driver.quit();
    }

}
