package teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPATeste {

    public static void main(String[] args){


            EntityManagerFactory factory =
                    Persistence.createEntityManagerFactory("locacaoDeVeiculos");
            EntityManager manager = factory.createEntityManager();

    }


}
