package Selenium_Test_Project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;

public class GetInfo {
    //WebDriver driver1 = new ChromeDriver();
    //driver.get("https://www.webaslan.com/");
    // driver.quit();

    //        driver.get("https://artoftesting.com/sampleSiteForSelenium");
    //        WebElement textbox = driver.findElement(By.id("fname"));
    //        textbox.sendKeys("Deneme");
    //
    //        WebElement button = driver.findElement(By.id("idOfButton"));
    //        button.click();
    //
    //        WebElement text = driver.findElement(By.id("dblClkBtn"));
    //        String a = text.getText();
    //        System.out.println(a);

    public static void GetInfoWithSelenium()
    {
        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("profile.default_content_setting_values.notifications", 2);
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", prefs);


        System.setProperty("webdriver.chrome.driver", "C:\\Users\\necat\\Downloads\\chromedriver.exe\\");

        WebDriver driver1 = new ChromeDriver(options);

        driver1.get("https://www.amazon.com.tr/Yeni-Ba%C5%9Flayanlar-Nesne-Tabanl%C4%B1-Programlama/dp/6059129005/ref=asc_df_6059129005/?tag=" +
                "trshpngglede-21&linkCode=df0&hvadid=510284706652&hvpos=&hvnetw=g&hvrand=5121728162433850325&hvpone=&" +
                "hvptwo=&hvqmt=&hvdev=c&hvdvcmdl=&hvlocint=&hvlocphy=1012763&hvtargid=pla-787071559881&psc=1");

        WebElement button = driver1.findElement(By.xpath("//*[@id=\"sp-cc-accept\"]"));
        button.click();
        driver1.navigate().refresh();

        WebElement priceAmazon = driver1.findElement(By.xpath("//*[@id=\"a-autoid-2-announce\"]/span[2]/span"));

        String price1 = priceAmazon.getText();
        System.out.println(price1);
        driver1.close();

        WebDriver driver2 = new ChromeDriver(options);

        driver2.get("https://www.idefix.com/Kitap/Yeni-Baslayanlar-Icin-C-ile-Nesne-Tabanli-Programlama/Fahrettin-Erdinc/" +
                "Egitim-Basvuru/Bilgisayar/urunno=0000000633351?gclid=Cj0KCQjw1ZeUBhDyARIsAOzAqQIaqzYXrfj2niZkhsU17D5JKQxQOphD01Bu-" +
                "-hY_mhuY9rxG9cErYYaAkoEEALw_wcB&gclsrc=aw.ds");

        WebElement priceIdefix = driver2.findElement(By.xpath("//*[@id=\"salePrice\"]"));
        String price2 = priceIdefix.getText();
        System.out.println(price2);
        driver2.close();

        WebDriver driver3 = new ChromeDriver(options);

        driver3.get("https://www.kitapsepeti.com/c-ile-nesne-tabanli-programlama?gclid=" +
                "Cj0KCQjw1ZeUBhDyARIsAOzAqQKo7seQxBVTaKZd4oQo93t4REUIX8wOQKX164n6F6lgGGm9_n0ZL1waAh64EALw_wcB");

        WebElement priceKitapSepeti = driver3.findElement(By.xpath("//*[@id=\"prd_final_price_display\"]"));
        String price3 = priceKitapSepeti.getText();
        System.out.println(price3);

        driver3.close();

        price1 = price1.replace(",",".");
        price2 = price2.replace(",",".");
        price3 = price3.replace(",",".");

        float priceAmazon1 = Float.parseFloat(price1.substring(0, 5));
        float priceIdefix1 = Float.parseFloat(price2.substring(0, 5));
        float pricekitapSepeti1 = Float.parseFloat(price3.substring(0, 5));

        float arrPrice[] = new float[]{priceAmazon1, priceIdefix1, pricekitapSepeti1};

        int n = arrPrice.length;
        float temp = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (arrPrice[j - 1] > arrPrice[j]) {
                    //swap elements
                    temp = arrPrice[j - 1];
                    arrPrice[j - 1] = arrPrice[j];
                    arrPrice[j] = temp;
                }
            }
        }

        System.out.println("En uygun fiyat : " +arrPrice[0]);
        System.out.println("İkinci en uygun fiyat : " +arrPrice[1]);
        System.out.println("En pahalı fiyat : " +arrPrice[2]);
    }

}
