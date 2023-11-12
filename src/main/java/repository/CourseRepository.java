package repository;

import config.HibernateUtils;
import domain.Course;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class CourseRepository implements Repository<Course> {

    private Session session;

    @Override
    public void save(Course obj) {
        session= HibernateUtils.getSessionFactory().openSession();
        Transaction tx=session.beginTransaction();

        session.save(obj);

        tx.commit();
        HibernateUtils.closeSession(session);



    }

    @Override
    public void remove(Course obj) {
        session= HibernateUtils.getSessionFactory().openSession();
        Transaction tx=session.beginTransaction();

        session.delete(obj);

        tx.commit();
        HibernateUtils.closeSession(session);


    }

    @Override
    public void getAll() {
        session=HibernateUtils.getSessionFactory().openSession();
        Transaction tx= session.beginTransaction();

        List<Course> allCourse = session.createQuery("FROM Course",Course.class).getResultList();
        allCourse.forEach(t-> System.out.println(t));

        tx.commit();
        session.close();

    }

    @Override
    public Course getById(Long id) {
        session= HibernateUtils.getSessionFactory().openSession();
        Transaction tx=session.beginTransaction();

        Course course = session.get(Course.class ,id);

        tx.commit();
        HibernateUtils.closeSession(session);


        return course;
    }
}
