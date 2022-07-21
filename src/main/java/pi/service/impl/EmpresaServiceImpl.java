package pi.service.impl;

import java.util.List;

import pi.service.EmpresaService;
import pi.service.model.empresa.Empresa;
import pi.service.util.db.server.CRUD;

public class EmpresaServiceImpl implements EmpresaService {

    public static Class table = Empresa.class;

	@Override
	public List<Empresa> list(String app) throws Exception {
		String[] required = { "direccion", "direccion.persona" };
		List<Empresa> list = CRUD.list(app,table, required);
		return list;
	}

	@Override
	public Empresa get(String app) {
		String[] required = { "direccion", "direccion.persona", "documento_tipo_xdefecto" };
		Empresa empresa = null;
		try {
			List<Empresa> list = CRUD.list(app,table, required);
			empresa = list.isEmpty() ? null : list.get(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return empresa;
	}

	@Override
	public List<Empresa> listActive(String app) throws Exception {
		String[] required = { "direccion", "direccion.persona" };
		List<Empresa> list = CRUD.list(app,table, required, "where a.activo is true");
		return list;
	}

	@Override
	public Empresa save(String app, Empresa empresa) throws Exception {
		CRUD.save(app,empresa);
		return empresa;
	}

	@Override
	public void delete(String app, Empresa empresa) throws Exception {
		CRUD.delete(app, empresa);
	}

	@Override
	public Empresa saveOrUpdate(String app, boolean save, Empresa empresa) throws Exception {
		CRUD.save(app,empresa);
		return empresa;
	}
    
}
