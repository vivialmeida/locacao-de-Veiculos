package teste.TesteModeloeRepository;

import modelo.Carro;
import modelo.ClasseDeCarro;
import modelo.SituacaoCarro;
import repository.CarroRepository;
import modelo.Sede;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.math.BigDecimal;

public class

TesteCarro {

    public static void main(String[] args) {
        EntityManagerFactory factory =
                Persistence.createEntityManagerFactory("locacaoDeVeiculos");
        EntityManager manager = factory.createEntityManager();
        EntityTransaction transacao = manager.getTransaction();

        CarroRepository  carroRepository = new CarroRepository(manager);


        transacao.begin();

        Sede sede = manager.find(Sede.class,1);

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
       // manager.persist(carro1);

        carroRepository.salvaOuAtualiza(carro1);
        carroRepository.salvaOuAtualiza(carro2);
        carroRepository.salvaOuAtualiza(carro3);
        carroRepository.salvaOuAtualiza(carro4);

        //System.out.println( carroRepository.buscarId("DQE-8364").toString());
      System.out.println( carroRepository.buscaPorClasse(ClasseDeCarro.COMPACTO));



        transacao.commit();

        manager.close();

        factory.close();






    }
}
