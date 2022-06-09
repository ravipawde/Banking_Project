package PomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import UtilClasses.UtilityClass;

public class Fund_Page extends UtilityClass{
	
	WebDriver driver;
	
	@FindBy(xpath="//div[text()='Balance available']")
	private WebElement fundAvailableText;
	
	@FindBy(xpath="//input[@id='wrs445Amount']")
	private WebElement amountInputField;
	
	@FindBy(xpath="//div[@id='amupNew89TransformDiv']/div")
	private WebElement amountConfirmText;
	
	@FindBy(xpath="//span[text()='DEPOSIT MONEY']")
	private WebElement depositButton;
	
	
	
	
	

	public Fund_Page(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	
	public boolean verifyFundPageLoaded()
	{
		WebElement element = expliciteWait(driver, fundAvailableText);
		
		String text = element.getText().trim();
		
		String dataFromExcel = "Balance available";
		
		if(text.equals(dataFromExcel))
		{
			return true;
		}
		
		return false;
	}
	
	public boolean enterDepositAmount()
	{
		amountInputField.clear();
		String amountToEnter = "500";
		
		amountInputField.sendKeys(amountToEnter);
		
		depositButton.click();
		
		WebElement element = expliciteWait(driver, amountConfirmText);
		
		double getEnteredAmout = Double.parseDouble(element.getText().split("₹")[1]);
		
		int k = (int) getEnteredAmout;
		
		System.out.println(k);
		
		if(amountToEnter.equals(String.valueOf(k)))
		{
			return true;
		}
		
		return false;
	}
	

	
	

}
