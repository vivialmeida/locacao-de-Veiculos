package Repository;

import javax.persistence.EntityManager;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

class DAOGenerico<T> {

    private final EntityManager manager;

    DAOGenerico(EntityManager manager) {
        this.manager = manager;
    }

    T buscaPorId(Class<T> clazz, Integer id) {
        return manager.find(clazz, id);
    }

    T salvaOuAtualiza(T t) {
        if( Objects.isNull(t) )
            this.manager.persist(t);
        else
            t = this.manager.merge(t);
        return t;
    }

    void remove(T t) {
        manager.remove(t);
        manager.flush();
    }

    Date formataData(String data) throws ParseException {
        Date sdf = new SimpleDateFormat ("dd/mm/yyyy").parse(data);
        return  sdf;
    }
}
