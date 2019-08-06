package Repository;

import modelo.Sede;

import javax.persistence.EntityManager;
import java.util.List;

public class SedeRepository {
    private final EntityManager  maneger;
    private final DAOGenerico<Sede> daoGenerico;

    public SedeRepository(EntityManager maneger){
        this.maneger = maneger;
        this.daoGenerico = new DAOGenerico<>(maneger);

    }

    public Sede buscaPor(Integer id){
        return daoGenerico.buscaPorId(Sede.class, id);
    }

    public List<Sede> buscaPor(String nome){
        return this.maneger.createQuery("from Sede where upper(nome) like (:nome) ", Sede.class)
                .setParameter("nome", nome.toUpperCase() + "%")
                .getResultList();
    }

    public Sede salvaOUAtualiza(Sede sede){
       return  daoGenerico.salvaOuAtualiza(sede);
    }


    public void remove(Sede sede){
        daoGenerico.remove(sede);
    }
}
