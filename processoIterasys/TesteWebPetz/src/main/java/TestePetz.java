import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;



import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.gargoylesoftware.htmlunit.javascript.host.Console;


public class TestePetz {
	

	
	@Test
	public void testeConsultaRacao() {
		
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().setSize(new Dimension(1200, 765));
		driver.get("https://www.petz.com.br/");
		driver.findElement(By.id("search")).sendKeys("Ra��o");
		driver.findElement(By.className("button-search")).click();
		//Esse assertEquals vai aproveitar o ccsSelector do terceiro produto para validar a p�gina de pesquisa 
		Assert.assertEquals("Ra��o Golden Special Sabor Frango e Carne para C�es Adultos", driver.findElement(By.cssSelector(".liProduct:nth-child(3) .nome_produto")).getText());
		driver.quit();
		
	}
	
	@Test
	public void testeTerceiroProdutoDaLista() {
		
		WebDriver driver = new FirefoxDriver();
		
		List<WebElement> listaProdutos = new ArrayList();
		
		driver.manage().window().setSize(new Dimension(1200, 765));
		driver.get("https://www.petz.com.br/busca?q=Ra%C3%A7%C3%A3o");
		driver.findElement(By.cssSelector(".liProduct:nth-child(3) .nome_produto")).click();
		//Valida��o pelo c�digo do produto 
		Assert.assertEquals("C�digo: 10002310000076", driver.findElement(By.cssSelector(".col-md-6:nth-child(2)")).getText());
																						
		driver.quit();
		
		
	}
	
	@Test
	public void testeValidarFornecedorNomeEVelores() {
		
		WebDriver driver = new FirefoxDriver();

		
		driver.manage().window().setSize(new Dimension(1200, 765));
		driver.get("https://www.petz.com.br/produto/racao-golden-formula-senior-para-caes-adultos-sabor-frango-e-arroz-15kg-71353");
		//Nome do produto
		Assert.assertEquals("Ra��o Golden F�rmula Senior para C�es Adultos Sabor Frango e Arroz - 15kg", driver.findElement(By.cssSelector("col-md-7 prod-info")).getText());
		//Fornecedor, marca, modelo
		Assert.assertEquals("Marca: Premier Pet | Golden", driver.findElement(By.cssSelector(".col-md-6:nth-child(3)")).getText());
		//Pre�o normal
		Assert.assertEquals("R$ 150,90",driver.findElement(By.className("price-current")).getText());
		//pre�o para assinantes
		Assert.assertEquals("R$ 135,81",driver.findElement(By.className("price-subscriber")).getText());
		
		driver.quit();

	}
	
	@Test
	public void testeColocarProdutoCarrinho() {
		
		WebDriver driver = new FirefoxDriver();

		driver.get("https://www.petz.com.br/produto/racao-golden-formula-senior-para-caes-adultos-sabor-frango-e-arroz-15kg-71353");
		driver.findElement(By.cssSelector("#adicionarAoCarrinho")).click();
		driver.quit();
		
		

	}
	

}