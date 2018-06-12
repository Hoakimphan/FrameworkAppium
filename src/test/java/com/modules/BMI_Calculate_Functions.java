package com.modules;

import org.openqa.selenium.support.How;

//import com.datas.ReadFileExcel;
import com.objects.BMI_Calculate_Page;
import com.untils.Supports;

public class BMI_Calculate_Functions extends BMI_Calculate_Page {
	Supports sup = new Supports();

	public void launchPage() {
		sup.readConfigs();
		sup.setUp();
		sup.get(URL);
		//sup.getApp().findElement(by); 
	}

	public void Age(String key) {
		sup.fill(How.XPATH, CALCULATE_TXT_AGE, key);
	}

	public void genderMale() {
		sup.click(How.XPATH, CALCULATE_RADIO_BTN_SEX_MALE);
	}

	public void genderFemale() {
		sup.click(How.XPATH, CALCULATE_RADIO_BTN_SEX_FEMALE);
	}

	public void HeightFeet(String key) {
		sup.fill(How.XPATH, CALCULATE_TXT_HEIGHT_FEET, key);
	}

	public void HeightInches(String key) {
		sup.fill(How.XPATH, CALCULATE_TXT_HEIGHT_INCHES, key);
	}

	public void Weight(String key) {
		sup.fill(How.XPATH, CALCULATE_TXT_WEIGHT, key);
	}

	public void Calculate() {
		sup.click(How.XPATH, CALCULATE_BTN);
	}

	public void closePage() {
		sup.closePage();
	}
}
