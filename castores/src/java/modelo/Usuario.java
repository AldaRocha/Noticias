
package modelo;

/**
 *
 * @author rocha
 */
public class Usuario{
    private int idUsuario;
    private String nombreUsuario;
    private String contrasenia;
    private String correo;
    private String esInterno;

    public Usuario(int idUsuario, String nombreUsuario, String contrasenia, String correo, String esInterno){
        this.idUsuario=idUsuario;
        this.nombreUsuario=nombreUsuario;
        this.contrasenia=contrasenia;
        this.correo=correo;
        this.esInterno=esInterno;
    }

    public Usuario(){
    }

    public int getIdUsuario(){
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario){
        this.idUsuario=idUsuario;
    }

    public String getNombreUsuario(){
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario){
        this.nombreUsuario=nombreUsuario;
    }

    public String getContrasenia(){
        return contrasenia;
    }

    public void setContrasenia(String contrasenia){
        this.contrasenia=contrasenia;
    }

    public String getCorreo(){
        return correo;
    }

    public void setCorreo(String correo){
        this.correo=correo;
    }

    public String getEsInterno(){
        return esInterno;
    }

    public void setEsInterno(String esInterno){
        this.esInterno=esInterno;
    }
}
