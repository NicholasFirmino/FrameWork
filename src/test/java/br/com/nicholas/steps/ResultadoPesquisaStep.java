package br.com.nicholas.steps;

import br.com.nicholas.logics.ResultadoPesquisaLogic;
import cucumber.api.java.en.Then;

public class ResultadoPesquisaStep {
	ResultadoPesquisaLogic logic = new ResultadoPesquisaLogic();
	
	@Then("^valido a pesquisa Google$")
	public void validoAPesquisaGoogle() {
		logic.validoAPesquisaGoogle();
	}
}
