package repository;

import modelo.Reserva;
import modelo.Sede;

import javax.persistence.EntityManager;
import java.util.List;

public class ReservaRepository {

    private final EntityManager maneger;
    private final DAOGenerico<Reserva> daoGenerico;


    public ReservaRepository(EntityManager maneger){
        this.maneger = maneger;
        this.daoGenerico =  new DAOGenerico<>(maneger);
    }

    public Reserva buscaPorId(Integer id){
        return daoGenerico.buscaPorId(Reserva.class, id);
    }

    public List<Reserva> reservasPorSede(Sede sede){
       return  maneger.createQuery("select r from Reserva r where r.sedeOrigem = :codigo", Reserva.class)
               .setParameter("codigo", sede)
               .getResultList();

    }


    public void remove(Reserva reserva){
        daoGenerico.remove(reserva);
    }

}
