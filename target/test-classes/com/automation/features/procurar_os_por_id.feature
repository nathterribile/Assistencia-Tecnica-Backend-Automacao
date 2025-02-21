@procurar_os_por_id
Feature: procurar_os_por_id
Scenario: verificar os cadastrada por id
Given o request da API PROCURAR OS POR ID "procurar_os_por_id.json"
When o sistema envia um request GET na API PROCURAR OS POR ID "PROCURAR_OS_POR_ID"
Then o status code da API PROCURAR OS POR ID retorna 200
And o response body da API PROCURAR OS POR ID confere com o JSON "procurar_os_por_id"


