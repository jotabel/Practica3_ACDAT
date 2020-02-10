package multas.entity;
// Generated 10-feb-2020 1:27:30 by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Persona generated by hbm2java
 */
public class Persona  implements java.io.Serializable {


     private Integer idpersona;
     private String nombre;
     private String direccion;
     private Date fechaNacimiento;
     private Conductor conductor;
     private Set vehiculos = new HashSet(0);
     private Policia policia;

    public Persona() {
    }

    public Persona(String nombre, String direccion, Date fechaNacimiento, Conductor conductor, Set vehiculos, Policia policia) {
       this.nombre = nombre;
       this.direccion = direccion;
       this.fechaNacimiento = fechaNacimiento;
       this.conductor = conductor;
       this.vehiculos = vehiculos;
       this.policia = policia;
    }
   
    public Integer getIdpersona() {
        return this.idpersona;
    }
    
    public void setIdpersona(Integer idpersona) {
        this.idpersona = idpersona;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDireccion() {
        return this.direccion;
    }
    
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public Date getFechaNacimiento() {
        return this.fechaNacimiento;
    }
    
    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    public Conductor getConductor() {
        return this.conductor;
    }
    
    public void setConductor(Conductor conductor) {
        this.conductor = conductor;
    }
    public Set getVehiculos() {
        return this.vehiculos;
    }
    
    public void setVehiculos(Set vehiculos) {
        this.vehiculos = vehiculos;
    }
    public Policia getPolicia() {
        return this.policia;
    }
    
    public void setPolicia(Policia policia) {
        this.policia = policia;
    }




}

