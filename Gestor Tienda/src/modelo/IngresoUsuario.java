package modelo;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author jhon_
 */
public class IngresoUsuario extends Conexion implements IIngresoUsuario{

    @Override
    public boolean IngresoUs(String usuario, String contrasena) throws SQLException {
        conectar();
        ResultSet result = state.executeQuery("select * from usuario WHERE nombreUsuario ='" + usuario + "' AND contrasena ='" + contrasena + "' ;");

        if (!result.next()) {
            return false;
        } else {
            return true;
        }

    }

}
