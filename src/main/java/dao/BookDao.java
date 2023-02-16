package dao;
import entities.Book;
import entities.Category;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;


import javax.xml.crypto.Data;
import java.security.PublicKey;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import UTILS.CONFIG;

import static UTILS.CONFIG.factory;

public class BookDao {
    public static int addBook(String title, double price, LocalDate date,Category id_c){
        Session session = factory.openSession();
        Transaction tx = null;
        Integer bookId = null;

        try {
            tx = session.beginTransaction();
            Book b = new Book();
            b.setTitle(title);
            b.setPrice(price);
            b.setDateEdition(Date.valueOf(date));
            b.setCategory(id_c);
            bookId= (Integer) session.save(b);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null)
                tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return bookId;

    }
    // fonction  pour afficher touts les livres
    public  static List<Book> listBooks(){
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            List<Book> lb = (List<Book>) session.createQuery("FROM Book").list();

            for (Book b : lb) {
                System.out.println("***********************************");
                System.out.println(" | ID: " + b.getId());
                System.out.println(" | Titre : -> " + b.getTitle());
                System.out.println(" | prix du livre -> : " + b.getPrice());
                System.out.println(" | date edition -> : " + b.getDateEdition());
                System.out.println(" | id category-> : " + b.getCategory());

            }
            tx.commit();
            return lb;
        } catch (HibernateException e) {
            if (tx != null)
                tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;

    }
    public static void deleteBook(int idBook){
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Book book = (Book) session.get(Book.class, idBook);
            session.delete(book);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null)
                tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }


    }
    //fonction pour la mise a jour d'un livre
    public static void updateBook(int idB ,int price ){
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Book book = (Book) session.get(Book.class, idB);

            book.setPrice(price);

            session.update(book);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null)
                tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
//code pour la mise a jour d'unlivre
    }

    public static void bookByCategory(){

        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            List<Object[]> results = session.createQuery("FROM Book b  JOIN b.category ORDER BY Category.title").list();
            for (Object[] aRow : results) {
                Book b = (Book) aRow[0];
                Category category = (Category) aRow[1];
                System.out.println(b.getTitle() + " -> " + category.getTitle());
            }
            tx.commit();

        } catch (HibernateException e) {
            if (tx != null)
                tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

    }
    public static void getBookBydata(LocalDate date){
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Query query = session.createQuery("SELECT b FROM Book b WHERE b.dateEdition = :dateEdition");
            query.setParameter("dateEdition", Date.valueOf(date));
            List<Book> books = (List<Book>) query.list();
            for (Book b : books) {
                System.out.println("***********************************");
                System.out.println(" | ID: " + b.getId());
                System.out.println(" | Titre : -> " + b.getTitle());
                System.out.println(" | prix du livre -> : " + b.getPrice());
                System.out.println(" | date edition -> : " + b.getDateEdition());
                System.out.println(" | id category-> : " + b.getCategory());

            }
            tx.commit();

        } catch (HibernateException e) {
            if (tx != null)
                tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }



    }
}
