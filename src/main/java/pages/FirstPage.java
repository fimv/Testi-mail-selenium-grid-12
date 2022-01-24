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
     * ����������� �������� ���� ������������
     */  	
    @FindBy(xpath = "//*[contains(text(), '�����')]/..")   
    private WebElement firstloginBtn;        
    
    /**
     * ����� ��� ������� ������ ����� �� ������ �������� g-mail
     */      
    public void clickFirstLoginBtn() {   
    	firstloginBtn.click(); 
    } 
    
    @Step("��������� �������� gmail � ��������� �� �������� ������")
    public void openPageRedirectAndCheck(String goTo) {    
    goTo(goTo); 
    clickFirstLoginBtn();
    }   
}
