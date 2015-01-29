/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import conexion.Conexion;
import dto.Categoria;
import interfaces.ICategoria;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Clases
 */
public class CategoriaDao implements ICategoria<Categoria> {
    
    private static final Conexion cn = Conexion.estadoConexion();
    
    @Override
    public boolean create(Categoria a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Categoria> readAll() {        
        ArrayList<Categoria> arrCat = new ArrayList();
        PreparedStatement ps;
        String st = "select id_cat, nombre from categorias";
        try{
        ps = cn.getConexion().prepareStatement(st);
        ResultSet res = ps.executeQuery();
            while(res.next())
                arrCat.add(new Categoria(Integer.parseInt(res.getString("id_cat")), res.getString("nombre")));
        }
        catch(SQLException ex){            
        }        
        return arrCat;        
    }

    @Override
    public boolean delete(Object key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }    
}
