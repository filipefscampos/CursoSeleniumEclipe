package br.ce.wcaquino.test;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static br.ce.wcaquino.core.DriverFactory.KillDriver;
import static br.ce.wcaquino.core.DriverFactory.getDriver;

import br.ce.wcaquino.core.DSL;

public class TestePrime {
	
	private DSL dsl;

	@Before
	public void inicializa(){
		dsl = new DSL();
	}
	
	@After
	public void finaliza(){
		KillDriver();
	}
	
	@Test
	public void deveInteragirComRadioPrime() {
		getDriver().get("https://www.primefaces.org/showcase/ui/input/oneRadio.xhtml?jfwid=04ed7");
		//j_idt312:console:0
		//dsl.clicarRadio("j_idt312:console:0");
		////input[@id='j_idt312:console:0']/../..//span
		dsl.clicarRadio(By.xpath("//input[@id='j_idt312:console:0']/../..//span"));
		Assert.assertTrue(dsl.isRadioMarcado("j_idt312:console:0"));
		dsl.clicarRadio(By.xpath("//label[.='Option2']/..//span"));
		Assert.assertTrue(dsl.isRadioMarcado("j_idt312:console:1"));
	}
	
	@Test
	public void deveInteragirComSelectPrime() {
		getDriver().get("https://www.primefaces.org/showcase/ui/input/oneMenu.xhtml?jfwid=6ab31");
		//dsl.selecionarCombo("j_idt311:option_input", "Option1");
		//dsl.clicarRadio(By.xpath("//*[@id='j_idt311:option_input']/../..//span"));
		////*[@id='j_idt311:option_items']//li[.='Option1']
		//dsl.clicarRadio(By.xpath("//*[@id='j_idt311:option_items']//li[.='Option1']"));
		//j_idt311:option_label
		dsl.selecionarComboPrime("j_idt311:option", "Option1");
		Assert.assertEquals("Option1", dsl.obterTexto("j_idt311:option_label"));
		
	}
	
}
