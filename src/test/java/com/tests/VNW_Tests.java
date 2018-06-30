package com.tests;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.How;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.modules.VNW_Functions;
import com.objects.VNW_Page;
import com.untils.AndroidSupports;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileBrowserType;
import io.appium.java_client.remote.MobileCapabilityType;

public class VNW_Tests extends VNW_Page {
	//private String city = "Ho Chi Minh";
	AndroidSupports supports = new AndroidSupports();
	VNW_Functions fun = new VNW_Functions();
	@BeforeTest
	public void setUpAndroid() throws MalformedURLException
	{
		supports.setUp();
	}
	@Test
	public void TC001()
	{
		supports.click(How.ID, VNW_BTN_ALLOW_LOCATION);
		supports.fill(How.ID, VNW_TXT_JOB_NAME, "Tester");
		supports.click(How.ID, VNW_SELECT_LOCATION);
		supports.fill(How.ID, VNW_TXT_LOCATION_NAME, "Ho chi minh");
		supports.click(How.ID, VNW_LOCATION_NAME);
		supports.click(How.ID, VNW_BTN_FIND_JOB);
		
	}
//	@AfterTest
//	public void TearDown()
//	{
//		fun.closeApp();
//	}
}
