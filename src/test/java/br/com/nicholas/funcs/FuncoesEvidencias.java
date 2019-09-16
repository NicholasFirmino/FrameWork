/*FuncoesBasicas
 * Classe que contem as funcoes para criacao de pasta e para tirar as screenshots
 */
package br.com.nicholas.funcs;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import br.com.nicholas.configs.DriverFactory;

public class FuncoesEvidencias {
	
	String diretorioEvidencias;
	String diretorioData;
	String diretorioResultado;
	String diretorioTeste;
	String diretorioHorarioTeste;
	String caminho;
	String nomeTeste;
	boolean passOrFail;
	private static List<File> src;
	private static List<String> nomePage;
	
	private static List<File> getSRC(){
		if(src == null) {
			src = new ArrayList<File>();
		}
		return src;
	}
	
	private static List<String> getNomePage(){
		if(nomePage == null) {
			nomePage = new ArrayList<String>();
		}
		return nomePage;
	}
	
	/*cria a String como data e hora recebendo a data e hora como parametro
	 * 
	 */
	public String geraDataHora(String data, String hora) {
		StringBuilder txt = new StringBuilder();	//cria a variavel txt como StringBuilder(Essa classe permite criar e manipular dados de Strings dinamicamente, ou seja, podem criar variáveis de String modificáveis.)
		txt.append(data).append(hora);	//append = adiciona string uma a outra
		return txt.toString();	//retorna txt como uma String
	}
	
	/*cria uma String do calendario gregoriano com a data atraves do local
	 *retorna a String formatada
	 */
	public String geraData() {
		String  txt="";	//declara a String txt
		Locale locale = new Locale("pt","BR");	//cria um objeto do tipo locale(pt, br), em portugues Brasil
		GregorianCalendar calendar = new GregorianCalendar();	//cria um objeto calendar(calendario Gregoriano)
		SimpleDateFormat formatador = new SimpleDateFormat("dd '_de_' MMMMM '_de_' yyyy",locale); //cria o objeto formatador(SimpleDateFormat) que recebe como o paremetro o formato da data
		txt = formatador.format(calendar.getTime());	//formatador executa o metodo format recebendo como parametro calendar pegando a data 
		return txt;	//retorna o txt formatado em dia mes e ano
	}
	
	/*cria uma String do calendario gregoriano com horario atraves do local
	 *retorna a String formatada
	 */
	public String geraHorario() {
		String  txt="";	//declara a String txt
		Locale locale = new Locale("pt","BR");	//cria um objeto do tipo locale(pt, br), em portugues Brasil
		GregorianCalendar calendar = new GregorianCalendar();  //cria um objeto calendar(calendario Gregoriano)
		SimpleDateFormat formatador = new SimpleDateFormat("HH'h'mm'm'ss's'",locale);	//cria o objeto formatador(SimpleDateFormat) que recebe como o paremetro o formato do horario
		txt = formatador.format(calendar.getTime());	//formatador executa o metodo format recebendo como parametro calendar pegando o horario
		return txt;	//retorna o txt formatado em hora e minuto
	}
	
	public boolean criaPastaEvidencias() {
		this.diretorioEvidencias = System.getProperty("user.dir").concat("\\evidencias\\");	//cria a o caminho da pasta
		File diretorio = new File(diretorioEvidencias);	//cria um arquivo diretorio com caminho da pasta 
		if (!diretorio.exists()) {	//se diretorio nao existir 
			diretorio.mkdirs();	//cria o diretorio
			return true; //retorna verdadeiro
		} else {	//caso contrario
			return false;	//retorna falso
		}
	}
	
	/*cria pasta para armazenar as screenshot em Evidencias com o nome AUTOMACAO_ mais o conteudo do geraData
	 *caso a pasta ja esteja criada no diretorio printa uma mensagem "Diretorio ja existe" e cria nada 
	 */
	public boolean criaPastaComAData() {
		
		criaPastaEvidencias();
		
		this.diretorioData = diretorioEvidencias.concat(geraData());	//cria a o caminho da pasta
		File diretorio = new File(diretorioData);	//cria um arquivo diretorio com caminho da pasta 
		if (!diretorio.exists()) {	//se diretorio nao existir 
			diretorio.mkdirs();	//cria o diretorio
			return true; //retorna verdadeiro
		} else {	//caso contrario
			return false;	//retorna falso
		}
	}

	public boolean criaPastaResultado() {
		
		String resultado = "failure";
		if(passOrFail) {
			resultado = "sucess";
		}
		
		criaPastaComAData();
	
		this.diretorioResultado = diretorioData.concat("\\").concat(resultado);	//cria o caminho da pasta
		File diretorio = new File(diretorioResultado);	//cria um arquivo diretorio com caminho da pasta 
		if (!diretorio.exists()) {	//se diretorio nao existir 
			diretorio.mkdirs();	//cria o diretorio
			return true; //retorna verdadeiro
		} else {	//caso contrario
			return false;	//retorna falso
		}
	}
	

	public boolean criaPastaTeste() {
		
		criaPastaResultado();
		
		this.diretorioTeste = diretorioResultado.concat("\\").concat(nomeTeste);	//cria a o caminho da pasta
		File diretorio = new File(diretorioTeste);	//cria um arquivo diretorio com caminho da pasta 
		if (!diretorio.exists()) {	//se diretorio nao existir 
			diretorio.mkdirs();	//cria o diretorio
			return true; //retorna verdadeiro
		} else {	//caso contrario
			return false;	//retorna falso
		}
	}
	
	public boolean criaPastaHorarioTeste() {
		
		criaPastaTeste();
		
		this.diretorioHorarioTeste = diretorioTeste.concat("\\").concat(geraHorario());	//cria a o caminho da pasta
		File diretorio = new File(diretorioHorarioTeste);	//cria um arquivo diretorio com caminho da pasta 
		if (!diretorio.exists()) {	//se diretorio nao existir 
			diretorio.mkdirs();	//cria o diretorio
			return true; //retorna verdadeiro
		} else {	//caso contrario
			return false;	//retorna falso
		}
	}
	
	public void gerarEvidencia(boolean res, String teste) {
		
		int contPrint=1;
		int contNomePage=0;
		nomeTeste = teste;
		passOrFail = res;	
		
		criaPastaHorarioTeste();
		
		for (File file : src) {
			try {
				FileUtils.copyFile(file, new File(diretorioHorarioTeste+"\\"+ (contPrint++) + "_" + getNomePage().get(contNomePage++) +".png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void gerarEvidencia(String res, String teste) {
		
		int contPrint=1;
		int contNomePage=0;
		nomeTeste = teste;
		if(res.equals("passed")) {
			passOrFail = true;
		}else {
			passOrFail = false;
		}
		criaPastaHorarioTeste();
		for (File file : src) {
			try {
				FileUtils.copyFile(file, new File(diretorioHorarioTeste+"\\"+ (contPrint++) + "_" + getNomePage().get(contNomePage++) +".png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void printaTela() {
		TakesScreenshot source = (TakesScreenshot) DriverFactory.getDriver();	//cria o objeto para a captura de Screenshot 
		getSRC().add(source.getScreenshotAs(OutputType.FILE));
		getNomePage().add(geraHorario());
	}
	
	public void printaTela(String nomePrint) {
		TakesScreenshot source = (TakesScreenshot) DriverFactory.getDriver();	//cria o objeto para a captura de Screenshot 
		getSRC().add(source.getScreenshotAs(OutputType.FILE));
		getNomePage().add(nomePrint);
	}
	
	public void printaGeraEvidencia(String nomePrint, String nomePasta) {
		criaPasta(nomePasta);
		File file = new File(caminho);
		TakesScreenshot source = (TakesScreenshot) DriverFactory.getDriver();
		file = source.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(file, new File(caminho.concat(nomePrint).concat(".png")));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public boolean criaPasta(String pasta) {
		caminho = System.getProperty("user.dir").concat("\\"+ pasta +"\\");	//cria a o caminho da pasta
		File diretorio = new File(caminho);	//cria um arquivo diretorio com caminho da pasta 
		if (!diretorio.exists()) {	//se diretorio nao existir 
			diretorio.mkdirs();	//cria o diretorio
			return true; //retorna verdadeiro
		} else {	//caso contrario
			return false;	//retorna falso
		}
	}
}
