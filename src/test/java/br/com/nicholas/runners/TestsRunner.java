package br.com.nicholas.runners;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.runner.JUnitCore;

public class TestsRunner {	
	
	public void executar() throws IOException, ClassNotFoundException {
		String caminhoArquivo = System.getProperty("user.dir").concat("\\configuracoes\\classes.txt");
		List<Class> classes = new ArrayList<Class>();
		BufferedReader buffRead = new BufferedReader(new FileReader(caminhoArquivo));
		String line = "";
		int i=0;
		while ((line = buffRead.readLine()) != null) {
			System.out.println(line);
			classes.add(Class.forName(line));
		}
		Class[] c = new Class[classes.size()];
		for (Class class1 : classes) {
			c[i++] = class1;
		}
		JUnitCore.runClasses(c);
		buffRead.close();
	}
}
