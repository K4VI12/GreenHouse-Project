package lk.flex.greenHouse.config;

import lk.flex.greenHouse.entity.Hiumidity;
import lk.flex.greenHouse.entity.SoilMoisture;
import lk.flex.greenHouse.entity.Temperature;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.model.naming.ImplicitNamingStrategyJpaCompliantImpl;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;


public class  SessionFactoryConfig {

    private static SessionFactoryConfig factoryConfig;
    private final SessionFactory sessionFactory;

    private SessionFactoryConfig() {
        sessionFactory = new Configuration()
                .configure()
                .addAnnotatedClass(Hiumidity.class)
                .addAnnotatedClass(Temperature.class)
                .addAnnotatedClass(SoilMoisture.class)
                .buildSessionFactory();

    }


    public static SessionFactoryConfig getInstance() {
        return (null == factoryConfig)
                ? factoryConfig = new SessionFactoryConfig()
                : factoryConfig;
    }


    public Session getSession() {
        return sessionFactory.openSession();
    }
}
