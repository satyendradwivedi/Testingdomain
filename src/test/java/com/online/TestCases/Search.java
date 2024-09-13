package com.online.TestCases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import com.online.POM.*;

public class Search extends Base{
	
	Login ls;
	
	@Test
	public void searchCourse()
	{
		ls=new Login(driver);
		ls.login(email, pwd);
	WebElement search=	driver.findElement(By.xpath("//input[@id='u368-search-form-autocomplete--3']"));
	String course="Cypress";
	search.sendKeys(course);
	List<WebElement> list=search.findElements(By.xpath("//ul[@id='u368-search-form-autocomplete--3-menu-content-items']/li"));
	for (WebElement result : list) {
        System.out.println(result.getText());
    }

    // Click on the first link that contains "cypress io"
    for (WebElement result : list) {
        if (result.getText().contains("cypress io")) {
            result.click();
            break;
        }
    }
	}
	

}
