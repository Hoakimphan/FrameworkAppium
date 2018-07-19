package com.tests;

import java.net.MalformedURLException;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.How;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.objects.TIKI_Page;
import com.untils.AndroidSupports;

public class TIKI_Tests extends TIKI_Page{
	AndroidSupports supports = null;
	@BeforeTest
	public void setUp() throws MalformedURLException
	{
		supports = new AndroidSupports();
		supports.setUp();
	}
//	@Test
//	public void TC001() throws InterruptedException
//	{
//		supports.click(How.ID, TIKI_SEARCH_HOME_PAGE);
//		supports.fill(How.ID, TIKI_TXT_SEARCH, "son moi");
//		//supports.pressKey();
//		supports.click(How.ID, TIKI_SELECT_RESULT);
//		supports.click(How.XPATH, TIKI_PRODUCT);
//		//
//		supports.click(How.ID, TIKI_BTN_ADD_PRODUCT);
//		supports.click(How.ID, TIKI_BTN_VIEW_CART);
//		supports.click(How.ID, TIKI_BTN_GOT_IT);
//		//supports.click(How.ID, TIKI_BTN_INCREASE_NUMBER);
//		supports.click(How.ID, TIKI_BTN_CONTINUE_CHECKOUT);
//		//login
//		supports.fill(How.ID, TIKI_TXT_EMAIL_LOGIN, "hoakimphanbackup003@gmail.com");
//		supports.fill(How.ID, TIKI_TXT_PASSWORD_LOGIN, "hoacau123");
//		supports.click(How.ID, TIKI_BTN_LOGIN);
//		//Thread.sleep(6000);
////		supports.click(How.XPATH, TIKI_SELECT_REGISTER_TAB);
////		//supports.swipe();
////		supports.fill(How.ID, TIKI_TXT_FULL_NAME, "Quyết tâm đậu đồ án");
////		supports.fill(How.ID, TIKI_TXT_EMAIL, "kimhoa@gmail.com");
////		supports.fill(How.ID, TIKI_TXT_PASSWORD, "Hoahoa12345");
////		supports.click(How.ID, TIKI_BTN_EDIT_BIRTHDAY);
////		supports.click(How.ID, TIKI_BTN_FINISH_EDIT_BIRTHDAY);
////		supports.click(How.ID, TIKI_BTN_SELECT_GENDER);
////		supports.click(How.ID, TIKI_BTHoiN_REGISTER);
//		supports.click(How.ID, TIKI_BTN_CONTINUE_CHECKOUT);
//		supports.click(How.ID, TIKI_BTN_ADD_MORE_ADDRESS);
//		supports.fill(How.XPATH, TIKI_TXT_FULL_NAME_FOR_ORDER, "Co gang qua do an");//chua nhap duoc
//		supports.fill(How.ID, TIKI_TXT_PHONE_NUMBER, "01697900013");
//		//
//		supports.click(How.ID, TIKI_EDIT_CITY);
//		//
//		//supports.scrollByText(TIKI_SELECT_CITY);
//		supports.fill(How.ID, TIKI_TXT_CITY, "Hồ Chí Minh");
//		//Thread.sleep(4000);
//		supports.click(How.XPATH, TIKI_SELECT_CITY);//chua click dc
//		//
//		//supports.scrollByText(TIKI_SELECT_DISTRICT);
//		supports.fill(How.ID, TIKI_TXT_DISTRICT, "Thu Duc");
//		//Thread.sleep(4000);
//		supports.click(How.XPATH, TIKI_SELECT_DISTRICT);
//		//
//		//supports.scrollByText(TIKI_SELECT_WARD);
//		supports.click(How.XPATH, TIKI_SELECT_WARD);
//		supports.fill(How.ID, TIKI_TXT_ADDRESS, "So 1 Vo van ngan");
//		supports.click(How.ID, TIKI_CHECKBOX_COMPANY_ADDRESS);
//		supports.click(How.ID, TIKI_BTN_SAVE_ADDRESS);
//		supports.click(How.XPATH, TIKI_BTN_RADIO_SELECT_ADD_MORE_ADDRESS);
//		//supports.click(How.ID, TIKI_BTN_CONTINUE);
//		//supports.click(How.ID, TIKI_BTN_SAVE_ADDRESS);
//		//supports.click(How.ID, TIKI_SELECT_ADDRESS);
//		//supports.click(How.ID, TIKI_BTN_CONTINUE);
//		//supports.click(How.ID, TIKI_BTN_PAY);
//		supports.click(How.ID, TIKI_BTN_CONTINUE);
//		//supports.scrollByText("Thanh toán tiền mặt khi nhận hàng");
//		supports.click(How.XPATH, TIKI_SELECT_PAY_METHOD);
//		supports.click(How.ID, TIKI_BTN_CONTINUE);
//		supports.click(How.ID, TIKI_BTN_CHECK_OUT);
//		supports.click(How.ID, TIKI_BTN_VIEW_ORDER_LIST);
//		supports.click(How.XPATH, TIKI_BTN_VIEW_ORDER_DETAIL);
//		//login tab
//		Thread.sleep(3000);
//	}
	//search and select for product
	@Test
	public void searchAndSelectProduct() throws InterruptedException
	{
		supports.click(How.ID, TIKI_SEARCH_HOME_PAGE);
		supports.fill(How.ID, TIKI_TXT_SEARCH, "Son moi bbia");
		supports.click(How.ID, TIKI_SELECT_RESULT);
		supports.click(How.XPATH, TIKI_PRODUCT);
		Thread.sleep(5000);
		addProduct();
//		Thread.sleep(10000);
//		addAddress();
	}
	//add product to card
	@Test
	public void addProduct() throws InterruptedException
	{
		supports.click(How.ID, TIKI_BTN_ADD_PRODUCT);
		supports.click(How.ID, TIKI_BTN_VIEW_CART);
		supports.click(How.ID, TIKI_BTN_GOT_IT);
		supports.click(How.ID, TIKI_BTN_CONTINUE_CHECKOUT);
		Thread.sleep(5000);
		login();
	}
	@Test
	//login to buy product
	public void login() throws InterruptedException
	{
		supports.fill(How.ID, TIKI_TXT_EMAIL_LOGIN, "hoakimphanbackup003@gmail.com");
		supports.fill(How.ID, TIKI_TXT_PASSWORD_LOGIN, "hoacau123");
		supports.click(How.ID, TIKI_BTN_LOGIN);
		Thread.sleep(5000);
		addAddress();
	}
	//add address for shipping
	@Test
	public void addAddress() throws InterruptedException
	{
		Thread.sleep(10000);
		supports.click(How.ID, TIKI_BTN_CONTINUE_CHECKOUT);
		supports.click(How.ID, TIKI_BTN_ADD_MORE_ADDRESS);
		supports.fill(How.XPATH, TIKI_TXT_FULL_NAME_FOR_ORDER, "Co gang qua do an");
		supports.fill(How.ID, TIKI_TXT_PHONE_NUMBER, "01697900013");
		//
		supports.click(How.ID, TIKI_EDIT_CITY);
		//
		//supports.scrollByText(TIKI_SELECT_CITY);
		supports.fill(How.ID, TIKI_TXT_CITY, "Hồ Chí Minh");
		//Thread.sleep(4000);
		supports.click(How.XPATH, TIKI_SELECT_CITY);//chua click dc
		//
		//supports.scrollByText(TIKI_SELECT_DISTRICT);
		supports.fill(How.ID, TIKI_TXT_DISTRICT, "Thu Duc");
		//Thread.sleep(4000);
		supports.click(How.XPATH, TIKI_SELECT_DISTRICT);
		//
		//supports.scrollByText(TIKI_SELECT_WARD);
		supports.click(How.XPATH, TIKI_SELECT_WARD);
		supports.fill(How.ID, TIKI_TXT_ADDRESS, "So 1 Vo van ngan");
		supports.click(How.ID, TIKI_CHECKBOX_COMPANY_ADDRESS);
		supports.click(How.ID, TIKI_BTN_SAVE_ADDRESS);
	}
	
	@AfterTest
	public void TearDown()
	{
		supports.closeApp();
	}

}
