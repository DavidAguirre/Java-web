/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package logger;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 *
 * @author Clases
 */
public class Actividades {
    
    
    public void logger(String mensaje){
        try{
            Logger logger = Logger.getLogger("MiLogDeActividades");
            //String ruta = "e:/miLog.txt";
            String ruta = "d:/miLog.log";
                FileHandler fh = new FileHandler(ruta,true);
            logger.addHandler(fh);            
                SimpleFormatter formatter = new SimpleFormatter();//Formato para que el archivo sea legible
                fh.setFormatter(formatter);
            logger.log(Level.INFO, mensaje);
            fh.close();
            }
            catch(IOException ex){} 
            catch (SecurityException ex) {}
    }
}
