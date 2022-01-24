package pages;

import io.qameta.allure.Step;

import java.net.MalformedURLException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;

public class InboxPage extends BasePage {	
	public InboxPage() throws MalformedURLException {
		super();		
	}	
      
    /**
     * ����������� �������� ������ "�������� ������"
     */
    @FindBy(xpath = "//*[@id=\":9x\"]/div/div")
    private WebElement WriteLetterBtn;		
    
    /**
     * ����������� �������� ���� ����
     */
    @FindBy(xpath = "//*[@id=\":gq\"]")
    private WebElement WhoomField;	
    
    /**
     * ����������� �������� ���� ���� ������
     */
    @FindBy(xpath = "//*[@id=\":g8\"] ")
    private WebElement TopicField;	
    
    /**
     * ����������� �������� ���� ����� ������
     */
    @FindBy(xpath = "//*[@id=\":he\"]")
    private WebElement TextField;	
    
    /**
     * ����������� �������� ���� ������ ���������
     */
    @FindBy(xpath = "//*[contains(text(), '���������')]/..")
    private WebElement SendBtn;
    
    /**
     * ����������� �������� ���� ������ �����
     */    
    @FindBy(xpath = "//*[contains(text(), '�����')]/..")
    private WebElement OutBtn;    
     
    @Step("������������ ���������� ����� � ����� {0}")  
    public String findLetters(String searchTopic) { 
    	final RemoteWebDriver chromeDriver = getChromeDriver();
    	final String xpath = "//*[contains(text(), '" + searchTopic + "')]";
    	final int xpathCount = chromeDriver.findElements(By.xpath(xpath)).size();  	
    	final String topicCount = String.valueOf(xpathCount);
    	return topicCount;        
    }    
    
    @Step("�������� �� ������ �������� ������")
    public void writeLetterBtn�lick() {    	
    	WriteLetterBtn.click(); 
    } 
       
    @Step("������ ��������� ������: ����, ����, ����� ������ {0}, {1}, {2} � �������� ������ ���������")
    public void topicWriteLetterBtn(String whoom, String topic, String topicForCount) {    	
    	WhoomField.sendKeys(whoom);
    	TopicField.sendKeys(topic);
    	TextField.sendKeys(topicForCount);     	
    	SendBtn.click(); 
    }  
    
    @Step("�������� �� ������ ����� �� ��������")
    public void clickOutBtn() {    	
    	OutBtn.click(); 
    }
    
    @Step("������� ���������� ��������� ���� ������ � ����� ")
    public void writeLetter(String whoom, String topic, String topicForCount) {
 	   writeLetterBtn�lick();   
 	   topicWriteLetterBtn(whoom, topic, topicForCount);
 	   clickOutBtn();   	   
    }
}



