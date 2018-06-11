import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.Logs;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;
import java.util.concurrent.TimeUnit;
import static java.lang.Thread.*;


public class DZ3 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = initChromeDriver();


        EventFiringWebDriver efDriver = new EventFiringWebDriver(driver);
        myListener logSteps = new myListener();
        efDriver.register(logSteps);

        efDriver.navigate().to("http://prestashop-automation.qatestlab.com.ua/admin147ajyvk0/");
        efDriver.findElement(By.id("email")).sendKeys("webinar.test@gmail.com");
        efDriver.findElement(By.id("passwd")).sendKeys("Xcg7299bnSmMuRLp9ITw");
        efDriver.findElement(By.name("submitLogin")).click();
        pauseBetweenSteps();
        //driver.findElement(By.cssSelector(".link-levelone -active")).click();
        //driver.findElement(By.cssSelector(".submenu > ")).click();

      //  EventFiringWebDriver selenium = new EventFiringWebDriver(driver).register(eventListener);


        WebElement menu = driver.findElement(By.linkText("Каталог"));
        WebElement categories = driver.findElement(By.cssSelector("#subtab-AdminCategories > a"));
        Hover(driver, menu);
        HoverAndClick(driver, menu, categories);
        pauseBetweenSteps();
        efDriver.findElement(By.cssSelector("#page-header-desc-category-new_category")).click();
        efDriver.findElement(By.cssSelector("#name_1")).sendKeys("Очки виртуальной реальности");
        efDriver.findElement(By.cssSelector("#link_rewrite_1")).sendKeys("23312");
        efDriver.findElement(By.cssSelector("#category_form_submit_btn")).click();
        pauseBetweenSteps();
        driver.findElement(By.cssSelector(".icon-caret-down")).click();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        pauseBetweenSteps();
        driver.close();




    }

    public static WebDriver initChromeDriver() {
        System.setProperty("webdriver.chrome.driver", DZ3.class.getResource("chromedriver.exe").getPath());
        return new ChromeDriver();
    }

    public static void Hover(WebDriver driver, WebElement element){
        Actions action = new Actions(driver);
        action.moveToElement(element).perform();
    }

    public static void HoverAndClick(WebDriver driver, WebElement elementToHover, WebElement elementToClick){
        Actions action = new Actions(driver);
        action.moveToElement(elementToHover).click(elementToClick).build().perform();
    }

    public static void  pauseBetweenSteps() throws InterruptedException {
        Thread.sleep(3000);
    }


    public static class myListener extends AbstractWebDriverEventListener {
        public void afterNavigateTo (java.lang.String url, WebDriver driver) {
            System.out.println("Navigate to "+ url);
        }
        public void beforeClickOn(WebElement element, WebDriver selenium) {
            System.out.println("Hover over element");
        }
        public void afterClickOn(WebElement element, WebDriver driver) {
            System.out.println("afterClickOn");
        }
        public void afterChangeValueOf(WebElement element, WebDriver selenium) {
            System.out.println("Change value");
        }
        public void afterFindBy(By by, WebElement element, WebDriver selenium) {
            System.out.println("after find by");
        }
        public void afterNavigateBack(WebDriver selenium) {
            System.out.println("Navigate Back");
        }
        public void afterNavigateForward(WebDriver selenium) {
            System.out.println("After Navigate forvard");
        }
        public void beforeChangeValueOf(WebElement element, WebDriver selenium) {
            System.out.println("Send value to form");
        }
        public void beforeFindBy(By by, WebElement element, WebDriver selenium) {
            System.out.println("Before find by element" );
        }
        public void beforeNavigateBack(WebDriver selenium) {
            System.out.println("Before navigate back");
        }
        public void beforeNavigateForward(WebDriver selenium) {
            System.out.println("Before Navigate forward");
        }
        public void beforeNavigateTo(String url, WebDriver selenium) {
            System.out.println("Before navigate To" + url);
        }

        public void onException(Throwable error, WebDriver selenium) {
            System.out.println("Exception:" + error);
        }

    }
}
