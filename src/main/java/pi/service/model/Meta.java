package pi.service.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import pi.service.model.empresa.Empresa;
import pi.service.model.empresa.Sucursal;
import pi.service.model.rrhh.Empleado;
import pi.service.model.rrhh.Permiso;

public class Meta implements Serializable {

    public Empresa empresa;
    public Sucursal sucursal;
    public Empleado empleado;
    public List<Permiso> permisos = new ArrayList<>();
    public String app_name;
    public String app_token;
    public Integer eva_server;
    public String ip_server;
    public String path_images;
    public String path_pdfs;
    public String path_temps;

    public Meta() {
    }

}
