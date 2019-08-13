package services;

import repository.ClienteRepository;
import util.EMFactory;

import javax.persistence.EntityManager;

public class CadastraOuAtualizaCliente {

    private final ClienteRepository repositorio;
    private final EntityManager manager;

    public CadastraOuAtualizaCliente() {
        this.manager = new EMFactory().getEntityManager();
        this.repositorio = new ClienteRepository(manager);
    }



}
