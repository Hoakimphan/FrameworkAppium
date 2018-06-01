package com.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		    System.setProperty("webdriver.chrome.driver","D:\\chrome\\chromedriver.exe");
		    WebDriver driver = new ChromeDriver();
		    driver.get("http://www.facebook.com");
	

	}

}
