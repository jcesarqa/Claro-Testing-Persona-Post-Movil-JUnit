package Personas;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class CelularPostPortabilidad_Test {

	private WebDriver driver;
	CelularPostPortabilidad celularpostportabilidad;
	
	@Before
	public void setUp() throws Exception {
		celularpostportabilidad = new CelularPostPortabilidad(driver);
		driver = celularpostportabilidad.chromeDriverConnection();
		celularpostportabilidad.visit("https://tiendaclaro.pe/");		
	}

	public String getDate() {
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yy");;
		Date date = new Date();
		return dateFormat.format(date);
	}
	public String getTime() {
		DateFormat timeFormat = new SimpleDateFormat("HH.mm.ss");;
		Date time = new Date();
		return timeFormat.format(time);
	}
	
	@After
	public void tearDown() throws Exception {
		driver.quit();
	}
	
	@Test
	public void test() throws InterruptedException, IOException {		
		try{
			//celularpostportabilidad.cancelaremergente();
			celularpostportabilidad.homeopcion();
			celularpostportabilidad.menucelulares();
			celularpostportabilidad.elegirproducto();
			celularpostportabilidad.agregaraccesorios();
			celularpostportabilidad.completarformulario();
			celularpostportabilidad.finalizarCompra();		
		}
		catch(Exception e)
		{
    	File captura = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    	FileUtils.copyFile(captura, new File(".\\reporte\\error_test_PERSONA_celular_portabilidad_"+getDate()+"_"+getTime()+".png"));
    	
    	String ruta = ".\\reporte\\error_test_PERSONA_celular_portabilidad_"+getDate()+"_"+getTime()+".txt";
            File file = new File(ruta);	           
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(""+e.getMessage());
            bw.close();	   
		}
	}
}
