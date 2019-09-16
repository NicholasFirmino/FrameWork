package br.com.nicholas.steps;

import br.com.nicholas.logics.PrincipalLogic;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;

public class PrincipalSteps {
	PrincipalLogic logic = new PrincipalLogic();
	
	@Given("^eu entro no site do Google$")
	public void euEntroNoSiteDoGoogle() {
		logic.euEntroNoSiteDoGoogle();
	}
	
	@And("^pesquiso no Google\"([^\"]*)\",\"([^\"]*)\"$")
	public void pesquiso_no_Google(String id, String campo) throws Throwable {
		logic.pesquiso_no_Google(id, campo);
	}
}
