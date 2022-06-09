package PomClasses;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import UtilClasses.UtilityClass;

public class Home_Page extends UtilityClass{
	
	WebDriver driver;
	
	@FindBy(xpath="//div[@class='valign-wrapper']/div")
	private WebElement profileIcon;
	
	@FindBy(xpath="//p[@class='truncate headerDggnd']")
	private WebElement profileEmail;
	
	@FindBy(xpath="//div[@class=\"valign-wrapper balance-wrap\"]")
	private WebElement fundButton;
	
	
	
	
	
	public Home_Page(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	
	public void clickOnProfile()
	{
		expliciteWait(driver, profileIcon);
		profileIcon.click();
	}
	
	public boolean verifyUser() throws IOException
	{
		
		WebElement element = expliciteWait(driver, profileEmail);
		
		String emailFromUI = element.getText().trim();
		
		String emailFromConfig = getDataFromPropertyFile("email");
		
		if(emailFromUI.equals(emailFromConfig))
		{
			return true;
		}
		
		return false;
	}
	
	public void clickOnFundButton()
	{
		fundButton.click();
	}

}
