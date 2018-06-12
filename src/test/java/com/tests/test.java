package com.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class test {
		WebDriver driver = null;
		@BeforeTest
		public void setUp()
		{
			System.setProperty("webdriver.chrome.driver","D:\\chrome\\chromedriver.exe");
		    driver = new ChromeDriver();
		    driver.manage().window().maximize();
		    driver.get("http://www.calculator.net/bmi-calculator.html");
		}		
		@Test
		public void TC1()
		{
			driver.findElement(By.id("cage")).clear();
		    driver.findElement(By.id("cage")).sendKeys("27");
		    driver.findElement(By.id("csex1")).click();
		    driver.findElement(By.id("cheightfeet")).clear();
		    driver.findElement(By.id("cheightfeet")).sendKeys("7");
		    driver.findElement(By.id("cheightinch")).clear();
		    driver.findElement(By.id("cheightinch")).sendKeys("20");
		    driver.findElement(By.id("cpound")).clear();
		    driver.findElement(By.id("cpound")).sendKeys("200");
		    driver.findElement(By.xpath("//*[@id=\"content\"]/div[3]/div[2]/table[4]/tbody/tr/td[1]/input[2]")).click();
		}
		@AfterTest
		public void tearDown()
		{
			driver.close();
		}
}
