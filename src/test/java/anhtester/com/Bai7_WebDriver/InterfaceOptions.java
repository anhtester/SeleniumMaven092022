package anhtester.com.Bai7_WebDriver;

import anhtester.com.common.BaseTest;
import org.openqa.selenium.Cookie;

import java.util.Set;

public class InterfaceOptions extends BaseTest {
    public static void main(String[] args) {
        createDriver();

        driver.get("https://anhtester.com");

        // Add a new cookie
        Cookie newCookie = new Cookie("customName", "95287942140bj28148974");
        driver.manage().addCookie(newCookie);

        System.out.println(driver.manage().getCookieNamed("customName"));

// Get all cookies
        Set<Cookie> cookies = driver.manage().getCookies();

        System.out.println(cookies.toString());

//// Delete a cookie by name
//        driver.manage().deleteCookieNamed("customName");
//
//// Delete all cookies
//        driver.manage().deleteAllCookies();

        closeDriver();
    }
}
