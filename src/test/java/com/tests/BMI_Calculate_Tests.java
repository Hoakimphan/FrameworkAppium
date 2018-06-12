package com.tests;

import java.io.IOException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.datas.ReadFileExcel;
import com.modules.BMI_Calculate_Functions;

public class BMI_Calculate_Tests{
	BMI_Calculate_Functions calculatePage;
	@BeforeTest
	public void setUp()
	{
		calculatePage = new BMI_Calculate_Functions();
		calculatePage.launchPage();
//		System.setProperty("webdriver.chrome.driver","D:\\chrome\\chromedriver.exe");
	}
	@Test
	public void TC001() throws IOException
	{
		ReadFileExcel getData = new ReadFileExcel("D:\\Auto_Test\\DataTest.xlsx");
		String age = getData.readData("Sheet1", "Age", 2);
		String feet = getData.readData("Sheet1", "Feet", 2);
		String inches = getData.readData("Sheet1", "Inches", 2);
		String weight = getData.readData("Sheet1", "Weight", 2);
		calculatePage.Age(age);
		calculatePage.genderMale();
		calculatePage.HeightFeet(feet);
		calculatePage.HeightInches(inches);
		calculatePage.Weight(weight);
		calculatePage.Calculate();
	}
	@AfterTest
	public void tearDown()
	{
		calculatePage.closePage();
	}
}
