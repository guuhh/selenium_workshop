# Selenium Workshop

Aplicação base para o workshop de selenium

Este é um projeto Gradle com plug-in idea, então se voce ja possui Intellij Idea e possui MacOS:

    $ ./gradlew idea
    $ open selenium_workshop.ipr

Caso contrário, apenas abra o projeto na sua IDE favorita (recomendamos IntelliJ) e sincronize o Gradle para instalar as dependências.


Modificando o driver do chromer conforme seu sistema operacional:


<p>Para Windows:</p>

Modificar o arquivo .java "HelloWorld.java" no metodo setUp()
@Before
public void setUp(){

        System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://www.thoughtworks.com");
    }

<p>Para MAC OS:</p>

Modificar o arquivo .java "HelloWorld.java" no metodo setUp()
@Before
public void setUp(){

        System.setProperty("webdriver.chrome.driver","./drivers/chromedriver");
        driver = new ChromeDriver();
        driver.get("http://www.thoughtworks.com");
    }
