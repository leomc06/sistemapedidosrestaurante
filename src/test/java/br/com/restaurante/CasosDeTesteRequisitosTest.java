package br.com.restaurante;

import br.com.restaurante.adapter.PagamentoExternoAdapter;
import br.com.restaurante.adapter.SistemaPagamentoExterno;
import br.com.restaurante.dominio.CategoriaItem;
import br.com.restaurante.dominio.Funcionario;
import br.com.restaurante.dominio.ItemCardapio;
import br.com.restaurante.dominio.ItemPedido;
import br.com.restaurante.dominio.Mesa;
import br.com.restaurante.dominio.Pedido;
import br.com.restaurante.dominio.PerfilFuncionario;
import br.com.restaurante.dominio.StatusPedido;
import br.com.restaurante.factory.DeliveryFactory;
import br.com.restaurante.servico.AcessoCardapioService;
import br.com.restaurante.servico.AutenticacaoService;
import br.com.restaurante.servico.CardapioService;
import br.com.restaurante.servico.ContaService;
import br.com.restaurante.servico.GarcomService;
import br.com.restaurante.servico.MonitorQualidadeService;
import br.com.restaurante.servico.PainelCozinhaService;
import br.com.restaurante.servico.PedidoService;
import br.com.restaurante.servico.ReceptorPedidoCozinha;
import br.com.restaurante.visitor.RelatorioPedidoVisitor;
import java.math.BigDecimal;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CasosDeTesteRequisitosTest {

    private ItemCardapio pizza() {
        return new ItemCardapio("Pizza", "Pizza de mussarela", "pizza.jpg",
                CategoriaItem.PRATO_PRINCIPAL, new BigDecimal("45.00"), true);
    }

    private ItemCardapio suco() {
        return new ItemCardapio("Suco", "Suco natural", "suco.jpg",
                CategoriaItem.BEBIDA, new BigDecimal("8.00"), true);
    }

    private Pedido pedidoConfirmado(Mesa mesa) {
        Pedido pedido = new Pedido(mesa);
        pedido.adicionarItem(new ItemPedido(pizza(), 1));
        pedido.confirmar();
        mesa.registrarPedido(pedido);
        return pedido;
    }

    @Test
    void RF0001_deveAcessarCardapioPeloQrCodeDaMesa() {
        CardapioService cardapio = new CardapioService();
        cardapio.adicionar(pizza());
        Mesa mesa = new Mesa(3);

        List<ItemCardapio> itens = new AcessoCardapioService(cardapio).acessarPorQrCode("MESA-3", mesa);

        assertEquals(1, itens.size());
        assertEquals("Pizza", itens.get(0).getNome());
    }

    @Test
    void RF0002_deveVisualizarCardapioComNomeDescricaoFotoEPreco() {
        CardapioService cardapio = new CardapioService();
        cardapio.adicionar(pizza());

        ItemCardapio item = cardapio.listarDisponiveis().get(0);

        assertEquals("Pizza", item.getNome());
        assertEquals("Pizza de mussarela", item.getDescricao());
        assertEquals("pizza.jpg", item.getFoto());
        assertEquals(new BigDecimal("45.00"), item.getPreco());
    }

    @Test
    void RF0003_deveAdicionarItemAoPedidoAntesDaConfirmacao() {
        Pedido pedido = new Pedido(new Mesa(1));

        pedido.adicionarItem(new ItemPedido(pizza(), 2));

        assertEquals(1, pedido.getItens().size());
        assertEquals(new BigDecimal("90.00"), pedido.calcularTotal());
    }

    @Test
    void RF0004_deveConfirmarPedidoEEnviarParaCozinhaComMock() {
        ReceptorPedidoCozinha cozinha = mock(ReceptorPedidoCozinha.class);
        Pedido pedido = new Pedido(new Mesa(2));
        pedido.adicionarItem(new ItemPedido(pizza(), 1));

        new PedidoService(cozinha).confirmar(pedido);

        assertEquals(StatusPedido.CONFIRMADO, pedido.getStatus());
        assertEquals(new BigDecimal("8.00"), new DeliveryFactory().criarCalculadoraTaxa().calcular(pedido));
        verify(cozinha).receber(pedido);
    }

    @Test
    void RF0005_RD0001_deveExibirPedidoNoPainelRespeitandoLimiteDeVintePedidos() {
        PainelCozinhaService painel = new PainelCozinhaService();

        for (int numero = 1; numero <= 20; numero++) {
            painel.receber(pedidoConfirmado(new Mesa(numero)));
        }

        assertEquals(20, painel.listarPedidosAtivos().size());
        assertThrows(IllegalStateException.class, () -> painel.receber(pedidoConfirmado(new Mesa(21))));
    }

    @Test
    void RF0006_deveAtualizarStatusDoPedidoEAquivarQuandoEntregue() {
        PainelCozinhaService painel = new PainelCozinhaService();
        Pedido pedido = pedidoConfirmado(new Mesa(4));
        painel.receber(pedido);

        painel.atualizarStatus(pedido, StatusPedido.EM_PREPARO);
        assertEquals(StatusPedido.EM_PREPARO, pedido.getStatus());

        painel.atualizarStatus(pedido, StatusPedido.ENTREGUE);
        assertTrue(painel.listarPedidosAtivos().isEmpty());
    }

    @Test
    void RF0007_deveVisualizarPedidosPorMesaParaGarcom() {
        Mesa mesa1 = new Mesa(1);
        Mesa mesa2 = new Mesa(2);
        pedidoConfirmado(mesa1);
        pedidoConfirmado(mesa2);

        var visao = new GarcomService().visualizarPedidosPorMesa(List.of(mesa1, mesa2));

        assertEquals(2, visao.size());
        assertEquals(StatusPedido.CONFIRMADO, visao.get(1).get(0).getStatus());
    }

    @Test
    void RF0008_deveCalcularContaDaMesaComPedidosConfirmados() {
        Mesa mesa = new Mesa(5);
        pedidoConfirmado(mesa);
        pedidoConfirmado(mesa);

        BigDecimal total = new ContaService().calcularTotal(mesa);

        assertEquals(new BigDecimal("90.00"), total);
    }

    @Test
    void RF0009_deveFecharContaAposPagamentoUsandoAdapter() {
        SistemaPagamentoExterno stub = valorEmCentavos -> valorEmCentavos == 4500 ? "APROVADO" : "NEGADO";
        Mesa mesa = new Mesa(6);
        pedidoConfirmado(mesa);

        assertTrue(new PagamentoExternoAdapter(stub).pagar(new BigDecimal("45.00")));

        new ContaService().fecharConta(mesa);
        assertTrue(mesa.isBloqueada());
        assertEquals(StatusPedido.FECHADO, mesa.getPedidos().get(0).getStatus());
    }

    @Test
    void RF0010_deveGerenciarCardapioComAdicionarEditarERemover() {
        CardapioService cardapio = new CardapioService();
        ItemCardapio item = suco();

        cardapio.adicionar(item);
        item.atualizar(new BigDecimal("9.00"), false);
        cardapio.remover("Suco");

        assertTrue(cardapio.listarTodos().isEmpty());
    }

    @Test
    void RF0011_deveGerarRelatorioDePedidosComVisitor() {
        Pedido pedido = pedidoConfirmado(new Mesa(7));
        RelatorioPedidoVisitor relatorio = new RelatorioPedidoVisitor();

        pedido.aceitar(relatorio);

        assertEquals(1, relatorio.getQuantidadePorItem().get("Pizza"));
        assertEquals(new BigDecimal("45.00"), relatorio.getFaturamento());
        assertTrue(relatorio.gerarTexto().contains("Pizza"));
    }

    @Test
    void RF0012_RNF0001_deveAutenticarFuncionarioComLoginESenha() {
        AutenticacaoService autenticacao = new AutenticacaoService();
        autenticacao.cadastrar(new Funcionario("gerente", "1234", PerfilFuncionario.GERENTE));

        assertTrue(autenticacao.autenticar("gerente", "1234"));
        assertFalse(autenticacao.autenticar("gerente", "senha-errada"));
    }

    @Test
    void RNF0002_deveValidarRespostaAbaixoDeTresSegundos() {
        MonitorQualidadeService monitor = new MonitorQualidadeService();

        assertTrue(monitor.respostaAteTresSegundos(1200));
        assertFalse(monitor.respostaAteTresSegundos(3500));
    }

    @Test
    void RNF0003_RNF0004_deveRepresentarResponsividadeEDisponibilidadeNoPrototipo() {
        MonitorQualidadeService monitor = new MonitorQualidadeService();

        assertTrue(monitor.interfaceMobileAceita(390));
        assertTrue(monitor.disponibilidadeMinima(99.2));
    }

    @Test
    void RD0002_deveBloquearConfirmacaoDePedidoAbaixoDeDezReais() {
        Pedido pedido = new Pedido(new Mesa(8));
        pedido.adicionarItem(new ItemPedido(suco(), 1));

        assertThrows(IllegalStateException.class, pedido::confirmar);
    }

}
