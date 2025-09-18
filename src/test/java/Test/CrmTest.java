package Test;


import Test1.CRM;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;



public class CrmTest {

    private WebDriver driver = null;
    private CRM crm;


    @Before
    public void SetUp(){
       WebDriverManager.chromedriver().setup();
        /*ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");*/
        driver = new ChromeDriver();

    }

    @Test
    public void TestLogin(){
        driver.get("https://classic.crmpro.com/index.html");
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.findElement(By.name("username")).sendKeys("ksheerabdinatha");
        driver.findElement(By.name("password")).sendKeys("Marusheka@4315");
        driver.findElement(By.xpath("//input[@type='submit']")).click();

        WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.titleContains("CRMPRO"));


        driver.switchTo().frame("mainpanel");
        driver.findElement(By.xpath("//a[@title='Contacts']")).click();



        driver.findElement(By.xpath("//a[@title='Deals']")).click();


        driver.findElement(By.xpath("//a[@title='Contacts']")).click();
        /*driver.findElement(By.xpath("//*[@id=\"vContactsForm\"]/table/tbody/tr[6]/td[1]/input")).click();*/

        driver.findElement(By.xpath("//a[text()='Test1 Lastname1']//parent::td[@class='datalistrow']//preceding-sibling::td[@class='datalistrow']//input[@name='contact_id']")).click();




    }

    /*@Test
    public void TestLogin1(){

        driver.get("https://www.google.com/");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//*[@id=\"L2AGLb\"]/div")).click();
        driver.findElement(By.xpath("//textarea[@id='APjFqb']")).sendKeys("testing");
        List<WebElement> list = driver.findElements(By.xpath("//ul[@role='listbox']//li/descendant::div[@class='lnnVse']"));
        System.out.println("Total no of suggestions in search box::: " + list.size());

    }*/
    @Test
    public void TestLogin1() {
        driver.get("https://www.google.com/");
        driver.manage().window().maximize();

        // Accept cookies
        driver.findElement(By.xpath("//*[@id=\"L2AGLb\"]/div")).click();

        // Enter search text
        driver.findElement(By.xpath("//textarea[@id='APjFqb']")).sendKeys("testing");

        // Wait for listbox
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@role='listbox']")));

        // Get all suggestions (raw count, may include hidden ones)
        List<WebElement> rawList = driver.findElements(By.xpath("//ul[@role='listbox']//li//span"));
        System.out.println("Raw count from DOM::: " + rawList.size());

        // Filter only visible suggestions
   /*     List<WebElement> visibleList = rawList.stream()
                .filter(WebElement::isDisplayed)
                .toList();*/




        /*for (WebElement suggestion : visibleList) {
            System.out.println(suggestion.getText());
        }*/

        /*for(int i=0; i< rawList.size(); i++){
            System.out.println(rawList.get(i).getText());
            if(rawList.get(i).getText().contains("testing eggs for freshness")){
                rawList.get(i).click();
                break;
            }

        }*/
    }

    /*@Test
    public void selectSpecificDate() {
        driver.get("https://classic.crmpro.com/index.html");
        driver.manage().window().maximize();

        // Login
        driver.findElement(By.name("username")).sendKeys("ksheerabdinatha");
        driver.findElement(By.name("password")).sendKeys("Marusheka@4315");
        driver.findElement(By.xpath("//input[@type='submit']")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Navigate to calendar
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Calendar')]"))).click();

        // Switch to frame
        driver.switchTo().frame("mainpanel");

        String targetDay = "18";
        String targetMonth = "May";
        String targetYear = "2025";

        // Select month
        Select monthSelect = new Select(driver.findElement(By.xpath("//select[@name='slctMonth']")));
        monthSelect.selectByVisibleText(targetMonth);

        // Select year
        Select yearSelect = new Select(driver.findElement(By.xpath("//select[@name='slctYear']")));
        yearSelect.selectByVisibleText(targetYear);

        // Wait for calendar to refresh and select the day
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@class,'loading')]")));

        // Click on the specific day
        WebElement dayElement = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//td[contains(@class,'calendarday') and text()='" + targetDay + "']")));
        dayElement.click();

        System.out.println("Successfully selected: " + targetMonth + " " + targetDay + ", " + targetYear);

        driver.switchTo().defaultContent();
    }*/





}
