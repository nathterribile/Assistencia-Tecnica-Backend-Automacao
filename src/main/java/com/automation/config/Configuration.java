package com.automation.config;

import java.net.URI;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.LoadPolicy;
import org.aeonbits.owner.Config.LoadType;

@Config.HotReload
@LoadPolicy(LoadType.MERGE)
@Config.Sources({
        "classpath:config.${ENVIRONMENT}.properties",
        "classpath:config.properties",
        "system:properties",
        "system:env"})

public interface Configuration extends Config {

    @Key("api.base.path")
    public String basePath();

    @Key("api.httpbin.uri")
    public URI httpbinPath();

    @Key("api.base.uri")
    public String baseURI();

    @Key("api.port")
    public int port();

    @Key("api.health.context")
    public String health();

    @Key("log.all")
    boolean logAll();

    
    @Key("responseSchemas.path")
    public String schemaPath();

    @Key("responseSchemas.extension")
    public String schemaExtension();

    @Key("body.path")
    public String bodyPath();
}