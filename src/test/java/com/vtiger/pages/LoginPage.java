package com.vtiger.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.vtiger.common.CommonFunctions;

public class LoginPage {
	
	private WebDriver driver;
	private CommonFunctions cf;
	ExtentTest logger;
	
	public LoginPage(WebDriver driver,ExtentTest logger)
	{
		this.driver = driver;
		this.logger=logger;
		PageFactory.initElements(driver, this);
		cf = new CommonFunctions(driver,logger);
	}
	
	//By username = By.name("user_name");
	
	@FindBy(name="user_name")
	WebElement tb_username;
	
	@FindBy(name="user_password")
	WebElement tb_userpwd;
	
	@FindBy(name="Login")
	WebElement btn_Login;
	
	@FindBy(xpath="//*[contains(text(),'123You must specify a valid username and password.')]")
	WebElement txt_errorMsg;
	
	public void verifyErrorMsg()
	{
		cf.IsElementDisplay(txt_errorMsg,"Error message validated successfully");
	}
	
	
	public void login(String userid, String pwd)
	{
		
		setUserid(userid);
		setPassword(pwd);
		clickLogin();
	}
	
	public void setUserid(String userid)
	{
		cf.EnterValue(tb_username, userid,userid+" entered successfully into User Name field");
	}
	
	public void setPassword(String pwd)
	{
		cf.EnterValue(tb_userpwd, pwd,pwd+" entered successfully into Password field");
	}
	
	public void clickLogin()
	{
		cf.ClickElement(btn_Login,"Login button clicked successfully");
	}
	
	

}
