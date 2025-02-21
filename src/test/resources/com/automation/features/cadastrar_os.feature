@cadastrar_os
Feature: cadastrar_os
Scenario: cadastro de nova ordem de servico
Given o request da API CADASTRAR OS "cadastrar_os.json"
When o sistema envia um request POST na API CADASTRAR OS "CADASTRAR_OS"
Then o status code da API CADASTRAR OS retorna 201
And o response body da API CADASTRAR OS confere com o JSON "cadastrar_os"


