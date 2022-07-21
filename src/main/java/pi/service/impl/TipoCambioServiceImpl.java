package pi.service.impl;

import java.util.List;





import pi.service.model.TipoCambio;
import pi.service.TipoCambioService;
import pi.service.util.db.server.CRUD;

public class TipoCambioServiceImpl implements TipoCambioService {

	@Override
	public List<TipoCambio> list(String app) throws Exception {

		String[] req = {"moneda"};
		return CRUD.list(app,TipoCambio.class, req," order by fecha desc");
	}

	@Override
	public TipoCambio getLastTipoCambio(String app) throws Exception {
		String[] req = {"moneda"};
		List<TipoCambio> list = CRUD.list(app,TipoCambio.class, req," order by fecha desc limit 1");
		if(list.isEmpty()){
			throw new Exception("No se han encontrado tipos de cambio activos en el sistema");
		}
		return list.get(0);
	}

	@Override
	public TipoCambio saveOrUpdate(String app, boolean save, TipoCambio object) throws Exception {
		if(save){
			CRUD.save(app,object);	
		}else{
			CRUD.update(app,object);
		}
		
		return object;
	}

}
