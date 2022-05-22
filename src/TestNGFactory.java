import org.testng.annotations.*;

public class TestNGFactory
{
    @Factory()
    public Object[] getTestClasses()
    {
        Object[] tests = new Object[2];
        tests[0]= new TestCaseTestNG();
        tests[1]= new Selenium_Test_Project.Test();
        return tests;
    }
}
