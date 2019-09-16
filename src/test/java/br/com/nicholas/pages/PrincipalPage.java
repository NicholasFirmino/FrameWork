package br.com.nicholas.pages;

import org.openqa.selenium.By;

public class PrincipalPage {
	public By logoGoogle() {return By.xpath("//*[@id='hplogo']");}
	
	public By barraDePesquisa() {return By.xpath("//*[@title='Pesquisar']");}
	
	public By btnPesquisaGoogle() {return By.xpath("(//*[@class='gNO89b'])[1]");}
}
