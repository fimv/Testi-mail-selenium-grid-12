package pages;

import java.net.MalformedURLException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import io.qameta.allure.Step;

public class FirstPage extends BasePage {	
	
	public FirstPage() throws MalformedURLException {
		super();		
	}

	/**
     * определение локатора меню пользовател€
     */  	
    @FindBy(xpath = "//*[contains(text(), '¬ойти')]/..")   
    private WebElement firstloginBtn;        
    
    /**
     * метод дл€ нажати€ кнопки ¬ойти на первой странице g-mail
     */      
    public void clickFirstLoginBtn() {   
    	firstloginBtn.click(); 
    } 
    
    @Step("ќткрываем страницу gmail и переходим на страницу логина")
    public void openPageRedirectAndCheck(String goTo) {    
    goTo(goTo); 
    clickFirstLoginBtn();
    }   
}
