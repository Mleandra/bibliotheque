package main;

import UTILS.CONFIG;
import dao.BookDao;
import dao.CategoryDao;
import entities.Category;

import java.time.LocalDate;
import java.util.Scanner;

public class ManageCategory {
    public static void main(String[] args) {

        System.out.println("Hello Hibernate");
        CONFIG.configHibernate();
        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println( );
        System.out.println("Votre base de données");
        CategoryDao.listCategories();
        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println( );
        System.out.println("Quel traitement voulez vous ?");
        int cas = 0;
        System.out.println("1-Insertion");
        System.out.println("2- Suppression ");
        System.out.println("3- Modification");
        System.out.println("4- Autre affichage");
        System.out.println("Entrez votre choix : ->");

        Scanner sc = new Scanner(System.in);
        cas = sc.nextInt();
        sc.nextLine();
        switch (cas) {
            case 1:
                System.out.println("1-Insertion");
                System.out.println("Entrez le nom de la categories : ->");
                String title = sc.nextLine();
                System.out.println("Entrez le nombres de livres de la categorie : ->");
                int nb = sc.nextInt();
                sc.nextLine();
                CategoryDao.addCategory(title,nb);
                CategoryDao.listCategories();
                System.out.println("-------------------------------------------------------------------------------------");
                System.out.println( );

                break;
            case 2:
                System.out.println("2- Suppression ");
                CategoryDao.listCategories();
                System.out.println("Entrez le id de la categorie a supprimé:-> ");
                int idc = sc.nextInt();
                sc.nextLine();
                CategoryDao.deleteCategory(idc);
                CategoryDao.listCategories();
                System.out.println("-------------------------------------------------------------------------------------");
                System.out.println( );

                break;
            case 3:
                System.out.println("3- Modification");
                CategoryDao.listCategories();
                System.out.println("Entrez le id de la categorie a modifier: ->");
                int idcm = sc.nextInt();
                sc.nextLine();
                System.out.println("Entrez le nouveau nomberes de livres: ->");
                int newnb = sc.nextInt();
                sc.nextLine();
                CategoryDao.updateCategory(idcm,newnb);
                CategoryDao.listCategories();
                System.out.println("-------------------------------------------------------------------------------------");
                System.out.println( );

                break;
            case 4:
                System.out.println("Autres" );
                System.out.println("Nombre de categorie" );
                System.out.println(CategoryDao.numberCategory());
                System.out.println("categorie par nombre max de livre" );
                CategoryDao.categoryGroupBook();

                System.out.println("-------------------------------------------------------------------------------------");
                System.out.println( );
                break;
            default:
                System.out.println("Choix incorrect");
                System.out.println("-------------------------------------------------------------------------------------");
                System.out.println( );
                break;
        }

    }
}
