package dao;

import models.Customer;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;

import java.util.List;

public class CustomerDao {

    public Customer findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Customer.class, id);
    }

    public void save(Customer user) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(user);
        tx1.commit();
        session.close();
    }

    public void update(Customer user) {

    }

    public void delete(Customer user) {

    }

    public List<Customer> finAll() {
        List<Customer> customerList = HibernateSessionFactoryUtil.getSessionFactory().openSession()
                .createQuery("From Customer").list();

        return customerList;
    }
}
