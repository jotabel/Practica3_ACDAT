package multas.entity;
// Generated 10-feb-2020 1:27:30 by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * PapeletaMulta generated by hbm2java
 */
public class PapeletaMulta  implements java.io.Serializable {


     private Integer idpapeleta;
     private Conductor conductor;
     private Policia policia;
     private TipoInfraccion tipoInfraccion;
     private Vehiculo vehiculo;
     private Date fecha;

    public PapeletaMulta() {
    }

	
    public PapeletaMulta(Conductor conductor, Policia policia, TipoInfraccion tipoInfraccion, Vehiculo vehiculo) {
        this.conductor = conductor;
        this.policia = policia;
        this.tipoInfraccion = tipoInfraccion;
        this.vehiculo = vehiculo;
    }
    public PapeletaMulta(Conductor conductor, Policia policia, TipoInfraccion tipoInfraccion, Vehiculo vehiculo, Date fecha) {
       this.conductor = conductor;
       this.policia = policia;
       this.tipoInfraccion = tipoInfraccion;
       this.vehiculo = vehiculo;
       this.fecha = fecha;
    }
   
    public Integer getIdpapeleta() {
        return this.idpapeleta;
    }
    
    public void setIdpapeleta(Integer idpapeleta) {
        this.idpapeleta = idpapeleta;
    }
    public Conductor getConductor() {
        return this.conductor;
    }
    
    public void setConductor(Conductor conductor) {
        this.conductor = conductor;
    }
    public Policia getPolicia() {
        return this.policia;
    }
    
    public void setPolicia(Policia policia) {
        this.policia = policia;
    }
    public TipoInfraccion getTipoInfraccion() {
        return this.tipoInfraccion;
    }
    
    public void setTipoInfraccion(TipoInfraccion tipoInfraccion) {
        this.tipoInfraccion = tipoInfraccion;
    }
    public Vehiculo getVehiculo() {
        return this.vehiculo;
    }
    
    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }
    public Date getFecha() {
        return this.fecha;
    }
    
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }




}


