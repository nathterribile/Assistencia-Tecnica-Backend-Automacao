@deletar_usuario
Feature:deletar_usuario
Scenario: exclusao de usuario para funcionario antigo
Given o request da API DELETAR USUARIO "deletar_usuario.json"
When o sistema envia um request DELETE na API DELETAR USUARIO "DELETAR_USUARIO"
Then o status code da API DELETAR USUARIO retorna 202
And o response body da API DELETAR USUARIO sera nulo

