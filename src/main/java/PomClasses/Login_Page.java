package PomClasses;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import UtilClasses.UtilityClass;

public class Login_Page extends UtilityClass{
	
	WebDriver driver;
	
	@FindBy(xpath="//div[contains(@class,'btn51Btn')]")
	private WebElement loginButton;
	
	@FindBy(xpath="//input[@id='login_email1']")
	private WebElement email;
	
	@FindBy(xpath="//div[@class='absolute-center btn51ParentDimension']")
	private WebElement continue1;
	
	@FindBy(xpath="//input[@id='login_password1']")
	private WebElement password;
	
	@FindBy(xpath="//div[@class='col l12 leps592LoginButton']")
	private WebElement submitButton;
	
	@FindBy(xpath="(//input[@type='number'])[1]")
	private WebElement pinField;
	
	
	public Login_Page(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	
	public void clickOnLognButton()
	{
		loginButton.click();
	}
	
	
	public void enterEmail() throws IOException
	{
		expliciteWait(driver, email);
		email.sendKeys(getDataFromPropertyFile("email"));
	}
	
	public void clickOnContinue()
	{
		expliciteWait(driver, continue1);
		continue1.click();
	}
	
	public void enterPassword() throws IOException
	{
		expliciteWait(driver, password);
		password.sendKeys(getDataFromPropertyFile("password"));
	}
	
	public void clickOnSubmit()
	{
		expliciteWait(driver, submitButton);
		submitButton.click();
	}
	
	
	public void enterPin() throws IOException, InterruptedException
	{
		String pin = getDataFromPropertyFile("pin");
		
		char[] digit = pin.toCharArray();
		
		System.out.println(Arrays.toString(digit));
		
		Thread.sleep(4000);
		
		expliciteWait(driver, pinField);
		
		List<WebElement> elements = driver.findElements(By.xpath("//input[@type='number']"));
		
		for(int i=0; i<digit.length; i++)
		{
			elements.get(i).sendKeys(String.valueOf(digit[i]));
		}
	}
	
	
}
