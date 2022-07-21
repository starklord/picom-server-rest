/*******************************************************************************
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
 *******************************************************************************/
package pi.service.impl;

import java.util.List;
import pi.service.model.Impuesto;
import pi.service.ImpuestoService;
import pi.service.util.db.server.CRUD;

public class ImpuestoServiceImpl implements ImpuestoService {

	@Override
	public List<Impuesto> list(String app) throws Exception {
		return CRUD.list(app,Impuesto.class,"order by nombre asc");
	}
	
	@Override
	public List<Impuesto> listActives(String app) throws Exception {
		return CRUD.list(app,Impuesto.class,"where activo is true order by nombre asc");
	}

	@Override
	public void delete(String app, Impuesto impuesto) throws Exception {
		CRUD.delete(app, impuesto);
	}

	@Override
	public Impuesto saveOrUpdate(String app, boolean save, Impuesto object) throws Exception {
		CRUD.save(app,object);
		return object;
	}

}
