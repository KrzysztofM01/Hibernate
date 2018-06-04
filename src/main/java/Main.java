import entities.Client;
import entities.Customer;
import entities.CustomerB2B;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {

    private static SessionFactory sessionFactory;

    public static void main(String[] args) {

        sessionFactory = new Configuration().configure().buildSessionFactory();
        Customer customer1 = new Customer();
        customer1.setName("Ziomek");
        customer1.setSurname("Worek");
        customer1.setNationality("porugwaj");
        CustomerB2B customer2 = new CustomerB2B();
        customer2.setNip("276192943");
        customer2.setName("Tadeuo");
        customer2.setNationality("Tregowica");
        //Main.persistCustomer(customer1);
        //System.out.println(customer1.getId());
        /*
        for (Customer customer: Main.getCustomerList()){
            System.out.println(customer.toString());
        }
        */
        //Main.insertCustomerB2B(customer2);
//        System.out.println(Main.getCustomerB2BByID(2).toString());
        System.out.println(customer1.toString());
        Main.insertCustomer(customer1);
        sessionFactory.close();
        //System.exit(0);
    }

    public static void insertCustomer (Client client) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        Integer id = null;
        try {
            transaction = session.beginTransaction();
            id = (Integer) session.save(client);
            transaction.commit();
        } catch (HibernateException e){
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        client.setId(id);
    }
/*
    public static ArrayList<Customer> getCustomerList () {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        ArrayList<Customer> arrayList = new ArrayList<>();
        try {
            transaction = session.beginTransaction();
            List queryList = session.createQuery("FROM entities.Customer WHERE id = 5").list();
            for (Object aQueryList : queryList) {
                Customer c = (Customer) aQueryList;
                arrayList.add(c);
            }
            transaction.commit();
        } catch (HibernateException e){
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        return arrayList;
    }
*/
    public static void insertCustomerB2B (CustomerB2B customerB2B) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        Integer id = null;
        try {
            transaction = session.beginTransaction();
            id = (Integer) session.save(customerB2B);
            transaction.commit();
        } catch (HibernateException e){
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        customerB2B.setId(id);
    }

    public static CustomerB2B getCustomerB2BByID(int id){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<CustomerB2B> criteriaQuery = criteriaBuilder.createQuery(CustomerB2B.class);
        Root<CustomerB2B> root = criteriaQuery.from(CustomerB2B.class);
        criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("id"), id));
        TypedQuery<CustomerB2B> typedQuery = session.createQuery(criteriaQuery);
        CustomerB2B customerB2B = typedQuery.getSingleResult();
        transaction.commit();
        session.close();
        return customerB2B;
    }

    public static void addCustomer(Client client){

    }
}
