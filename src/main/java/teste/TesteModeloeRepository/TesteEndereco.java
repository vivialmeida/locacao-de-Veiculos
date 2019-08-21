package teste.TesteModeloeRepository;

import modelo.Endereco;
import repository.EnderecoRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TesteEndereco {

    public static void main(String[] args) {
        EntityManagerFactory factory =
                Persistence.createEntityManagerFactory("locacaoDeVeiculos");
        EntityManager manager = factory.createEntityManager();
        EntityTransaction transacao = manager.getTransaction();

        EnderecoRepository er = new EnderecoRepository(manager);

        transacao.begin();

        Endereco endereco = new Endereco();
        endereco.setRua("Rua das flores");
        endereco.setBairro("Renascenca");
        endereco.setNumero("51");
        endereco.setEstado("MA");
        endereco.setCidade("Sao Luis");
        endereco.setCep("65035873");
        er.salvaOuAtualiza(endereco);

        transacao.commit();

        manager.close();

        factory.close();


    }
}