# Sistema de Pedidos de Restaurante

Projeto acadêmico de Engenharia de Software para a Parte 2 da atividade. O sistema é um protótipo em Java, sem interface gráfica e sem banco de dados, com foco em requisitos, padrões GoF, testes, documentação técnica e versionamento.

## Objetivo

Simular o fluxo básico de pedidos por mesa em um restaurante:

- cliente acessa o cardápio pelo QR Code da mesa;
- cliente monta e confirma o pedido;
- cozinha recebe e atualiza o status;
- garçom acompanha pedidos por mesa;
- caixa calcula e fecha a conta;
- gerente mantém o cardápio e consulta relatório;
- funcionários acessam os painéis com login e senha.

## Tecnologias

- Java 17
- Maven
- JUnit 5
- Mockito

## Padrões GoF Aplicados

- `Abstract Factory`: criação de regras de atendimento, como taxa de delivery.
- `Adapter`: integração com um sistema externo simulado de pagamento.
- `Visitor`: geração de relatório de pedidos sem colocar essa regra dentro da classe `Pedido`.

