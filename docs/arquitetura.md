# Documento Arquitetural

## Visao Geral

Este projeto representa um sistema simples de restaurante, sem interface grafica e sem banco de dados, criado para demonstrar arquitetura em camadas, padroes GoF, testes automatizados, JavaDoc e versionamento Git.

## Camadas Iniciais

- `domain`: classes de dominio do restaurante.
- `service`: regras de negocio e casos de uso.
- `factory`: implementacao planejada do padrao Abstract Factory.
- `adapter`: implementacao planejada do padrao Adapter.
- `visitor`: implementacao planejada do padrao Visitor.

## Padroes Planejados

### Abstract Factory

Sera usado para criar familias de objetos relacionados ao atendimento do restaurante sem acoplar o codigo principal a classes concretas.

### Adapter

Sera usado para adaptar uma dependencia externa ou simulada para uma interface interna do sistema.

### Visitor

Sera usado para aplicar operacoes sobre entidades do dominio sem concentrar logica condicional nas classes principais.

## Decisoes Da Etapa 1

- O projeto foi configurado como Maven para facilitar abertura no NetBeans e execucao dos testes.
- O Java 17 foi definido como versao base.
- JUnit 5 e Mockito foram adicionados desde o inicio para preparar as proximas etapas.
- A aplicacao nao tera interface grafica nem banco de dados, seguindo o foco em arquitetura e qualidade.
