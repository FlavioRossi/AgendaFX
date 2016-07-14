/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.time.LocalDate;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author FLAVIO
 */
public class Persona {
    private final StringProperty nombre;
    private final StringProperty apellido;
    private final StringProperty domicilio;
    private final IntegerProperty codigoPostal;
    private final StringProperty ciudad;
    private final ObjectProperty<LocalDate> cumplano;

    public Persona() {
        this(null, null);
    }

    public Persona(String nombre, String apellido) {
        this.nombre = new SimpleStringProperty(nombre);
        this.apellido = new SimpleStringProperty(apellido);
        
        this.domicilio = new SimpleStringProperty("Las Heras");
        this.codigoPostal = new SimpleIntegerProperty(5539);
        this.ciudad = new SimpleStringProperty("Mendoza");
        this.cumplano = new SimpleObjectProperty<>(LocalDate.of(1991, 2, 11));
    }

    public StringProperty nombre(){
        return nombre;
    }

    public StringProperty apellido(){
        return apellido;
    }

    public StringProperty domicilio(){
        return domicilio;
    }

    public IntegerProperty codigoPostal(){
        return codigoPostal;
    }

    public StringProperty ciudad(){
        return ciudad;
    }

    public ObjectProperty<LocalDate> cumplano(){
        return cumplano;
    }
    
    public String getNombre() {
        return nombre.get();
    }

    public String getApellido() {
        return apellido.get();
    }

    public String getDomicilio() {
        return domicilio.get();
    }

    public int getCodigoPostal() {
        return codigoPostal.get();
    }

    public String getCiudad() {
        return ciudad.get();
    }

    public LocalDate getCumplano() {
        return cumplano.get();
    }
    
    public void setNombre(String nombre){
        this.nombre.set(nombre);
    }
    
    public void setApellido(String apellido){
        this.apellido.set(apellido);
    }
    
    public void setDomicilio(String domicilio){
        this.domicilio.set(domicilio);
    }
    
    public void setCiudad(String ciudad){
        this.ciudad.set(ciudad);
    }
    
    public void setCodigoPostal(int codigoPostal){
        this.codigoPostal.set(codigoPostal);
    }
    
    public void setCumplano(LocalDate cumplano){
        this.cumplano.set(cumplano);
    }
}
