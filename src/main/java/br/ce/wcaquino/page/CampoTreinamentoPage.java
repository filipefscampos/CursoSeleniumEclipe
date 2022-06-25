package br.ce.wcaquino.page;
import org.openqa.selenium.By;

import br.ce.wcaquino.core.BasePage;

public class CampoTreinamentoPage extends BasePage {
	
	public void setNome(String nome) {
		dsl.escrever("elementosForm:nome", nome);
	}
	
	public void setSobreNome(String nome) {
		dsl.escrever("elementosForm:sobrenome", nome);
	}
	
	public void setSexoMasculino() {
		dsl.clicarRadio("elementosForm:sexo:0");
	}
	
	public void setSexoFeminino() {
		dsl.clicarRadio("elementosForm:sexo:1");
	}
	
	public void setComidaFavoritaCarne() {
		dsl.clicarRadio("elementosForm:comidaFavorita:0");
	}
	
	public void setComidaFavoritaPizza() {
		dsl.clicarRadio("elementosForm:comidaFavorita:2");
	}
	
	public void setComidaFavoritaVegetariano() {
		dsl.clicarRadio("elementosForm:comidaFavorita:3");
	}
	
	public void setEscolaridade(String valor) {
		dsl.selecionarCombo("elementosForm:escolaridade", valor);
	}
	
	public void setEsportes(String... valores) {
		for(String valor: valores) {
			dsl.selecionarCombo("elementosForm:esportes", valor);
		}
	}
	
	public void cadastrar() {
		dsl.clicarBotao("elementosForm:cadastrar");
	}
	
	public String obterResultadoCadastro() {
		return dsl.obterTexto(By.xpath("//*[@id='resultado']/span"));
	}
	
	public String obterNomeCadastro() {
		//return dsl.obterTexto("descNome");
		return dsl.obterTexto(By.xpath("//*[@id='descNome']/span"));
	}
	
	public String obterSobreNomeCadastro() {
		//return dsl.obterTexto("descSobrenome");
		return dsl.obterTexto(By.xpath("//*[@id='descSobrenome']/span"));
	}
	
	public String obterSexoCadastro() {
		//return dsl.obterTexto("descSexo");
		return dsl.obterTexto(By.xpath("//*[@id='descSexo']/span"));
	}
	
	public String obterComidaCadastro() {
		//return dsl.obterTexto("descComida");
		return dsl.obterTexto(By.xpath("//*[@id='descComida']/span"));
	}
	
	public String obterEscolaridadeCadastro() {
		//return dsl.obterTexto("descEscolaridade");
		return dsl.obterTexto(By.xpath("//*[@id='descEscolaridade']/span"));
	}
	
	public String obterEsporteCadastro() {
		//return dsl.obterTexto("descEsportes");
		return dsl.obterTexto(By.xpath("//*[@id='descEsportes']/span"));
	}	
	
}
