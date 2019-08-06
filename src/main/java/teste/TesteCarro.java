package teste;

import Repository.CarroRepository;
import modelo.Sede;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class

TesteCarro {

    public static void main(String[] args) {
        EntityManagerFactory factory =
                Persistence.createEntityManagerFactory("locacaoDeVeiculos");
        EntityManager manager = factory.createEntityManager();
        EntityTransaction transacao = manager.getTransaction();

        CarroRepository  carroRepository = new CarroRepository(manager);


        transacao.begin();

        Sede sede = manager.find(Sede.class,2);

        /*Carro carro1 = new Carro();
        carro1.setClasseDeCarro(ClasseDeCarro.COMPACTO);
        carro1.setLocacaoDeOrigem(sede);
        carro1.setLocalizacaoAtual(sede);
        carro1.setAno("2019");
        carro1.setModelo("Ford Ka");
        carro1.setPlaca("PYT-5846");
        carro1.setKm(4000);

        manager.persist(carro1); */

       //System.out.println( carroRepository.buscarId("PTG-0129").toString());
        System.out.println( carroRepository.listaDeCarros());



        transacao.commit();

        manager.close();

        factory.close();






    }
}
