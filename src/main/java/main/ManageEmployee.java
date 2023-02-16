package main;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import dao.BookDao;
import dao.CategoryDao;
import entities.Book;
import entities.Category;
import UTILS.CONFIG;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import dao.EmployeeDAO;
import entities.Employee;
import UTILS.CONFIG.*;

public class ManageEmployee {



	public static void main(String[] args) {
		
        System.out.println("Hello Hibernate");
        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println( );
		CONFIG.configHibernate();
        System.out.println("Votre base de données");
        EmployeeDAO.listEmployees();
        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println( );
        System.out.println("Quel traitement voulez vous ?");
        int cas = 0;
        System.out.println("1-Insertion");

        System.out.println("2- Suppression ");
        System.out.println("3- Modification");
        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println( );
        System.out.println("Entrez voitre choix");

        Scanner sc = new Scanner(System.in);
        cas= sc.nextInt();
        sc.nextLine();
        switch (cas){
            case 1:
                System.out.println("1-Insertion");

                System.out.println("Donner votre firstname : ");
                String fsname = sc.nextLine();
                System.out.println("Donner votre lastname : ");
                String lsname = sc.nextLine();

                System.out.println("Donner votre salaire : ");
                int salaire = sc.nextInt();
                EmployeeDAO.addEmployee(fsname,lsname,salaire);
                EmployeeDAO.listEmployees();
                System.out.println("-------------------------------------------------------------------------------------");
                System.out.println( );

                break;
            case 2:
                System.out.println("2- Suppression ");
                EmployeeDAO.listEmployees();
                System.out.println("Entrez le id de l'employe  a supprime : ");
                int ide= sc.nextInt();
                sc.nextLine();
                EmployeeDAO.deleteEmployee(ide);
                EmployeeDAO.listEmployees();
                System.out.println("-------------------------------------------------------------------------------------");
                System.out.println( );

                break;
            case 3:
                System.out.println("3- Modification");
                EmployeeDAO.listEmployees();
                System.out.println("Entrez le id de l'employe: ");
                int id= sc.nextInt();
                sc.nextLine();
                System.out.println("Entrez le salaire : ");
                int prix = sc.nextInt();
                sc.nextLine();
                EmployeeDAO.updateEmployee(id,prix);
                EmployeeDAO.listEmployees();
                System.out.println("-------------------------------------------------------------------------------------");
                System.out.println( );

                break;
            case 4:
                //BookDao.bookByCat();
                break;
            default:
                System.out.println("Choix incorrect");
                System.out.println("-------------------------------------------------------------------------------------");
                System.out.println( "fin");
                break;
        }

	}

	

}
