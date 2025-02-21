@logar_usuario
Feature:logar_usuario
Scenario: login de funcionario para cadastro de OS
Given o request da API LOGAR USUARIO "logar_usuario.json"
When o sistema envia um request GET na API LOGAR USUARIO "LOGAR_USUARIO"
Then o status code da API LOGAR USUARIO retorna 200
And o response body da API LOGAR USUARIO sera nulo


