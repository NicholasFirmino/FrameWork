package br.com.nicholas.funcs;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import br.com.nicholas.configs.DriverFactory;

public class FuncoesBasicas {
	
	FuncoesEvidencias evid = new FuncoesEvidencias();

//________________________________________________________Funções_Básicas_1____________________________________________________
	public void clica(By elemento) {
		DriverFactory.getDriver().findElement(elemento).click();
	}
	
	public void esperaEstarClicavel(By elemento) {
		DriverFactory.getWait().until(ExpectedConditions.elementToBeClickable(elemento));
	}
	
	public void escreve(By elemento, String escrita) {
		DriverFactory.getDriver().findElement(elemento).sendKeys(escrita);
	}
	
	public void limpaConteudo(By elemento) {
		DriverFactory.getDriver().findElement(elemento).clear();
	}
	
	public String atributoElemento(By elemento, String nome) {
		return DriverFactory.getDriver().findElement(elemento).getAttribute(nome);
	}
	
	public String propriedadeCSSElemento(By elemento, String nomePropriedade) {
		return DriverFactory.getDriver().findElement(elemento).getCssValue(nomePropriedade);
	}
	
	public Dimension dimensaoElemento(By elemento) {
		return DriverFactory.getDriver().findElement(elemento).getSize();
	}
	
	public String nomeTagHTML(By elemento) {
		return DriverFactory.getDriver().findElement(elemento).getTagName();
	}
	
	public String textoElemento(By elemento) {
		return DriverFactory.getDriver().findElement(elemento).getText();
	}
	
	public Boolean elementoVisivelNaTela(By elemento) {
		return DriverFactory.getDriver().findElement(elemento).isDisplayed();
	}
	
	public Boolean elementoAtivoNaTela(By elemento) {
		return DriverFactory.getDriver().findElement(elemento).isEnabled();
	}
	
	public Boolean elementoSelecionadoNaTela(By elemento) {
		return DriverFactory.getDriver().findElement(elemento).isSelected();
	}
	
	public void enviaDadosDoFormularioParaOServirdor(By elemento) {
		DriverFactory.getDriver().findElement(elemento).submit();		
	}
	
	public void moverAteOElemento(By elemento) {
		Actions actions = new Actions(DriverFactory.getDriver());
		actions.moveToElement((WebElement) elemento);
		actions.perform();
	}
	
	public void acessarSite(String site) {
		DriverFactory.getDriver().get(site);
	}
	
//________________________________________________________Funções_Básicas_2____________________________________________________	
	public void esperaEstarClicavelClica(By elemento) {
		esperaEstarClicavel(elemento);
		clica(elemento);
	}
	
	public void limpaConteudoEscreve(By elemento, String escrita) {
		limpaConteudo(elemento);
		escreve(elemento, escrita);
	}
	
	public void clicaDuasVezes(By elemento) {
		clica(elemento);
		clica(elemento);
	}
	
	public void esperaEstarVisivel(By elemento) {
		esperaEstarClicavel(elemento);
	}
	
//________________________________________________________Funções_Básicas_3____________________________________________________
	
	public void printa() {
		evid.printaTela();
	}
	
	public void clicaPrinta(By elemento) {
		clica(elemento);
		printa();
	}
	
	public void esperaEstarClicavelClicaPrinta(By elemento) {
		esperaEstarClicavelClica(elemento);
		printa();
	}
	
	public void escrevePrinta(By elemento, String escrita) {
		escreve(elemento, escrita);
		printa();
	}
	
	public void esperaPrinta(By elemento, int tempo) {
		espera(tempo);
		printa();
	}
	
	public void gerarEvidencia(boolean res, String teste) {
		evid.gerarEvidencia(res, teste);
	}
	
	public void gerarEvidencia(String res, String teste) {
		evid.gerarEvidencia(res, teste);
	}
	
	public void esperaEstarClicavelPrinta(By elemento) {
		esperaEstarClicavel(elemento);
		printa();
	}
	
	public void esperaEstarClicavelPrinta(By elemento, int tempo) {
		esperaEstarClicavel(elemento);
		espera(tempo);
		printa();
	}
	
	public boolean validarTeste(By elemento, String teste) {
		String texto;
		Assert.assertEquals(elemento, teste);
		texto = DriverFactory.getDriver().findElement(elemento).getText();
		if(texto.equals(teste)) {
			return true;
		}else {
			return false;	
		}
	}
	
	public boolean validarTeste(By elemento) {
		try {
			DriverFactory.getWait().until(ExpectedConditions.presenceOfElementLocated(elemento));
			return true;
		} catch (Exception e2) {
			return false;
		}
	}
	
//________________________________________________________Funções_Básicas_Extra____________________________________________________

	public void urlDaPagina() {
		DriverFactory.getDriver().getCurrentUrl();
	}
	
	public void fechaJanela() {
		DriverFactory.getDriver().close();
	}
	
	public void fechaTodasJanelas() {
		DriverFactory.getDriver().quit();
	}

	public String origemDaPaginaWeb() {
		return DriverFactory.getDriver().getPageSource();
	}
	
	public String tituloDaPagina() {
		return DriverFactory.getDriver().getTitle();
	}
	
	public void espera(int tempo) {
		try {
			Thread.sleep(tempo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public Rectangle localizacaoEOTamanhoDoElemento(By elemento) {
		return DriverFactory.getDriver().findElement(elemento).getRect();
	}
}
