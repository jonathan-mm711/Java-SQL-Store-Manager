/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import negocio.Disco;
import negocio.Poster;
import negocio.Producto;

/**
 *
 * @author jhon_
 */
public class MantenedorProducto extends Conexion implements IMantenedorProducto {

    @Override
    public void insertarPoster(Poster poster) {
        try {
            conectar();
            state.executeUpdate("INSERT INTO producto(Codigo, Nombre, Precio, Dimension) VALUES('" + poster.getCodigo()
                    + "', '" + poster.getNombre() + "'," + poster.getPrecio() + ",'" + poster.getDimension() + "');");
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void insertarDisco(Disco disco) {
        try {
            conectar();
            state.executeUpdate("INSERT INTO producto(Codigo, Nombre, Precio, Artista, Annio) VALUES('" + disco.getCodigo()
                    + "', '" + disco.getNombre() + "'," + disco.getPrecio() + ",'" + disco.getArtista() + "','" + disco.getAnnio() + "');");
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    @Override
    public ArrayList<Poster> listarPoster() throws SQLException {
        conectar();
        ArrayList<Poster> listarposter = new ArrayList<Poster>();
        ResultSet result = state.executeQuery("select * from producto");
        while (result.next()) {
            try {
                Poster poster = new Poster();
                poster.setCodigo((String) result.getObject(1));
                poster.setNombre((String) result.getObject(2));
                poster.setPrecio((Integer) result.getObject(3));
                poster.setDimension((String) result.getObject(6));
                listarposter.add(poster);
            } catch (Exception ex) {
                Logger.getLogger(MantenedorProducto.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return listarposter;

    }

    @Override
    public ArrayList<Disco> listarDisco() throws SQLException {
        conectar();

        ArrayList<Disco> listardisco = new ArrayList<Disco>();
        ResultSet result = state.executeQuery("select * from producto");
        while (result.next()) {
            try {
                Disco disco = new Disco() {
                };
                disco.setCodigo((String) result.getObject(1));
                disco.setNombre((String) result.getObject(2));
                disco.setPrecio((Integer) result.getObject(3));
                disco.setArtista((String) result.getObject(4));
                disco.setAnnio((Integer) result.getObject(5));
                listardisco.add(disco);
            } catch (Exception ex) {
                Logger.getLogger(MantenedorProducto.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return listardisco;

    }

    @Override
    public Poster buscarPoster(String codigo) throws SQLException {
        conectar();
        Poster poster = new Poster();
        ResultSet result = state.executeQuery("select * from producto Where codigo ='" + codigo + "'  ;");

        while (result.next()) {
            try {
                poster.setCodigo((String) result.getObject(1));
                poster.setNombre((String) result.getObject(2));
                poster.setPrecio((Integer) result.getObject(3));
                poster.setDimension((String) result.getObject(6));
            } catch (Exception ex) {
                Logger.getLogger(MantenedorProducto.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return poster;
    }

    @Override
    public Disco buscarDisco(String codigo) throws SQLException {
        conectar();
        Disco disco = new Disco();
        ResultSet result = state.executeQuery("select * from producto Where codigo ='" + codigo + "'  ;");

        while (result.next()) {
            try {
                disco.setCodigo((String) result.getObject(1));
                disco.setNombre((String) result.getObject(2));
                disco.setPrecio((Integer) result.getObject(3));
                disco.setArtista((String) result.getObject(4));
                disco.setAnnio((Integer) result.getObject(5));
            } catch (Exception ex) {
                Logger.getLogger(MantenedorProducto.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return disco;
    }

    @Override
    public int eliminar(String codigo) {
        int entero = 0;
        try {
            conectar();
            entero = state.executeUpdate("DELETE FROM producto WHERE codigo='" + codigo + "';");
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return entero;
    }

    @Override
    public int modificarPoster(Poster poster) {
        int entero = 0;
        try {
            conectar();
            entero = state.executeUpdate("update producto set nombre='" + poster.getNombre()
                    + "', precio=" + poster.getPrecio()
                    + ", dimension='" + poster.getDimension()
                    + "' where codigo='" + poster.getCodigo() + "';");
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return entero;
    }

    @Override
    public int modificarDisco(Disco disco) {
        int entero = 0;
        try {
            conectar();
            entero = state.executeUpdate("update producto set nombre='"
                    + disco.getNombre()
                    + "', precio=" + disco.getPrecio()
                    + ",  artista='" + disco.getArtista()
                    + "', annio=" + disco.getAnnio()
                    + " where codigo='" + disco.getCodigo() + "';");

            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return entero;
    }

}
