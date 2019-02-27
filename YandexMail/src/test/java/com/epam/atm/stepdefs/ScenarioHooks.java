package com.epam.atm.stepdefs;

import com.epam.atm.utils.Browser;
import com.epam.atm.utils.WebDriverSingleton;
import cucumber.api.java.After;

public class ScenarioHooks {
    Browser browser;

    @After("@logout")
    public void logOff() {
       WebDriverSingleton.kill();
    }
}
