package anhtester.com.Bai8_CheckboxRadioDropdown;

import anhtester.com.common.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HandleCheckbox extends BaseTest {
    public static void main(String[] args) {
        createDriver();

        driver.get("https://demo.seleniumeasy.com/basic-checkbox-demo.html");

        //Kiểm tra checkbox mặc định
        WebElement checkboxOne = driver.findElement(By.xpath("//input[@id='isAgeSelected']"));
        boolean checkboxStatusBefore = checkboxOne.isSelected();
        System.out.println(checkboxStatusBefore);

        //Nếu checkbox chưa chọn (false) thì click chọn
        if (checkboxStatusBefore == false) {
            checkboxOne.click();
        }

        //Kiểm tra lại kết quả sau khi click chọn
        sleep(1);
        boolean checkboxStatusAfter = checkboxOne.isSelected();
        System.out.println("Trạng thái Checkbox sau khi chọn: " + checkboxStatusAfter);

        //Kiểm tra thông báo liên quan với kết quả khi đã chọn
        sleep(1);
        WebElement message = driver.findElement(By.xpath("//div[@id='txtAge']"));
        System.out.println("Trạng thái Message: " + message.isDisplayed());
        System.out.println(message.getText());

        closeDriver();
    }
}
