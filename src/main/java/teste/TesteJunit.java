package teste;

import modelo.*;
import org.junit.*;
import repository.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class TesteJunit {
    private static EntityManagerFactory factory;
    private EntityManager manager;
    private CarroRepository repositoryCarro;
    private ClienteRepository repositoryCliente;
    private ReservaRepository repositoryReserva;
    private SedeRepository repositorySede;
    private EnderecoRepository repositoryEndereco;
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/uuuu");

    @BeforeClass
    public static void inicio() {
        factory = Persistence.createEntityManagerFactory("locacaoDeVeiculos");
    }

    @AfterClass
    public static void fim() {
        factory.close();
    }


    @Before
    public void antes() {
        manager = factory.createEntityManager();
        repositoryCarro = new CarroRepository(manager);
        repositoryCliente = new ClienteRepository(manager);
        repositorySede = new SedeRepository(manager);
        repositoryReserva = new ReservaRepository(manager);
        repositoryEndereco = new EnderecoRepository(manager);

        manager.getTransaction().begin();
    }

    @After
    public void depois() {
        manager.getTransaction().rollback();
    }


    @Test  //Teste01
    public void deveRecuperarCarrosDaClasseCompacto() {

        Endereco endereco = new Endereco();
        endereco.setRua("Rua das flores");
        endereco.setBairro("Renascenca");
        endereco.setNumero("51");
        endereco.setEstado("MA");
        endereco.setCidade("Sao Luis");
        endereco.setCep("65035873");

        Sede sede = new Sede();
        sede.setEndereco(endereco);
        sede.setMultaPorAtraso(new BigDecimal(80));
        sede.setNomeDoGerente("Flavio Alencar");
        sede.setTelefone("989716163");
        sede.setNome("Rent a Car Farol");

        Carro carro1 = new Carro();
        //carro1.setLocalizacaoAtual(sede);
        carro1.setPlaca("OPT-8654");
        carro1.setModelo("Celta");
        carro1.setKm(234000);
        carro1.setAno("2016");
        carro1.setLocacaoDeOrigem(sede);
        carro1.setClasseDeCarro(ClasseDeCarro.COMPACTO);
        carro1.setSedeAtual(sede);
        carro1.setSituacao(SituacaoCarro.ALUGADO);
        carro1.setValorDiaria(new BigDecimal(100));

        Carro carro2 = new Carro();
        carro2.setPlaca("RES-6688");
        carro2.setModelo("Punto");
        carro2.setKm(234000);
        carro2.setAno("2016");
        carro2.setLocacaoDeOrigem(sede);
        carro2.setClasseDeCarro(ClasseDeCarro.MEDIO);
        carro2.setSedeAtual(sede);
        carro2.setSituacao(SituacaoCarro.FORA_DA_ORIGEM);
        carro2.setValorDiaria(new BigDecimal(150));

        Carro carro3 = new Carro();
        carro3.setPlaca("DQE-8364");
        carro3.setModelo("Mercedes");
        carro3.setKm(234000);
        carro3.setAno("2016");
        carro3.setLocacaoDeOrigem(sede);
        carro3.setClasseDeCarro(ClasseDeCarro.LUXO);
        carro3.setSedeAtual(sede);
        carro3.setSituacao(SituacaoCarro.ALUGADO);
        carro3.setValorDiaria(new BigDecimal(300));

        Carro carro4 = new Carro();
        carro4.setPlaca("DQE-8364");
        carro4.setModelo("Mercedes");
        carro4.setKm(234000);
        carro4.setAno("2016");
        carro4.setLocacaoDeOrigem(sede);
        carro4.setClasseDeCarro(ClasseDeCarro.COMPACTO);
        carro4.setSedeAtual(sede);
        carro4.setSituacao(SituacaoCarro.ALUGADO);
        carro4.setValorDiaria(new BigDecimal(100));

        repositoryEndereco.salvaOuAtualiza(endereco);
        repositorySede.salvaOUAtualiza(sede);
        repositoryCarro.salvaOuAtualiza(carro1);
        repositoryCarro.salvaOuAtualiza(carro2);
        repositoryCarro.salvaOuAtualiza(carro3);

        manager.flush();


        List<Carro> carros = repositoryCarro.buscaPorClasse(ClasseDeCarro.COMPACTO);
        for (Carro c : carros) {
            Assert.assertEquals("compacto", c.getClasseDeCarro().toString());
        }

    }

    @Test //Teste02
    public void deveRecuperarCarrosDaClasseLuxo() {

        Endereco endereco = new Endereco();
        endereco.setRua("Rua das flores");
        endereco.setBairro("Renascenca");
        endereco.setNumero("51");
        endereco.setEstado("MA");
        endereco.setCidade("Sao Luis");
        endereco.setCep("65035873");

        Sede sede = new Sede();
        sede.setEndereco(endereco);
        sede.setMultaPorAtraso(new BigDecimal(80));
        sede.setNomeDoGerente("Flavio Alencar");
        sede.setTelefone("989716163");
        sede.setNome("Rent a Car Farol");


        //Criando objetos Carro
        Carro carro1 = new Carro();
        //carro1.setLocalizacaoAtual(sede);
        carro1.setPlaca("OPT-8654");
        carro1.setModelo("Celta");
        carro1.setKm(234000);
        carro1.setAno("2016");
        carro1.setLocacaoDeOrigem(sede);
        carro1.setClasseDeCarro(ClasseDeCarro.LUXO);
        carro1.setSedeAtual(sede);
        carro1.setSituacao(SituacaoCarro.DISPONIVEL);
        carro1.setValorDiaria(new BigDecimal(400));

        Carro carro2 = new Carro();
        carro2.setPlaca("RES-6688");
        carro2.setModelo("Punto");
        carro2.setKm(234000);
        carro2.setAno("2016");
        carro2.setLocacaoDeOrigem(sede);
        carro2.setClasseDeCarro(ClasseDeCarro.LUXO);
        carro2.setSedeAtual(sede);
        carro2.setSituacao(SituacaoCarro.FORA_DA_ORIGEM);
        carro2.setValorDiaria(new BigDecimal(400));

        Carro carro3 = new Carro();
        carro3.setPlaca("DQE-8364");
        carro3.setModelo("Mercedes");
        carro3.setKm(234000);
        carro3.setAno("2016");
        carro3.setLocacaoDeOrigem(sede);
        carro3.setClasseDeCarro(ClasseDeCarro.GRANDE);
        carro3.setSedeAtual(sede);
        carro3.setSituacao(SituacaoCarro.DISPONIVEL);
        carro3.setValorDiaria(new BigDecimal(300));

        Carro carro4 = new Carro();
        carro4.setPlaca("DQE-8364");
        carro4.setModelo("Mercedes");
        carro4.setKm(234000);
        carro4.setAno("2016");
        carro4.setLocacaoDeOrigem(sede);
        carro4.setClasseDeCarro(ClasseDeCarro.COMPACTO);
        carro4.setSedeAtual(sede);
        carro4.setSituacao(SituacaoCarro.DISPONIVEL);
        carro4.setValorDiaria(new BigDecimal(100));

        repositoryEndereco.salvaOuAtualiza(endereco);
        repositorySede.salvaOUAtualiza(sede);
        repositoryCarro.salvaOuAtualiza(carro1);
        repositoryCarro.salvaOuAtualiza(carro2);
        repositoryCarro.salvaOuAtualiza(carro3);

        manager.flush();


        List<Carro> carros = repositoryCarro.buscaPorClasse(ClasseDeCarro.LUXO);
        for (Carro c : carros) {
            Assert.assertEquals("luxo", c.getClasseDeCarro().toString());
        }
    }

    @Test
    public void reservaParaCarrosLocalizadosEmOutrasede() throws Exception {

        Endereco endereco = new Endereco();
        endereco.setRua("Rua das flores");
        endereco.setBairro("Renascenca");
        endereco.setNumero("51");
        endereco.setEstado("MA");
        endereco.setCidade("Sao Luis");
        endereco.setCep("65035873");

        Endereco endereco1 = new Endereco();
        endereco.setRua("Rua Macarena");
        endereco.setBairro("Itapiracó");
        endereco.setNumero("18B");
        endereco.setEstado("MA");
        endereco.setCidade("Sao Luis");
        endereco.setCep("65035589");


        //Criando objeto Sede
        Sede sede1 = new Sede();
        sede1.setEndereco(endereco);
        sede1.setMultaPorAtraso(new BigDecimal(90));
        sede1.setNomeDoGerente("Jose Ferreira");
        sede1.setTelefone("989716163");
        sede1.setNome("Locadora Dois Irmaos");

        Sede sede2 = new Sede();
        sede2.setEndereco(endereco);
        sede2.setMultaPorAtraso(new BigDecimal(80));
        sede2.setNomeDoGerente("Flavio Alencar");
        sede2.setTelefone("989716163");
        sede2.setNome("Rent a Car Farol");

        Carro carro2 = new Carro();
        carro2.setPlaca("RES-6688");
        carro2.setModelo("Punto");
        carro2.setKm(234000);
        carro2.setAno("2016");
        carro2.setLocacaoDeOrigem(sede1);
        carro2.setClasseDeCarro(ClasseDeCarro.MEDIO);
        carro2.setSedeAtual(sede2);
        carro2.setSituacao(SituacaoCarro.FORA_DA_ORIGEM);
        carro2.setValorDiaria(new BigDecimal(150));

        CNH cnh = new CNH();
        cnh.setCategoria("B");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/uuuu");
        cnh.setValidadeDaCNH(LocalDate.parse("22/10/2019", formatter));
        cnh.setCPF("51532181");
        cnh.setNumeroDaCNH("88888");

        Cliente cliente = new Cliente();
        cliente.atualizaDados(cnh);
        cliente.setNome("Vitoria Baptista");
        cliente.setEndereco(endereco);

        Assert.assertNotNull(sede2.realizarReserva(cliente, carro2, 4));

    }

    @Test(expected = IllegalStateException.class) //Teste04
    public void clienteNaoDeveRealizarSegundaReservaComLocacaoEmAberto() throws Exception {

        Endereco endereco = new Endereco();
        endereco.setRua("Rua das flores");
        endereco.setBairro("Renascenca");
        endereco.setNumero("51");
        endereco.setEstado("MA");
        endereco.setCidade("Sao Luis");
        endereco.setCep("65035873");


        Sede sede = new Sede();
        sede.setEndereco(endereco);
        sede.setMultaPorAtraso(new BigDecimal(80));
        sede.setNomeDoGerente("Flavio Alencar");
        sede.setTelefone("989716163");
        sede.setNome("Rent a Car Farol");

        Carro carro2 = new Carro();
        carro2.setPlaca("RES-6688");
        carro2.setModelo("Punto");
        carro2.setKm(234000);
        carro2.setAno("2016");
        carro2.setLocacaoDeOrigem(sede);
        carro2.setClasseDeCarro(ClasseDeCarro.MEDIO);
        carro2.setSedeAtual(sede);
        carro2.setSituacao(SituacaoCarro.FORA_DA_ORIGEM);
        carro2.setValorDiaria(new BigDecimal(150));

        Carro carro1 = new Carro();
        //carro1.setLocalizacaoAtual(sede);
        carro1.setPlaca("OPT-8654");
        carro1.setModelo("Celta");
        carro1.setKm(234000);
        carro1.setAno("2016");
        //carro1.setLocacaoDeOrigem(sede2);
        carro1.setClasseDeCarro(ClasseDeCarro.COMPACTO);
        carro1.setSedeAtual(sede);
        carro1.setSituacao(SituacaoCarro.DISPONIVEL);
        carro1.setValorDiaria(new BigDecimal(100));

        CNH cnh = new CNH();
        cnh.setCategoria("B");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/uuuu");
        cnh.setValidadeDaCNH(LocalDate.parse("22/10/2019", formatter));
        cnh.setCPF("51532181");
        cnh.setNumeroDaCNH("88888");

        Cliente cliente = new Cliente();
        cliente.atualizaDados(cnh);
        cliente.setNome("Vitoria Baptista");
        cliente.setEndereco(endereco);

        Assert.assertNotNull(sede.realizarReserva(cliente, carro2, 5));
        sede.realizarReserva(cliente, carro2, 4);

    }

    @Test(expected = Exception.class) //Teste05
    public void clienteNaoDeveRealizarReservaCasoPossuaPendencia() throws Exception {
        Endereco endereco = new Endereco();
        endereco.setRua("Rua das flores");
        endereco.setBairro("Renascenca");
        endereco.setNumero("51");
        endereco.setEstado("MA");
        endereco.setCidade("Sao Luis");
        endereco.setCep("65035873");


        Sede sede = new Sede();
        sede.setEndereco(endereco);
        sede.setMultaPorAtraso(new BigDecimal(80));
        sede.setNomeDoGerente("Flavio Alencar");
        sede.setTelefone("989716163");
        sede.setNome("Rent a Car Farol");

        CNH cnh = new CNH();
        cnh.setCategoria("B");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/uuuu");
        cnh.setValidadeDaCNH(LocalDate.parse("22/10/2019", formatter));
        cnh.setCPF("51532181");
        cnh.setNumeroDaCNH("88888");

        Cliente cliente = new Cliente();
        cliente.atualizaDados(cnh);
        cliente.setNome("Vitoria Baptista");
        cliente.setEndereco(endereco);

        Reserva reserva = new Reserva();
        reserva.setCliente(cliente);
        reserva.setSedeDevolucao(sede);
        cliente.adicionarReserva(reserva);

        Reserva reserva1 = new Reserva();
        cliente.adicionarReserva(reserva1);

    }

    @Test //Teste06
    public void atualizarDadosDaHabilitacao() throws Exception {


        Endereco endereco = new Endereco();
        endereco.setRua("Rua das flores");
        endereco.setBairro("Renascenca");
        endereco.setNumero("51");
        endereco.setEstado("MA");
        endereco.setCidade("Sao Luis");
        endereco.setCep("65035873");

        CNH cnh = new CNH();
        cnh.setCategoria("B");
        cnh.setValidadeDaCNH(LocalDate.parse("22/10/2019", formatter));
        cnh.setCPF("51532181");
        cnh.setNumeroDaCNH("88888");

        Cliente cliente = new Cliente();
        cliente.atualizaDados(cnh);
        cliente.setNome("Vitoria Baptista");
        cliente.setEndereco(endereco);

        CNH cnh1 = new CNH();
        cnh.setCategoria("B");
        cnh.setValidadeDaCNH(LocalDate.parse("08/10/2022", formatter));
        cnh.setCPF("51532181");
        cnh.setNumeroDaCNH("88888");
        Assert.assertNotNull(cliente.atualizaDados(cnh1));


    }

    @Test(expected = IllegalStateException.class) //Teste07
    public void naoDeveAlugarUmCarroNoMesmoIntervaloDeTempo() throws Exception {

        CNH cnh1 = new CNH();
        cnh1.setCategoria("B");
        cnh1.setValidadeDaCNH(LocalDate.parse("22/10/2019", formatter));
        cnh1.setCPF("51532181");
        cnh1.setNumeroDaCNH("88888");

        CNH cnh2 = new CNH();
        cnh2.setCategoria("AB");
        cnh2.setValidadeDaCNH(LocalDate.parse("30/01/2022", formatter));
        cnh2.setCPF("96565612");
        cnh2.setNumeroDaCNH("666666");

        Endereco endereco = new Endereco();
        endereco.setRua("Rua das flores");
        endereco.setBairro("Renascenca");
        endereco.setNumero("51");
        endereco.setEstado("MA");
        endereco.setCidade("Sao Luis");
        endereco.setCep("65035873");

        Sede sede = new Sede();
        sede.setEndereco(endereco);
        sede.setMultaPorAtraso(new BigDecimal(80));
        sede.setNomeDoGerente("Flavio Alencar");
        sede.setTelefone("989716163");
        sede.setNome("Rent a Car Farol");

        Carro carro1 = new Carro();
        carro1.setSedeOrigem(sede);
        carro1.setPlaca("OPT-8654");
        carro1.setModelo("Celta");
        carro1.setKm(234000);
        carro1.setAno("2016");
        carro1.setClasseDeCarro(ClasseDeCarro.COMPACTO);
        carro1.setSedeAtual(sede);
        carro1.setSituacao(SituacaoCarro.DISPONIVEL);
        carro1.setValorDiaria(new BigDecimal(100));

        Cliente cliente2 = new Cliente();
        cliente2.atualizaDados(cnh2);
        cliente2.setNome("Paulo Roberto Neres");
        cliente2.setEndereco(endereco);

        Cliente cliente = new Cliente();
        cliente.atualizaDados(cnh1);
        cliente.setNome("Vitoria Baptista");
        cliente.setEndereco(endereco);

        Assert.assertNotNull(sede.realizarReserva(cliente, carro1, 7));
        sede.realizarReserva(cliente2, carro1, 3);

    }

    @Test //Teste08
    public void deveRealizarReservaParaCNHDentroDoPrazoDeValidade() throws Exception {

        CNH cnh1 = new CNH();
        cnh1.setCategoria("B");
        cnh1.setValidadeDaCNH(LocalDate.parse("22/10/2019", formatter));
        cnh1.setCPF("51532181");
        cnh1.setNumeroDaCNH("88888");
        Endereco endereco = new Endereco();
        endereco.setRua("Rua das flores");
        endereco.setBairro("Renascenca");
        endereco.setNumero("51");
        endereco.setEstado("MA");
        endereco.setCidade("Sao Luis");
        endereco.setCep("65035873");

        Cliente cliente = new Cliente();
        cliente.atualizaDados(cnh1);
        cliente.setNome("Vitoria Baptista");
        cliente.setEndereco(endereco);

        Sede sede = new Sede();
        sede.setEndereco(endereco);
        sede.setMultaPorAtraso(new BigDecimal(80));
        sede.setNomeDoGerente("Flavio Alencar");
        sede.setTelefone("989716163");
        sede.setNome("Rent a Car Farol");

        Carro carro1 = new Carro();
        carro1.setSedeOrigem(sede);
        carro1.setPlaca("OPT-8654");
        carro1.setModelo("Celta");
        carro1.setKm(234000);
        carro1.setAno("2016");
        carro1.setClasseDeCarro(ClasseDeCarro.COMPACTO);
        carro1.setSedeAtual(sede);
        carro1.setSituacao(SituacaoCarro.DISPONIVEL);
        carro1.setValorDiaria(new BigDecimal(100));

        Assert.assertNotNull(sede.realizarReserva(cliente, carro1, 7));

    }

    @Test(expected = IllegalStateException.class) //Teste09
    public void naoeveRealizarReservaParaCNHForaDoPrazoDeValidade() throws Exception {

        CNH cnh1 = new CNH();
        cnh1.setCategoria("B");
        cnh1.setValidadeDaCNH(LocalDate.parse("01/07/2019", formatter));
        cnh1.setCPF("51532181");
        cnh1.setNumeroDaCNH("88888");
        Endereco endereco = new Endereco();
        endereco.setRua("Rua das flores");
        endereco.setBairro("Renascenca");
        endereco.setNumero("51");
        endereco.setEstado("MA");
        endereco.setCidade("Sao Luis");
        endereco.setCep("65035873");

        Cliente cliente = new Cliente();
        cliente.atualizaDados(cnh1);
        cliente.setNome("Vitoria Baptista");
        cliente.setEndereco(endereco);

        Sede sede = new Sede();
        sede.setEndereco(endereco);
        sede.setMultaPorAtraso(new BigDecimal(80));
        sede.setNomeDoGerente("Flavio Alencar");
        sede.setTelefone("989716163");
        sede.setNome("Rent a Car Farol");

        Carro carro1 = new Carro();
        carro1.setSedeOrigem(sede);
        carro1.setPlaca("OPT-8654");
        carro1.setModelo("Celta");
        carro1.setKm(234000);
        carro1.setAno("2016");
        carro1.setClasseDeCarro(ClasseDeCarro.COMPACTO);
        carro1.setSedeAtual(sede);
        carro1.setSituacao(SituacaoCarro.DISPONIVEL);
        carro1.setValorDiaria(new BigDecimal(100));

        sede.realizarReserva(cliente, carro1, 7);

    }

    @Test//Teste10
    public void deveRecuperarReservasEmAbertoPorSede() throws Exception {


        CNH cnh1 = new CNH();
        cnh1.setCategoria("B");
        cnh1.setValidadeDaCNH(LocalDate.parse("22/10/2019", formatter));
        cnh1.setCPF("51532181");
        cnh1.setNumeroDaCNH("88888");

        CNH cnh2 = new CNH();
        cnh2.setCategoria("AB");
        cnh2.setValidadeDaCNH(LocalDate.parse("30/01/2022", formatter));
        cnh2.setCPF("96565612");
        cnh2.setNumeroDaCNH("666666");

        CNH cnh3 = new CNH();
        cnh3.setCategoria("B");
        cnh3.setValidadeDaCNH(LocalDate.parse("24/11/2021", formatter));
        cnh3.setCPF("94486543");
        cnh3.setNumeroDaCNH("77777777");

        Endereco endereco = new Endereco();
        endereco.setRua("Rua das flores");
        endereco.setBairro("Renascenca");
        endereco.setNumero("51");
        endereco.setEstado("MA");
        endereco.setCidade("Sao Luis");
        endereco.setCep("65035873");

        Sede sede = new Sede();
        sede.setEndereco(endereco);
        sede.setMultaPorAtraso(new BigDecimal(80));
        sede.setNomeDoGerente("Flavio Alencar");
        sede.setTelefone("989716163");
        sede.setNome("Rent a Car Farol");

        Carro carro1 = new Carro();
        carro1.setSedeOrigem(sede);
        carro1.setPlaca("OPT-8654");
        carro1.setModelo("Celta");
        carro1.setKm(234000);
        carro1.setAno("2016");
        carro1.setClasseDeCarro(ClasseDeCarro.COMPACTO);
        carro1.setSedeAtual(sede);
        carro1.setSituacao(SituacaoCarro.DISPONIVEL);
        carro1.setValorDiaria(new BigDecimal(100));

        Carro carro2 = new Carro();
        carro2.setSedeOrigem(sede);
        carro2.setPlaca("ABC-8974");
        carro2.setModelo("Renault");
        carro2.setKm(251000);
        carro2.setAno("2018");
        carro2.setClasseDeCarro(ClasseDeCarro.COMPACTO);
        carro2.setSedeAtual(sede);
        carro2.setSituacao(SituacaoCarro.DISPONIVEL);
        carro2.setValorDiaria(new BigDecimal(100));

        Carro carro3 = new Carro();
        carro3.setSedeOrigem(sede);
        carro3.setPlaca("ABC-8974");
        carro3.setModelo("Lamborgini");
        carro3.setKm(89000);
        carro3.setAno("2019");
        carro3.setClasseDeCarro(ClasseDeCarro.LUXO);
        carro3.setSedeAtual(sede);
        carro3.setSituacao(SituacaoCarro.DISPONIVEL);
        carro3.setValorDiaria(new BigDecimal(800));

        Cliente cliente = new Cliente();
        cliente.atualizaDados(cnh1);
        cliente.setNome("Vitoria Baptista");
        cliente.setEndereco(endereco);

        Cliente cliente2 = new Cliente();
        cliente2.atualizaDados(cnh2);
        cliente2.setNome("Paulo Roberto Neres");
        cliente2.setEndereco(endereco);

        Cliente cliente3 = new Cliente();
        cliente3.atualizaDados(cnh2);
        cliente3.setNome("Bianca Nobreaga");
        cliente3.setEndereco(endereco);

        sede.realizarReserva(cliente, carro1, 7);
        sede.realizarReserva(cliente2, carro2, 3);
        sede.realizarReserva(cliente3, carro3, 8);


        List<Reserva> reservas = sede.recuperarReservasEmAberto();
        for (Reserva r : reservas) {
            Assert.assertEquals("aberta", r.getStatusReserva().toString());

        }

    }

    @Test //Teste11
    public void valorTotalParaCarrosDevolvidosNaMesmaSede() throws Exception {


        CNH cnh1 = new CNH();
        cnh1.setCategoria("B");
        cnh1.setValidadeDaCNH(LocalDate.parse("22/10/2019", formatter));
        cnh1.setCPF("51532181");
        cnh1.setNumeroDaCNH("88888");

        Endereco endereco = new Endereco();
        endereco.setRua("Rua das flores");
        endereco.setBairro("Renascenca");
        endereco.setNumero("51");
        endereco.setEstado("MA");
        endereco.setCidade("Sao Luis");
        endereco.setCep("65035873");


        Cliente cliente = new Cliente();
        cliente.atualizaDados(cnh1);
        cliente.setNome("Vitoria Baptista");
        cliente.setEndereco(endereco);

        Sede sede = new Sede();
        sede.setEndereco(endereco);
        sede.setMultaPorAtraso(new BigDecimal(80));
        sede.setNomeDoGerente("Flavio Alencar");
        sede.setTelefone("989716163");
        sede.setNome("Rent a Car Farol");

        Endereco endereco2 = new Endereco();
        endereco2.setRua("Rua Flamengo");
        endereco2.setBairro("Liberdade");
        endereco2.setNumero("100");
        endereco2.setEstado("MA");
        endereco2.setCidade("Sao Luis");
        endereco2.setCep("6222256");

        Sede sede2 = new Sede();
        sede2.setEndereco(endereco2);
        sede2.setMultaPorAtraso(new BigDecimal(90));
        sede2.setNomeDoGerente("Jose Freitas");
        sede2.setTelefone("989716163");
        sede2.setNome("Rent YAS");

        Carro carro1 = new Carro();
        carro1.setSedeOrigem(sede);
        carro1.setPlaca("OPT-8654");
        carro1.setModelo("Celta");
        carro1.setKm(234000);
        carro1.setAno("2016");
        carro1.setClasseDeCarro(ClasseDeCarro.COMPACTO);
        carro1.setSedeAtual(sede);
        carro1.setSituacao(SituacaoCarro.DISPONIVEL);
        carro1.setValorDiaria(new BigDecimal(100));

        Reserva reserva = sede.realizarReserva(cliente, carro1, 8);
        sede.encerrarReserva(reserva);

        BigDecimal valorSemMulta = reserva.getValorTotal();

        Assert.assertEquals(valorSemMulta, reserva.getValorTotal());


    }

    @Test //Teste12
    public void ValotTotalComTaxaParaCarrosDevolvidosEmOutraSede() throws Exception {


        CNH cnh1 = new CNH();
        cnh1.setCategoria("B");
        cnh1.setValidadeDaCNH(LocalDate.parse("22/10/2019", formatter));
        cnh1.setCPF("51532181");
        cnh1.setNumeroDaCNH("88888");

        Endereco endereco = new Endereco();
        endereco.setRua("Rua das flores");
        endereco.setBairro("Renascenca");
        endereco.setNumero("51");
        endereco.setEstado("MA");
        endereco.setCidade("Sao Luis");
        endereco.setCep("65035873");

        Cliente cliente = new Cliente();
        cliente.atualizaDados(cnh1);
        cliente.setNome("Vitoria Baptista");
        cliente.setEndereco(endereco);

        Sede sede = new Sede();
        sede.setEndereco(endereco);
        sede.setMultaPorAtraso(new BigDecimal(80));
        sede.setNomeDoGerente("Flavio Alencar");
        sede.setTelefone("989716163");
        sede.setNome("Rent a Car Farol");

        Endereco endereco2 = new Endereco();
        endereco2.setRua("Rua Flamengo");
        endereco2.setBairro("Liberdade");
        endereco2.setNumero("100");
        endereco2.setEstado("MA");
        endereco2.setCidade("Sao Luis");
        endereco2.setCep("6222256");


        Sede sede2 = new Sede();
        sede2.setEndereco(endereco2);
        sede2.setMultaPorAtraso(new BigDecimal(90));
        sede2.setNomeDoGerente("Jose Freitas");
        sede2.setTelefone("989716163");
        sede2.setNome("Rent YAS");

        Carro carro1 = new Carro();
        carro1.setSedeOrigem(sede);
        carro1.setPlaca("OPT-8654");
        carro1.setModelo("Celta");
        carro1.setKm(234000);
        carro1.setAno("2016");
        carro1.setClasseDeCarro(ClasseDeCarro.COMPACTO);
        carro1.setSedeAtual(sede);
        carro1.setSituacao(SituacaoCarro.DISPONIVEL);
        carro1.setValorDiaria(new BigDecimal(100));

        Reserva reserva = sede.realizarReserva(cliente, carro1, 8);
        sede2.encerrarReserva(reserva);

        BigDecimal valorComMulta = reserva.getValorTotal();

        Assert.assertEquals(valorComMulta, reserva.getValorTotal());


    }
}
