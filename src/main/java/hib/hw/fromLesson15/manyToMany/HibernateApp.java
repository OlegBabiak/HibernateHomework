package hib.hw.fromLesson15.manyToMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.HashSet;

public class HibernateApp {
    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();

        Session session = sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();

        Item item01 = new Item(10);
        Item item02 = new Item(20);
        Item item03 = new Item(30);
        Item item04 = new Item(40);

        HashSet<Item> items = new HashSet<>(Arrays.asList(item01, item02, item03, item04));
        Cart cart = new Cart(4, "cart", items);

        session.persist(cart);
        transaction.commit();
        session.close();
    }
}
