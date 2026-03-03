package stepDefinitions;

import io.cucumber.java.BeforeAll;
import io.cucumber.java.AfterAll;
import utils.Base;

public class Hooks {

    @BeforeAll
    public static void setUp() {
        Base.getDriver(); // start browser once before all scenarios
    }

    @AfterAll
    public static void tearDown() {
        Base.quitDriver(); // quit browser once after all scenarios
    }
}
