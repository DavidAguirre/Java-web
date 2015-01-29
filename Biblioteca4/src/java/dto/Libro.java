package dto;

import java.sql.Timestamp;

public class Libro {
    private int id;
    private String nombre;
    private int anio;
    private Timestamp fecha_reg;
    private Categoria cat;

    public Libro() {}

    public Libro(int anio, String nombre, Timestamp fecha_reg, Categoria cat) {
        this.nombre = nombre;
        this.anio = anio;
        this.fecha_reg = fecha_reg;
        this.cat = cat;
    }        
    
    public Libro(int id, String nombre, Categoria cat) {
        this.id = id;
        this.nombre = nombre;
        this.cat = cat;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public Timestamp getFecha_reg() {
        return fecha_reg;
    }

    public void setFecha_reg(Timestamp fecha_reg) {
        this.fecha_reg = fecha_reg;
    }

    public Categoria getCat() {
        return cat;
    }

    public void setCat(Categoria cat) {
        this.cat = cat;
    }    
    
}
