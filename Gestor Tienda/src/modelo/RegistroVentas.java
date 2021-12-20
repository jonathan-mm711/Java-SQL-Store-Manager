/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import negocio.Venta;

/**
 *
 * @author jhon_
 */
public class RegistroVentas extends Conexion implements IRegistroVentas{

    @Override
    public ArrayList<Venta> listNumVenta() throws SQLException, Exception
    {
        conectar();
        ArrayList<Venta> listNumVenta = new ArrayList<Venta>();
        
        ResultSet result = state.executeQuery("SELECT numeroVenta FROM venta GROUP BY numeroVenta");
        
        while(result.next())
        {
            Venta numVenta = new Venta();
            numVenta.setNumero((Integer) result.getObject(1));
            listNumVenta.add(numVenta);
        }
        
        return listNumVenta;
    }
}
