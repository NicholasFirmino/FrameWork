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
	/**Método que limpa conteudo e escreve
	 * 
	 * @author nicholas.firmino
	 * 
	 * @param elemento é o elemento a limpado e escrito
	 * @param escrita é o que vai ser escrito
	 */
	public void limpaConteudoEscreve(By elemento, String escrita) {
		limpaConteudo(elemento);
		escreve(elemento, escrita);
	}
	/**Método que limpa conteudo e escreve
	 * 
	 * @author nicholas.firmino
	 * 
	 * @param printa1 boolean para indicar se ira printar antes, true printa e false NÃO printa
	 * @param elemento é o elemento a ser clicado
	 * @param printa2 boolean para indicar se ira printar depois, true printa e false NÃO printa
	 * @param escrita é o que vai ser escrito
	 * @param printa3 boolean para indicar se ira printar antes, true printa e false NÃO printa
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
	/**Método que da dois clicks em um elemento
	 * 
	 * @author nicholas.firmino
	 * 
	 * @param elemento é o elemento a clicado duas vezes
	 */
	public void clicaDuasVezes(By elemento) {
		clica(elemento);
		clica(elemento);
	}
	
//________________________________________________________Funções_Básicas_3____________________________________________________
	/**Método que printa a tela
	 * 
	 * @author nicholas.firmino
	 * 
	 */
	public void printa() {
		evid.printaTela();
	}
	
//-----------------------------------------------------------------------------------------------------------------------------
	/**Método que printa a tela
	 * 
	 * @author nicholas.firmino
	 * 
	 * @param status do teste(passed, failure ...)
	 * @param nomeTeste para o resultado na evidencia
	 */
	public void gerarEvidencia(String status, String nomeTeste) {
		evid.gerarEvidencia(status, nomeTeste);
	}
	
	/**Método que printa a tela
	 * 
	 * @author nicholas.firmino
	 * 
	 * @param status do teste(passed, failure ...)
	 * @param nomeTeste para o resultado na evidencia
	 */
	public void gerarEvidencia(boolean status, String nomeTeste) {
		evid.gerarEvidencia(status, nomeTeste);
	}
	
	/**Método que printa a tela
	 * 
	 * @author nicholas.firmino
	 * 
	 * @param printa boolean para indicar se ira printar antes, true printa e false NÃO printa
	 * @param status do teste(passed, failure ...)
	 * @param nomeTeste para o resultado na evidencia
	 */
	public void gerarEvidencia(boolean printa,String status, String nomeTeste) {
		if(printa) {
			printa();
		}
		evid.gerarEvidencia(status, nomeTeste);
	}
	
	/**Método que printa a tela
	 * 
	 * @author nicholas.firmino
	 * 
	 * @param printa boolean para indicar se ira printar antes, true printa e false NÃO printa
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
	/**Método para validar teste, se o teste for igual ao conteudo texto do elemento return true se não false
	 * 
	 * @author nicholas.firmino
	 * 
	 * @param elemento é o elemento de referncia para verificação
	 * @param teste é a String a ser verficada com o texto
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
	
	/**Método para validar teste, se elemento for encontrado na pagina return true se não false
	 * 
	 * @author nicholas.firmino
	 * 
	 * @param elemento é o elemento de referncia para verificação
	 */
	public boolean validarTeste(By elemento) {
		try {
			DriverFactory.getWait().until(ExpectedConditions.presenceOfElementLocated(elemento));
			return true;
		} catch (Exception e2) {
			return false;
		}
	}
	
	/**Método para validar teste, se elemento for encontrado na pagina return true se não false
	 * 
	 * @author nicholas.firmino
	 * 
	 * @param elemento é o elemento de referncia para verificação
	 */
	public void esperaEstarClicavelClica(By elemento, boolean printa) {
		esperaEstarClicavelClica(elemento);
		clica(elemento);
		if(printa) {
			printa();
		}
	}
	
	/**Método que espera um determinado tempo e printa
	 * 
	 * @author nicholas.firmino
	 * 
	 * @param tempo determinado para espera
	 * @param printa boolean para indicar se ira printar depois, true printa e false NÃO printa
	 */
	public void espera(int tempo, boolean printa) {
		espera(tempo);
		if(printa) {
			printa();
		}
		printa();
	}
	
	/**Método que espera elemento estar clicavel
	 * 
	 * @author nicholas.firmino
	 * 
	 * @param elemento que sera esperado para ser clicavel
	 * @param printa boolean para indicar se ira printar depois, true printa e false NÃO printa
	 */
	public void esperaEstarClicavel(By elemento, boolean printa) {
		esperaEstarClicavel(elemento);
		if(printa) {
			printa();
		}
	}
	
	/**Método que espera elemento estar clicavel
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
	
	/**Método que espera elemento estar clicavel
	 * 
	 * @author nicholas.firmino
	 * 
	 * @param elemento que sera esperado para ser clicavel
	 * @param espera determinado para continuar o processo
	 * @param printa boolean para indicar se ira printar depois, true printa e false NÃO printa
	 */
	public void esperaEstarClicavel(By elemento, int tempo, boolean printa) {
		esperaEstarClicavel(elemento);
		espera(tempo);
		if(printa) {
			printa();
		}
	}
	
//________________________________________________________Funções_Básicas_Extra____________________________________________________
	
	/**Método que retorna a url da pagina
	 * 
	 * @author nicholas.firmino
	 * 
	 */
	public String urlDaPagina() {
		return DriverFactory.getDriver().getCurrentUrl();
	}
	
	/**Método que fecha a janela aberta
	 * 
	 * @author nicholas.firmino
	 * 
	 */
	public void fechaJanela() {
		DriverFactory.getDriver().close();
	}
	
	/**Método que fecha a janela todas as janelas 
	 * 
	 * @author nicholas.firmino
	 * 
	 */
	public void fechaTodasJanelas() {
		DriverFactory.getDriver().quit();
	}

	/**Método que retorna o código fonte da página que foi armazenada como string
	 * 
	 * @author nicholas.firmino
	 * 
	 */	
	public String origemDaPaginaWeb() {
		return DriverFactory.getDriver().getPageSource();
	}
	
	/**Método que retorna o código fonte da página que foi armazenada como string
	 * 
	 * @author nicholas.firmino
	 * 
	 */	
	public String tituloDaPagina() {
		return DriverFactory.getDriver().getTitle();
	}
	
	/**Método que espera um determinado tempo
	 * 
	 * @author nicholas.firmino
	 * 
	 * @param tempo é valor em ms a ser esperado
	 * 
	 */	
	public void espera(int tempo) {
		try {
			Thread.sleep(tempo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	/**Método que retorna a localização e o tamaanho do elemento
	 * 
	 * @author nicholas.firmino
	 * 
	 * @param elemento é o objeto referencia da localização e para o tamanho
	 * 
	 */	
	public Rectangle localizacaoEOTamanhoDoElemento(By elemento) {
		return DriverFactory.getDriver().findElement(elemento).getRect();
	}

	
}
