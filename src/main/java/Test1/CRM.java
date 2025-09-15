package Test1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CRM {

    WebDriver driver;

    public CRM (WebDriver driver){
        this.driver=driver;
    }

    public void HomePage(){
    driver.get("https://classic.crmpro.com/index.html");
    driver.manage().window().maximize();
    driver.findElement(By.name("username"));
    driver.findElement(By.name("password"));
    }
}
