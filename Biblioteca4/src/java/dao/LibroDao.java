package dao;

import logger.Actividades;
import conexion.Conexion;
import dto.Categoria;
import dto.Libro;
import interfaces.ILibro;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LibroDao implements ILibro<Libro>{

    Actividades act = new Actividades();
        
    private static final Conexion cn = Conexion.estadoConexion();
        
    @Override
    public boolean create(Libro lib) {      
        boolean estado = false;
        PreparedStatement ps;
        
        String nombre = lib.getNombre();
        int anio = lib.getAnio();
        Timestamp fechaReg = lib.getFecha_reg();
        int idCat = lib.getCat().getId();
                        
        try {            
            ps = cn.getConexion().prepareStatement("insert into libros (anio,nombre,fecha_reg,id_cat) values (?,?,?,?)");
            ps.setString(1, String.valueOf(anio));
            ps.setString(2, nombre);            
            ps.setString(3, fechaReg.toString());
            ps.setString(4, String.valueOf(idCat));
            
            if(ps.executeUpdate() == 1)
                estado = true;
            act.logger("Registro insertado correctamente");
            
        } catch (SQLException ex) {
            Logger.getLogger(LibroDao.class.getName()).log(Level.SEVERE, null, ex);
            act.logger("Problemas al insertar un libro");
        }
        finally{
            Logger.getLogger(LibroDao.class.getName()).log(Level.SEVERE, null, "Inserción de datos...");
        }                
        return estado;
    }

    @Override
    public ArrayList<Libro> readAll() {
        ArrayList<Libro> arrLib = new ArrayList();
        PreparedStatement ps;
        String st = "select lib.id, lib.nombre, cat.nombre as categoria, cat.id_cat \n" +
                                          "from libros lib \n" +
                                          "inner join categorias cat\n" +
                                          "on lib.id_cat = cat.id_cat";
        try{
        ps = cn.getConexion().prepareStatement(st);
        ResultSet res = ps.executeQuery();
            while(res.next())
                arrLib.add(new Libro(Integer.parseInt(res.getString("id")), res.getString("nombre"), new Categoria(Integer.parseInt(res.getString("id_cat")),res.getString("categoria"))));
        }
        catch(SQLException ex){
            
        }        
        return arrLib;
    }

    @Override
    public boolean delete(Object key) {
        boolean estado = false;
        PreparedStatement ps;
                        
        try {            
            ps = cn.getConexion().prepareStatement("delete from libros where id = ?");
            ps.setString(1, String.valueOf(key));
            
            if(ps.executeUpdate() == 1)
                estado = true;         
            
        } catch (SQLException ex) {
            Logger.getLogger(LibroDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            Logger.getLogger(LibroDao.class.getName()).log(Level.SEVERE, null, "Inserción de datos...");
        }                
        return estado;
    }

    @Override
    public ArrayList<Libro> readByCategoria(Object id) {
        
        ArrayList<Libro> arrLib = new ArrayList();
        PreparedStatement ps;
        String st = "select lib.id, lib.nombre, cat.nombre as categoria, cat.id_cat \n" +
                                          "from libros lib \n" +
                                          "inner join categorias cat\n" +
                                          "on lib.id_cat = cat.id_cat where lib.id_cat = ?";
        try{
        ps = cn.getConexion().prepareStatement(st);
        ps.setString(1, id.toString());
        ResultSet res = ps.executeQuery();
            while(res.next())
                arrLib.add(new Libro(Integer.parseInt(res.getString("id")), res.getString("nombre"), new Categoria(Integer.parseInt(res.getString("id_cat")),res.getString("categoria"))));
        }
        catch(SQLException ex){
            
        }        
        return arrLib;        
    }
    
    
    
}
