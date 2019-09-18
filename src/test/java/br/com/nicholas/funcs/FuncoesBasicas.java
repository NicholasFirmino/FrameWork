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
	/**Método para clicar em elemento.
	 * 
	 * @author nicholas.firmino
	 * 
	 * @param elemento é o elemento a ser clicado.
	 */
	public void clica(By elemento) {
		DriverFactory.getDriver().findElement(elemento).click();
	}
	
	/**Método para clicar em elemento com os paramentos de print.
	 * 
	 * @author nicholas.firmino
	 * 
	 * @param printa1 boolean para indicar se ira printar antes, true printa e false NÃO printa
	 * @param elemento é o elemento a ser clicado.
	 * @param printa2 boolean para indicar se ira printar depois, true printa e false NÃO printa
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
	
	/**Método que espera até o elemtento estar clicavel
	 * 
	 * @author nicholas.firmino
	 * 
	 * @param elemento é o elemento que deve ser esperado a estar clicavel
	 */
	public void esperaEstarClicavel(By elemento) {
		DriverFactory.getWait().until(ExpectedConditions.elementToBeClickable(elemento));
	}
	
	/**Método que espera até o elemtento estar clicavel com os paramentros de print
	 * 
	 * @author nicholas.firmino
	 * 
	 * @param printa1 boolean para indicar se ira printar antes, true printa e false NÃO printa
	 * @param elemento é o elemento a ser clicado.
	 * @param printa2 boolean para indicar se ira printar depois, true printa e false NÃO printa
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
	/**Método para escreve no elemento.
	 * 
	 * @author nicholas.firmino
	 * 
	 * @param elemento é o elemento que deve ser escrito
	 * @param escrita é o que será escrito no elemento
	 */
	public void escreve(By elemento, String escrita) {
		DriverFactory.getDriver().findElement(elemento).sendKeys(escrita);
	}
	/**Método para escreve no elemento.
	 * 
	 * @author nicholas.firmino
	 * 
	 * @param printa1 boolean para indicar se ira printar antes, true printa e false NÃO printa
	 * @param elemento é o elemento a ser clicado.
	 * @param escrita é o que será escrito no elemento
	 * @param printa2 boolean para indicar se ira printar depois, true printa e false NÃO printa
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
	/**Método para limpar conteudo
	 * 
	 * @author nicholas.firmino
	 * 
	 * @param elemento é o elemento que deve ser limpado
	 */
	public void limpaConteudo(By elemento) {
		DriverFactory.getDriver().findElement(elemento).clear();
	}
	/**Método para limpar conteudo
	 * 
	 * @author nicholas.firmino
	 * 
	 * @param printa1 boolean para indicar se ira printar antes, true printa e false NÃO printa
	 * @param elemento é o elemento que deve ser limpado
	 * @param printa2 boolean para indicar se ira printar depois, true printa e false NÃO printa
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
	/**Método que atraves de um elemento retorna o resultado da busca de um atributo
	 * 
	 * @author nicholas.firmino
	 * 
	 * @param elemento é o elemento a ser verificado
	 * @param nomeAtributo é o tipo de atributo que deve ser consultado
	 */
	public String atributoElemento(By elemento, String nomeAtributo) {
		return DriverFactory.getDriver().findElement(elemento).getAttribute(nomeAtributo);
	}
	
	/**Método que atraves de um elemento retorna o resultado da busca da propriedade
	 * 
	 * @author nicholas.firmino
	 * 
	 * @param elemento é o elemento a ser verificado as propriedades
	 * @param nomePropriedade é o tipo de propriedade CSS que deve ser consultado
	 */
	public String propriedadeCSSElemento(By elemento, String nomePropriedade) {
		return DriverFactory.getDriver().findElement(elemento).getCssValue(nomePropriedade);
	}
	
	/**Método que atraves de um elemento retorna a dimensão do mesmo em string
	 * @author nicholas.firmino
	 * 
	 * @param elemento é o elemento a ser verificado as dimensoes
	 */
	public String dimensaoElementoString(By elemento) {
		Dimension dim = DriverFactory.getDriver().findElement(elemento).getSize();
		return dim.toString();
	}
	
	/**Método que atraves de um elemento retorna a dimensão do mesmo
	 * @author nicholas.firmino
	 * 
	 * @param elemento é o elemento a ser verificado as dimensoes
	 */
	public Dimension dimensaoElemento(By elemento) {
		return DriverFactory.getDriver().findElement(elemento).getSize();
	}
	
	/**Método que atraves de um elemento retorna o nome da tag
	 * 
	 * @author nicholas.firmino
	 * 
	 * @param elemento é o elemento da busca da tag
	 */
	public String nomeTagHTML(By elemento) {
		return DriverFactory.getDriver().findElement(elemento).getTagName();
	}
	
	/**Método que atraves de um elemento retorna o texto dele
	 * 
	 * @author nicholas.firmino
	 * 
	 * @param elemento é o elemento a ser verificado o texto
	 */
	public String textoElemento(By elemento) {
		return DriverFactory.getDriver().findElement(elemento).getText();
	}
	
	/**Método que atraves de um elemento verifica se ele esta visivel
	 * 
	 * @author nicholas.firmino
	 * 
	 * @param elemento é o elemento a ser verificado se esta visivel
	 */
	public Boolean elementoVisivelNaTela(By elemento) {
		return DriverFactory.getDriver().findElement(elemento).isDisplayed();
	}
	
	/**Método que atraves de um elemento verifica se ele esta ativo
	 * 
	 * @author nicholas.firmino
	 * 
	 * @param elemento é o elemento a ser verificado se esta ativo
	 */
	public Boolean elementoAtivoNaTela(By elemento) {
		return DriverFactory.getDriver().findElement(elemento).isEnabled();
	}
	
	/**Método que atraves de um elemento verifica se ele esta selecionado
	 * 
	 * @author nicholas.firmino
	 * 
	 * @param elemento é o elemento a ser verificado se esta selecionado
	 */
	public Boolean elementoSelecionadoNaTela(By elemento) {
		return DriverFactory.getDriver().findElement(elemento).isSelected();
	}
	
	/**Método que atraves de um elemento envia os dados dele(formulario) para o servidor -->submit
	 * 
	 * @author nicholas.firmino
	 * 
	 * @param elemento é o formulario a ser submetido 
	 */
	public void enviaDadosDoFormularioParaOServirdor(By elemento) {
		DriverFactory.getDriver().findElement(elemento).submit();		
	}
//-------------------------------------------------------------------------------------------------------------------------------	
	/**Método que move tela até o elemento
	 * 
	 * @author nicholas.firmino
	 * 
	 * @param elemento é o elemento referencia
	 */
	public void moverAteOElemento(By elemento) {
		Actions actions = new Actions(DriverFactory.getDriver());
		actions.moveToElement((WebElement) elemento);
		actions.perform();
	}
	/**Método que move tela até o elemento
	 * 
	 * @author nicholas.firmino
	 * 
	 * @param printa1 boolean para indicar se ira printar antes, true printa e false NÃO printa
	 * @param elemento é o elemento referencia
	 * @param printa2 boolean para indicar se ira printar depois, true printa e false NÃO printa
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
	/**Método que acessa um site
	 * 
	 * @author nicholas.firmino
	 * 
	 * @param site é o site a ser acessado
	 */
	public void acessarSite(String site) {
		DriverFactory.getDriver().get(site);
	}
	
	/**Método que acessa um site
	 * 
	 * @author nicholas.firmino
	 * 
	 * @param printa1 boolean para indicar se ira printar antes, true printa e false NÃO printa
	 * @param site é o site a ser acessado
	 * @param printa2 boolean para indicar se ira printar depois, true printa e false NÃO printa
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
	
//________________________________________________________Funções_Básicas_2____________________________________________________	
	/**Método que espera um elemento estar clicavel e clica
	 * 
	 * @author nicholas.firmino
	 * 
	 * @param elemento é o elemento a ser clicado
	 */
	public void esperaEstarClicavelClica(By elemento) {
		esperaEstarClicavel(elemento);
		clica(elemento);
	}
	/**Método que acessa um site
	 * 
	 * @author nicholas.firmino
	 * 
	 * @param printa1 boolean para indicar se ira printar antes, true printa e false NÃO printa
	 * @param elemento é o elemento a ser clicado
	 * @param printa2 boolean para indicar se ira printar depois, true printa e false NÃO printa
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
	
//________________________________________________________Funções_Básicas_3____________________________________________________
	
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
