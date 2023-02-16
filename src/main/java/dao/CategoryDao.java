package dao;

import entities.Category;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;


import java.util.List;

import static UTILS.CONFIG.factory;

public class CategoryDao {
    //methode pour l'insertion  d'une categories dans la base de donnée
    public static int addCategory(String title,int nberBook){
    //code de creation d'une categories
        Session session = factory.openSession();
        Transaction tx = null;
        Integer categoryId = 0;
        try {
            tx = session.beginTransaction();
            Category c = new Category();
            c.setTitle(title);
            c.setNbBook(nberBook);
            categoryId= (Integer) session.save(c);
            tx.commit();
            return categoryId;
        } catch (HibernateException e) {
            if (tx != null)
                tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return categoryId;
    }
    public static Category getElm(int id){
        Category category=null;
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            category = (Category) session.get(Category.class, id);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null)
                tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return category;

    }

    // fonction  pour afficher toute les catgories
    public  static List<Category> listCategories(){
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            List<Category> lc = (List<Category>) session.createQuery("FROM Category").list();

            for (Category c : lc) {
                System.out.println("***********************************");
                System.out.println(" | ID: " + c.getCategoryId());
                System.out.println(" | Titre : -> " + c.getTitle());
                System.out.println(" | Nombre de livre -> : " + c.getNbBook());

            }
            tx.commit();
            return lc;
        } catch (HibernateException e) {
            if (tx != null)
                tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;

    }
    public static void deleteCategory(int categoryId){
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Category category = (Category) session.get(Category.class, categoryId);
            session.delete(category);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null)
                tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

    }
    //fonction pour la mise a jour d'une categories
    public static void updateCategory(int categoryId,int nbrBook){
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Category category = (Category) session.get(Category.class, categoryId);
            category.setNbBook(nbrBook);
            session.update(category);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null)
                tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

//code pour la mise a jour d'une categories
    }
    public static int numberCategory(){
        Session session = factory.openSession();
        Transaction tx = null;
        int nberC =0;
        try {
            tx = session.beginTransaction();
            List<Category> lc = (List<Category>) session.createQuery("FROM Category").list();
            tx.commit();
            nberC = lc.size();
            return nberC;
        } catch (HibernateException e) {
            if (tx != null)
                tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return nberC;
    }

    public static void categoryGroupBook(){
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            List<Category> lc = (List<Category>)  session.createQuery("From Category order by CATEGORY_NBBOOK desc").list();
            for (Category c : lc) {
                System.out.println("***********************************");
                System.out.println(" | ID: " + c.getCategoryId());
                System.out.println(" | Titre : -> " + c.getTitle());
                System.out.println(" | Nombre de livre -> : " + c.getNbBook());

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
