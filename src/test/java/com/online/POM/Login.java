package com.online.POM;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login {

	
WebDriver ldriver;
	
	public Login(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
		
	@FindBy(xpath="//input[@id='form-group--1']")
	@CacheLookup
	WebElement email;
	@FindBy(xpath="//input[@id='form-group--3']")
	@CacheLookup
	WebElement password;
	@FindBy(xpath="//button[@type='submit']//span[@class='ud-btn-label'][normalize-space()='Log in']")
	@CacheLookup
	WebElement login;
	
	public void login(String emailtext,String paswordtext) {
		email.sendKeys(emailtext);
		password.sendKeys(paswordtext);
		login.click();
	}
}
	
	