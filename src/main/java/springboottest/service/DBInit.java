package springboottest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;
import springboottest.entity.ItemRepository;
import springboottest.entity.Item;

// not working
// java.lang.IllegalStateException: Failed to execute CommandLineRunner
// Caused by: org.hibernate.property.access.spi.PropertyAccessException: Error accessing field [private java.lang.String springboottest.entity.Item.name] by reflection for persistent property [springboottest.entity.Item#name] : springboottest.entity.Item@65897882
// Caused by: java.lang.IllegalArgumentException: Can not set java.lang.String field springboottest.entity.Item.name to springboottest.entity.Item
@Service
public class DBInit implements CommandLineRunner
{
    @Autowired
    ItemRepository repo;

    @Override
    public void run(String[] args)
    {
        // output works
        System.out.println("CommandLineRunner run() executing...");
        repo.save(new Item("ItemName"));
    }
}

// working well
//public class DBInit
//{
//    public static void main(String[] args)
//    {
//        Configuration configuration = new Configuration().configure();
//        SessionFactory sessionFactory = configuration.buildSessionFactory();
//        Session session = sessionFactory.openSession();
//        Item item1 = new Item("itemName");
//        session.beginTransaction();
//        session.save(item1);
//        session.getTransaction().commit();
//    }
//}