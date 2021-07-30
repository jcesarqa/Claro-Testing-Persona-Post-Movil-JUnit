package Personas;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Base.Base;

public class CelularPostPortabilidad extends Base{
	
	By cancelar = By.xpath("//button[@class=\"pushcrew-chrome-style-notification-btn pushcrew-btn-close\"]");
	By homeregalo = By.xpath("//div[@id='content-wrap']/main/app-home/app-login/div[2]/div[2]");
	By escridoc = By.id("field-doc");
	By escritelf = By.id("field-last");
	By submitdatos = By.xpath("//button[@type='submit']");
	
	By menu = By.xpath("//button[@id='menuCollapsed']/img");
	By celulares = By.xpath("//div[@id='heading10']/h5/button/span");
	By postpago = By.xpath("//div[@id='subHeading37']/h5/button/span");
	By portabilidad = By.xpath("//button[@id='Cel-Postpago-Portabilidad']/span");
	By celular = By.xpath("//div[5]/section/div[3]/div/img");
	By addbolsa = By.xpath("//button[@id='Equipo-añadir-bolsa']");
	By botonaccesorios = By.xpath("//div/div/button");
	By accesosiguiente = By.xpath("//span[contains(.,'Agregar a la bolsa')]");
	By mibolsasiguiente = By.xpath("//div[@id='page-container']/main/app-bolsa/div[2]/div/div[2]/button/span");
	
	By resumen = By.xpath("//div[@id='content-wrap']/div/section/form/div/div/app-resumen-pedido/div/div/div/div/i");
	
	By campodoc = By.id("field-doc");
	By campocel = By.id("field-cel");
	By camponom = By.id("field-name");
	By campoape = By.id("field-last");
	By campomail = By.id("field-mail");	
	By terminos = By.xpath("//div[@id='content-wrap']/div/section/form/div/div[3]/div[7]/ul/li/label/a");
	By aceptar = By.xpath("(//button[@type='button'])[6]");
	By dropdonwlist = By.xpath("//div[@id='content-wrap']/div/section/form/app-bolsa-envio-v2/div/section/div/div[3]/app-direccion/form/div/div/div/select");
	By direccion = By.xpath("(//input[@type='text'])[5]");
	By botonf = By.xpath("//div[@id='page-container']/main/app-bolsa-informacion-v2/div[2]/div/div[2]/button/span");
	
	By condpago = By.linkText("Términos y Condiciones de Pago.");
	By acepcondpago = By.xpath("//button[@data-dismiss='modal']");
	By checkterm = By.xpath("//span[@for='ckbTerms3']");
	By confirmarpago = By.xpath("//div[@id='page-container']/main/app-confirmacion/div[2]/div/div[2]/button");
	
	
	
	public CelularPostPortabilidad(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public void cancelaremergente () throws InterruptedException {
		Thread.sleep(2000);
		click(cancelar);
	}
	
	public void homeopcion () throws InterruptedException {
		Thread.sleep(1000);
		mover(findElement(homeregalo));
		click(homeregalo);
		Thread.sleep(1000);
		type("77777777",escridoc);
		type("999999999",escritelf);
		captura("PERSONA_celular_portabilidad","1.datos");
		click(submitdatos);
		Thread.sleep(1000);		
	}	
	
	public void menucelulares () throws InterruptedException{
		Thread.sleep(1000);
		captura("PERSONA_celular_portabilidad","0.home");
		click(menu);
		Thread.sleep(1000);
		captura("PERSONA_celular_portabilidad","2.menu1");
		click(celulares);
		Thread.sleep(1000);
		captura("PERSONA_celular_portabilidad","2.menu2");
		click(postpago);
		Thread.sleep(1000);
		captura("PERSONA_celular_portabilidad","2.menu3");
		click(portabilidad);
	}
	
	public void elegirproducto () throws InterruptedException {
		Thread.sleep(1000);
		scroll(ubicacion(celular),"");
		Thread.sleep(1000);
		captura("PERSONA_celular_portabilidad","3.producto");
		click(celular);
		Thread.sleep(3000);
		captura("PERSONA_celular_portabilidad","4.detallesproducto");
		click(addbolsa);
	}
	
	public void agregaraccesorios () throws InterruptedException {
		Thread.sleep(1000);
		captura("PERSONA_celular_portabilidad","5.accesorios1");
		scrollfinal();
		Thread.sleep(1000);
		List<WebElement> addaccesorios = findElements(botonaccesorios);
		addaccesorios.get(1).click();
		captura("PERSONA_celular_portabilidad","5.accesorios2");
		click(accesosiguiente);	
		Thread.sleep(1000);
		captura("PERSONA_celular_portabilidad","6.mibolsa");
		click(mibolsasiguiente);
	}
	
	public void completarformulario () throws InterruptedException {
		Thread.sleep(500);
		click(resumen);
		Thread.sleep(1000);
		captura("PERSONA_celular_portabilidad","7.resumen");
		click(resumen);
		
		type("77777777",campodoc);
		type("999999999",campocel);
		clear(camponom);
		clear(campoape);
		clear(campomail);		
		type("Carlos Sebastian",camponom);
		type("Ortiz Alejandro",campoape);
		type("somosclaro@dddd.com",campomail);
		Thread.sleep(1000);
		captura("PERSONA_celular_portabilidad","8.datospersonales");
		scroll("(0,-300)","");
		scroll("(0,400)","");
		Thread.sleep(1000);
		click(terminos);
		captura("PERSONA_celular_portabilidad","9.terminos");
		click(aceptar);
		
		scroll(ubicacion(dropdonwlist),"");
		List<WebElement> paqueteopcio = findElements(dropdonwlist);		
		WebElement depart = paqueteopcio.get(0);
		selectList(depart,11);
		WebElement provinc = paqueteopcio.get(1);
		selectList(provinc,1);		
		WebElement dsitrito = paqueteopcio.get(2);
		selectList(dsitrito,1);
		clear(direccion);
		type("Lima, La Molina, Av. Javier Prado",direccion);	
		Thread.sleep(1000);
		captura("PERSONA_celular_portabilidad","10.direccion");
		click(botonf);
	}
	
	public void finalizarCompra () throws InterruptedException {		
		Thread.sleep(500);
		captura("PERSONA_celular_portabilidad","11.finalizar1");
		scroll("(0,380)","");
		Thread.sleep(500);
		captura("PERSONA_celular_portabilidad","11.finalizar2");
		click(condpago);
		click(acepcondpago);
		click(checkterm);
		captura("PERSONA_celular_portabilidad","12.aceptermicondicio");
		click(confirmarpago);
		Thread.sleep(10000);
		captura("PERSONA_celular_portabilidad","13.pasarelapago");
	}
}
