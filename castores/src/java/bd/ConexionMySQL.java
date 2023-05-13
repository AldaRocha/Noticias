
package bd;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author rocha
 */
public class ConexionMySQL{
    Connection conn;
    public Connection open(){
        String usuario="root"; //Aqui va el usuario de su gestor por default esta el mio pero se puede cambiar
        String contrasenia="2418Fran11@@"; //Mismo caso para la contraseña
                                               /*Aqui va Nom.BD?useSSL=false&"  */
        String url="jdbc:mysql://127.0.0.1:3306/francisco_rocha?useSSL=false&"
                  +"allowPublicKeyRetrieval=true&"
                  +"useUnicode=true&characterEncoding=utf-8";
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn=DriverManager.getConnection(url, usuario, contrasenia);
            return conn;
        } catch(Exception e){
            throw new RuntimeException(e);
        }
    }
    
    public void close(){
        if(conn!=null){
            try{
                conn.close();
            } catch(Exception e){
                e.printStackTrace();
                System.out.println("Exception controlada.");
            }
        }
    }
}
