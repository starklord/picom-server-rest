package pi.server.rest;

import java.util.List;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

import pi.service.factory.Services;
import pi.service.model.empresa.Sucursal;

@Path("/pi/SucursalService")
public class SucursalRest {

    @POST
    @Path("/listActive")
    public List<Sucursal> listActive(@QueryParam("app") String app) { 
        return Services.getSucursal().listActive(app);
    }
    
}
