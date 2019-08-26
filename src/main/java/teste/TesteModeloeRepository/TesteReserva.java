package teste.TesteModeloeRepository;

import modelo.*;
import repository.ReservaRepository;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class TesteReserva {



    public static void main(String []args ) throws Exception {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("locacaoDeVeiculos");
        EntityManager manager = factory.createEntityManager();
        EntityTransaction transacao =  manager.getTransaction() ;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/uuuu");

        ReservaRepository reservaRepository = new ReservaRepository(manager);

         transacao.begin();


        CNH cnh1 = new CNH();
        cnh1.setCategoria("B");
        cnh1.setValidadeDaCNH(LocalDate.parse("22/10/2019", formatter));
        cnh1.setCPF("51532181");
        cnh1.setNumeroDaCNH("88888");
        manager.persist(cnh1);

        CNH cnh2 = new CNH();
        cnh2.setCategoria("AB");
        cnh2.setValidadeDaCNH(LocalDate.parse("30/01/2022", formatter));
        cnh2.setCPF("96565612");
        cnh2.setNumeroDaCNH("666666");
        manager.persist(cnh2);

        CNH cnh3 = new CNH();
        cnh3.setCategoria("B");
        cnh3.setValidadeDaCNH(LocalDate.parse("24/11/2021", formatter));
        cnh3.setCPF("94486543");
        cnh3.setNumeroDaCNH("77777777");
        manager.persist(cnh3);

        Endereco endereco = new Endereco();
        endereco.setRua("Rua das flores");
        endereco.setBairro("Renascenca");
        endereco.setNumero("51");
        endereco.setEstado("MA");
        endereco.setCidade("Sao Luis");
        endereco.setCep("65035873");
        manager.persist(endereco);


        Sede sede = new Sede();
        sede.setEndereco(endereco);
        sede.setMultaPorAtraso(new BigDecimal(80));
        sede.setNomeDoGerente("Flavio Alencar");
        sede.setTelefone("989716163");
        sede.setNome("Rent a Car Farol");
        manager.persist(sede);


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
        manager.persist(carro1);

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
        manager.persist(carro2);

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
        manager.persist(carro3);

        Cliente cliente = new Cliente();
        cliente.atualizaDados(cnh1);
        cliente.setNome("Vitoria Baptista");
        cliente.setEndereco(endereco);
        cnh1.setCliente(cliente);
        manager.persist(cliente);

        Cliente cliente2 = new Cliente();
        cliente2.atualizaDados(cnh2);
        cliente2.setNome("Paulo Roberto Neres");
        cliente2.setEndereco(endereco);
        cnh2.setCliente(cliente2);
        manager.persist(cliente2);

        Cliente cliente3 = new Cliente();
        cliente3.atualizaDados(cnh3);
        cliente3.setNome("Bianca Nobreaga");
        cliente3.setEndereco(endereco);
        cnh3.setCliente(cliente3);
        manager.persist(cliente3);


        sede.realizarReserva(cliente, carro1, 7);
        sede.realizarReserva(cliente2,carro2,3);
        sede.realizarReserva(cliente3, carro3, 8);

        System.out.println(sede.recuperarReservasEmAberto());


    transacao.commit();

    manager.close();

    factory.close();


    }
}
