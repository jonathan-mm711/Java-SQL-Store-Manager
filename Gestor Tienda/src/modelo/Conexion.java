/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 *
 * @author jhon_
 */
public class Conexion {

    protected Connection con;
    protected Statement state;
//El Puerto lógico de MySql siempre es el 3306 no se cambia
//Cadena de conexiòn

    public void conectar() {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/musicstore", "root", null);
            state = con.createStatement();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}