import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static java.lang.Thread.*;

public class DZ1 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = initChromeDriver();
        driver.get("http://prestashop-automation.qatestlab.com.ua/admin147ajyvk0/");
        driver.findElement(By.id("email")).sendKeys("webinar.test@gmail.com");
        driver.findElement(By.id("passwd")).sendKeys("Xcg7299bnSmMuRLp9ITw");
        driver.findElement(By.name("submitLogin")).click();
        pauseBetweenSteps();
        driver.findElement(By.id("header_employee_box")).click();
        pauseBetweenSteps();
        driver.findElement(By.id("header_logout")).click();
        pauseBetweenSteps();
        driver.close();


    }

   public static void  pauseBetweenSteps() throws InterruptedException {
        Thread.sleep(1000);
    }

    public static WebDriver initChromeDriver() {
        System.setProperty("webdriver.chrome.driver", DZ1.class.getResource("chromedriver.exe").getPath());
        return new ChromeDriver();
    }
}
