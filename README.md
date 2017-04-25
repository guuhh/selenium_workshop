# Selenium Workshop
Aplicacao base para o workshop de selenium

Este é um projeto Gradle com plug-in idea, entao se voce ja possui Intellij Idea e possui MacOS:

    $ ./gradlew idea
    $ open selenium_workshop.ipr

Caso contrário, apenas abra o projeto na sua IDE favorita (recomendamos IntelliJ) e sincronize o Gradle para instalar as dependencias.
_
Para a execução automática dos testes no bash/terminal:

     $ ./gradlew test

Para a execução das classes de testes em modo debug:

     $ ./gradlew test --debug
