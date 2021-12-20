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
import negocio.Disco;
import negocio.Venta;

/**
 *
 * @author jhon_
 */
public class IngresarVenta extends Conexion implements IIngresarVenta {

    @Override
    public int idInternoActual() throws SQLException {
        try {
            int idInternoActual = -1;
            conectar();
            Disco med = new Disco();
            ResultSet result = state.executeQuery("SELECT MAX(idInterno) as max FROM Venta;");
            if(result.next())
            {
                idInternoActual = result.getInt("max");
            }
            return idInternoActual +1;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return 0;
    }
    
    @Override
    public void insertarVenta(Venta venta,int idInterno) {
        try {
            long fechaSinFormato = venta.getFecha().getTime();
            java.sql.Date fechaConFormato = new java.sql.Date(fechaSinFormato);
            conectar();
            state.executeUpdate("INSERT INTO venta(idInterno, numeroVenta, fecha, codigoProducto) VALUES("+ idInterno +"," + venta.getNumero()
                    + ", '" + fechaConFormato + "','" + venta.producto.getCodigo() + "');");
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public ArrayList<Venta> ventaNumVenta(int numVenta) throws SQLException {
        conectar();

        ArrayList<Venta> listarventa = new ArrayList<Venta>();
        ResultSet result = state.executeQuery("SELECT numeroVenta, fecha, codigoProducto FROM `venta` WHERE numeroVenta ="+numVenta+";");
        while (result.next()) {
            try {
                Venta venta = new Venta();
                venta.setNumero((Integer) result.getObject(1));
                venta.setFecha((Date) result.getObject(2));
                venta.producto.setCodigo((String) result.getObject(3));
                listarventa.add(venta);
            } catch (Exception ex) {
                Logger.getLogger(IngresarVenta.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return listarventa;
    }

    @Override
    public Disco buscarProducto(String codigo) throws SQLException {
        Disco producto = new Disco();
                conectar();

        ResultSet result = state.executeQuery("SELECT nombre, precio FROM `producto` WHERE codigo ="+codigo+";");
        while (result.next()) {
            try {
                producto.setNombre((String) result.getObject(1));
                producto.setPrecio((Integer) result.getObject(2));
            } catch (Exception ex) {
                Logger.getLogger(IngresarVenta.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return producto;
    }

    @Override
    public int calcularTotalConDescuento(int subTotal) {
        int total;
        if(subTotal>=20000)
        {
            total = subTotal-(subTotal*DESCUENTO/100);
            return total;
        }
        else
        {
            total = subTotal;
            return total;
        }
    }
    
     

}
