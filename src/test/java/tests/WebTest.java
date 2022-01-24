package tests;

import io.qameta.allure.Description;
import org.junit.BeforeClass;
import org.junit.Test;
import java.io.IOException;
import java.net.MalformedURLException;
import pages.PasswordPage;
import util.PropertyManager;
import pages.FirstPage;
import pages.InboxPage;
import pages.LoginPage;

public class WebTest {	
	
	public static FirstPage firstPage;
	public static LoginPage loginPage;
	public static PasswordPage passwordPage;
	public static InboxPage inboxPage;
	private String login;
	private String passw;
	private String url;
	private String whoom;
	private String topic;
	private String topicForCount;	
	    
	@BeforeClass
	public static void setup() throws MalformedURLException {   

		firstPage = new FirstPage();
		loginPage = new LoginPage();
		passwordPage = new PasswordPage();
		inboxPage = new InboxPage();		
	}
		
    @Test
    @Description("���� ��� �������� ����� gmail ����� selenium")
    public void open() throws IOException {
    	url = PropertyManager.getInstance().getUrl();    	
    	login = PropertyManager.getInstance().getLogin();
    	passw = PropertyManager.getInstance().getPassword();
    	whoom = PropertyManager.getInstance().getWhoom();
    	topic = PropertyManager.getInstance().getTopic();
    	topicForCount = PropertyManager.getInstance().getTopicForCount();
    	firstPage.openPageRedirectAndCheck(url);              
    	loginPage.openLoginPageRedirectAndCheck(login);
    	passwordPage.openPasswordPageRedirectAndCheck(passw);        
    	inboxPage.writeLetter(whoom, topic, inboxPage.findLetters(topicForCount));
     }       
}
	
	
	
	