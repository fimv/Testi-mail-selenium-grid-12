package pages;

import io.qameta.allure.Step;
import org.junit.After;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BasePage {
    private static RemoteWebDriver chromeDriver;

    public BasePage() throws MalformedURLException {
        initWebDriver();
        PageFactory.initElements(chromeDriver, this);
    }

    public RemoteWebDriver getChromeDriver() {
        return chromeDriver;
    }

    private void initWebDriver() throws MalformedURLException  {
        if (chromeDriver == null) {
        	DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        	chromeDriver = new RemoteWebDriver(new URL("http://192.168.1.146:4444/wd/hub"), capabilities);
        	chromeDriver.manage().window().maximize();
        	chromeDriver.manage().timeouts().implicitlyWait(1L, TimeUnit.SECONDS);
        	chromeDriver.get( "auf ссылка");        	
        }
    }

    @Step("Переходим на страницу по ссылке {0}")
    public void goTo(String url) {
        chromeDriver.manage().window().maximize();
        chromeDriver.get(url);
    }    
   
    @After
    @Step("Закрываем браузер")
    public void closeBrowser() {
        if (chromeDriver != null) {
            chromeDriver.close();
            chromeDriver.quit();
        } 
    }           
}