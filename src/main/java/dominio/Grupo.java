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
public class Grupo {
    
    private int id_grupo;
    private String nombre;
    private int miembros;

    public Grupo(int id_grupo, String nombre, int miembros) {
        this.id_grupo = id_grupo;
        this.nombre = nombre;
        this.miembros = miembros;
    }

    public Grupo(String nombre, int miembros) {
        this.nombre = nombre;
        this.miembros = miembros;
    }

    public Grupo(int id_grupo) {
        this.id_grupo = id_grupo;
    }

    public Grupo() {
    }

    public int getId_grupo() {
        return id_grupo;
    }

    public void setId_grupo(int id_grupo) {
        this.id_grupo = id_grupo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getMiembros() {
        return miembros;
    }

    public void setMiembros(int miembros) {
        this.miembros = miembros;
    }

    @Override
    public String toString() {
        return "Grupo{" + "id_grupo=" + id_grupo + ", nombre=" + nombre + ", miembros=" + miembros + '}';
    }
        
}
