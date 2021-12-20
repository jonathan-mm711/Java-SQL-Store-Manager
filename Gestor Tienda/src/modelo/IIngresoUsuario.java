/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.SQLException;

/**
 *
 * @author matia
 */
public interface IIngresoUsuario {
    /**
     * Este método recibe los string usuario y contrasena y hace una consulta a la base de datos
     * viendo si hay alguna fila donde ambos calcen a la vez. Retorna un valor booleano.
     * @param usuario
     * @param contrasena
     * @return boolean
     * @throws SQLException 
     */
    public boolean IngresoUs(String usuario, String contrasena) throws SQLException;
}
