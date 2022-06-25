package br.ce.wcaquino.test;
import static br.ce.wcaquino.core.DriverFactory.KillDriver;
import static br.ce.wcaquino.core.DriverFactory.getDriver;

import java.time.Duration;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.ce.wcaquino.core.DSL;
import br.ce.wcaquino.core.DriverFactory;
import junit.framework.Assert;

public class TesteAjax {

	private DSL dsl;

	@Before
	public void inicializa(){
		getDriver().get("https://www.primefaces.org/showcase/ui/ajax/basic.xhtml?jfwid=8f2f3");
		dsl = new DSL();
	}
	
	@After
	public void finaliza(){
		KillDriver();
	}
	
	@Test
	public void testAjax() {
		dsl.escrever(By.id("j_idt311:name"), "Teste");
		dsl.clicarBotao("j_idt311:j_idt315");
		WebDriverWait wait = new WebDriverWait(getDriver(), null);
		//wait.until(ExpectedConditions.textToBe(By.id("j_idt311:display"), "Teste"));
		//Esperar até que haja invisibilidade de um elemento na tela
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("j_idt98")));
		Assert.assertEquals("Teste", dsl.obterTexto(By.id("j_idt311:display")));
	}
}
