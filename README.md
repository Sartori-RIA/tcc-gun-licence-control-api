# tcc-project-sinarm-api

## projeto de back-end para sistema utilizado para TCC

### author: Lucas Antonio Ramos Sartori

IDEA utilizada: Intellij IDEA Ultimate 17.2.1

## Tecnologias:

+ **Java 1.8**
+ **Kotlin**

### Banco de Dados

+ **MySQL**

### Persistencia de Dados

+ **Hibernate**
+ **BeanValidation**
+ **EJB**
+ **Javax Injection**

### Testes 

+ **JUnit**

### Servidor

+ **REST**
+ **Jax-rs**
+ **Wildfly 11.0.0.final**

### Segurança

+ **JWT - Auth0**
+ **Argon2**

## Requisitos

+ **Wildfly >= 11.0.0.final**
+ **jdk >= 1.8**
+ **MySQL ultima versao**

#### Servidor em Docker já configurado

+ git clone https://github.com/Sartori-RIA/tcc-gun-licence-control-servidor-wildfly-docker.git

#### Servidor não configurado

+ **criar um DB chamado `sinarm_db`**
+ **instale no seu servidor todas as libs listadas no arquivo `pom.xml` que estejam com o seguinte trecho `<scope>provided</scope>`**

+ **adicione no seu wildfly o driver do mysql, e adicione o jar no seu respectivo diretorio**

```xml
  <driver name="mysql-6.0.6" module="com.mysql">
    <xa-datasource-class>com.mysql.jdbc.jdbc2.optional.MysqlXADataSource</xa-datasource-class>
  </driver>
```

+ **adicione o datasource ao standalone**

```xml
  <datasource jta="true" jndi-name="java:/sinarm_ds" pool-name="sinarm_ds" enabled="true" use-ccm="true">
    <connection-url>jdbc:mysql://localhost:3306/sinarm_db?useSSL=false</connection-url>
      <driver>mysql-6.0.6</driver>
        <pool>
            <min-pool-size>5</min-pool-size>
            <max-pool-size>100</max-pool-size>
            <prefill>true</prefill>
        </pool>
        <security>
            <user-name>**seu-usuario**</user-name>
            <password>**sua senha**</password>
        </security>
        <validation>
            <valid-connection-checker class-name="org.jboss.jca.adapters.jdbc.extensions.mysql.MySQLValidConnectionChecker"/>
            <background-validation>true</background-validation>
            <exception-sorter class-name="org.jboss.jca.adapters.jdbc.extensions.mysql.MySQLExceptionSorter"/>
        </validation>
  </datasource>
```

+ **Apos iniciado o servidor pela primeira vez para criar o banco, rodar o script `/src/main/resources/sql/sinarm.sql`**
