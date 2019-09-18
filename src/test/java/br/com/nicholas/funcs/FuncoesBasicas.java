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

//________________________________________________________Fun��es_B�sicas_1____________________________________________________
	/**M�todo para clicar em elemento.
	 * 
	 * @author nicholas.firmino
	 * 
	 * @param elemento � o elemento a ser clicado.
	 */
	public void clica(By elemento) {
		DriverFactory.getDriver().findElement(elemento).click();
	}
	
	/**M�todo para clicar em elemento com os paramentos de print.
	 * 
	 * @author nicholas.firmino
	 * 
	 * @param printa1 boolean para indicar se ira printar antes, true printa e false N�O printa
	 * @param elemento � o elemento a ser clicado.
	 * @param printa2 boolean para indicar se ira printar depois, true printa e false N�O printa
	 */
	public void clica(boolean printa1, By elemento, boolean printa2) {
		if(printa1) {
			printa();
		}
		DriverFactory.getDriver().findElement(elemento).click();
		if(printa2) {
			printa();
		}
	}
//-------------------------------------------------------------------------------------------------------------------------------
	
	/**M�todo que espera at� o elemtento estar clicavel
	 * 
	 * @author nicholas.firmino
	 * 
	 * @param elemento � o elemento que deve ser esperado a estar clicavel
	 */
	public void esperaEstarClicavel(By elemento) {
		DriverFactory.getWait().until(ExpectedConditions.elementToBeClickable(elemento));
	}
	
	/**M�todo que espera at� o elemtento estar clicavel com os paramentros de print
	 * 
	 * @author nicholas.firmino
	 * 
	 * @param printa1 boolean para indicar se ira printar antes, true printa e false N�O printa
	 * @param elemento � o elemento a ser clicado.
	 * @param printa2 boolean para indicar se ira printar depois, true printa e false N�O printa
	 */
	public void esperaEstarClicavel(boolean printa1, By elemento, boolean printa2) {
		if(printa1) {
			printa();
		}
		DriverFactory.getWait().until(ExpectedConditions.elementToBeClickable(elemento));
		if(printa2) {
			printa();
		}
	}
//------------------------------------------------------------------------------------------------------------------------------
	/**M�todo para escreve no elemento.
	 * 
	 * @author nicholas.firmino
	 * 
	 * @param elemento � o elemento que deve ser escrito
	 * @param escrita � o que ser� escrito no elemento
	 */
	public void escreve(By elemento, String escrita) {
		DriverFactory.getDriver().findElement(elemento).sendKeys(escrita);
	}
	/**M�todo para escreve no elemento.
	 * 
	 * @author nicholas.firmino
	 * 
	 * @param printa1 boolean para indicar se ira printar antes, true printa e false N�O printa
	 * @param elemento � o elemento a ser clicado.
	 * @param escrita � o que ser� escrito no elemento
	 * @param printa2 boolean para indicar se ira printar depois, true printa e false N�O printa
	 */
	public void escreve(boolean printa1, By elemento, String escrita, boolean printa2) {
		if(printa1) {
			printa();
		}
		DriverFactory.getDriver().findElement(elemento).sendKeys(escrita);
		if(printa2) {
			printa();
		}
	}
//-----------------------------------------------------------------------------------------------------------------------------
	/**M�todo para limpar conteudo
	 * 
	 * @author nicholas.firmino
	 * 
	 * @param elemento � o elemento que deve ser limpado
	 */
	public void limpaConteudo(By elemento) {
		DriverFactory.getDriver().findElement(elemento).clear();
	}
	/**M�todo para limpar conteudo
	 * 
	 * @author nicholas.firmino
	 * 
	 * @param printa1 boolean para indicar se ira printar antes, true printa e false N�O printa
	 * @param elemento � o elemento que deve ser limpado
	 * @param printa2 boolean para indicar se ira printar depois, true printa e false N�O printa
	 */
	public void limpaConteudo(boolean printa1,By elemento, boolean printa2) {
		if(printa1) {
			printa();
		}
		DriverFactory.getDriver().findElement(elemento).clear();
		if(printa2) {
			printa();
		}
	}
//-----------------------------------------------------------------------------------------------------------------------------
	/**M�todo que atraves de um elemento retorna o resultado da busca de um atributo
	 * 
	 * @author nicholas.firmino
	 * 
	 * @param elemento � o elemento a ser verificado
	 * @param nomeAtributo � o tipo de atributo que deve ser consultado
	 */
	public String atributoElemento(By elemento, String nomeAtributo) {
		return DriverFactory.getDriver().findElement(elemento).getAttribute(nomeAtributo);
	}
	
	/**M�todo que atraves de um elemento retorna o resultado da busca da propriedade
	 * 
	 * @author nicholas.firmino
	 * 
	 * @param elemento � o elemento a ser verificado as propriedades
	 * @param nomePropriedade � o tipo de propriedade CSS que deve ser consultado
	 */
	public String propriedadeCSSElemento(By elemento, String nomePropriedade) {
		return DriverFactory.getDriver().findElement(elemento).getCssValue(nomePropriedade);
	}
	
	/**M�todo que atraves de um elemento retorna a dimens�o do mesmo em string
	 * @author nicholas.firmino
	 * 
	 * @param elemento � o elemento a ser verificado as dimensoes
	 */
	public String dimensaoElementoString(By elemento) {
		Dimension dim = DriverFactory.getDriver().findElement(elemento).getSize();
		return dim.toString();
	}
	
	/**M�todo que atraves de um elemento retorna a dimens�o do mesmo
	 * @author nicholas.firmino
	 * 
	 * @param elemento � o elemento a ser verificado as dimensoes
	 */
	public Dimension dimensaoElemento(By elemento) {
		return DriverFactory.getDriver().findElement(elemento).getSize();
	}
	
	/**M�todo que atraves de um elemento retorna o nome da tag
	 * 
	 * @author nicholas.firmino
	 * 
	 * @param elemento � o elemento da busca da tag
	 */
	public String nomeTagHTML(By elemento) {
		return DriverFactory.getDriver().findElement(elemento).getTagName();
	}
	
	/**M�todo que atraves de um elemento retorna o texto dele
	 * 
	 * @author nicholas.firmino
	 * 
	 * @param elemento � o elemento a ser verificado o texto
	 */
	public String textoElemento(By elemento) {
		return DriverFactory.getDriver().findElement(elemento).getText();
	}
	
	/**M�todo que atraves de um elemento verifica se ele esta visivel
	 * 
	 * @author nicholas.firmino
	 * 
	 * @param elemento � o elemento a ser verificado se esta visivel
	 */
	public Boolean elementoVisivelNaTela(By elemento) {
		return DriverFactory.getDriver().findElement(elemento).isDisplayed();
	}
	
	/**M�todo que atraves de um elemento verifica se ele esta ativo
	 * 
	 * @author nicholas.firmino
	 * 
	 * @param elemento � o elemento a ser verificado se esta ativo
	 */
	public Boolean elementoAtivoNaTela(By elemento) {
		return DriverFactory.getDriver().findElement(elemento).isEnabled();
	}
	
	/**M�todo que atraves de um elemento verifica se ele esta selecionado
	 * 
	 * @author nicholas.firmino
	 * 
	 * @param elemento � o elemento a ser verificado se esta selecionado
	 */
	public Boolean elementoSelecionadoNaTela(By elemento) {
		return DriverFactory.getDriver().findElement(elemento).isSelected();
	}
	
	/**M�todo que atraves de um elemento envia os dados dele(formulario) para o servidor -->submit
	 * 
	 * @author nicholas.firmino
	 * 
	 * @param elemento � o formulario a ser submetido 
	 */
	public void enviaDadosDoFormularioParaOServirdor(By elemento) {
		DriverFactory.getDriver().findElement(elemento).submit();		
	}
//-------------------------------------------------------------------------------------------------------------------------------	
	/**M�todo que move tela at� o elemento
	 * 
	 * @author nicholas.firmino
	 * 
	 * @param elemento � o elemento referencia
	 */
	public void moverAteOElemento(By elemento) {
		Actions actions = new Actions(DriverFactory.getDriver());
		actions.moveToElement((WebElement) elemento);
		actions.perform();
	}
	/**M�todo que move tela at� o elemento
	 * 
	 * @author nicholas.firmino
	 * 
	 * @param printa1 boolean para indicar se ira printar antes, true printa e false N�O printa
	 * @param elemento � o elemento referencia
	 * @param printa2 boolean para indicar se ira printar depois, true printa e false N�O printa
	 */
	public void moverAteOElemento(boolean printa1, By elemento, boolean printa2) {
		if(printa1) {
			printa();
		}
		Actions actions = new Actions(DriverFactory.getDriver());
		actions.moveToElement((WebElement) elemento);
		actions.perform();
		if(printa2) {
			printa();
		}
	}
//-------------------------------------------------------------------------------------------------------------------------------
	/**M�todo que acessa um site
	 * 
	 * @author nicholas.firmino
	 * 
	 * @param site � o site a ser acessado
	 */
	public void acessarSite(String site) {
		DriverFactory.getDriver().get(site);
	}
	
	/**M�todo que acessa um site
	 * 
	 * @author nicholas.firmino
	 * 
	 * @param printa1 boolean para indicar se ira printar antes, true printa e false N�O printa
	 * @param site � o site a ser acessado
	 * @param printa2 boolean para indicar se ira printar depois, true printa e false N�O printa
	 */
	public void acessarSite(boolean printa1, String site, boolean printa2) {
		if(printa1) {
			printa();
		}
		DriverFactory.getDriver().get(site);
		if(printa2) {
			printa();
		}
	}
	
//________________________________________________________Fun��es_B�sicas_2____________________________________________________	
	/**M�todo que espera um elemento estar clicavel e clica
	 * 
	 * @author nicholas.firmino
	 * 
	 * @param elemento � o elemento a ser clicado
	 */
	public void esperaEstarClicavelClica(By elemento) {
		esperaEstarClicavel(elemento);
		clica(elemento);
	}
	/**M�todo que acessa um site
	 * 
	 * @author nicholas.firmino
	 * 
	 * @param printa1 boolean para indicar se ira printar antes, true printa e false N�O printa
	 * @param elemento � o elemento a ser clicado
	 * @param printa2 boolean para indicar se ira printar depois, true printa e false N�O printa
	 */
	public void esperaEstarClicavelClica(boolean printa1, By elemento, boolean printa2) {
		if(printa1) {
			printa();
		}
		esperaEstarClicavel(elemento);
		clica(elemento);
		if(printa2) {
			printa();
		}
	}
//------------------------------------------------------------------------------------------------------------------------------
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
	
//________________________________________________________Fun��es_B�sicas_3____________________________________________________
	
	public void printa() {
		evid.printaTela();
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
	
//________________________________________________________Fun��es_B�sicas_Extra____________________________________________________

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
