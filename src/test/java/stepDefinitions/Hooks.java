package stepDefinitions;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import utils.Base;

public class Hooks {

    @BeforeClass
    public static void setUp() {
        Base.getDriver(); // start browser once before all scenarios
    }

    @AfterClass
    public static void tearDown() {
        Base.quitDriver(); // quit browser once after all scenarios
    }
}
