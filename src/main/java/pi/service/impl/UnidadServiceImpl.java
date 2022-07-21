package pi.service.impl;

import java.util.List;





import pi.service.model.almacen.Unidad;
import pi.service.UnidadService;
import pi.service.util.db.server.CRUD;

public class UnidadServiceImpl implements UnidadService{
	@Override
	public List<Unidad> list(String app) throws Exception {
		return CRUD.list(app,Unidad.class,"order by nombre asc");
	}

	@Override
	public void saveOrUpdate(String app, Unidad unidad) throws Exception {
		if(unidad.id==null){
			CRUD.save(app,unidad);
		}else{
			CRUD.update(app,unidad);
		}
	}

	@Override
	public void delete(String app, Unidad unidad) throws Exception {
		CRUD.delete(app, unidad);
	}

	@Override
	public List<Unidad> listActives(String app) throws Exception {
		return CRUD.list(app,Unidad.class,"where activo is true order by nombre asc");
	}
}
