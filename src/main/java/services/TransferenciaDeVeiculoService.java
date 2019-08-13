package services;

import modelo.Carro;
import modelo.Sede;
import repository.CarroRepository;
import util.EMFactory;

import javax.persistence.EntityManager;

public class TransferenciaDeVeiculoService {
    private final CarroRepository repositorio;
    private final EntityManager manager;


    public TransferenciaDeVeiculoService() {
        this.manager = new EMFactory().getEntityManager();
        repositorio = new CarroRepository(manager);
    }

    public Carro tranferenciaDeVeiculo(Carro carro, Sede sede) {

        try {
            manager.getTransaction().begin();
            if (repositorio.buscarId(carro.getPlaca()) != null) {
                carro.setLocalizacaoAtual(sede);
                repositorio.salvaOuAtualiza(carro);
                manager.getTransaction().commit();
                return carro;
            } else {
                return null;
            }

        } catch (Exception e) {
            throw new RuntimeException(e);

        }


    }
}
