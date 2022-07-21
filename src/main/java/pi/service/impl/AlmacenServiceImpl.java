package pi.service.impl;

import java.util.ArrayList;
import java.util.List;





import pi.service.model.almacen.Almacen;
import pi.service.util.db.server.CRUD;
import pi.service.AlmacenService;

public class AlmacenServiceImpl implements AlmacenService {

	@Override
	public List<Almacen> list(String app, int empresaId) throws Exception {
		String[] req={"sucursal","sucursal.empresa"};//hola
		return CRUD.list(app, Almacen.class,req,"where c.id = " + empresaId);
	}
	
	@Override
	public List<Almacen> listActives(String app, int empresaId) {
		List<Almacen> list = new ArrayList<>();
		try{
			String[] req={"sucursal","sucursal.empresa"};
		list = CRUD.list(app,Almacen.class,req,"where c.id = " + empresaId + "and a.activo is true");
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return list;
	}

	@Override
	public void delete(String app, Almacen almacen) throws Exception {
		CRUD.delete(app,almacen);
	}

	@Override
	public Almacen saveOrUpdate(String app, boolean save, Almacen almacen) throws Exception {
		if(save){
			CRUD.save(app,almacen);
		}else{
			CRUD.update(app,almacen);
		}
		return almacen;
	}

	

	

}
