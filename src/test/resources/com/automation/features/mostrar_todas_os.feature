@mostrar_todas_os
Feature: mostrar_todas_os
Scenario: pesquisar por todas as os cadastradas
Given a API MOSTRAR TODAS OS "MOSTRAR_TODAS_OS"
When o sistema envia um request GET na API MOSTRAR TODAS OS
Then o status code da API MOSTRAR TODAS OS retorna 200
And o response body da API MOSTRAR TODAS OS confere com o JSON "mostrar_todas_os"


