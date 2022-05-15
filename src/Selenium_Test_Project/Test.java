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
        driver.get("https://www.webaslan.com/");
        driver.quit();

    }
}
