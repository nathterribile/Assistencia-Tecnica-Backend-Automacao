@alterar_os
Feature: alterar_os
Scenario: alteracao de os cadastrada
Given o request da API ALTERAR OS "alterar_os.json"
When o sistema envia um request PUT na API ALTERAR OS "ALTERAR_OS"
Then o status code da API ALTERAR OS retorna 202
And o response body da API ALTERAR OS confere com o JSON "alterar_os"


