package com.automation.resources.rest;

public enum Resources {
    
    PROCURAR_OS_POR_ID("/os/${id}"),
    ALTERAR_OS("/os/${id}"),
    MOSTRAR_TODAS_OS("/os"),
    CADASTRAR_OS("/os"),
    LOGAR_USUARIO("/usuario/login?usuario=${usuario}&senha=${senha}"),
    CADASTRAR_USUARIO("/usuario/cadastrar"),
    DELETAR_USUARIO("/usuario/${id}");

    private final String resource;

    Resources(final String resource) {
        this.resource = resource;
    }

    public String getResource() {
        return resource;
    }
}
