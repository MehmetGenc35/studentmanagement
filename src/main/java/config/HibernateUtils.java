package config;

import domain.Course;
import domain.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {

    private static SessionFactory sessionFactory;

    //uygulama çalıştığında config yapılsın
    static{
        try {
            Configuration config = new Configuration().
                    configure("hibernate.cfg.xml").
                    addAnnotatedClass(Student.class).
                    addAnnotatedClass(Course.class);

            sessionFactory = config.buildSessionFactory();
        }catch (Exception e){
            System.err.println("Initial Session Factory is failed!");
        }

    }

    public static SessionFactory getSessionFactory(){

        return sessionFactory;
    }
    //sf kapatalım
    public static void shutDown(){

        getSessionFactory().close();
    }

    //session da kapatalım
//sessionı da kapatalım
    public static void closeSession(Session session){
        if (session!=null && session.isOpen()){
            session.close();
        }
    }





}
