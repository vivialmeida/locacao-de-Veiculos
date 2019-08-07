package repository;

import modelo.Carro;

import javax.persistence.EntityManager;
import java.util.List;

public class CarroRepository  {

    private final DAOGenerico<Carro> daoGenerico;
    private final EntityManager maneger;

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

    public List<Carro> listaPorClasse(){return maneger.createQuery("from Carro", Carro.class).getResultList();
   }

    public void remover (Carro carro) {
        daoGenerico.remove(carro);
    }

    public Carro salvaOuAtualiza(Carro carro){
         return  daoGenerico.salvaOuAtualiza(carro);
    }
}