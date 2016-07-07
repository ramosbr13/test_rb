package StepDefinition;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import static org.testng.AssertJUnit.assertTrue;
public class LoginCaminhoBasico {

	WebDriver driver;
	
@Given("^I have URL to enter the system$")
public void i_have_URL_to_enter_the_system() throws Throwable {
	try{  
		  System.setProperty("webdriver.chrome.driver", "C:\\Users\\bruno\\Documents\\Eclipse\\Drivers\\chromedriver.exe"); 
		  driver = new ChromeDriver();
		  driver.manage().window().maximize();
		  driver.get("https://github.com/");
		  driver.findElement(By.linkText("Sign in")).click();
		  }catch (Exception e){
		  System.out.println("Falha na abertura do Google Chrome");
		}
}

@When("^I enter with valid user and valid password$")
public void i_enter_with_valid_user_and_valid_password() throws Throwable {
////////////////////////ESTE TRECHO DE CÓDIGO TESTA SE O USUARIO OU SENHA SÃO INVÁLIDOS///////////////////////////////////
////////////////PARA MELHORAR FUTURAMENTE PODERIA SEPARAR EM OUTRA CLASSE////////////////////////////////////
//////////SE QUISER TESTAR É SÒ DESCOMENTAR ESTE TRECHO ABAIXO, DEIXEI COMENTADO PARA NÃO BLOQUEAR SENHA OU ALGO DO TIPO/////
	
	///////SENHA INVALIDA//////////
	/*driver.findElement(By.id("login_field")).sendKeys("rbrasiltester");
	driver.findElement(By.id("password")).sendKeys("vvvvv");
	driver.findElement(By.name("commit")).click();
	Thread.sleep(5000);
	
	boolean InvalidPass =  driver.getPageSource().contains("Incorrect username or password.");
	 assertTrue(InvalidPass);
		Thread.sleep(5000);
		driver.findElement(By.id("login_field")).clear();
		driver.findElement(By.id("password")).clear();
		
		
			///////USUARIO INVALIDO//////////
	 driver.findElement(By.id("login_field")).sendKeys("rbggg");
		driver.findElement(By.id("password")).sendKeys("rbrasiltesterpassword2016");
		driver.findElement(By.name("commit")).click();
		Thread.sleep(5000);
		
		boolean InvalidUser =  driver.getPageSource().contains("Incorrect username or password.");
		 assertTrue(InvalidUser);
			Thread.sleep(5000);
			driver.findElement(By.id("login_field")).clear();
			driver.findElement(By.id("password")).clear();*/
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	driver.findElement(By.id("login_field")).sendKeys("rbrasiltester");
	driver.findElement(By.id("password")).sendKeys("rbrasiltesterpassword2016");
	driver.findElement(By.name("commit")).click();
	
}

@And("^I navigate to  directory test_rb$")
public void i_navigate_to_directory_test_rb() throws Throwable {
	 driver.findElement(By.className("repo")).click();
	 driver.findElement(By.xpath("//*[@id=\'js-repo-pjax-container\']/descendant::span[text()='Issues']")).click();
	//// driver.findElement(By.xpath("//*[@id=\'js-repo-pjax-container\']")).click();
	 Thread.sleep(5000);
	 driver.findElement(By.cssSelector("#js-repo-pjax-container>div.container.new-discussion-timeline.experiment-repo-nav>div.repository-content>div>div.subnav>a")).click();
	// driver.get("https://github.com/ramosbr13/test_rb/issues/new");
}

@And("^I create a new issue and I verify if new issue was created$")
public void i_create_a_new_issue_and_I_verify_if_new_issue_was_created() throws Throwable {
	Thread.sleep(5000);
	driver.findElement(By.id("issue_title")).sendKeys("Issue RB3");
	driver.findElement(By.id("issue_title")).submit();
	boolean NewItemIssue =  driver.getPageSource().contains("Issue RB3");
	 assertTrue(NewItemIssue);
}

@And("^I add a comment and verify if comment was created$")
public void i_add_a_comment_and_verify_if_comment_was_created() throws Throwable {
	driver.findElement(By.id("new_comment_field")).sendKeys("Este item é para a Prova");
	driver.findElement(By.cssSelector("#partial-new-comment-form-actions > button.btn.btn-primary")).click();

	
	Thread.sleep(10000);
	boolean NewItemComment =  driver.getPageSource().contains("Este item é para a Prova");
	assertTrue(NewItemComment);

}

@And("^I apply a label dulplicate on the issue and I verify if labeel duplicate was created$")
public void i_apply_a_label_dulplicate_on_the_issue_and_I_verify_if_labeel_duplicate_was_created() throws Throwable {
	 Thread.sleep(5000);
	 driver.findElement(By.xpath("//*[@id=\'js-repo-pjax-container\']/descendant::span[text()='Issues']")).click();
	 Thread.sleep(5000);
	 //COMO NÃO ESTÁ DINAMICO MUDAR O ID DA ISSUE NO SELETOR NA LINHA ABAIXO
	 driver.findElement(By.cssSelector("#issue_2>div>label>input")).click();
	 Thread.sleep(5000);
	 driver.findElement(By.cssSelector("#js-issues-toolbar>div.table-list-triage.js-issues-toolbar-triage>div>div.left.select-menu.label-select-menu.js-menu-container.js-select-menu>form>button")).click(); 
	 Thread.sleep(5000);
	 driver.findElement(By.cssSelector("#js-issues-toolbar>div.table-list-triage.js-issues-toolbar-triage>div>div.left.select-menu.label-select-menu.js-menu-container.js-select-menu.is-dirty.active>form>div.select-menu-modal-holder.js-menu-content.js-navigation-container.js-active-navigation-container>div>div.js-select-menu-deferred-content>div.select-menu-list>div:nth-child(1)>div:nth-child(2)>div")).click();
	 Thread.sleep(5000);
	 //encaminha para a página da lista de duplicate labels via css selector
	 driver.findElement(By.cssSelector("#js-issues-toolbar>div.table-list-filters>div.table-list-header-toggle.right>div.left.select-menu.label-select-menu.js-menu-container.js-select-menu>button")).click(); 
	 Thread.sleep(5000);
	 driver.findElement(By.cssSelector("#js-issues-toolbar>div.table-list-filters>div.table-list-header-toggle.right>div.left.select-menu.label-select-menu.js-menu-container.js-select-menu.is-dirty.active>div>div>div.js-select-menu-deferred-content>div.select-menu-list>div:nth-child(1)>a:nth-child(3)>div>div>span.name")).click();
	 Thread.sleep(10000);
	 
	 boolean NewItemDuplicate =  driver.getPageSource().contains("Issue RB3");
	 assertTrue(NewItemDuplicate);

}

@And("^I close the issue$")
public void i_close_the_issue() throws Throwable {
	Thread.sleep(12000);
	 //COMO NÃO ESTÁ DINAMICO MUDAR O ID DA ISSUE NO SELETOR NA LINHA ABAIXO
	driver.findElement(By.cssSelector("#issue_2>div>div.d-table-cell.width-full.p-3>a")).click();
	Thread.sleep(5000);
	driver.findElement(By.cssSelector("#partial-new-comment-form-actions>button.btn.js-comment-and-button")).click();
}

@Then("^I close the browser$")
public void i_close_the_browser() throws Throwable {
    driver.quit();
}
	
}
