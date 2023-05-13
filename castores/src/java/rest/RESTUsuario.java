
package rest;

import com.google.gson.Gson;
import core.ControllerUsuario;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import modelo.Usuario;

/**
 *
 * @author rocha
 */
@Path("log")
public class RESTUsuario{
    @Path("in")
    @Produces(MediaType.APPLICATION_JSON)
    @POST
    public Response login(@FormParam("datos") @DefaultValue("") String datos) throws Exception{
        String out="";
        Gson gson=new Gson();
        Usuario u=new Usuario();
        Usuario us=new Usuario();
        ControllerUsuario cu=new ControllerUsuario();
        
        u=gson.fromJson(datos, Usuario.class);
        us=cu.login(u.getNombreUsuario(), u.getContrasenia());
        try{
            if(us!=null){
                out=gson.toJson(us);
            }else{
                out="""
                    {"error":"Datos de Credencial incorrectos"}
                    """;
            }
        } catch(Exception e){
            e.printStackTrace();
            out = """
                  {"exception":"?"}
                  """;
            out = String.format(out, e.toString());
        }
        return Response.status(Response.Status.OK).entity(out).build();
    }
}
