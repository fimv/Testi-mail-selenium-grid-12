package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.net.MalformedURLException;

public class LoginPage extends BasePage {		 
	
    public LoginPage() throws MalformedURLException {
		super();		
	}

	/**
    * определение локатора поля ввода логина
    */	 
    @FindBy(xpath = "//*[contains(@id, 'identifierId')]")    
    private WebElement loginField;    
        
    /**
     * определение локатора кнопки входа в аккаунт
     */  
    @FindBy(xpath = "//*[@id=\"identifierNext\"]/div/button/span")
    private WebElement loginBtn;	
    
    /**
     * метод для ввода логина
     */
    @Step("Вводим логин")    
    public void inputLogin(String login) {      	
        loginField.sendKeys(login);
    }          
    
    /**
     * метод для осуществления нажатия кнопки далее для перехода на страницу ввода пароля
     */
    @Step("Нажимаем кнопку Далее на странице ввода логина")  
    public void clickLoginBtn() {    	
    	loginBtn.click(); 
    } 
    
    @Step("Открываем страницу ввода логина и переходим на страницу ввода пароля")
    public void openLoginPageRedirectAndCheck(String login) {    	
    	inputLogin(login);  
    	clickLoginBtn();    	
    }
}

