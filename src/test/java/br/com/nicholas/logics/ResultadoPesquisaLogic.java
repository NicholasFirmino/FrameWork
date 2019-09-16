package br.com.nicholas.logics;

import org.junit.Assert;

import br.com.nicholas.funcs.FuncoesBasicas;
import br.com.nicholas.pages.PrincipalPage;
import br.com.nicholas.pages.ResultadoPesquisaPage;

public class ResultadoPesquisaLogic extends FuncoesBasicas{
	PrincipalPage page1 = new PrincipalPage();
	ResultadoPesquisaPage page2 = new ResultadoPesquisaPage();
	
	public void validoAPesquisaGoogle() {
		Assert.assertTrue(validarTeste(page2.resultadoPesquisa()));
	}
}


