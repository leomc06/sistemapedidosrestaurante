# Estratégia de Testes

Os testes ficam em `src/test/java/br/com/restaurante/CasosDeTesteRequisitosTest.java`.

## Matriz de Rastreabilidade

| Teste | Requisito | Objetivo |
| --- | --- | --- |
| RF0001_deveAcessarCardapioPeloQrCodeDaMesa | RF0001 | Validar acesso ao cardápio pelo QR Code da mesa. |
| RF0002_deveVisualizarCardapioComNomeDescricaoFotoEPreco | RF0002 | Conferir dados exibidos do cardápio. |
| RF0003_deveAdicionarItemAoPedidoAntesDaConfirmacao | RF0003 | Adicionar item e calcular subtotal do pedido. |
| RF0004_deveConfirmarPedidoEEnviarParaCozinhaComMock | RF0004 | Confirmar pedido e enviar à cozinha usando mock. |
| RF0005_RD0001_deveExibirPedidoNoPainelRespeitandoLimiteDeVintePedidos | RF0005, RD0001 | Exibir pedidos no painel e limitar 20 pedidos ativos. |
| RF0006_deveAtualizarStatusDoPedidoEAquivarQuandoEntregue | RF0006 | Atualizar status e arquivar pedido entregue. |
| RF0007_deveVisualizarPedidosPorMesaParaGarcom | RF0007 | Mostrar pedidos agrupados por mesa. |
| RF0008_deveCalcularContaDaMesaComPedidosConfirmados | RF0008 | Calcular total da conta da mesa. |
| RF0009_deveFecharContaAposPagamentoUsandoAdapter | RF0009, RD0003 | Pagar, fechar conta e bloquear mesa. |
| RF0010_deveGerenciarCardapioComAdicionarEditarERemover | RF0010 | Adicionar, editar e remover item do cardápio. |
| RF0011_deveGerarRelatorioDePedidosComVisitor | RF0011 | Gerar relatório com Visitor. |
| RF0012_RNF0001_deveAutenticarFuncionarioComLoginESenha | RF0012, RNF0001 | Validar login e senha de funcionário. |
| RNF0002_deveValidarRespostaAbaixoDeTresSegundos | RNF0002 | Simular validação de tempo de resposta. |
| RNF0003_RNF0004_deveRepresentarResponsividadeEDisponibilidadeNoPrototipo | RNF0003, RNF0004 | Simular responsividade e disponibilidade. |
| RD0002_deveBloquearConfirmacaoDePedidoAbaixoDeDezReais | RD0002 | Bloquear pedido abaixo de R$ 10,00. |

## Observações

- Existem exatamente 15 testes unitários.
- Há cenário válido, cenário alternativo e cenário de exceção.
- O teste de confirmação usa mock com Mockito.
- O teste de pagamento usa stub para simular a dependência externa.
