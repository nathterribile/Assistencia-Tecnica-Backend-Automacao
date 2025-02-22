# MyAssist backend automation

Backend automation of an web app for an technical assistance enterprise. 



## Labels

- [Java 21.0.3](https://www.java.com/pt_BR/ "Java")
- [Maven 3.9.9](https://maven.apache.org/ "Maven")
- [JUnit 5.9.0](https://junit.org/junit5/ "JUnit")
- [Cucumber 7.2.3](https://cucumber.io/ "Cucumber")
- [slf4j 1.7.36](https://www.slf4j.org/ "Simple Logging Facade for Java")
- [REST-assured 5.1.1](https://rest-assured.io/ "REST-assured")



## Stack

**Back-end:** Java



## Functionalities

- User generation for new employee
- Employee login to register service order
- User deletion for old employee
- Registration of new service order
- Change of registered service order
- Search for all registered service orders
- Check service order registered by ID



## Run

To run the test you just need to choose the scenario of the feature you want to validate, change the path of the tag SelectClasspathResource in TestRunner Class and than run the command

```cmd
  mvn test
```

**Exemple of path of the loggin feature:**

@SelectClasspathResource("com/automation/features/logar_usuario.feature")



## Screenshots

[API cadastrar_usuario](https://github.com/nathterribile/Assistencia-Tecnica-Backend-Automacao/blob/main/test-output/Pdf/cadastrar_usuario.pdf)


[API logar_usuario](https://github.com/nathterribile/Assistencia-Tecnica-Backend-Automacao/blob/main/test-output/Pdf/logar_usuario.pdf)

[API cadastrar_usuario](https://github.com/nathterribile/Assistencia-Tecnica-Backend-Automacao/blob/main/test-output/Pdf/cadastrar_usuario.pdf)

[API deletar_usuario](https://github.com/nathterribile/Assistencia-Tecnica-Backend-Automacao/blob/main/test-output/Pdf/deletar_usuario.pdf)

[API cadastrar_os](https://github.com/nathterribile/Assistencia-Tecnica-Backend-Automacao/blob/main/test-output/Pdf/cadastrar_os.pdf)

[API alterar_os](https://github.com/nathterribile/Assistencia-Tecnica-Backend-Automacao/blob/main/test-output/Pdf/alterar_os.pdf)



## Autor

- [@nathterribile](https://github.com/nathterribile/Assistencia-Tecnica-Backend-Automacao/blob/main/test-output/Spark/alterar_os.html)