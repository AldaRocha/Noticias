
package core;

import bd.ConexionMySQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modelo.Comentario;
import modelo.Respuesta;
import modelo.Usuario;

/**
 *
 * @author rocha
 */
public class ControllerUsuario{
    public Usuario login(String usuario, String contrasenia) throws Exception{
        String sql="SELECT * FROM usuario WHERE nombreUsuario=? AND contrasenia=?"; 

        ConexionMySQL connMySQL=new ConexionMySQL();

        Connection conn = connMySQL.open();

        PreparedStatement pstmt = conn.prepareStatement(sql); //ejecuta consultas SQL
        
        ResultSet rs = null;
        pstmt.setString(1, usuario);
        pstmt.setString(2, contrasenia);

        rs = pstmt.executeQuery();

        Usuario u = null;
        
        if (rs.next())
            u = (fill(rs));
        
        rs.close();
        pstmt.close();
        connMySQL.close();
        
        return u;
    }
    
    private Usuario fill(ResultSet rs) throws Exception{
        Usuario u=new Usuario();        
        
        u.setIdUsuario(rs.getInt("idUsuario"));
        u.setNombreUsuario(rs.getString("nombreUsuario"));
        u.setContrasenia(rs.getString("contrasenia"));
        u.setCorreo(rs.getString("correo"));
        u.setEsInterno(rs.getString("esInterno"));
        
        return u;
    }
}
