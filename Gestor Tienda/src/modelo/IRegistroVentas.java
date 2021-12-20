/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.SQLException;
import java.util.ArrayList;
import negocio.Venta;

/**
 *
 * @author matia
 */
public interface IRegistroVentas {
    /**
     * Este método hace una consulta a la tabla "venta" en la base de datos
     * y devuelve una lista con todos los "numeroVenta" individuales.
     * @return listNumVenta
     * @throws SQLException
     * @throws Exception 
     */
    public ArrayList<Venta> listNumVenta() throws SQLException, Exception;
}
