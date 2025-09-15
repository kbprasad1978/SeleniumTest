package Pages;



/*public class LoginPage {
   WebDriver driver;

   public LoginPage(WebDriver driver){
       this.driver = driver;
   }
}*/

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class HomePage {
    WebDriver driver;

    By cookieBtn = By.id("PolicyOptInLink");
    By loginMenu = By.id("loginMnu");
    By signIn = By.xpath("//*[@id=\"mnuouter\"]/ul[2]/li/ul/li[1]/a");

    public HomePage(WebDriver driver) {
        this.driver = driver;

       test this file to check if the build is triggered in Jenkins
    }

    public void goToHomePage(){
        driver.get("https://jobserve.com/gb/en/Job-Search/");
        driver.manage().window().maximize();
        driver.findElement(cookieBtn).click();
        driver.findElement(loginMenu).click();
        driver.findElement(signIn).click();

    }


}
