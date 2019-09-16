/*BuscarEnderecoTest
 *Classe de Execucao de teste para as features e as steps, relacionando cada passo para a realizacao dos testes
 */

package br.com.nicholas.tests;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "features/PesquisarGoogle.feature", glue = {	//caminho da feature do test
		"" }, monochrome = true, dryRun = false)
public class PesquisarGoogleTest {
	
}
