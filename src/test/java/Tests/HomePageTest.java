package Tests;

import Pages.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;


import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



public class HomePageTest {
    private static final Logger logger = Logger.getLogger(HomePageTest.class);
    private WebDriver driver = null;
    private HomePage homePage;

    @Before

    public void setUp() {
        logger.info("Setting up ChromeDriver");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        homePage = new HomePage(driver);


    }

    @Test
    public void testHomePageLogin() {
        logger.info("Jobserve website");
        driver.get("https://jobserve.com/gb/en/Job-Search/");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//*[@id=\"PolicyOptInLink\"]")).click();
        driver.findElement(By.id("loginMnu")).click();
        WebElement signIn = driver.findElement(By.xpath("//*[@id=\"mnuouter\"]/ul[2]/li/ul/li[1]/a"));
        signIn.click();
        homePage.goToHomePage();
    }
    @After
    public void cleanUp(){
        logger.info("performing clean up");
        driver.quit();
    }



}
