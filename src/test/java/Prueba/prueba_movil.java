package Prueba;

import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class prueba_movil {
	
	private ChromeDriver driver;
	
	By celulares = By.xpath("//div[5]/section/div[3]/div/img");
	
	@Before
	public void setUp() throws Exception {
		Map<String, String> mobileEmulation = new HashMap<String, String>();
		ChromeOptions chromeOptions = new ChromeOptions();
		
		mobileEmulation.put("deviceName", "iPhone 5/SE");		
		chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);
		
		System.setProperty("webdriver.chrome.driver","./src/test/resources/chromedriver/chromedriver.exe");
		driver = new ChromeDriver(chromeOptions);
		driver.manage().window().maximize();
		driver.get("https://tiendaclaro.pe/catalogo/personas/portabilidad/acuerdo-18/celulares/todos/todos?nav=1");
		
	}

	@After
	public void tearDown() throws Exception {
		//driver.quit();
	}
	
	@Test
	public void test() throws InterruptedException { 
		Point ubicacion;
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		Thread.sleep(1000);
		ubicacion = driver.findElement(celulares).getLocation();
		
		js.executeScript("window.scrollTo"+ubicacion,"");
		
		System.out.println(ubicacion);
	}
	

}