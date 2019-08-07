package teste;

import repository.ReservaRepository;
import modelo.Reserva;
import modelo.Sede;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.text.ParseException;


public class TesteReserva {



    public static void main(String []args ) throws ParseException {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("locacaoDeVeiculos");
        EntityManager manager = factory.createEntityManager();
        EntityTransaction transacao =  manager.getTransaction() ;

        ReservaRepository reservaRepository = new ReservaRepository(manager);

         transacao.begin();


    /* Cliente cliente = manager.find(Cliente.class, 1);




    Carro carro = manager.find(Carro.class, "PTG-5165");

    Reserva reserva = new Reserva();
    reserva.setCarro(carro);
    reserva.setCliente(cliente);
    reserva.setDataDaLocacao(reservaRepository.formataData("28/09/2019"));
    reserva.setDataRetorno(reservaRepository.formataData("30/09/2019"));
    reserva.setMulta(80);
    reserva.setSedeOrigem(sede);
    reserva.getKmRodados(80);
    reserva.setSedeDevolucao(sede);
    reserva.setQuantidadeDeDiarias(reserva.diferencaDeDataEmDias());


    manager.persist(reserva); */

    Sede sede = manager.find(Sede.class, 2);

 for (Reserva r: reservaRepository.reservasPorSede(sede)){
          System.out.println(r.toString());
 }

   // Reserva reserva = manager.find(Reserva.class, 2);

   // reservaRepository.remove(reserva);

    transacao.commit();

    manager.close();

    factory.close();


    }
}
