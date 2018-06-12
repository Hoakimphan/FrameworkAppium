package com.untils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.configs.Configs;
import com.datas.PathProvider;

public class Supports {
	private static WebDriver driver;		//o day anh de private vi li do, tranh' cac class khac thay doi driver, khi can thi dung ham getApp() nay ne
	int timeoutDefault = 30;
	public String browser ="";
	PathProvider path = new PathProvider();
	public String webDriverPath;
	
	public Supports() {
		browser = Configs.browser;
	}
	
	//Em phai phan tich FW cua anh, hoc va viet thanh FW cua em. Vi cai mindset cua anh no khac em --> neu loi thi e se k bik sua
	/*
	 * Vi du o day: 
	 * 1. Anh initialize 1 String browser: 
	 * 		Muc dich: de anh read tu 1 file nao do (java, properties, excel v...v..). Kieu khi web.conf ay
	 * 		Loi o day: Em chua read no tu Configs.browser
	 * 
	 * ---> co 3 cach giai quyet:
	 * 1. Dung constructor, ngay luc em tao object den Supports class --> no cung read lun String browser
	 * 2. Em call 1 method khoi tao no kieu nhu readConfigs --> roi gan vao cho nao cung dc, truoc khi khoi tao WebDriver
	 * 3. Dung no nhu setUp()
	 * 
	 * Em nen can trong:
	 * private dung trong noi bo, co nhieu method xu ly ngam, dung nen public
	 */
	
	public WebDriver getApp()
	{
		return driver;
	}
	
	public void readConfigs() {
		browser = Configs.browser;
	}
	
	public void setUp()
	{
		//readConfigs();
		ChromeOptions options = new ChromeOptions();
		System.out.println("!!!!!!!!!!!!!!   "+browser);
		switch (browser.toLowerCase()) {
		case "chrome" :
			webDriverPath = path.getDriverChromePath();
			System.setProperty("webdriver.chrome.driver", webDriverPath);
			driver = new ChromeDriver();
			break;
		case "firefox":
			webDriverPath = path.getDriverGeckoPath();
			System.setProperty("webdriver.gecko.driver", webDriverPath);
			driver = new FirefoxDriver();
			break;
		case "opera":
			webDriverPath = path.getDriverOperaPath();
			System.setProperty("webdriver.gecko.driver", webDriverPath);
			driver = new OperaDriver();
			break;
		case "opera_chromium":
			webDriverPath = path.getDriverOperaPath();
			String Opera_Location = "C:\\Program Files\\Opera\\52.0.2871.64\\opera.exe";
			System.setProperty("webdriver.opera.driver", webDriverPath);
			options.setBinary(Opera_Location);
			DesiredCapabilities caps = new DesiredCapabilities();
			caps.setCapability(ChromeOptions.CAPABILITY, options);
			OperaDriver driverOpera = new OperaDriver(caps);
			driver = driverOpera;
			break;
		case "ie":
			webDriverPath = path.getDriverIEPath();
			System.setProperty("webdriver.ie.driver", webDriverPath);
			driver = new InternetExplorerDriver();
			
		case "edge":
			webDriverPath = path.getDriverIEPath();
			System.setProperty("webdriver.edge.driver", webDriverPath);
			driver = new EdgeDriver();
			break;
		default:
			break;
		}
	}
	public void get(String url) {
		driver.get(url);
	}	
	public void closePage()
	{
		driver.quit();
	}
	public WebElement getElement(How eHow, String eLocator)
	{
		waitForElement(eHow, eLocator, timeoutDefault);
		switch (eHow) {
		case CLASS_NAME:
			return driver.findElement(By.className(eLocator));
		case CSS:
			return driver.findElement(By.cssSelector(eLocator));
		case ID:
			return driver.findElement(By.id(eLocator));
		case ID_OR_NAME:
			return driver.findElement(By.id(eLocator));
		case LINK_TEXT:
			return driver.findElement(By.linkText(eLocator));
		case NAME:
			return driver.findElement(By.name(eLocator));
		case PARTIAL_LINK_TEXT:
			return driver.findElement(By.partialLinkText(eLocator));
		case TAG_NAME:
			return driver.findElement(By.tagName(eLocator));
		case XPATH:
			return driver.findElement(By.xpath(eLocator));
		case UNSET:
			break;
		}
		return null;
	}
	public void waitForElement(How eHow, String eLocator, int timeout)
	{
		switch (eHow) {
		case CLASS_NAME:
			new WebDriverWait(driver, timeout)
					.until(ExpectedConditions.visibilityOfElementLocated(By.className(eLocator)));
			break;
		case CSS:
			new WebDriverWait(driver, timeout)
					.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(eLocator)));
			break;
		case ID:
			new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOfElementLocated(By.id(eLocator)));
			break;
		case ID_OR_NAME:
			new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOfElementLocated(By.id(eLocator)));
			break;
		case LINK_TEXT:
			new WebDriverWait(driver, timeout)
					.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(eLocator)));
			break;
		case NAME:
			new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOfElementLocated(By.name(eLocator)));
			break;
		case PARTIAL_LINK_TEXT:
			new WebDriverWait(driver, timeout)
					.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText(eLocator)));
			break;
		case TAG_NAME:
			new WebDriverWait(driver, timeout)
					.until(ExpectedConditions.visibilityOfElementLocated(By.tagName(eLocator)));
			break;
		case XPATH:
			new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(eLocator)));
			break;
		case UNSET:
			break;
		}
	}
	//click function
	public void click(How eHow, String eLocator)
	{
		waitForElement(eHow, eLocator, timeoutDefault);
		getElement(eHow, eLocator).click();
	}
	//send text function
	public void clearText(How eHow, String eLocator)
	{
		getElement(eHow, eLocator).clear();
	}
	public void fill(How eHow, String eLocator, String text)
	{
		waitForElement(eHow, eLocator, timeoutDefault);
		getElement(eHow, eLocator).clear();
		getElement(eHow, eLocator).sendKeys(text);
		System.out.printf("Input into [%s] value [%s] %n", eLocator, text);
	}
	public String getText(How eHow, String eLocator)
	{
		waitForElement(eHow, eLocator, timeoutDefault);
		return getElement(eHow, eLocator).getText();
	}
	//scroll function
	public void scrollDownByPixel(double x, double y)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(" + x + "," + y + ")");
	}
	public void scrollByElement(How eHow, String eLocator)//using for scroll vertical and horizontal by element
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement element = getElement(eHow, eLocator);
		js.executeScript("arguments[0].scrollIntoView();", element);
	}
	public void scrollDownToBottom()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}
	public void scrollUptoOnTop()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(document.body.scrollHeight,0)");
	}
	

}
