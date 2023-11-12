package repository;

import config.HibernateUtils;
import domain.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class StudentRepository implements Repository {
    private Session session;

    @Override
    public void save(Object obj) {

        session= HibernateUtils.getSessionFactory().openSession();
        Transaction tx=session.beginTransaction();

        session.save(obj);

        tx.commit();
        HibernateUtils.closeSession(session);

    }

    @Override
    public void remove(Object obj) {
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

        List<Student> allStudent = session.createQuery("FROM Student",Student.class).getResultList();
        allStudent.forEach(t-> System.out.println(t));

        tx.commit();
        HibernateUtils.closeSession(session);

    }

    @Override
    public Student getById(Long id) {
        session= HibernateUtils.getSessionFactory().openSession();
        Transaction tx=session.beginTransaction();

        Student student  = session.get(Student.class ,id);

        tx.commit();
        HibernateUtils.closeSession(session);


        return student;

    }
}
