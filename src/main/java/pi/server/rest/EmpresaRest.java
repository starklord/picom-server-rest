package pi.server.rest;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import pi.service.factory.Services;
import pi.service.model.empresa.Empresa;

@Path("/pi/empresa")
public class EmpresaRest {

    @GET
    public String hello() {
        return "empresa module started now...";
    }

    @GET
    @Path("/get")
    @Produces(MediaType.APPLICATION_JSON)
    public Empresa get(@QueryParam("app") String app) {
        
        Empresa  emp = Services.getEmpresa().get(app);
        System.out.println("empresa: " + emp.toString());
        return emp;
    }   

    @POST
    public Empresa save(Empresa empresa){
        empresa.commercial_name = empresa.commercial_name+"modificadito";
        return empresa;
    }
}
