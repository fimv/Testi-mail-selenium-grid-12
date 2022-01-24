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
    * ����������� �������� ���� ����� ������
    */	 
    @FindBy(xpath = "//*[contains(@id, 'identifierId')]")    
    private WebElement loginField;    
        
    /**
     * ����������� �������� ������ ����� � �������
     */  
    @FindBy(xpath = "//*[@id=\"identifierNext\"]/div/button/span")
    private WebElement loginBtn;	
    
    /**
     * ����� ��� ����� ������
     */
    @Step("������ �����")    
    public void inputLogin(String login) {      	
        loginField.sendKeys(login);
    }          
    
    /**
     * ����� ��� ������������� ������� ������ ����� ��� �������� �� �������� ����� ������
     */
    @Step("�������� ������ ����� �� �������� ����� ������")  
    public void clickLoginBtn() {    	
    	loginBtn.click(); 
    } 
    
    @Step("��������� �������� ����� ������ � ��������� �� �������� ����� ������")
    public void openLoginPageRedirectAndCheck(String login) {    	
    	inputLogin(login);  
    	clickLoginBtn();    	
    }
}

