package com.modules;

import org.openqa.selenium.support.How;

import com.objects.VNW_Page;
import com.untils.AndroidSupports;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class VNW_Functions extends VNW_Page{
	AndroidSupports supportAn = new AndroidSupports();
	private AndroidDriver<MobileElement> driverAn;
	public void allow()
	{
		supportAn.click(How.ID, VNW_BTN_ALLOW_LOCATION);
	}
	public void job(String key)
	{
		supportAn.fill(How.ID, VNW_TXT_JOB_NAME, key);
	}
	public void selectLocation()
	{
		supportAn.click(How.ID, VNW_SELECT_LOCATION);
	}
	public void typeLocation(String key)
	{
		supportAn.fill(How.ID, VNW_TXT_LOCATION_NAME, key);
	}
	public void clickLocation()
	{
		supportAn.click(How.ID, VNW_LOCATION_NAME);
	}
	public void findJob()
	{
		supportAn.click(How.ID, VNW_BTN_FIND_JOB);
	}
	public void closeApp()
	{
		supportAn.closeApp();
	}
	public void takeScreenShots()
	{
		supportAn.takeScreenShot(driverAn);
	}

}
