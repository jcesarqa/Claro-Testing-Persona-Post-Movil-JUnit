package Negocios;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Base.Base;

public class MovilEquipoPostNueva extends Base{
	
	By cancelar = By.xpath("//button[@class=\"pushcrew-chrome-style-notification-btn pushcrew-btn-close\"]");
	
	By homeregalo = By.xpath("//div[@id='content-wrap']/main/app-home-empresa/app-login/div[2]/div[2]");
	By escridoc = By.id("field-doc");
	By escritelf = By.id("field-last");
	By submitdatos = By.xpath("//button[@type='submit']");
	
	By negocio = By.linkText("Negocios");
	
	By menu = By.xpath("//button[@id='menuCollapsed']/img");
	By conectividadmovil = By.xpath("//div[@id='heading22']/h5/button/img[2]");
	By equipostpago = By.xpath("//div[@id='subHeading25']");
	By lineanueva = By.xpath("//div[@id='childHeading93']/h5/button/span");
	
	By productos = By.xpath("//div[@id='contentcatalog']/app-product/div/div[4]/section/div[3]/div/img");
	By addbolsa = By.xpath("//button[@id='Equipo-añadir-bolsa']");
	By comenzarpago = By.xpath("//div[2]/button/span");
	
	By resumen = By.xpath("//div[@id='content-wrap']/div/section/form/div/div/app-resumen-pedido/div/div/div/div/i");
	
	By camporuc = By.id("field-doc");
	By campocel = By.id("field-cel");
	By camponom = By.id("field-name");
	By campomail = By.id("field-mail");	
	By terminos = By.xpath("//div[@id='content-wrap']/div/section/form/div/div[3]/div[5]/ul/li/label/a");
	By aceptar = By.xpath("(//button[@type='button'])[6]");
	
	By dropdonwlist = By.xpath("//select");
	By direccion = By.xpath("//input[@formcontrolname=\"direccion\"]");
	By botonf = By.xpath("//div[@id='page-container']/main/app-bolsa-informacion-v2/div[2]/div/div[2]/button/span");
	By checkcon = By.xpath("//span[contains(.,'check_box')]");
	By confirmarpago = By.xpath("//div[@id='page-container']/main/app-confirmacion/div[2]/div/div[2]/button");
	
	public MovilEquipoPostNueva(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	public void cancelaremergente () throws InterruptedException {
		Thread.sleep(2000);
		click(cancelar);
	}

	public void negocios() throws InterruptedException {
		captura("NEGOCIO_movil_postpagoNueva","0.home0");
		click(negocio);
	}
	
	public void homeopcion () throws InterruptedException {
		Thread.sleep(1000);
		mover(findElement(homeregalo));
		click(homeregalo);
		Thread.sleep(1000);
		type("77777777",escridoc);
		type("999999999",escritelf);
		captura("NEGOCIO_movil_postpagoNueva","1.datos");
		click(submitdatos);
		Thread.sleep(1000);	
	}
		
	public void menuopciones() throws InterruptedException {
		Thread.sleep(1000);
		captura("NEGOCIO_movil_postpagoNueva","0.home");
		click(menu);
		Thread.sleep(1000);
		captura("NEGOCIO_movil_postpagoNueva","2.menu1");
		click(conectividadmovil);
		Thread.sleep(1000);
		captura("NEGOCIO_movil_postpagoNueva","2.menu2");
		click(equipostpago);
		Thread.sleep(1000);
		captura("NEGOCIO_movil_postpagoNueva","2.menu3");
		click(lineanueva);
	}
	
	public void elegirproducto () throws InterruptedException {
		Thread.sleep(1000);
		scroll(ubicacion(productos),"");
		Thread.sleep(1000);
		captura("NEGOCIO_movil_postpagoNueva","3.producto");
		click(productos);
		Thread.sleep(3000);
	}
	
	public void añadirMibolsa() throws InterruptedException {		
		//MI BOLSA
		scroll("(0,200)","");
		Thread.sleep(2000);
		captura("NEGOCIO_movil_postpagoNueva","4.detalles");
		click(addbolsa);
		scroll("(0,0);","");
		Thread.sleep(1000);
		captura("NEGOCIO_movil_postpagoNueva","5.comenzarpago");
		click(comenzarpago);
		Thread.sleep(1000);
	}
	public void completarFormulario () throws InterruptedException {
		Thread.sleep(500);
		click(resumen);
		Thread.sleep(2000);
		captura("NEGOCIO_movil_postpagoNueva","7.resumen");
		click(resumen);
		scroll("(0,200)","");
		type("44444444444",camporuc);
		type("999999999",campocel);
		clear(camponom);
		clear(campomail);		
		type("Carlos Sebastian",camponom);
		type("somosclaro@dddd.com",campomail);		
		Thread.sleep(1000);
		captura("NEGOCIO_movil_postpagoNueva","8.datospersonales");	
		scroll("(0,300)","");
		Thread.sleep(1000);		
		click(terminos);
		captura("NEGOCIO_movil_postpagoNueva","9.terminos");	
		click(aceptar);
		
		List<WebElement> paqueteopcio = findElements(dropdonwlist);		
		WebElement depart = paqueteopcio.get(1);
		selectList(depart,11);
		WebElement provinc = paqueteopcio.get(2);
		selectList(provinc,1);		
		WebElement dsitrito = paqueteopcio.get(3);
		selectList(dsitrito,1);
		clear(direccion);
		type("Lima, La Molina, Av. Javier Prado",direccion);
		Thread.sleep(1000);
		captura("NEGOCIO_movil_postpagoNueva","10.direccion");
		click(botonf);
	}
	
	public void finalizarCompra () throws InterruptedException {
		captura("NEGOCIO_movil_postpagoNueva","10.resumenfinal1");	
		scroll("(0,600)","");
		Thread.sleep(1000);
		click(checkcon);
		captura("NEGOCIO_movil_postpagoNueva","10.resumenfinal2");
		click(confirmarpago);
		Thread.sleep(1000);
		captura("NEGOCIO_movil_postpagoNueva","11.finalizado");
	}
}
