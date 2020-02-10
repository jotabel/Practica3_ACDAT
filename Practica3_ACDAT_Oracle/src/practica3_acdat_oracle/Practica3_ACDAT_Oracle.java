package practica3_acdat_oracle;

import java.util.Iterator;
import java.util.Scanner;
import multas.entity.Conductor;
import multas.entity.TipoInfraccion;
import multas.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Practica3_ACDAT_Oracle {

    public static void main(String[] args) {
        menu();
    }
    
    public static void menu() {
        int option = 0;
        Scanner teclado = new Scanner(System.in);
        do {
            System.out.println("CONSULTAS A EJECUTAR");
            System.out.println("------------------------------------");
            System.out.println("1. Tipos de infracciones cuya multa supera los 500€.");
            System.out.println("2. Listado con los nombres de los conductores cuya licencia de conducir ya ha vencido.");
            System.out.println("6. Salir");
            System.out.println("------------------------------------");
            System.out.println("INTRODUZCA UNA OPCIÓN");
            option = teclado.nextInt();
            if(option >=1 && option <=2) {
                
                switch(option) {
                    case 1:
                        Consulta1();
                        break;
                    case 2:
                        Consulta2();
                        break;
                }
                
            } else if(option == 6){
                System.out.println("Hasta luego!!");
                System.exit(0);
            } else {
                System.out.println("Opción no válida!!");
            }
        } while (option != 6);
    }
    
    public static void Consulta1() {
        TipoInfraccion inf = new TipoInfraccion();
        SessionFactory sfactory = HibernateUtil.getSessionFactory();
        Session session = sfactory.openSession();
        Query q = session.createQuery("from TipoInfraccion where importe>500");
        Iterator<?> iter = q.iterate();
        while (iter.hasNext()) {
            inf = (TipoInfraccion) iter.next();
            System.out.println("-- ID: "+inf.getIdtipo()+" DESCRIPCIÓN: "+inf.getDescripcion());
        }
    }
    
    public static void Consulta2() {
        Conductor cond = new Conductor();
        SessionFactory sfactory = HibernateUtil.getSessionFactory();
        Session session = sfactory.openSession();
        Query q  = session.createQuery("from Conductor where fechaExpiracion < sysdate()");
        Iterator<?> iter = q.iterate();
        while (iter.hasNext()) {
            cond = (Conductor) iter.next();
            System.out.println("-- NOMBRE CONDUCTOR: "+cond.getPersona().getNombre());
        }
    }
    
}
