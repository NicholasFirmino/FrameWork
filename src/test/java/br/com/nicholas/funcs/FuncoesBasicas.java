package br.com.nicholas.funcs;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import br.com.nicholas.drivers.DriverFactory;

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
	/**M�todo que limpa conteudo e escreve
	 * 
	 * @author nicholas.firmino
	 * 
	 * @param elemento � o elemento a limpado e escrito
	 * @param escrita � o que vai ser escrito
	 */
	public void limpaConteudoEscreve(By elemento, String escrita) {
		limpaConteudo(elemento);
		escreve(elemento, escrita);
	}
	/**M�todo que limpa conteudo e escreve
	 * 
	 * @author nicholas.firmino
	 * 
	 * @param printa1 boolean para indicar se ira printar antes, true printa e false N�O printa
	 * @param elemento � o elemento a ser clicado
	 * @param printa2 boolean para indicar se ira printar depois, true printa e false N�O printa
	 * @param escrita � o que vai ser escrito
	 * @param printa3 boolean para indicar se ira printar antes, true printa e false N�O printa
	 */
	public void limpaConteudoEscreve(boolean printa1, By elemento, boolean printa2, String escrita, boolean printa3) {
		if(printa1) {
			printa();
		}
		limpaConteudo(elemento);
		if(printa2) {
			printa();
		}
		escreve(elemento, escrita);
		if(printa3) {
			printa();
		}
	}
//------------------------------------------------------------------------------------------------------------------------------
	/**M�todo que da dois clicks em um elemento
	 * 
	 * @author nicholas.firmino
	 * 
	 * @param elemento � o elemento a clicado duas vezes
	 */
	public void clicaDuasVezes(By elemento) {
		clica(elemento);
		clica(elemento);
	}
	
//________________________________________________________Fun��es_B�sicas_3____________________________________________________
	/**M�todo que printa a tela
	 * 
	 * @author nicholas.firmino
	 * 
	 */
	public void printa() {
		evid.printaTela();
	}
	
//-----------------------------------------------------------------------------------------------------------------------------
	/**M�todo que printa a tela
	 * 
	 * @author nicholas.firmino
	 * 
	 * @param status do teste(passed, failure ...)
	 * @param nomeTeste para o resultado na evidencia
	 */
	public void gerarEvidencia(String status, String nomeTeste) {
		evid.gerarEvidencia(status, nomeTeste);
	}
	
	/**M�todo que printa a tela
	 * 
	 * @author nicholas.firmino
	 * 
	 * @param status do teste(passed, failure ...)
	 * @param nomeTeste para o resultado na evidencia
	 */
	public void gerarEvidencia(boolean status, String nomeTeste) {
		evid.gerarEvidencia(status, nomeTeste);
	}
	
	/**M�todo que printa a tela
	 * 
	 * @author nicholas.firmino
	 * 
	 * @param printa boolean para indicar se ira printar antes, true printa e false N�O printa
	 * @param status do teste(passed, failure ...)
	 * @param nomeTeste para o resultado na evidencia
	 */
	public void gerarEvidencia(boolean printa,String status, String nomeTeste) {
		if(printa) {
			printa();
		}
		evid.gerarEvidencia(status, nomeTeste);
	}
	
	/**M�todo que printa a tela
	 * 
	 * @author nicholas.firmino
	 * 
	 * @param printa boolean para indicar se ira printar antes, true printa e false N�O printa
	 * @param status do teste(passed, failure ...)
	 * @param nomeTeste para o resultado na evidencia
	 */
	public void gerarEvidencia(boolean printa,boolean status, String nomeTeste) {
		if(printa) {
			printa();
		}
		evid.gerarEvidencia(status, nomeTeste);
	}
//------------------------------------------------------------------------------------------------------------------------------
	/**M�todo para validar teste, se o teste for igual ao conteudo texto do elemento return true se n�o false
	 * 
	 * @author nicholas.firmino
	 * 
	 * @param elemento � o elemento de referncia para verifica��o
	 * @param teste � a String a ser verficada com o texto
	 */
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
	
	/**M�todo para validar teste, se elemento for encontrado na pagina return true se n�o false
	 * 
	 * @author nicholas.firmino
	 * 
	 * @param elemento � o elemento de referncia para verifica��o
	 */
	public boolean validarTeste(By elemento) {
		try {
			DriverFactory.getWait().until(ExpectedConditions.presenceOfElementLocated(elemento));
			return true;
		} catch (Exception e2) {
			return false;
		}
	}
	
	/**M�todo para validar teste, se elemento for encontrado na pagina return true se n�o false
	 * 
	 * @author nicholas.firmino
	 * 
	 * @param elemento � o elemento de referncia para verifica��o
	 */
	public void esperaEstarClicavelClica(By elemento, boolean printa) {
		esperaEstarClicavelClica(elemento);
		clica(elemento);
		if(printa) {
			printa();
		}
	}
	
	/**M�todo que espera um determinado tempo e printa
	 * 
	 * @author nicholas.firmino
	 * 
	 * @param tempo determinado para espera
	 * @param printa boolean para indicar se ira printar depois, true printa e false N�O printa
	 */
	public void espera(int tempo, boolean printa) {
		espera(tempo);
		if(printa) {
			printa();
		}
		printa();
	}
	
	/**M�todo que espera elemento estar clicavel
	 * 
	 * @author nicholas.firmino
	 * 
	 * @param elemento que sera esperado para ser clicavel
	 * @param printa boolean para indicar se ira printar depois, true printa e false N�O printa
	 */
	public void esperaEstarClicavel(By elemento, boolean printa) {
		esperaEstarClicavel(elemento);
		if(printa) {
			printa();
		}
	}
	
	/**M�todo que espera elemento estar clicavel
	 * 
	 * @author nicholas.firmino
	 * 
	 * @param elemento que sera esperado para ser clicavel
	 * @param tempo para prosseguir os processos
	 */
	public void esperaEstarClicavel(By elemento, int tempo) {
		esperaEstarClicavel(elemento);
		espera(tempo);
	}
	
	/**M�todo que espera elemento estar clicavel
	 * 
	 * @author nicholas.firmino
	 * 
	 * @param elemento que sera esperado para ser clicavel
	 * @param espera determinado para continuar o processo
	 * @param printa boolean para indicar se ira printar depois, true printa e false N�O printa
	 */
	public void esperaEstarClicavel(By elemento, int tempo, boolean printa) {
		esperaEstarClicavel(elemento);
		espera(tempo);
		if(printa) {
			printa();
		}
	}
	
//________________________________________________________Fun��es_B�sicas_Extra____________________________________________________
	
	/**M�todo que retorna a url da pagina
	 * 
	 * @author nicholas.firmino
	 * 
	 */
	public String urlDaPagina() {
		return DriverFactory.getDriver().getCurrentUrl();
	}
	
	/**M�todo que fecha a janela aberta
	 * 
	 * @author nicholas.firmino
	 * 
	 */
	public void fechaJanela() {
		DriverFactory.getDriver().close();
	}
	
	/**M�todo que fecha a janela todas as janelas 
	 * 
	 * @author nicholas.firmino
	 * 
	 */
	public void fechaTodasJanelas() {
		DriverFactory.getDriver().quit();
	}

	/**M�todo que retorna o c�digo fonte da p�gina que foi armazenada como string
	 * 
	 * @author nicholas.firmino
	 * 
	 */	
	public String origemDaPaginaWeb() {
		return DriverFactory.getDriver().getPageSource();
	}
	
	/**M�todo que retorna o c�digo fonte da p�gina que foi armazenada como string
	 * 
	 * @author nicholas.firmino
	 * 
	 */	
	public String tituloDaPagina() {
		return DriverFactory.getDriver().getTitle();
	}
	
	/**M�todo que espera um determinado tempo
	 * 
	 * @author nicholas.firmino
	 * 
	 * @param tempo � valor em ms a ser esperado
	 * 
	 */	
	public void espera(int tempo) {
		try {
			Thread.sleep(tempo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	/**M�todo que retorna a localiza��o e o tamaanho do elemento
	 * 
	 * @author nicholas.firmino
	 * 
	 * @param elemento � o objeto referencia da localiza��o e para o tamanho
	 * 
	 */	
	public Rectangle localizacaoEOTamanhoDoElemento(By elemento) {
		return DriverFactory.getDriver().findElement(elemento).getRect();
	}

	
}
