package repository;


import modelo.Carro;
import modelo.ClasseDeCarro;
import util.EMFactory;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class CarroRepository  {

    private final DAOGenerico<Carro> daoGenerico;
    EntityManager maneger = EMFactory.getEntityManager();

    public CarroRepository(EntityManager  maneger){
    this.maneger = maneger;
    daoGenerico = new DAOGenerico<>(maneger);
    }



    public Carro buscarId(String id){
       return  maneger.find(Carro.class, id);
    }


    public List<Carro> listaDeCarros(){
        return maneger.createQuery("from Carro", Carro.class).getResultList();

    }


   public List<Carro>buscaPorClasse(ClasseDeCarro classe){
       Query q = maneger.createQuery("from Carro where classeDeCarro = :classe");
       q.setParameter("classe",classe);
       return q.getResultList();
   }

    public void remover (Carro carro) {
        daoGenerico.remove(carro);
    }

    public Carro salvaOuAtualiza(Carro carro){
         return  daoGenerico.salvaOuAtualiza(carro);
    }
}