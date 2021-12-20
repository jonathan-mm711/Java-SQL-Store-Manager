/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.SQLException;
import java.util.ArrayList;
import negocio.Disco;
import negocio.Venta;

/**
 *
 * @author jhon_
 */
public interface IIngresarVenta {
    /**
     * Este método es para conseguir el valor máximo de "idInterno" en la tabla "venta" de la base de dats
     * y le suma 1. Esta variable servirá para diferenciar cada producto ingresado en un numero de venta individual
     * @return idInternoActual
     * @throws SQLException 
     */
    public int idInternoActual() throws SQLException;
    /**
     * Este método inserta el los valores "idInterno", "numeroVenta", "fecha" y "codigo" a la tabla "venta"
     * en la base de datos.
     * @param venta
     * @param idInterno 
     */
    public void insertarVenta(Venta venta, int idInterno);
    /**
     * Este método hace una consulta a la base de datos a la tabla "venta" y filtra los resultados
     * que posean el mismo "numeroVenta" ingresado como parámetro.
     * Devuelve una lista con objetos Venta que poseen Numero, Fecha y Producto.getCodigo.
     * @param numVenta
     * @return listarventa
     * @throws SQLException 
     */
    public ArrayList<Venta> ventaNumVenta(int numVenta) throws SQLException;
    /**
     * Este método hace una consulta buscando las columnas "nombre" y "precio" de la tabla "producto" en la base de datos.
     * Retorna un objeto Disco con esas propiedades. Podría haber sido un objeto Poster ya que
     * Lo importante son las propiedades de la clase Producto que se usarán.
     * @param codigo
     * @return Disco
     * @throws SQLException 
     */
    public Disco buscarProducto(String codigo) throws SQLException;
    /**
     * Este es el porcentaje que se descuenta para compras mayores a $20.000
     */
    final int DESCUENTO = 10;
    /**
     * Este método recibe la suma de precios en la compra actual y revisa si esta compra supera los $20.000
     * Si ese es el caso, aplica el DESCUENTO en porcentaje. En caso contrario, devuelve el parámetro subTotal.
     * @param subTotal
     * @return total
     */
    public int calcularTotalConDescuento(int subTotal);
}
