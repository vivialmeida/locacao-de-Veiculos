package repository;

import modelo.Endereco;

import javax.persistence.EntityManager;

public class EnderecoRepository {

    private final EntityManager maneger;
    private final DAOGenerico<Endereco> daoGenerico;

    public EnderecoRepository(EntityManager maneger) {
        this.maneger = maneger;
        this.daoGenerico = new DAOGenerico<>(maneger);

    }
    public Endereco salvaOuAtualiza(Endereco endereco){
        return  daoGenerico.salvaOuAtualiza(endereco);
    }

    public Endereco buscaPorId(Integer id) {
        return daoGenerico.buscaPorId(Endereco.class, id);
    }


    public void remove(Endereco endereco) {
        daoGenerico.remove(endereco);
    }

}
