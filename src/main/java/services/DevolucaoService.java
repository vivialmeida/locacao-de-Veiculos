package services;

import modelo.Reserva;
import repository.ReservaRepository;
import util.EMFactory;

import javax.persistence.EntityManager;

public class DevolucaoService {

    private final ReservaRepository repositorio;
    private final EntityManager manager;

    public DevolucaoService() {
        this.manager = new EMFactory().getEntityManager();
        this.repositorio = new ReservaRepository(manager);
    }

    public boolean devolucao(Reserva reserva) {

        try {

            manager.getTransaction().begin();
           if (manager.find(Reserva.class, reserva) == null){
               return  false;
           } else if (reserva.getSedeDevolucao().equals(reserva.getSedeOrigem())) {
                return true;
            } else {
                reserva.calculaValorComMulta();
                manager.getTransaction().commit();
                return  true;
            }
        } catch (Exception e) {
            throw new RuntimeException();
        }

    }


}
