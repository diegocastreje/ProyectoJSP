/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

/**
 *
 * @author diego
 */
public class Genero {
    
    private int id_genero;
    private String nombre;

    public Genero(int id_genero, String nombre) {
        this.id_genero = id_genero;
        this.nombre = nombre;
    }

    public Genero(String nombre) {
        this.nombre = nombre;
    }

    public Genero(int id_genero) {
        this.id_genero = id_genero;
    }

    public Genero() {
    }
    
    public int getId_genero() {
        return id_genero;
    }

    public void setId_genero(int id_genero) {
        this.id_genero = id_genero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Genero{" + "id_genero=" + id_genero + ", nombre=" + nombre + '}';
    }
    
}
