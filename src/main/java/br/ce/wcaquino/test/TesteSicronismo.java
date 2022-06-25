package br.ce.wcaquino.test;
import static br.ce.wcaquino.core.DriverFactory.KillDriver;
import static br.ce.wcaquino.core.DriverFactory.getDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

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

public class TesteSicronismo {
	
	private DSL dsl;

	@Before
	public void inicializa(){
		getDriver().get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		dsl = new DSL();
	}
	
	@After
	public void finaliza(){
		//driver.quit();
	}
	
	@Test
	public void deveUtilizarEsperaFixa() throws InterruptedException { //deve lan�ar uma exce��o para o junit tratar como que o teste falhou
		dsl.clicarBotao("buttonDelay");		
		//Espera fixa
		Thread.sleep(5000);
		dsl.escrever("novoCampo", "Deu Certo?");
	}
	
	@Test
	public void deveUtilizarEsperaImplicita() throws InterruptedException { 
		dsl.clicarBotao("buttonDelay");
		//Espera implicita (deve esperar a presen�a do elemento em AT� Xs)
		getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		dsl.escrever("novoCampo", "Deu Certo?");
		//posso retirar a espera para n�o impactar a todo ambiente
		getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
	}
	
	@Test
	public void deveUtilizarEsperaExplicita() throws InterruptedException { 
		dsl.clicarBotao("buttonDelay");
		//Espera explicita (n�s temos que definir um tempo padr�o de espera para o driver, e, dizer qual campo tem que aguardar)
		WebDriverWait wait = new WebDriverWait(getDriver(), null);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("novoCampo")));
		dsl.escrever("novoCampo", "Deu Certo?");
	}
	
}
