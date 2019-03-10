package com.epam.atm.utils;

import java.util.concurrent.TimeUnit;

public class WebDriverSingleton {

    private static Browser browser;
    private WebDriverSingleton() {
    }

    public static Browser getWebDriverInstance() {
        String browserName = System.getProperty("browserName");
        WebDriverCreator creator;

        if (browserName == null)
            browserName = "c"; //this is to run test on Android, use "chrome" to run it on chrome, etc.

        if (browserName.equals("chrome"))
            creator = new ChromeDriverCreator();
        else if (browserName.equals("firefox"))
            creator = new FirefoxDriverCreator();
        else
            creator = new AndroidDriverCreator();

        if (browser == null) {
            //System.setProperty("webdriver.chrome.driver", "C:\\Users\\Nataha\\Desktop\\AT_CDP\\WebDriver\\chromedriver.exe");
            browser = new Browser(creator.createWebDriver());
            browser.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
            //browser.manage().window().maximize();
        }
        return browser;
    }
    public static void kill(){
        if(browser != null){
            browser.quit();
            browser = null;
       }
    }
}

/*System.setProperty("webdriver.chrome.driver", "C:\\Users\\Nataha\\Desktop\\AT_CDP\\WebDriver\\chromedriver.exe");
 *DesiredCapabilities capabilities = DesiredCapabilities.chrome();
 *driver = new ChromeDriver(capabilities);
 *driver = new CustomDriverDecorator(driver); - acc.to lecture
 */

