package br.com.nicholas.runners;

import org.junit.runner.JUnitCore;

import br.com.nicholas.tests.PesquisarGoogleTest;

public class TestsRunner {	
	
	public void executar() {
		JUnitCore.runClasses(PesquisarGoogleTest.class);
	}
}
