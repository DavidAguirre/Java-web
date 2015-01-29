/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package interfaces;

import java.util.ArrayList;

/**
 *
 * @author clases
 */
public interface ILibro <Algo> {
    public boolean create(Algo key);
    public boolean delete(Object key);
    public ArrayList<Algo> readAll();
    
    public ArrayList<Algo> readByCategoria(Object key);
}
