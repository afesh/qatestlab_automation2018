import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static java.lang.Thread.*;

public class DZ2 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = initChromeDriver();
        driver.get("http://prestashop-automation.qatestlab.com.ua/admin147ajyvk0/");
        driver.findElement(By.id("email")).sendKeys("webinar.test@gmail.com");
        driver.findElement(By.id("passwd")).sendKeys("Xcg7299bnSmMuRLp9ITw");
        driver.findElement(By.name("submitLogin")).click();
        pauseBetweenSteps();
        driver.findElement(By.id("tab-AdminDashboard")).click();
        pauseBetweenSteps();
        driver.navigate().refresh();
        pauseBetweenSteps();



        // Clicking menu

        driver.findElement(By.id("subtab-AdminParentOrders")).click();
        checkB(driver);


        driver.findElement(By.id("subtab-AdminCatalog")).click();
        checkB(driver);


        driver.findElement(By.xpath("/html/body/nav/ul/li[5]/a")).click();
        checkB(driver);

        driver.findElement(By.xpath("//*[@id='subtab-AdminParentCustomerThreads']/a/span")).click();
        checkB(driver);

        driver.findElement(By.xpath("//*[@id=\'subtab-AdminStats\']/a/span")).click();
        checkB(driver);

        driver.findElement(By.xpath("//*[@id=\'subtab-AdminParentModulesSf\']/a/span")).click();
        checkB(driver);

        driver.findElement(By.xpath("/html/body/nav/ul/li[9]/a")).click();
        checkB(driver);

        driver.findElement(By.xpath("/html/body/nav/ul/li[10]/a/span")).click();
        checkB(driver);

        driver.findElement(By.xpath("//*[@id=\"subtab-AdminParentShipping\"]/a/span")).click();
        checkB(driver);

        driver.findElement(By.xpath("//*[@id=\'subtab-AdminParentPayment\']/a/span")).click();
        checkB(driver);

        driver.findElement(By.xpath("//*[@id=\'subtab-AdminInternational\']/a/span")).click();
        checkB(driver);

        driver.findElement(By.cssSelector("#subtab-ShopParameters > a")).click();
        checkB(driver);

        driver.findElement(By.cssSelector("#subtab-AdminAdvancedParameters > a")).click();
        checkB(driver);
        driver.close();

    }
    public static void  pauseBetweenSteps() throws InterruptedException {
        Thread.sleep(1000);
    }

    private static void checkB(WebDriver driver) throws InterruptedException {
        String Menu1 = driver.getCurrentUrl();
        refreshUrl(driver);
        String Menu2 = driver.getCurrentUrl();
        pageCheck(Menu1, Menu2);
    }

    private static void pageCheck(String m1, String m2) {
        if (!m1.equals(m2)) {
            System.out.println(m1);
            System.out.println(m2);
            System.out.println("Error! Pages before reboot and after reboot are not equal ");
        }
    }

    private static void refreshUrl(WebDriver driver) throws InterruptedException {
        Thread.sleep(1000);
        driver.navigate().refresh();
        Thread.sleep(5000);
        System.out.println("Title name is : "+ driver.getTitle());

    }


    public static WebDriver initChromeDriver() {
        System.setProperty("webdriver.chrome.driver", DZ2.class.getResource("chromedriver.exe").getPath());
        return new ChromeDriver();
    }



}
