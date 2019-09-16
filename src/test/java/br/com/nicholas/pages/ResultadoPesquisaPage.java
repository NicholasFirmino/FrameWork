package br.com.nicholas.pages;

import org.openqa.selenium.By;

public class ResultadoPesquisaPage {
	public By logoGoogle() {return By.xpath("//*[@id='logo']");}
	
	public By barraDePesquisa() {return By.xpath("//*[@class='vdLsw gsfi']");}
	
	public By resultadoPesquisa() {return By.xpath("//*[@id='resultStats']");}
}
