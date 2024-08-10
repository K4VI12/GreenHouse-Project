package lk.flex.greenHouse.repository;

import lk.flex.greenHouse.config.SessionFactoryConfig;
import lk.flex.greenHouse.entity.Hiumidity;
import lk.flex.greenHouse.entity.Temperature;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class TemperatureRepository {
    private final Session session;

    public TemperatureRepository() {
        session = SessionFactoryConfig
                .getInstance()
                .getSession();
    }


    public int save(Temperature customer) {
        Transaction transaction = session.beginTransaction();
        try {
            int customerId = (int) session.save(customer);
            transaction.commit();
            session.close();
            return customerId;
        } catch (Exception e) {
            transaction.rollback();
            session.close();
            e.printStackTrace();
            return -1;
        }
    }
    public List<Temperature> getAll() {
        String hql = "SELECT s FROM Temperature s ";
        Query query = session.createQuery(hql);
        //query.setParameter("room_type_id",ID);
        List<Temperature> list = query.getResultList();
        return list;
    }
}
