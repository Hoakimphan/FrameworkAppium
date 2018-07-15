package com.untils;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.remote.MobileCapabilityType;

public class AndroidSupports {
	AndroidDriver<AndroidElement> driverAn;
	Dimension size;
	
	int timeoutDefault = 30;
	String destDir;
	DateFormat dateFormat;
	public void setUp() throws MalformedURLException
	{
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "192.168.35.101:5555");
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "6.0");
		caps.setCapability("appPackage", "vn.tiki.app.tikiandroid");
		//caps.setCapability("appActivity", "vn.tiki.app.tikiandroid.ui.home.UniversalLinkDispatcherActivity");
		caps.setCapability("appActivity", "vn.tiki.app.tikiandroid.ui.SplashActivity");
		driverAn = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),caps);
		driverAn.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}
	public MobileElement getElement(How eHow, String eLocator) 
	{
		waitForElement(eHow, eLocator, timeoutDefault);
		switch (eHow) {
		case CLASS_NAME:
			return driverAn.findElementByClassName(eLocator);
		case ID:	
			System.out.println(driverAn.findElementById(eLocator));
			return driverAn.findElementById(eLocator);
		case NAME:
			return driverAn.findElementByName(eLocator);
		case XPATH:
			return driverAn.findElementByXPath(eLocator);
		case UNSET:
			break;
		}
		
		return null;
	}
	public void waitForElement(How eHow, String eLocator, int timeout)
	{
		switch (eHow) {
		case CLASS_NAME:
			new WebDriverWait(driverAn, timeout)
					.until(ExpectedConditions.visibilityOfElementLocated(By.className(eLocator)));
			break;
		case ID:
			new WebDriverWait(driverAn, timeout).until(ExpectedConditions.visibilityOfElementLocated(By.id(eLocator)));
			break;
		case ID_OR_NAME:
			new WebDriverWait(driverAn, timeout).until(ExpectedConditions.visibilityOfElementLocated(By.id(eLocator)));
			break;
		case NAME:
			new WebDriverWait(driverAn, timeout).until(ExpectedConditions.visibilityOfElementLocated(By.name(eLocator)));
			break;
		case XPATH:
			new WebDriverWait(driverAn, timeout).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(eLocator)));
			break;
		case UNSET:
			break;
		}
	}
	public void closeApp()
	{
		driverAn.quit();
	}
	public void click(How eHow, String eLocator) 
	{
		//Thread.sleep(6000);
		waitForElement(eHow, eLocator, timeoutDefault);
		getElement(eHow, eLocator).isDisplayed();
		getElement(eHow, eLocator).click();
	}
	public void fill(How eHow, String eLocator, String text) 
	{
		
		//waitForElement(eHow, eLocator, timeoutDefault);
		getElement(eHow, eLocator).isDisplayed();
		getElement(eHow, eLocator).clear();
		getElement(eHow, eLocator).sendKeys(text);
	}
	public void scrollByText(String key)
	{
		//waitForElement(eHow, eLocator, timeoutDefault);
		//getElement(eHow, eLocator).isDisplayed();
		driverAn.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+key+"\"));");	
	}
	public void dragAndDropFromAToB(String eLocator, int a, int b)
	{
		WebElement ele1 = (WebElement) driverAn.findElementsById(eLocator).get(a);
		WebElement ele2 = (WebElement) driverAn.findElementsById(eLocator).get(b);
		TouchAction action = new TouchAction((MobileDriver) driverAn);
		action.longPress(ele1).moveTo(ele2).release().perform();  
	}
	public void dragAndDropFromBToA(String eLocator, int a, int b)
	{
		WebElement ele1 = (WebElement) driverAn.findElementsById(eLocator).get(a);
		WebElement ele2 = (WebElement) driverAn.findElementsById(eLocator).get(b);
		TouchAction action = new TouchAction((MobileDriver) driverAn);
		action.longPress(ele2).moveTo(ele1).release().perform();  
	}
	public void takeScreenShot(AndroidDriver<MobileElement> driver)
	{
		destDir = "screenshots";
		//capture screenshot
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		//set data format to set it as screenshot file name
		dateFormat = new SimpleDateFormat("dd-MMM-yyyy__hh_mm_ssaa");
		//create folder under project with name "screenshots" provider to destDir
		new File(destDir).mkdirs();
		//set file name using current date time
		String destFile =  dateFormat.format(new Date())+".png";
		
		try
		{
			FileUtils.copyFile(srcFile, new File(destDir+"/"+destFile));
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	public void pressKey()
	{
		driverAn.pressKeyCode(AndroidKeyCode.KEYCODE_NUMPAD_ENTER );
	}
//	public void SwipeTab() 
//	{
//		size = driverAn.manage().window().getSize();
//		System.out.println(size);
//		int startx = (int) (size.width * 0.80);
//		int endx = (int) (size.width * 0.05);
//		int starty =  size.height/2;
//		//
//		driverAn.swipe(startx, starty, endx, starty, 3000);
//		
//	}
	
}
