#Author: brunoramos.santos@live.live.com
#Feature: List of steps
 #> Testar Login (Test Login);
 #> Navegar para o diretório teste_rb (Navigating to directory test_rb);
 #> Navegar para a tab issues (Navigating to tab_issues);
 #> Criar uma nova issue e verificar se a issue foi criada (Creating new issue and to verify if issue was created);
 #> Adicionar um comentário e verificar se o comentário foi criado (Adding a comment and verify if comment was created);
 #> Aplicar uma label duplicate e verificar se foi aplicada (Applying a label duplicate and to verify if was created);
 #> Fechar (close) a issue (Close issue).

Feature: Testing scenario for RB 
Scenario: Login on GitHub
  Given I have URL to enter the system
  When I enter with valid user and valid password 
	And I navigate to  directory test_rb
	And I create a new issue and I verify if new issue was created 
	And I add a comment and verify if comment was created
	And I apply a label dulplicate on the issue and I verify if labeel duplicate was created
	And I close the issue
	Then I close the browser

