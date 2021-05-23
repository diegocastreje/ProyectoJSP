/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import datos.MusicaDAO;
import dominio.Cancion;
import dominio.Genero;
import dominio.Grupo;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author diego
 */

@WebServlet("/ServletControlador")
public class ServletControlador extends HttpServlet{

    private void accionDefault(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException{
        List<Cancion> canciones = new MusicaDAO().listarCanciones();
        HttpSession sesion = req.getSession();
        sesion.setAttribute("canciones", canciones);
        sesion.setAttribute("totalCanciones", canciones.size());
        List<Grupo> grupos = new MusicaDAO().listarGrupos();
        sesion.setAttribute("grupos", grupos);
        sesion.setAttribute("totalGrupos", grupos.size());
        List<Genero> generos = new MusicaDAO().listarGeneros();
        sesion.setAttribute("generos", generos);
        sesion.setAttribute("totalGeneros", generos.size());
        resp.sendRedirect("canciones.jsp");
    }    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String accion = req.getParameter("accion");
        if(accion != null){
            switch(accion){
                case "editarCancion":
                    this.editarCancion(req,resp);
                    break;
                case "editarGrupo":
                    this.editarGrupo(req,resp);
                    break;
                case "editarGenero":
                    this.editarGenero(req,resp);
                    break;
                case "goCanciones":
                    this.goCanciones(req, resp);
                    break;
                case "goGrupos":
                    this.goGrupos(req, resp);
                    break;
                case "goGeneros":
                    this.goGeneros(req,resp);
                    break;
                case "eliminar":
                    this.eliminar(req,resp);
                    break; 
                default:
                    this.accionDefault(req, resp);
            }
        }else{
            this.accionDefault(req, resp);
        }
    }
    
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException{
        String accion = req.getParameter("accion");
        if(accion != null){
            switch(accion){
                case "insertarCancion":
                    this.insertarCancion(req, resp);
                    break;
                case "insertarGrupo":
                    this.insertarGrupo(req, resp);
                    break;
                case "insertarGenero":
                    this.insertarGenero(req, resp);
                    break;
                case "modificarCancion":
                    this.modificarCancion(req, resp);
                    break;
                case "modificarGrupo":
                    this.modificarGrupo(req, resp);
                    break;
                case "modificarGenero":
                    this.modificarGenero(req, resp);
                    break;    
                default:
                    this.accionDefault(req, resp);
            }
        }else{
            this.accionDefault(req, resp);
        }
    }    

    private void editarCancion(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        HttpSession sesion = req.getSession();
        int id_cancion = Integer.parseInt(req.getParameter("id_cancion"));
        Cancion cancion = new MusicaDAO().encontrarCanciones(new Cancion(id_cancion));
        System.out.println(cancion);
        sesion.setAttribute("cancion", cancion);
        List<Grupo> grupos = new MusicaDAO().listarGrupos();
        sesion.setAttribute("grupos", grupos);
        List<Genero> generos = new MusicaDAO().listarGeneros();
        sesion.setAttribute("generos", generos);
        String jspEditar = "/WEB-INF/paginas/cancion/editarCancion.jsp";
        req.getRequestDispatcher(jspEditar).forward(req, resp);
    }
    
    private void editarGrupo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        int id_grupo = Integer.parseInt(req.getParameter("id_grupo"));
        Grupo grupo = new MusicaDAO().encontrarGrupos(new Grupo(id_grupo));
        System.out.println(grupo);
        req.setAttribute("grupo", grupo);
        String jspEditar = "/WEB-INF/paginas/grupo/editarGrupo.jsp";
        req.getRequestDispatcher(jspEditar).forward(req, resp);
    }
    
    private void editarGenero(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        int id_genero = Integer.parseInt(req.getParameter("id_genero"));
        Genero genero = new MusicaDAO().encontrarGeneros(new Genero(id_genero));
        req.setAttribute("genero", genero);
        String jspEditar = "/WEB-INF/paginas/genero/editarGenero.jsp";
        req.getRequestDispatcher(jspEditar).forward(req, resp);
    }    

    
    private void eliminar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        if(req.getParameter("id_cancion") != "")
            eliminarCancion(req, resp);
        if(req.getParameter("id_grupo") != "")
            eliminarGrupo(req, resp);
        if(req.getParameter("id_genero") != "")
            eliminarGenero(req, resp);
    }
    private void eliminarCancion(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException{
        int id_cancion = Integer.parseInt(req.getParameter("id_cancion"));
        Cancion cancion = new Cancion(id_cancion);
        int registrosModificados = new MusicaDAO().eliminarCancion(cancion);
        System.out.println("Registros Modificados=> " + registrosModificados);
        
        this.accionDefault(req, resp);
    }

    private void eliminarGrupo(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException{
        int id_grupo = Integer.parseInt(req.getParameter("id_grupo"));
        Grupo grupo = new Grupo(id_grupo);
        int registrosModificados = new MusicaDAO().eliminarGrupo(grupo);
        System.out.println("Registros Modificados=> " + registrosModificados);
        
        goGrupos(req, resp);
    }

    private void eliminarGenero(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException{
        int id_genero = Integer.parseInt(req.getParameter("id_genero"));
        Genero genero = new Genero(id_genero);
        int registrosModificados = new MusicaDAO().eliminarGenero(genero);
        System.out.println("Registros Modificados=> " + registrosModificados);
        
        goGeneros(req, resp);
    }
    
    private void insertarCancion (HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException{
        String nombre = req.getParameter("nombre");
        int anho = 0;
        String anhoString = req.getParameter("anho");
        if(anhoString != null && !"".equals(anhoString)){
            anho = Integer.parseInt(anhoString);
        }
        String link = req.getParameter("link");
        
        String grupo = req.getParameter("grupo");

        String genero = req.getParameter("genero");     
        
        Cancion cancion = new Cancion(nombre, anho, link, grupo, genero);
        
        int registrosModificados = new MusicaDAO().insertarCanciones(cancion);
        System.out.println("Registros Modificados =>" + registrosModificados);
        
        this.accionDefault(req, resp);
    }
    
    private void insertarGrupo(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException{
        String nombre = req.getParameter("nombre");
        int miembros = 0;
        String miembrosString = req.getParameter("miembros");
        if(miembrosString != null && !"".equals(miembrosString)){
            miembros = Integer.parseInt(miembrosString);
        }
        
        Grupo grupo = new Grupo(nombre, miembros);
        
        int registrosModificados = new MusicaDAO().insertarGrupos(grupo);
        System.out.println("Registros Modificados =>" + registrosModificados);
        
        this.accionDefault(req, resp);
    }

    private void insertarGenero(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException{
        String nombre = req.getParameter("nombre");
        
        Genero genero = new Genero(nombre);
        
        int registrosModificados = new MusicaDAO().insertarGeneros(genero);
        System.out.println("Registros Modificados =>" + registrosModificados);
        
        this.accionDefault(req, resp);
    }      

    private void modificarCancion(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException{
        int id_cancion = Integer.parseInt(req.getParameter("id_cancion"));
        String nombre = req.getParameter("nombre");
        int anho = 0;
        String anhoString = req.getParameter("anho");
        if(anhoString != null && !"".equals(anhoString)){
            anho = Integer.parseInt(anhoString);
        }
        String link = req.getParameter("link");
        
        String grupo = req.getParameter("grupo");
        
        String genero = req.getParameter("genero");
      
        Cancion cancion = new Cancion(id_cancion, nombre, anho, link, grupo, genero);
        
        int registrosModificados = new MusicaDAO().actualizarCancion(cancion);
        System.out.println("Registros Modificados => " + registrosModificados);
        
        goCanciones(req, resp);
    }
    private void modificarGrupo(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException{
        int id_grupo = Integer.parseInt(req.getParameter("id_grupo"));
        String nombre = req.getParameter("nombre");
        int miembros = 0;
        String miembrosString = req.getParameter("miembros");
        if(miembrosString != null && !"".equals(miembrosString)){
            miembros = Integer.parseInt(miembrosString);
        }       
        Grupo grupo = new Grupo(id_grupo, nombre, miembros);
        
        int registrosModificados = new MusicaDAO().actualizarGrupo(grupo);
        System.out.println("Registros Modificados => " + registrosModificados);
        
        this.accionDefault(req, resp);
    }  
    private void modificarGenero(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException{
        int id_genero = Integer.parseInt(req.getParameter("id_genero"));
        String nombre = req.getParameter("nombre");
     
        Genero genero = new Genero(id_genero, nombre);
        System.out.println(genero);
        int registrosModificados = new MusicaDAO().actualizarGenero(genero);
        System.out.println("Registros Modificados => " + registrosModificados);
        
        this.accionDefault(req, resp);
    }      

    private void goCanciones(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{
        List<Cancion> canciones = new MusicaDAO().listarCanciones();
        HttpSession sesion = req.getSession();
        sesion.setAttribute("canciones", canciones);
        sesion.setAttribute("totalCanciones", canciones.size());
        resp.sendRedirect("canciones.jsp");
    }
        
    private void goGrupos(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        List<Grupo> grupos = new MusicaDAO().listarGrupos();
        HttpSession sesion = req.getSession();
        sesion.setAttribute("grupos", grupos);
        sesion.setAttribute("totalGrupos", grupos.size());        
        resp.sendRedirect("grupos.jsp");
    }

    private void goGeneros(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        List<Genero> generos = new MusicaDAO().listarGeneros();
        HttpSession sesion = req.getSession();
        sesion.setAttribute("generos", generos);
        sesion.setAttribute("totalGeneros", generos.size());        
        resp.sendRedirect("generos.jsp");
    }
}
