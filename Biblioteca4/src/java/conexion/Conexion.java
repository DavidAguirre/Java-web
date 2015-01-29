package conexion;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {
    
    private Connection conexion;
    
    public static Conexion instancia;
    
    private Conexion(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/bdclases", "root", "");
        }
        
        catch (SQLException ex) {
                Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, "Problemas al conectar a la BD");        
        }
        
        catch(ClassNotFoundException ex){
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, "Problemas al cargar el driver");        
        }
        
        finally{
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, "Conexión a la BD");        
        }
    }
    
    public static Conexion estadoConexion(){
        if(instancia == null)
            instancia = new Conexion();
        
        return instancia;
    }
    
    public void cerrarConexion(){
        instancia = null;
    }
    
    public Connection getConexion(){
        return conexion;
    }
}
