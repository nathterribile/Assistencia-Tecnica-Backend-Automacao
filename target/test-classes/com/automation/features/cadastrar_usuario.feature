@cadastrar_usuario
Feature: cadastrar_usuario
Scenario: geracao de usuario para novo funcionario
Given o request da API CADASTRAR USUARIO "cadastrar_usuario.json"
When o sistema envia um request POST na API CADASTRAR USUARIO "CADASTRAR_USUARIO"
Then o status code da API CADASTRAR USUARIO retorna 201
And o response body da API CADASTRAR USUARIO confere com o JSON "cadastrar_usuario"


