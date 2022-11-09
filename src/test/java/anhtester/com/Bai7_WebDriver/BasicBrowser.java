package anhtester.com.Bai7_WebDriver;

import anhtester.com.common.BaseTest;
import org.openqa.selenium.By;

public class BasicBrowser extends BaseTest {

    public static void main(String[] args) {
        createDriver();

        driver.navigate().to("http://anhtester.com");
        sleep(2);
        driver.findElement(By.id("btn-login")).click();
        sleep(1);
//        // Điều hướng về lịch sử trang trước đó
//        driver.navigate().back();
//        sleep(2);
//        // Làm mới trang hiện tại
//        driver.navigate().refresh();
//        sleep(2);
//        // Điều hướng đến trang tiếp sau
//        driver.navigate().forward();

        // Get the title of the page
        System.out.println(driver.getTitle());
        // Get the current URL
        System.out.println(driver.getCurrentUrl());
        // Get the current page HTML source
        System.out.println(driver.getPageSource());

        closeDriver();
    }

}
