/** *****************************************************************************
 * Copyright 2011 Google Inc. All Rights Reserved.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ****************************************************************************** */
package pi.service.impl;


import java.util.ArrayList;
import java.util.List;


import pi.App;
import pi.service.LoginService;
import pi.service.model.Meta;
import pi.service.model.rrhh.CargoPermiso;
import pi.service.model.rrhh.Empleado;
import pi.service.model.rrhh.Permiso;
import pi.service.util.Util;
import pi.service.util.db.server.CRUD;

public class LoginServiceImpl implements LoginService {

    @Override
	public Meta login(String app, String user, String pass, int empresaId, int sucursalId) throws Exception {
		Class table = Empleado.class;
		String[] required = {
			"persona","sucursal","cargo","empresa","empresa.direccion","empresa.direccion.persona","caja" 
		};
		String filter = "where usuario = '" + user + "' and clave = '" + Util.encrypt(pass) +"' and a.empresa = " +empresaId ;
		List<Empleado> listEmpleados =  CRUD.list(app,table,required,filter);
		if(listEmpleados.isEmpty()){
			throw new Exception("No se pudo validar el usuario o clave");
		}
		Empleado empleado = listEmpleados.get(0);
		if(!empleado.activo){
			throw new Exception("El usuario ingresado se encuentra inhabilitado");
		}
		
		//para los permisos
		String[] requiredCP = {"cargo","permiso"};
		List<CargoPermiso> cargosPermisos = CRUD.list(app,CargoPermiso.class,requiredCP,"where b.id = " + empleado.cargo.id);
		List<Permiso> permisos = new ArrayList<>();
		boolean tienePermisoTodasSucursales = false; 
		for(CargoPermiso cp:cargosPermisos){
			permisos.add(cp.permiso);
			if(cp.permiso.id == Util.PER_JEFE_ADMINISTRACION||cp.permiso.id == Util.PER_JEFE_VENTAS||cp.permiso.id == Util.PER_JEFE_LOGISTICA) {
				tienePermisoTodasSucursales = true;
			}
		}
		if(!tienePermisoTodasSucursales) {
			if(empleado.sucursal.id !=sucursalId){
				throw new Exception("No cuenta con permisos para la sucursal seleccionada");
			}
		}else {
			SucursalServiceImpl sucursalService = new SucursalServiceImpl();
			empleado.sucursal = sucursalService.get(app,sucursalId);
		}
		
		Meta meta = new Meta();
		meta.sucursal = empleado.sucursal;
		meta.empresa = empleado.empresa;
		meta.empleado = empleado;
		meta.permisos = permisos;
        return meta;
    }

    // @Override
    // public Persona login(String user, String pass, int empresaId, int sucursalId) throws Exception {

    //     PersonaService personaService = new PersonaServiceImpl();
    //     Persona per = personaService.getByCodigoAndClavePortal(user, pass);
    //     if (per==null) {
    //         throw new Exception("No se pudo validar el usuario o clave");
    //     }
    //     if (!per.activo) {
    //         throw new Exception("No se encuentra activo para utilizar el sistema");
    //     }
    //     SucursalServiceImpl sucursalService = new SucursalServiceImpl();
    //     Sucursal sucursal = sucursalService.get(sucursalId);
    //     UI.getCurrent().getSession().setAttribute("persona", per);
    //     UI.getCurrent().getSession().setAttribute("sucursal", sucursal);
    //     return per;
    // }


}
