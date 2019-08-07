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

    public void devolucao(Reserva reserva) {
        try {
            manager.find(Reserva.class, reserva);
            if (reserva.getSedeDevolucao().equals(reserva.getSedeOrigem())) {
                return;
            } else {
                reserva.calculaValorComMulta();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }


}
