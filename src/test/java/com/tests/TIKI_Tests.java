package com.tests;

import java.net.MalformedURLException;

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
	public void TC001()
	{
		supports.click(How.ID, TIKI_SEARCH_HOME_PAGE);
		supports.fill(How.ID, TIKI_TXT_SEARCH, "Son");
		supports.click(How.ID, TIKI_SELECT_RESULT);
		supports.scrollByText(How.NAME, TIKI_PRODUCT, "Son Môi Bbia Last Rouge (3.7g)");//chua run duoc dong nay
		supports.click(How.NAME, TIKI_PRODUCT);
		supports.click(How.ID, TIKI_BTN_VIEW_CART);
		supports.click(How.ID, TIKI_BTN_ADD_PRODUCT);
		supports.click(How.ID, TIKI_BTN_INCREASE_NUMBER);
		supports.click(How.ID, TIKI_BTN_CONTINUE_CHECKOUT);
		supports.click(How.XPATH, TIKI_SELECT_REGISTER_TAB);
		supports.fill(How.ID, TIKI_TXT_FULL_NAME, "Quyết tâm đậu đồ án");
		supports.fill(How.ID, TIKI_TXT_EMAIL, "kimhoa@gmail.com");
		supports.fill(How.ID, TIKI_TXT_PASSWORD, "Hoahoa12345");
		supports.click(How.ID, TIKI_BTN_EDIT_BIRTHDAY);
		supports.click(How.ID, TIKI_BTN_FINISH_EDIT_BIRTHDAY);
		supports.click(How.ID, TIKI_BTN_SELECT_GENDER);
		supports.click(How.ID, TIKI_BTN_REGISTER);
		supports.click(How.ID, TIKI_BTN_CONTINUE_CHECKOUT);
		supports.fill(How.ID, TIKI_TXT_FULL_NAME_FOR_ORDER, "Quyết tâm đậu đồ án");
		supports.fill(How.ID, TIKI_TXT_PHONE_NUMBER, "01697901234");
		supports.click(How.ID, TIKI_EDIT_CITY);
		supports.click(How.ID, TIKI_SELECT_CITY);
		supports.click(How.ID, TIKI_SELECT_DISTRICT);
		supports.click(How.ID, TIKI_SELECT_WARD);
		supports.fill(How.ID, TIKI_TXT_ADDRESS, "Số 1, Võ Văn Ngân");
		supports.click(How.ID, TIKI_BTN_PAY);
		supports.click(How.ID, TIKI_BTN_CONTINUE);
		supports.scrollByText(How.ID, TIKI_SELECT_PAY_METHOD, "Thanh toán tiền mặt khi nhận hàng");
		supports.click(How.ID, TIKI_SELECT_PAY_METHOD);
		supports.click(How.ID, TIKI_BTN_CONTINUE);
		supports.click(How.ID, TIKI_BTN_CHECK_OUT);
	}

}
