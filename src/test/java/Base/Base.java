package Base;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Base {
	
	private WebDriver driver;
	Actions accion;
	JavascriptExecutor js;
	Select lista1;
	
	public Base (WebDriver driver) {
		this.driver = driver;
	}
	
	public WebDriver chromeDriverConnection() {
		Map<String, String> mobileEmulation = new HashMap<String, String>();
		ChromeOptions chromeOptions = new ChromeOptions();
		
		mobileEmulation.put("deviceName", "iPhone 5/SE");		
		chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);
		
		System.setProperty("webdriver.chrome.driver","./src/test/resources/chromedriver/chromedriver.exe");
		driver = new ChromeDriver(chromeOptions);
		driver.manage().window().maximize();
		return driver;
	}
	
	public WebElement findElement (By locator) {
		return driver.findElement(locator);
	}
	
	public void mover (WebElement element) {
		accion = new Actions(driver);
	    accion.moveToElement(element).perform();
	}
	
	public void scroll (String script,String argument) {
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo"+script,argument);
	}
	
	public void scrollfinal () {
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight);","");
	}
	
	public String ubicacion (By locator) {
		String ubicacion = String.valueOf(driver.findElement(locator).getLocation());
		return ubicacion;
	}
	
	public String ubicacion (WebElement locator) {
		String ubicacion = String.valueOf(locator.getLocation());
		return ubicacion;
	}
	public List<WebElement> findElements (By locator) {
		return driver.findElements(locator);
	}
	
	public void selectList (WebElement element,int index) {
		lista1 = new Select(element);
		lista1.selectByIndex(index);
	}
	
	public String getText (WebElement element) {
		return element.getText();
	}
	
	public void clear (By locator) {
		driver.findElement(locator).clear();
	}
	
	public void type (String inputText, By locator) {
		driver.findElement(locator).sendKeys(inputText);
	}
	
	public void click (By locator) {
		driver.findElement(locator).click();
	}
	
	public Boolean isDisplay (By locator) {
		try {
			return driver.findElement(locator).isDisplayed();
		} catch (org.openqa.selenium.NoSuchElementException e){ 
			return false;
		}
	}
	
	public void visit (String url) {
		driver.get(url);
	}
	
	public void captura(String archivo, String nombre) throws InterruptedException {
		File caputura = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try{
			FileUtils.copyFile(caputura, new File (".\\reporte\\capturas_"+archivo+"\\"+nombre+".png"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
}
