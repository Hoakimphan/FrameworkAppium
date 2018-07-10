package com.tests;

import java.net.MalformedURLException;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.How;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.objects.TIKI_Page;
import com.untils.AndroidSupports;

public class TIKI_Tests extends TIKI_Page{
	AndroidSupports supports = new AndroidSupports();
	@BeforeTest
	public void setUp() throws MalformedURLException
	{
		supports.setUp();
	}
	@Test
	public void TC001() throws InterruptedException
	{
		supports.click(How.ID, TIKI_SEARCH_HOME_PAGE);
		supports.fill(How.ID, TIKI_TXT_SEARCH, "Son moi bbia");
		supports.click(How.ID, TIKI_SELECT_RESULT);
		//supports.scrollByText(How.NAME, TIKI_PRODUCT, "Son Môi Bbia Last Rouge (3.7g)");//chua run duoc dong nay
		supports.click(How.XPATH, TIKI_PRODUCT);
		supports.click(How.ID, TIKI_BTN_ADD_PRODUCT);
		supports.click(How.ID, TIKI_BTN_VIEW_CART);
		supports.click(How.ID, TIKI_BTN_GOT_IT);
		supports.click(How.ID, TIKI_BTN_INCREASE_NUMBER);
		supports.click(How.ID, TIKI_BTN_CONTINUE_CHECKOUT);
		//login
		supports.fill(How.ID, TIKI_TXT_EMAIL_LOGIN, "cautrang001@gmail.com");
		supports.fill(How.ID, TIKI_TXT_PASSWORD_LOGIN, "cauhoa123");
		supports.click(How.ID, TIKI_BTN_LOGIN);
		//Thread.sleep(6000);
//		supports.click(How.XPATH, TIKI_SELECT_REGISTER_TAB);
//		//supports.swipe();
//		supports.fill(How.ID, TIKI_TXT_FULL_NAME, "Quyết tâm đậu đồ án");
//		supports.fill(How.ID, TIKI_TXT_EMAIL, "kimhoa@gmail.com");
//		supports.fill(How.ID, TIKI_TXT_PASSWORD, "Hoahoa12345");
//		supports.click(How.ID, TIKI_BTN_EDIT_BIRTHDAY);
//		supports.click(How.ID, TIKI_BTN_FINISH_EDIT_BIRTHDAY);
//		supports.click(How.ID, TIKI_BTN_SELECT_GENDER);
//		supports.click(How.ID, TIKI_BTN_REGISTER);
		supports.click(How.ID, TIKI_BTN_CONTINUE_CHECKOUT);
		supports.click(How.ID, TIKI_BTN_ADD_MORE_ADDRESS);
		supports.fill(How.ID, TIKI_TXT_FULL_NAME_FOR_ORDER, "Quyết tâm đậu đồ án");//chua nhap duoc
		supports.fill(How.ID, TIKI_TXT_PHONE_NUMBER, "01697901234");
		//
		supports.click(How.ID, TIKI_EDIT_CITY);
		//
		supports.scrollByText(TIKI_SELECT_CITY);
		supports.click(How.ID, TIKI_SELECT_CITY);//chua click dc
		//
		supports.scrollByText(TIKI_SELECT_DISTRICT);
		supports.click(How.ID, TIKI_SELECT_DISTRICT);
		//
		supports.scrollByText(TIKI_SELECT_WARD);
		supports.click(How.ID, TIKI_SELECT_WARD);
		supports.fill(How.ID, TIKI_TXT_ADDRESS, "Số 1, Võ Văn Ngân");
		supports.click(How.ID, TIKI_BTN_SAVE_ADDRESS);
		supports.click(How.ID, TIKI_SELECT_ADDRESS);
		supports.click(How.ID, TIKI_BTN_CONTINUE);
		supports.click(How.ID, TIKI_BTN_PAY);
		supports.click(How.ID, TIKI_BTN_CONTINUE);
		supports.scrollByText("Thanh toán tiền mặt khi nhận hàng");
		supports.click(How.ID, TIKI_SELECT_PAY_METHOD);
		supports.click(How.ID, TIKI_BTN_CONTINUE);
		supports.click(How.ID, TIKI_BTN_CHECK_OUT);
		//login tab
		
	}

}
