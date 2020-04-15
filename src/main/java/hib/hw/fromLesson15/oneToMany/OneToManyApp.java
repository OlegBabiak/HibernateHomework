package hib.hw.fromLesson15.oneToMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class OneToManyApp {
    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();

        Session session = sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();

        Post post01 = new Post();
        Post post02 = new Post();
        post01.setTitle("Games");
        post02.setTitle("Toys");

        Comment comment01 = new Comment("Roman");
        Comment comment02 = new Comment("Ostap");
        Comment comment03 = new Comment("Maksym");
        Comment comment04 = new Comment("Nazar");
        Comment comment05 = new Comment("Mark");

        comment01.setPost(post01);
        comment02.setPost(post01);
        comment03.setPost(post02);
        comment04.setPost(post02);
        comment05.setPost(post01);

        Set<Comment> comments01 = new HashSet<>(Arrays.asList(comment01, comment02, comment05));
        Set<Comment> comments02 = new HashSet<>(Arrays.asList(comment03, comment04));

        post01.setComments(comments01);
        post02.setComments(comments02);

        session.persist(post01);
        session.persist(post02);

        transaction.commit();

        Post postFromDB = session.find(Post.class, 1);
        System.out.println(postFromDB.getTitle());

        Comment commentFromDB = session.find(Comment.class, 4);
        System.out.println(commentFromDB.getPost().getTitle());
        Comment commentFromDB2 = session.find(Comment.class, 5);
        System.out.println(commentFromDB2.getAuthorName());

        session.close();
    }
}
