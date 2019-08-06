package Repository;

import modelo.Reserva;
import modelo.Sede;

import javax.persistence.EntityManager;
import java.text.ParseException;
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

    public List<Reserva> reservasPorSede(Sede sede){
       return  maneger.createQuery(" from  Sede s join Reserva r on s.codigo = r.sedeOrigem.codigo where s.codigo = :codigo ", Reserva.class)
                .setParameter(sede.getCodigo(), sede).getResultList();

    }

    public Date formataData(String data) throws ParseException {
       return daoGenerico.formataData(data);
    }

}
