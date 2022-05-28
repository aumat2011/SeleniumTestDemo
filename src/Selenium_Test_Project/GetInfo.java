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


        System.setProperty("webdriver.chrome.driver", "C:\\Users\\ugur_\\Downloads\\chromedriver.exe\\");

        WebDriver driver = new ChromeDriver(options);

        driver.get("https://www.amazon.com.tr/Yeni-Ba%C5%9Flayanlar-Nesne-Tabanl%C4%B1-Programlama/dp/6059129005/" +
                "ref=asc_df_6059129005/?tag=trshpngglede-21&linkCode=df0&hvadid=510284706652&hvpos=&hvnetw=g&hvrand=" +
                "5121728162433850325&hvpone=hvptwo=&hvqmt=&hvdev=c&hvdvcmdl=&hvlocint=&hvlocphy=1012763&hvtargid=pla-787071559881&psc=1");

        WebElement button = driver.findElement(By.xpath("//*[@id=\"sp-cc-accept\"]"));
        button.click();
        driver.navigate().refresh();
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        WebElement priceAmazon = driver.findElement(By.xpath("//*[@id=\"a-autoid-1-announce\"]/span[2]/span"));
        String price1 = priceAmazon.getText();
        String magazaAmazon = "amazon.com.tr";

        System.out.println(magazaAmazon + ": "+ price1);

        driver.get("https://www.idefix.com/Kitap/Yeni-Baslayanlar-Icin-C-ile-Nesne-Tabanli-Programlama/Fahrettin-Erdinc/" +
                "Egitim-Basvuru/Bilgisayar/urunno=0000000633351?gclid=Cj0KCQjw1ZeUBhDyARIsAOzAqQIaqzYXrfj2niZkhsU17D5JKQxQOphD01Bu-" +
                "-hY_mhuY9rxG9cErYYaAkoEEALw_wcB&gclsrc=aw.ds");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        WebElement priceIdefix = driver.findElement(By.xpath("//*[@id=\"salePrice\"]"));
        String price2 = priceIdefix.getText();
        String magazaIdefix = "idefix.com.tr";
        System.out.println(magazaIdefix + ": "+ price2);

        driver.get("https://www.kitapsepeti.com/c-ile-nesne-tabanli-programlama?gclid=" +
                "Cj0KCQjw1ZeUBhDyARIsAOzAqQKo7seQxBVTaKZd4oQo93t4REUIX8wOQKX164n6F6lgGGm9_n0ZL1waAh64EALw_wcB");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        WebElement priceKitapSepeti = driver.findElement(By.xpath("//*[@id=\"prd_final_price_display\"]"));
        String price3 = priceKitapSepeti.getText();
        String magazaKitapsepeti = "kitapsepeti.com.tr";
        System.out.println(magazaKitapsepeti + ": "+ price3);

        driver.close();

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

        Reporting(magazaAmazon, magazaIdefix, magazaKitapsepeti, priceAmazon1, priceIdefix1, arrPrice);

    }

    private static void Reporting(String magazaAmazon, String magazaIdefix, String magazaKitapsepeti, float priceAmazon1, float priceIdefix1, float[] arrPrice) {
        if(arrPrice[0] == priceAmazon1)
        {
            System.out.println("En uygun fiyat : "+ magazaAmazon +" "+ arrPrice[0]);
        }
        else if(arrPrice[0] == priceIdefix1)
        {
            System.out.println("En uygun fiyat : "+ magazaIdefix +" "+ arrPrice[0]);
        }
        else
        {
            System.out.println("En uygun fiyat : "+ magazaKitapsepeti +" "+ arrPrice[0]);
        }

        if(arrPrice[1] == priceAmazon1)
        {
            System.out.println("İkinci en uygun fiyat : "+ magazaAmazon +" "+ arrPrice[1]);
        }
        else if(arrPrice[1] == priceIdefix1)
        {
            System.out.println("İkinci en uygun fiyat : "+ magazaIdefix +" "+ arrPrice[1]);
        }
        else
        {
            System.out.println("İkinci en uygun fiyat : "+ magazaKitapsepeti +" "+ arrPrice[1]);
        }

        if(arrPrice[2] == priceAmazon1)
        {
            System.out.println("En pahalı fiyat : "+ magazaAmazon +" "+ arrPrice[2]);
        }
        else if(arrPrice[2] == priceIdefix1)
        {
            System.out.println("En pahalı fiyat : "+ magazaIdefix +" "+ arrPrice[2]);
        }
        else
        {
            System.out.println("En pahalı fiyat : "+ magazaKitapsepeti +" "+ arrPrice[2]);
        }
    }

}
