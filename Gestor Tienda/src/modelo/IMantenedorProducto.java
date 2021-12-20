/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLException;
import java.util.ArrayList;
import negocio.Disco;
import negocio.Poster;

/**
 *
 * @author jhon_
 */
public interface IMantenedorProducto {
    
    /**
     * Inserta Productos tipo Poster en la base de datos
     * @param poster 
     */
    public void insertarPoster(Poster poster);


    /**
     * Inserta Productos tipo Disc en la base de datos
     * @param disco 
     */
    public void insertarDisco(Disco disco);

    /**
     * Lista los Productos tipo Poster
     * @return los datos del Producto tipo Poster
     * @throws SQLException 
     */
    public ArrayList<Poster>listarPoster()throws SQLException;

    /**
     * Lista los Productos tipo Disco
     * @return los datos del Producto tipo Disco
     * @throws SQLException 
     */
    public ArrayList<Disco> listarDisco()throws SQLException;

    /**
     * Busca los datos de un Producto tipo Poster ingresando su codigo
     * @param codigo
     * @return los datos del Producto tipo Poster
     * @throws SQLException 
     */
    public Poster buscarPoster(String codigo) throws SQLException;

    /**
     * Busca los datos de un Producto tipo Disco ingresando su codigo
     * @param codigo
     * @return los datos del Producto tipo Disco
     * @throws SQLException 
     */
    public Disco buscarDisco(String codigo) throws SQLException;


    /**
     * Elimina un producto de cualquier tipo ingresando su codigo
     * @param codigo
     * @return regresa un entero si se elimino el producto con exito
     */
    public int eliminar(String codigo);

    /**
     * Modifica los datos de un Producto tipo Poster ingresando su codigo
     * @param poster
     * @return regresa un entero si se modifico el producto con exito
     */
    public int modificarPoster(Poster poster);

    /**
     * Modifica los datos de un Producto tipo Disco ingresando su codigo
     * @param disco
     * @return regresa un entero si se modifico el producto con exito
     */
    public int modificarDisco(Disco disco);
}
