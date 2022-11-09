package anhtester.com.ThucHanh;

import anhtester.com.common.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;

public class ClientCRM extends BaseTest {

    //Login to CRM system
    public static void signinCRM() {
        driver.get("https://rise.fairsketch.com/signin");
        driver.findElement(By.xpath("//input[@id='email']")).clear();
        driver.findElement(By.xpath("//input[@id='password']")).clear();
        sleep(1);
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("admin@demo.com");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("riseDemo");
        driver.findElement(By.xpath("//button[normalize-space()='Sign in']")).click();
    }

    //Open Client page
    public static void openClientPage() {
        sleep(2);
        driver.findElement(By.xpath("//span[normalize-space()='Clients']")).click();
        sleep(2);
        driver.findElement(By.xpath("//div[@id='page-content']//a[normalize-space()='Clients']")).click();
        sleep(1);
    }

    //Enter data on Add Client dialog
    public static void enterDataAddClient(String clientName) {
        driver.findElement(By.xpath("//a[normalize-space()='Add client']")).click();
        sleep(2);
        driver.findElement(By.xpath("//input[@id='company_name']")).sendKeys(clientName);
        driver.findElement(By.xpath("//div[@id='s2id_created_by']")).click();
        sleep(1);
        driver.findElement(By.xpath("//div[@id='select2-drop']//input")).sendKeys("Sara Ann", Keys.ENTER);
        driver.findElement(By.id("address")).sendKeys("DHĐT");
        driver.findElement(By.id("city")).sendKeys("Cao Lãnh");
        driver.findElement(By.id("state")).sendKeys("Đồng Tháp");
        driver.findElement(By.id("zip")).sendKeys("81000");
        driver.findElement(By.id("country")).sendKeys("Việt Nam");
        driver.findElement(By.id("phone")).sendKeys("123456789");
        driver.findElement(By.id("website")).sendKeys("https://anhtester.com");

        //Cuộn chuột đến element Label ở cuối để thấy được các element bị che
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(false);", driver.findElement(By.xpath("//label[normalize-space()='Disable online payment']")));

        driver.findElement(By.id("vat_number")).sendKeys("0");

        driver.findElement(By.xpath("//div[@id='s2id_group_ids']")).click();
        driver.findElement(By.xpath("//div[@id='s2id_group_ids']//input")).sendKeys("VIP", Keys.ENTER);

        sleep(1);
        driver.findElement(By.xpath("//button[normalize-space()='Save']")).click();
    }

    //Search Client after Added
    public static void checkClientAfterAdded(String clientName) {
        sleep(2);
        driver.findElement(By.xpath("//div[@id='client-table_filter']//input")).sendKeys(clientName);
        sleep(2);
        String clientNameInTable = driver.findElement(By.xpath("//table[@id='client-table']//tbody//tr[1]/td[2]")).getText();
        System.out.println(clientNameInTable);

    }

    //Kiểm tra Month name và click chọn Ngày hệ thống HRM
    public static void checkMonthName(String monthName, String dayNumber) {
        for (int i = 1; i <= 12; i++) {
            sleep(1);
            String getMonthName = driver.findElement(By.xpath("//div[@class='dtp-date']//div[contains(@class, 'dtp-actual-month')]")).getText();
            if (getMonthName.equals(monthName)) {
                //Click chọn Ngày
                driver.findElement(By.xpath("//a[normalize-space()='" + dayNumber + "']")).click();
                break; //Thoát vòng lặp
            }
            driver.findElement(By.xpath("(//div[@class='dtp-date']//div[contains(@class, 'right center')])[1]")).click();
        }
    }

    public static void main(String[] args) {
        createDriver();

        signinCRM();
        openClientPage();
        enterDataAddClient("Anh Tester");
        checkClientAfterAdded("Anh Tester");

        closeDriver();
    }

}
