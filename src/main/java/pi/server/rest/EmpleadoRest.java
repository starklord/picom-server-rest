package pi.server.rest;

import java.util.List;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import pi.service.EmpleadoService;
import pi.service.factory.Services;
import pi.service.model.rrhh.Empleado;
import pi.service.model.rrhh.Permiso;

@Path("/pi/EmpleadoService")
public class EmpleadoRest implements EmpleadoService{

    @POST
    @Path("/cambiarClave")  
    @Produces(MediaType.APPLICATION_JSON) 
    @Override
    public String cambiarClave(
        @QueryParam("app") String app, 
        @QueryParam("empleadoId") int empleadoId, 
        @QueryParam("claveActual") String claveActual, 
        @QueryParam("claveNueva") String claveNueva, 
        @QueryParam("claveNuevaRep") String claveNuevaRep)
            throws Exception {
        return Services.getEmpleado().cambiarClave(app, empleadoId, claveActual, claveNueva, claveNuevaRep);
    }

    @Override
    public List<Empleado> list(String app, int empresaId) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Empleado> listUsuariosSistema(String app, int empresaId) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Permiso> listPermisosSession(String app) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Empleado save(String app, Empleado object) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Empleado saveOrUpdate(String app, boolean save, Empleado object) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Empleado> listVendedores(String app, int empresaId) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Empleado getByPin(String app, int pin) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }
}
