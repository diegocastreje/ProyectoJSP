/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import dominio.Cancion;
import dominio.Genero;
import dominio.Grupo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author diego
 */
public class MusicaDAO {
    
    private static final String SQL_SELECT_CANCION = "SELECT c.id_cancion, c.nombre, c.anho, c.link, g.nombre AS 'grupo', ge.nombre AS 'genero' FROM cancion c INNER JOIN grupo g ON c.grupo = g.id_grupo INNER JOIN genero ge ON c.genero = ge.id_genero";
    private static final String SQL_SELECT_GRUPO = "SELECT * FROM grupo";
    private static final String SQL_SELECT_GENERO = "SELECT * FROM genero";
   
    private static final String SQL_SELECT_CANCION_BY_ID = "SELECT nombre, anho, link, grupo, genero FROM cancion WHERE id_cancion = ?";
    private static final String SQL_SELECT_GRUPO_BY_ID = "SELECT nombre, miembros FROM grupo WHERE id_grupo = ?";
    private static final String SQL_SELECT_GENERO_BY_ID = "SELECT nombre FROM genero WHERE id_genero = ?";
    
    private static final String SQL_INSERT_CANCION = "INSERT INTO cancion(nombre, anho, link, grupo, genero) VALUES (?, ?, ?, ?, ?)";
    private static final String SQL_INSERT_GRUPO = "INSERT INTO grupo(nombre, miembros) VALUES (?, ?)";
    private static final String SQL_INSERT_GENERO = "INSERT INTO genero(nombre) VALUES (?)";
    
    private static final String SQL_UPDATE_CANCION = "UPDATE cancion SET nombre = ?, anho = ?, link = ?, grupo = ?, genero = ? WHERE id_cancion = ?";
    private static final String SQL_UPDATE_GRUPO = "UPDATE grupo SET nombre = ?, miembros = ? WHERE id_grupo = ?";
    private static final String SQL_UPDATE_GENERO = "UPDATE genero SET nombre = ? WHERE id_genero = ?";
    
    private static final String SQL_DELETE_CANCION = "DELETE FROM cancion WHERE id_cancion = ?";
    private static final String SQL_DELETE_GRUPO= "DELETE FROM grupo WHERE id_grupo = ?";
    private static final String SQL_DELETE_GENERO = "DELETE FROM genero WHERE id_genero= ?";
    
    public List<Cancion> listarCanciones(){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Cancion cancion = null;
        List<Cancion> canciones = new ArrayList<>();
        try{
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_CANCION);
            rs = stmt.executeQuery();
            while(rs.next()){
                int id_cancion = rs.getInt("id_cancion");
                String nombre = rs.getString("nombre");
                int anho = rs.getInt("anho");
                String link = rs.getString("link");
                String grupo = rs.getString("grupo");
                String genero = rs.getString("genero");
                
                cancion = new Cancion(id_cancion, nombre, anho, link, grupo, genero);
                canciones.add(cancion);
            }
        }catch(SQLException ex){
            ex.printStackTrace(System.out);
        }finally{
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return canciones;
    }
    
    public List<Grupo> listarGrupos(){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Grupo grupo = null;
        List<Grupo> grupos = new ArrayList<>();
        try{
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_GRUPO);
            rs = stmt.executeQuery();
            while(rs.next()){
                int idGrupo = rs.getInt("id_grupo");
                String nombre = rs.getString("nombre");
                int miembros = rs.getInt("miembros");
                
                grupo = new Grupo(idGrupo, nombre, miembros);
                grupos.add(grupo);
            }
        }catch(SQLException ex){
            ex.printStackTrace(System.out);
        }finally{
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return grupos;
    }    
    
    public List<Genero> listarGeneros(){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Genero genero = null;
        List<Genero> generos = new ArrayList<>();
        try{
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_GENERO);
            rs = stmt.executeQuery();
            while(rs.next()){
                int idGenero = rs.getInt("id_genero");
                String nombre = rs.getString("nombre");
                
                genero = new Genero(idGenero, nombre);
                generos.add(genero);
            }
        }catch(SQLException ex){
            ex.printStackTrace(System.out);
        }finally{
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return generos;
    }
    
    public Cancion encontrarCanciones(Cancion cancion){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try{
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_CANCION_BY_ID, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            
            stmt.setInt(1, cancion.getId_cancion());
            rs = stmt.executeQuery();
            System.out.println(cancion.getId_cancion());
            System.out.println(rs);
            //rs.absolute(1);
            
            while(rs.next()){
                String nombre = rs.getString("nombre");
                int anho = rs.getInt("anho");
                String link = rs.getString("link");
                String grupo = rs.getString("grupo");
                String genero = rs.getString("genero");
                cancion.setNombre(nombre);
                cancion.setAnho(anho);
                cancion.setLink(link);
                cancion.setGrupo(grupo);
                cancion.setGenero(genero);
            }
        }catch (SQLException ex){
            ex.printStackTrace(System.out);
        }finally{
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);            
        }
        return cancion;
    }
    
    public Grupo encontrarGrupos(Grupo grupo){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try{
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_GRUPO_BY_ID, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            
            stmt.setInt(1, grupo.getId_grupo());
            rs = stmt.executeQuery();
            System.out.println(grupo.getId_grupo());
            System.out.println(rs);
            //rs.absolute(1);
            
            while(rs.next()){
                String nombre = rs.getString("nombre");
                int miembros = rs.getInt("miembros");
                grupo.setNombre(nombre);
                grupo.setMiembros(miembros);
            }
        }catch (SQLException ex){
            ex.printStackTrace(System.out);
        }finally{
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);            
        }
        return grupo;
    } 
    
    public Genero encontrarGeneros(Genero genero){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try{
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_GENERO_BY_ID, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            
            stmt.setInt(1, genero.getId_genero());
            rs = stmt.executeQuery();
            System.out.println(genero.getId_genero());
            System.out.println(rs);
            //rs.absolute(1);
            
            while(rs.next()){
                String nombre = rs.getString("nombre");
                genero.setNombre(nombre);
            }
        }catch (SQLException ex){
            ex.printStackTrace(System.out);
        }finally{
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);            
        }
        return genero;
    }    

    public int insertarCanciones(Cancion cancion){
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try{
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT_CANCION);
            stmt.setString(1, cancion.getNombre());
            stmt.setInt(2, cancion.getAnho());
            stmt.setString(3, cancion.getLink());
            stmt.setString(4, cancion.getGrupo());
            stmt.setString(5, cancion.getGenero());
            
            rows = stmt.executeUpdate();
        }catch(SQLException ex){
            ex.printStackTrace(System.out);
        }finally{
            Conexion.close(stmt);
            Conexion.close(conn);             
        }
        return rows;
    }

    public int insertarGrupos(Grupo grupo){
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try{
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT_GRUPO);
            stmt.setString(1, grupo.getNombre());
            stmt.setInt(2, grupo.getMiembros());
            
            rows = stmt.executeUpdate();
        }catch(SQLException ex){
            ex.printStackTrace(System.out);
        }finally{
            Conexion.close(stmt);
            Conexion.close(conn);             
        }
        return rows;
    }
    
     public int insertarGeneros(Genero genero){
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try{
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT_GENERO);
            stmt.setString(1, genero.getNombre());
            
            rows = stmt.executeUpdate();
        }catch(SQLException ex){
            ex.printStackTrace(System.out);
        }finally{
            Conexion.close(stmt);
            Conexion.close(conn);             
        }
        return rows;
    }   
     
    public int actualizarCancion(Cancion cancion){
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try{
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE_CANCION);
            stmt.setString(1, cancion.getNombre());
            stmt.setInt(2, cancion.getAnho());
            stmt.setString(3, cancion.getLink());
            stmt.setString(4, cancion.getGrupo());
            stmt.setString(5, cancion.getGenero());
            stmt.setInt(6, cancion.getId_cancion());
            
            rows = stmt.executeUpdate();
        }catch(SQLException ex){
            ex.printStackTrace(System.out);
        }finally{
            Conexion.close(stmt);
            Conexion.close(conn);             
        }
        return rows;
    }     

    public int actualizarGrupo(Grupo grupo){
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try{
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE_GRUPO);
            stmt.setString(1, grupo.getNombre());
            stmt.setInt(2, grupo.getMiembros());
            stmt.setInt(3, grupo.getId_grupo());
            
            rows = stmt.executeUpdate();
        }catch(SQLException ex){
            ex.printStackTrace(System.out);
        }finally{
            Conexion.close(stmt);
            Conexion.close(conn);             
        }
        return rows;
    }     
    
    public int actualizarGenero(Genero genero){
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try{
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE_GENERO);
            stmt.setString(1, genero.getNombre());
            stmt.setInt(2, genero.getId_genero());
            System.out.println(genero.getNombre() + genero.getId_genero());
            
            rows = stmt.executeUpdate();
        }catch(SQLException ex){
            ex.printStackTrace(System.out);
        }finally{
            Conexion.close(stmt);
            Conexion.close(conn);             
        }
        return rows;
    }
    
    public int eliminarCancion(Cancion cancion){
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try{
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE_CANCION);
            stmt.setInt(1, cancion.getId_cancion());
            
            rows = stmt.executeUpdate();
        }catch(SQLException ex){
            ex.printStackTrace(System.out);
        }finally{
            Conexion.close(stmt);
            Conexion.close(conn);             
        }
        return rows;
    }      
    
    public int eliminarGrupo(Grupo grupo){
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try{
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE_GRUPO);
            stmt.setInt(1, grupo.getId_grupo());
            
            rows = stmt.executeUpdate();
        }catch(SQLException ex){
            ex.printStackTrace(System.out);
        }finally{
            Conexion.close(stmt);
            Conexion.close(conn);             
        }
        return rows;
    }  

    public int eliminarGenero(Genero genero){
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try{
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE_GENERO);
            stmt.setInt(1, genero.getId_genero());
            
            rows = stmt.executeUpdate();
        }catch(SQLException ex){
            ex.printStackTrace(System.out);
        }finally{
            Conexion.close(stmt);
            Conexion.close(conn);             
        }
        return rows;
    }      
}
