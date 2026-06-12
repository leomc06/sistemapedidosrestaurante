# Sistema Restaurante GOF

Projeto academico em Java com foco em Engenharia de Software, padroes de projeto GoF, testes unitarios, documentacao tecnica e versionamento Git.

## Objetivo

Evoluir um sistema simples de restaurante aplicando:

- 1 padrao GoF criacional: Abstract Factory;
- 1 padrao GoF estrutural: Adapter;
- 1 padrao GoF comportamental: Visitor;
- testes unitarios com JUnit 5;
- stubs e mocks com Mockito;
- JavaDoc;
- estrategia de versionamento com Git.

## Tecnologias

- Java 17
- Maven
- JUnit 5
- Mockito
- NetBeans

## Como Abrir No NetBeans

1. Abra o NetBeans.
2. Clique em `File > Open Project`.
3. Selecione a pasta `restaurante-gof`.
4. Aguarde o Maven carregar as dependencias.
5. Execute a classe `br.com.restaurante.Main`.

## Como Executar Pelo Terminal

```bash
mvn clean compile
mvn exec:java
```

## Como Rodar Os Testes

```bash
mvn test
```

## Estrutura Inicial

```text
restaurante-gof/
├── pom.xml
├── README.md
├── docs/
│   └── arquitetura.md
├── src/
│   ├── main/
│   │   └── java/
│   │       └── br/
│   │           └── com/
│   │               └── restaurante/
│   │                   ├── Main.java
│   │                   ├── adapter/
│   │                   ├── domain/
│   │                   ├── factory/
│   │                   ├── service/
│   │                   └── visitor/
│   └── test/
│       └── java/
│           └── br/
│               └── com/
│                   └── restaurante/
```

## Status

Etapa 1: estrutura inicial do projeto criada.



