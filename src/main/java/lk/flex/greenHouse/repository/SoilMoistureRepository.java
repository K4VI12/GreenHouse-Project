package lk.flex.greenHouse.repository;

import lk.flex.greenHouse.config.SessionFactoryConfig;
import lk.flex.greenHouse.entity.Hiumidity;
import lk.flex.greenHouse.entity.SoilMoisture;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class SoilMoistureRepository {
    private final Session session;

    public SoilMoistureRepository() {
        session = SessionFactoryConfig
                .getInstance()
                .getSession();
    }


    public int save(SoilMoisture soilMoisture) {
        Transaction transaction = session.beginTransaction();
        try {
            int customerId = (int) session.save(soilMoisture);
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
    public List<SoilMoisture> getAll() {
        String hql = "SELECT s FROM SoilMoisture s ";
        Query query = session.createQuery(hql);
        //query.setParameter("room_type_id",ID);
        List<SoilMoisture> list = query.getResultList();
        return list;
    }
}