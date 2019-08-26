package repository;

import modelo.Endereco;
import modelo.Reserva;
import modelo.Sede;

import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.util.Date;
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

    public Reserva salvaOuAtualiza(Reserva reserva){
        return  daoGenerico.salvaOuAtualiza(reserva);
    }

    public List<Reserva> reservasPorSede(Sede sede){
       return  maneger.createQuery("select r from Reserva r where r.sedeOrigem = :codigo", Reserva.class)
               .setParameter("codigo", sede)
               .getResultList();

    }

   /* public List<Reserva> reservasFinalizadasPorSedeEntre(LocalDate dateInicio, LocalDate dateFim, Sede sede){
        return maneger.createQuery("select r from Reserva r where r.sedeDevolucao = :sede and r.dataRetorno = :dateFim between :dateInicio  ").getResultList();

    } */


    public void remove(Reserva reserva){
        daoGenerico.remove(reserva);
    }

}
