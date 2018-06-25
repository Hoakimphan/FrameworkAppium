package com.tests;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.modules.VNW_Functions;
import com.untils.AndroidSupports;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileBrowserType;
import io.appium.java_client.remote.MobileCapabilityType;

public class VNW_Tests {
	//private String city = "Ho Chi Minh";
	AndroidSupports as = new AndroidSupports();
	VNW_Functions fun = new VNW_Functions();
	@BeforeTest
	public void setUpAndroid() throws MalformedURLException
	{
		as.setUp();
	}
	@Test
//	public void SearchJob() throws InterruptedException
//	{
//		driverAn.findElement(By.id("com.android.packageinstaller:id/permission_allow_button")).click();
//		driverAn.getClass();
//		driverAn.findElement(By.id("com.vietnamworks.vietnamworks:id/mainedit")).sendKeys("Tester");
//		driverAn.findElement(By.id("com.vietnamworks.vietnamworks:id/location")).click();
//		//driverAn.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Ho Chi Minh\"));");
//		//driverAn.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+city+"\"));");	
//		driverAn.findElement(By.id("com.vietnamworks.vietnamworks:id/main_edit")).sendKeys("Ho chi minh");
//		//click to select location
//		//driverAn.findElement(By.xpath("//android.widget.ListView[@index='3']//android.widget.LinearLayout[@index='0']")).click();
//		driverAn.findElementById("com.vietnamworks.vietnamworks:id/main").click();
//		//click on find job button
//		driverAn.findElement(By.id("com.vietnamworks.vietnamworks:id/find_btn")).click();	
//		Thread.sleep(3000);
//		as.takeScreenShot(driverAn);
//	}
	public void TC001()
	{
		fun.allow();
		fun.job("Tester");
		fun.selectLocation();
		fun.typeLocation("Ho Chi Minh");
		fun.clickLocation();
		fun.findJob();
		fun.takeScreenShots();
	}
//	@AfterTest
//	public void TearDown()
//	{
//		fun.closeApp();
//	}
}
