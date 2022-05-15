package Selenium_Test_Project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.Set;

public class Test {
    public static void main(String[] Args){

        System.setProperty("webdriver.chrome.driver","C:\\Users\\ugur_\\Downloads\\chromedriver.exe\\");
        WebDriver driver = new ChromeDriver();
        //driver.get("https://www.webaslan.com/");
        //driver.quit();

        driver.get("https://artoftesting.com/sampleSiteForSelenium");
        WebElement textbox = driver.findElement(By.id("fname"));
        textbox.sendKeys("Deneme");

        WebElement button = driver.findElement(By.id("idOfButton"));
        button.click();

        WebElement text = driver.findElement(By.id("dblClkBtn"));
        String a = text.getText();
        System.out.println(a);

    }
}
