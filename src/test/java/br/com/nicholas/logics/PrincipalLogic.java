package br.com.nicholas.logics;

import br.com.nicholas.funcs.FuncoesBasicas;
import br.com.nicholas.funcs.FuncoesExcel;
import br.com.nicholas.pages.PrincipalPage;

public class PrincipalLogic extends FuncoesBasicas{
	PrincipalPage page = new PrincipalPage();
	FuncoesExcel fe = new FuncoesExcel("./dados/pesquisasGoogle.xlsx", 0);
	
	public void euEntroNoSiteDoGoogle() {
		acessarSite("https://www.google.com/");
		esperaEstarClicavelPrinta(page.barraDePesquisa(), 2000);
	}
	
	public void pesquiso_no_Google(String id, String campo) throws Throwable {
		escrevePrinta(page.barraDePesquisa(), fe.getMassaPeloId(id, campo));
		clicaPrinta(page.btnPesquisaGoogle());
	}
}


