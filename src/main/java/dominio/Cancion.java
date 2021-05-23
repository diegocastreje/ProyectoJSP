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
public class Cancion {
    
    private int id_cancion;
    private String nombre;
    private int anho;
    private String link;
    private String grupo;
    private String genero;

    public Cancion(int id_cancion, String nombre, int anho, String link, String grupo, String genero) {
        this.id_cancion = id_cancion;
        this.nombre = nombre;
        this.anho = anho;
        this.link = link;
        this.grupo = grupo;
        this.genero = genero;
    }
    
    public Cancion(String nombre, int anho, String link, String grupo, String genero) {
        this.nombre = nombre;
        this.anho = anho;
        this.link = link;
        this.grupo = grupo;
        this.genero = genero;
    }
    
    public Cancion(int id_cancion) {
        this.id_cancion = id_cancion;
    }
    
    public Cancion(){
        
    }

    public int getId_cancion() {
        return id_cancion;
    }

    public void setId_cancion(int id_cancion) {
        this.id_cancion = id_cancion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAnho() {
        return anho;
    }

    public void setAnho(int anho) {
        this.anho = anho;
    }
    
    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }    

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    @Override
    public String toString() {
        return "Cancion{" + "id_cancion=" + id_cancion + ", nombre=" + nombre + ", anho=" + anho + ", grupo=" + grupo + ", genero=" + genero + '}';
    }
    
}
