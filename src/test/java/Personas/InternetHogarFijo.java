package Personas;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Base.Base;

public class InternetHogarFijo extends Base{
	
	By cancelar = By.xpath("//button[@class=\"pushcrew-chrome-style-notification-btn pushcrew-btn-close\"]");
	By homeregalo = By.xpath("//div[@id='content-wrap']/main/app-home/app-login/div[2]/div[2]");
	By escridoc = By.id("field-doc");
	By escritelf = By.id("field-last");
	By submitdatos = By.xpath("//button[@type='submit']");
	

	By menu = By.xpath("//button[@id='menuCollapsed']/img");
	By interhogar = By.xpath("//div[@id='heading12']");
	By hogar = By.xpath("//div[2]/div/div[2]/div[2]/div/div/div[2]/div/h5/button/span");
	By interfijo = By.xpath("//div[@id='childHeading39']/h5/button/span");

	By opcionfijo = By.xpath("//div[@id='contentcatalog']/app-product/div/div/section");
	By solicitar = By.id("Equipo-solicitar-servicio");
	By siguiente = By.xpath("//div[2]/button/span");
	
	By resumen = By.xpath("//div[@id='content-wrap']/div/section/form/div/div/app-resumen-pedido/div/div/div/div/i");
	
	By campodoc = By.id("field-doc");
	By campocel = By.id("field-cel");
	By camponom = By.id("field-name");
	By campoape = By.id("field-last");
	By campomail = By.id("field-mail");	
	By terminos = By.xpath("//div[@id='content-wrap']/div/section/form/div/div[3]/div[6]/ul/li/label/a");
	By aceptar = By.xpath("(//button[@type='button'])[6]");
	By dropdonwlist = By.xpath("//select");
	By direccion = By.xpath("(//input[@type='text'])[5]");
	By botonf = By.xpath("//div[@id='page-container']/main/app-bolsa-informacion-v2/div[2]/div/div[2]/button/span");
	By pagocont = By.xpath("//button[@id='Pago-continuar']");

	By checkterm = By.xpath("//span[@for='ckbTerms3']");
	By confirmarpago = By.xpath("//div[2]/div/div[2]/button/span");
	
	public InternetHogarFijo(WebDriver driver) {
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
		captura("PERSONA_internethogar_fijo","1.datos");
		click(submitdatos);
		Thread.sleep(1000);		
	}
	
	public void buscarInternetHogar () throws InterruptedException {
		Thread.sleep(1000);
		captura("PERSONA_internethogar_fijo","0.home");
		click(menu);
		Thread.sleep(1000);
		captura("PERSONA_internethogar_fijo","2.menu1");
		click(interhogar);
		Thread.sleep(1000);
		captura("PERSONA_internethogar_fijo","2.menu2");
		click(hogar);
		Thread.sleep(1000);
		captura("PERSONA_internethogar_fijo","2.menu3");
		click(interfijo);
	}	
	
	public void elegiropcion () throws InterruptedException {
		List<WebElement> opcionesfoijo = findElements(opcionfijo);		
		WebElement opcionelegida = opcionesfoijo.get(3);
		scroll(ubicacion(opcionelegida),"");
		Thread.sleep(1000);
		captura("PERSONA_internethogar_fijo","3.opciones");
		opcionelegida.click();
		Thread.sleep(2000);
		captura("PERSONA_internethogar_fijo","4.solicitar");
		click(solicitar);
		Thread.sleep(1000);
		captura("PERSONA_internethogar_fijo","5.siguiente");
		click(siguiente);
	}
	
	public void completarFormulario () throws InterruptedException {	
		Thread.sleep(500);
		click(resumen);
		Thread.sleep(1000);
		captura("PERSONA_internethogar_fijo","6.resumen");
		click(resumen);

		scroll("(0,300)","");
		Thread.sleep(1000);
		type("77777777",campodoc);
		type("999999999",campocel);
		clear(camponom);
		clear(campoape);
		clear(campomail);		
		type("Carlos Sebastian",camponom);
		type("Ortiz Alejandro",campoape);
		type("somosclaro@dddd.com",campomail);
		Thread.sleep(1000);
		captura("PERSONA_internethogar_fijo","7.datospersonales");
		scroll("(0,-300)","");
		scroll("(0,400)","");
		Thread.sleep(1000);
		click(terminos);
		captura("PERSONA_internethogar_fijo","8.terminos");
		click(aceptar);

		scroll("(0,600)","");
		scroll(ubicacion(dropdonwlist),"");
		List<WebElement> paqueteopcio = findElements(dropdonwlist);		
		WebElement depart = paqueteopcio.get(1);
		selectList(depart,10);
		WebElement provinc = paqueteopcio.get(2);
		selectList(provinc,1);		
		WebElement dsitrito = paqueteopcio.get(3);
		selectList(dsitrito,1);
		clear(direccion);
		type("Lima, La Molina, Av. Javier Prado",direccion);	
		Thread.sleep(1000);
		captura("PERSONA_internethogar_fijo","9.direccion");
		click(botonf);
	}
	
	public void finalizarCompra () throws InterruptedException {
		captura("PERSONA_internethogar_fijo","10.finalizarcompra1");
		scroll("(0,400)","");
		Thread.sleep(1000);
		click(checkterm);
		captura("PERSONA_internethogar_fijo","11.confirmar");
	}
	
	public void confirmarcompra () throws InterruptedException {
		Thread.sleep(1000);
		click(confirmarpago);
		Thread.sleep(5000);
		captura("PERSONA_internethogar_inalambrico","12.confirmar");
	}
}
