package main;

import UTILS.CONFIG;
import dao.BookDao;
import dao.CategoryDao;
import entities.Category;
import java.time.LocalDate;
import java.util.Scanner;

public class ManageBook {
    public static void main(String[] args) {
        System.out.println("Hello Hibernate");
        CONFIG.configHibernate();
        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println( );
        System.out.println("Votre base de données");
        BookDao.listBooks();
        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println( );
        System.out.println("Quel traitement voulez vous ?");
        int cas = 0;
        System.out.println("1-Insertion");
        System.out.println("2- Suppression ");
        System.out.println("3- Modification");

        System.out.println("4- livre par categoris");
        System.out.println("5- livre par date edition");
        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println( );
        System.out.println("Entrez votre choix : ->");

        Scanner sc = new Scanner(System.in);
        cas = sc.nextInt();
        sc.nextLine();
        switch (cas) {
            case 1:
                System.out.println("1-Insertion");
                System.out.println("Entrez le nom du livre : ");
                String title = sc.nextLine();
                System.out.println("Entrez le prix : ");
                int price = sc.nextInt();
                sc.nextLine();
                System.out.println("Entrez la date d'edtion sous forme 'aaaa-mm-jj' ->");
                String dateE = sc.nextLine();
                CategoryDao.listCategories();
                System.out.println("Entrez le id category: ");
                int idC = sc.nextInt();
                Category category = CategoryDao.getElm(idC);
                sc.nextLine();
                BookDao.addBook(title, price, LocalDate.parse(dateE), category);
                BookDao.listBooks();
                System.out.println("-------------------------------------------------------------------------------------");
                System.out.println( );
                System.out.println("relance le programme pour une nouvelle op");

                break;
            case 2:
                System.out.println("2- Suppression ");
                BookDao.listBooks();
                System.out.println("Entrez le id du livre: ");
                int idb = sc.nextInt();
                sc.nextLine();
                BookDao.deleteBook(idb);
                BookDao.listBooks();
                System.out.println("-------------------------------------------------------------------------------------");
                System.out.println( );
                System.out.println("relance le programme pour une nouvelle op");

                break;
            case 3:
                System.out.println("3- Modification");
                BookDao.listBooks();
                System.out.println("Entrez le id du livre: ");
                int id = sc.nextInt();
                sc.nextLine();
                System.out.println("Entrez le prix : ");
                int prix = sc.nextInt();
                sc.nextLine();
                BookDao.updateBook(id, prix);
                BookDao.listBooks();
                System.out.println("-------------------------------------------------------------------------------------");
                System.out.println( );
                System.out.println("relance le programme pour une nouvelle op");

                break;
            case 4:
                BookDao.bookByCategory();
                System.out.println("-------------------------------------------------------------------------------------");
                System.out.println( );
                System.out.println("relance le programme pour une nouvelle op");
                break;
            case 5:
                System.out.println("Entrez la date d'edtion sous forme 'aaaa-mm-jj' ->");
                dateE = sc.nextLine();
                BookDao.getBookBydata(LocalDate.parse(dateE));
                System.out.println("-------------------------------------------------------------------------------------");
                System.out.println( );
                System.out.println("relance le programme pour une nouvelle op");
                break;
            default:
                System.out.println("Choix incorrect");
                BookDao.listBooks();
                break;
        }

    }


}

