package br.ce.wcaquino.core;

import static br.ce.wcaquino.core.DriverFactory.KillDriver;
import static br.ce.wcaquino.core.DriverFactory.getDriver;

import java.io.File;
import java.io.IOException;

import org.junit.After;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

public class BaseTest {
	
	@Rule
	public TestName testname = new TestName();
	
	@After
	public void finaliza() throws IOException{
		TakesScreenshot ss = (TakesScreenshot) getDriver();
		File arquivo = ss.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(arquivo, new File("target"+ File.separator +"screenshot" + File.separator + testname.getMethodName()+".jpg"));

		if(Propriedades.FECHAR_BROWSER) {
			KillDriver();
		}
	}
	
}
