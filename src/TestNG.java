
import org.testng.annotations.*;

public class TestNG
{
    @BeforeClass
    void beforeClass()
    {
        System.out.println("This will execute before class");
    }

    @AfterClass
    void afterClass()
    {
        System.out.println("This will execute after class");
    }

    @BeforeMethod
    void beforeMethod()
    {
        System.out.println("This will execute before every method");
    }

    @AfterMethod
    void afterMethod()
    {
        System.out.println("This will execute after every method");
    }

    @BeforeTest
    void beforeTest()
    {
        System.out.println("This will execute before test");
    }

    @AfterTest
    public void afterTest()
    {
        System.out.println("This will execute after test");
    }

    @Test(priority=1)
    void setup()
    {
        System.out.println("opening browser");
    }

    @Test(priority=2)
    void login()
    {
        System.out.println("login test");
    }

    @Test(priority=3)
    void teardown()
    {
        System.out.println("closing browser");
    }

    @BeforeSuite
    void beforeSuit()
    {
        System.out.println("This will execute before the Test Suite");
    }

    @AfterSuite
    void afterSuite()
    {
        System.out.println("This will execute after the Test Suite");
    }

}
