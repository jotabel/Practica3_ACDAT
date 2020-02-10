package practica3_acdat_mysql;

import java.util.Iterator;
import java.util.Scanner;
import multas.entity.Conductor;
import multas.entity.Persona;
import multas.entity.TipoInfraccion;
import multas.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Practica3_ACDAT_MySQL {

    public static void main(String[] args) {
        // TODO code application logic here
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
            System.out.println("3. Edad media de los conductores que tienen infracciones por ‘Exceso de velocidad’.");
            System.out.println("4. Nombre de los conductores que han cometido una infracción cuyo importe sea inferior al\n"
                    + "del importe de algunas de las infracciones cometidas en el día de ayer.");
            System.out.println("5. Listado con el número de placa de todos aquellos policías que hayan sancionado todos los tipos\n"
                    + "de infracciones.");
            System.out.println("6. Salir");
            System.out.println("------------------------------------");
            System.out.println("INTRODUZCA UNA OPCIÓN");
            option = teclado.nextInt();
            if(option >=1 && option <=5) {
                
                switch(option) {
                    case 1:
                        Consulta1();
                        break;
                    case 2:
                        Consulta2();
                        break;
                    case 3:
                        Consulta3();
                        break;
                    case 4:
                        Consulta4();
                        break;
                    case 5:
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
        Query q  = session.createQuery("from Conductor where fechaExpiracion < now()");
        Iterator<?> iter = q.iterate();
        while (iter.hasNext()) {
            cond = (Conductor) iter.next();
            System.out.println("-- NOMBRE CONDUCTOR: "+cond.getPersona().getNombre());
        }
    }
    
    public static void Consulta3() {
        SessionFactory sfactory = HibernateUtil.getSessionFactory();
        Session session = sfactory.openSession();
        Query q = session.createQuery("select avg(datediff (now(), fechaNacimiento)/365) from Persona where idpersona in (select idpersona from Conductor where idpersona in (select conductor from PapeletaMulta where idtipoinfraccion in (select idtipo from TipoInfraccion where descripcion='exceso de velocidad')))");
        
        Double result = (Double) q.uniqueResult();
        Long resultF = Math.round(result);
        System.out.println("-- EDAD MEDIA: "+resultF);
    }
    
    public static void Consulta4() {
        Persona pers = new Persona();
        SessionFactory sfactory = HibernateUtil.getSessionFactory();
        Session session = sfactory.openSession();
        Query q = session.createQuery("from Persona as per where idpersona in (select conductor from PapeletaMulta where tipoInfraccion in (select idtipo from TipoInfraccion where importe < (select max(importe) from TipoInfraccion where idtipo in (select tipoInfraccion from PapeletaMulta where datediff(now(), fecha)=1) )))");
        Iterator<?> iter = q.iterate();
        while (iter.hasNext()) {
            pers = (Persona) iter.next();
            System.out.println("-- NOMBRE: "+pers.getNombre());
        }
    }
    
    public static void Consulta5() {
        
    }

}
