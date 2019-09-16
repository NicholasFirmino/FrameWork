package br.com.nicholas.funcs;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.format.CellNumberFormatter;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class FuncoesExcel {
	private String nomeArquivo;
	private XSSFWorkbook wb;
	private XSSFSheet planilha;

//_____________________________________________________________Construtor_________________________________________________________
	/**
	 * Construtor vazio da classe, permitindo que se escolha o arquivo a ser
	 * aberto atrav�s dos m�todos setNomePlanilha
	 */
	public FuncoesExcel() {	
	}
	
	/**
	 * Construtor com par�metro de nome do arquivo, permitindo a abertura de
	 * qualquer arquivo do excel
	 * 
	 * @param fileName
	 * nome do arquivo a ser aberto
	 */
	public FuncoesExcel(String nomeArquivo) {
		this.nomeArquivo = nomeArquivo;
		this.abrePlanilha();
	}
	
	/**Construtor com par�metro de nome do arquivo, permitindo a abertura de
	 * qualquer arquivo do excel.
	 * 
	 * @param fileName nome do arquivo a ser aberto
	 * @param indicePlanilha �ndice da planilha a ser aberta.
	 */
	public FuncoesExcel(String fileName, int indicePlanilha) {
		this.nomeArquivo = fileName;
		this.abrePlanilha(indicePlanilha);
	}
	
	public FuncoesExcel(String nomeArquivo, String nomePlanilha) {
		this.nomeArquivo = nomeArquivo;
		this.abrePlanilha(nomePlanilha);
	}
//_____________________________________________________________Gets________________________________________________________________	
	/**
	 * M�todo que retorna o objeto manipulador de arquivos do excel
	 * 
	 * @return atributo do tipo XSSFSheet {@link XSSFSheet}
	 */
	public XSSFSheet getPlanilha() {
		return this.planilha;
	}
	
	/**
	 * M�todo que retorna o nome do arquivo
	 * 
	 * @return String com o caminho do arquivo aberto
	 */
	public String getNomeArquivo() {
		return this.nomeArquivo;
	}
	
	/**
	 * M�todo que retorna a planilha aberta
	 * 
	 * @return atributo do tipo XSSFWorkbook {@link XSSFWorkbook}
	 */
	public XSSFWorkbook getWorkBook() {
		return this.wb;
	}
//____________________________________________________________Funcionalidades________________________________________________________
	/**M�todo que abre a planilha.
	 * 
	 * @param indicePlanilha �ndice da planilha a ser aberta.
	 */
	public void abrePlanilha() {
		try {
			this.wb = new XSSFWorkbook(new FileInputStream(new File(this.getNomeArquivo())));
		} catch (IOException ex) {
			System.out.println("Erro ao abrir a pasta de Excel em '" + this.getNomeArquivo() + "' ..." + ex);
		}

		this.planilha = this.getPlanilha();
	}
	public void abrePlanilha(int indicePlanilha) {
		try {
			this.wb = new XSSFWorkbook(new FileInputStream(new File(this.getNomeArquivo())));
		} catch (IOException ex) {
			System.out.println("Erro ao abrir a pasta de Excel em '" + this.getNomeArquivo() + "' ..." + ex);
		}

		this.planilha = this.getWorkBook().getSheetAt(indicePlanilha);
	}
	/**
	 * M�todo que abre a planilha
	 * @param nomePlanilha nome da planilha a ser aberta.
	 */
	public void abrePlanilha(String nomePlanilha) {
		System.out.println(nomePlanilha);
		try {
			this.wb = new XSSFWorkbook(new FileInputStream(new File(this.getNomeArquivo())));
		} catch (IOException ex) {
			String message = "Erro ao abrir a pasta de Excel em '" + this.getNomeArquivo() + "' ...";
			System.out.println(message);
		}

		this.planilha = this.getWorkBook().getSheet(nomePlanilha);
		if ( this.planilha == null ) {
			String message = "N�o foi poss�vel abrir a planilha de nome '" + nomePlanilha + "' ...";
			System.out.println(message);
		}
	}
	/**
	 * M�todo que pega o valor de uma c�lula em texto
	 * 
	 * @param linha
	 *            inteiro que representa a linha da c�lula desejada, iniciando
	 *            em 0
	 * @param coluna
	 *            inteiro que representa a coluna da c�lula desejada, iniciando
	 *            em 0
	 * @return String com o texto contido na c�lula encontrada
	 */
	public String getTextoCelula(int linha, int coluna) {
		String textoCelula;
		try {
			textoCelula = this.getPlanilha().getRow(linha).getCell(coluna).getStringCellValue();
		} catch (Exception ex) {
			textoCelula = Integer.toString((int) this.getPlanilha().getRow(linha).getCell(coluna).getNumericCellValue());
		}
		// System.out.println(textoCelula);
		return textoCelula;
	}
	
	public String getTextoCelula( Cell cell ) {
		String textoCelula;
		try {
			textoCelula = cell.getStringCellValue();
		} catch (Exception ex) {
			textoCelula = Integer.toString((int) cell.getNumericCellValue());
		}
		//	System.out.println(textoCelula);
		return textoCelula;
	}
	/**
	 * M�todo que pega o texto absoluto de uma c�lula
	 * 
	 * @param linha
	 *            inteiro que representa a linha da c�lula desejada, iniciando
	 *            em 0
	 * @param coluna
	 *            inteiro que representa a coluna da c�lula desejada, iniciando
	 *            em 0
	 * @return String com o texto absoluto contido na c�lula encontrada
	 */
	public String getTextoSimplesCelula(int linha, int coluna) {
		String textoCelula;

		textoCelula = this.getPlanilha().getRow(linha).getCell(coluna).getStringCellValue();

		String stringFormat = this.getPlanilha().getRow(linha).getCell(coluna).getCellStyle().getDataFormatString();
		CellNumberFormatter fmt = new CellNumberFormatter(stringFormat);
		textoCelula = fmt.format(this.getPlanilha().getRow(linha).getCell(coluna).getNumericCellValue());

		return textoCelula;
	}
	/**
	 * M�todo que pega o valor da c�lula em Double
	 * 
	 * @param linha
	 *            inteiro que representa a linha da c�lula desejada, iniciando
	 *            em 0
	 * @param coluna
	 *            inteiro que representa a coluna da c�lula desejada, iniciando
	 *            em 0
	 * @return Double com o valor contido na c�lula encontrada
	 */
	public double getValorCelulaDouble(int linha, int coluna) {
		double valorCelula;
		try {
			valorCelula = this.getPlanilha().getRow(linha).getCell(coluna).getNumericCellValue();
		} catch (Exception ex) {
			valorCelula = Double.parseDouble(this.getPlanilha().getRow(linha).getCell(coluna).getStringCellValue());
		}

		return valorCelula;
	}
	
	/**
	 * M�todo que pega o valor da c�lula em int
	 * 
	 * @param linha
	 *            inteiro que representa a linha da c�lula desejada, iniciando
	 *            em 0
	 * @param coluna
	 *            inteiro que representa a coluna da c�lula desejada, iniciando
	 *            em 0
	 * @return inteiro com o valor contido na c�lula encontrada
	 */
	public int getValorCelulaInt(int linha, int coluna) {
		int valorCelula;
		try {
			valorCelula = (int) this.getPlanilha().getRow(linha).getCell(coluna).getNumericCellValue();
		} catch (Exception ex) {
			valorCelula = Integer.parseInt(this.getPlanilha().getRow(linha).getCell(coluna).getStringCellValue());
		}

		return valorCelula;
	}
	
	/**
	 * M�todo que insere o valor em texto em uma c�lula
	 * 
	 * @param linha
	 *            inteiro que representa a linha da c�lula desejada, iniciando
	 *            em 0
	 * @param coluna
	 *            inteiro que representa a coluna da c�lula desejada, iniciando
	 *            em 0
	 * @param value
	 *            String com o texto a ser inserido na c�lula
	 */
	public void setTextoCelula(int linha, int coluna, String value) {
		this.getPlanilha().getRow(linha).getCell(coluna).setCellValue(value);
	}
	
	/**
	 * M�todo que insere o valor em Double em uma c�lula
	 * 
	 * @param linha
	 *            inteiro que representa a linha da c�lula desejada, iniciando
	 *            em 0
	 * @param coluna
	 *            inteiro que representa a coluna da c�lula desejada, iniciando
	 *            em 0
	 * @param value
	 *            Double com o valor a ser inserido na c�lula
	 */
	public void setValorCelulaDouble(int linha, int coluna, double value) {
		this.getPlanilha().getRow(linha).getCell(coluna).setCellValue(value);
	}
	
	/**
	 * M�todo que insere o valor em int em uma c�lula
	 * 
	 * @param linha
	 *            inteiro que representa a linha da c�lula desejada, iniciando
	 *            em 0
	 * @param coluna
	 *            inteiro que representa a coluna da c�lula desejada, iniciando
	 *            em 0
	 * @param value
	 *            int ocm o valor a ser inserido na c�lula
	 */
	public void setValorCelulaInt(int linha, int coluna, int value) {
		this.getPlanilha().getRow(linha).getCell(coluna).setCellValue(value);
	}
	
	/**
	 * M�todo que retorna lista com os itens de uma coluna
	 * 
	 * @param coluna
	 *            �ndice da coluna desejada
	 * @return List com os valores encontrados na coluna
	 */
	public List<String> itensColuna(Integer coluna) {
		List<String> valores = new ArrayList<String>();
		for (Row r : this.getWorkBook().getSheetAt(0)) {
			Cell c = r.getCell(coluna);
			if (c != null) {
				valores.add(c.getStringCellValue());
			}
		}

		return valores;
	}
	
	/**
	 * M�todo que procura um texto em uma planilha, e retorna o �ndice da linha
	 * onde o texto foi encontrado
	 * 
	 * @param textoCelula
	 *            valor a ser encontrado em uma c�lula
	 * @return n�mero da linha onde o texto foi encontrado. Caso o texto n�o
	 *         tenha sido encontrado, retorna -1
	 */
	public int achaLinhaPorTexto(String textoCelula) {
		for (Row linha : this.getWorkBook().getSheetAt(0)) {
			for (Cell celula : linha) {
				if (celula.getCellType() == Cell.CELL_TYPE_STRING) {
					if (celula.getRichStringCellValue().getString().trim().equals(textoCelula)) {
						return linha.getRowNum();
					}
				}
			}
		}
		return -1;
	}
	
	public int achaLinhaPorTextoR(String textoCelula) {
		for (Row linha : this.getWorkBook().getSheetAt(0)) {
			for (Cell celula : linha) {
				if (celula != null && celula.getCellType() == Cell.CELL_TYPE_STRING) {
					if (celula.getRichStringCellValue().getString().trim().equals(textoCelula)) {
						return linha.getRowNum();
					}
				}
			}
		}
		return -1;
	}
	
	public int achaColunaPorTexto(String textoCelula) {
		for (Iterator<Cell> it = planilha.getRow(0).cellIterator(); it.hasNext(); ) {
		     Cell cell = it.next();
		     if(cell.getRichStringCellValue().getString().trim().equals(textoCelula)) {
		    	 return cell.getColumnIndex();
		     }
		 }
		return -1;
	}
	
	public String achaLinhaColunaPorTexto(String textoCelula) {
		String linha = Integer.toString(achaLinhaPorTexto(textoCelula));
		String coluna = Integer.toString(achaColunaPorTexto(textoCelula));
		return "[" + linha + "," + coluna + "]";
	}
	
	public String getMassaPeloId(String idMassa, String campo){
		int linha = achaLinhaPorTexto(idMassa);
		int coluna = achaColunaPorTexto(campo);
		return getTextoCelula(linha, coluna);
	}
	
}
