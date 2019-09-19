/*--Configuracao--
 * Classe de configuiracao basica, como, instaciar o driver e finalizalo
 */


package br.com.nicholas.drivers;

import java.io.File;
import java.io.IOException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.nicholas.funcs.FuncoesBasicas;
import cucumber.api.Scenario;

public class DriverFactory {
	
	private static WebDriver driver;
	private static WebDriverWait wait;
	public static String nomeTeste;
	
	static FuncoesBasicas fb;
	
	/*metodo getDriver usado para pegar Webdriver instaciado
	 * 
	 */
	public static WebDriver getDriver() {	
		if(driver == null) {
			inicializaDriver();
		}
		return driver;
	}
	
	/*metodo getDriver usado para pegar Webdriver instaciado
	 * 
	 */
	public static WebDriverWait getWait() {
		if(wait == null) {
			wait = new WebDriverWait(driver,15);
		}
		return wait;
	}
	
	/*metodo de inicializacao
	 * 
	 */
	@Before
	public static void inicializa(Scenario scenario) {	
		inicializaDriver();
		nomeTeste = scenario.getName();
	}
	
	/*metodo de finalizacao
	 * 
	 */
	@After	
	public static void finaliza(Scenario scenario) {
		fb = new FuncoesBasicas();
		if(!scenario.getStatus().equals("passed")) {
			fb.printa();
		}
		fb.gerarEvidencia(true, scenario.getStatus(), nomeTeste);
		if(driver != null) {
			driver.quit();
		}
	}
	
	public static void inicializaDriver() {
		try {
			System.setProperty("webdriver.chrome.driver", new File("./drivers/chromedriver.exe").getCanonicalPath());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver,15);
	}
}