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





import pi.service.model.DocumentoIdentidad;
import pi.service.DocumentoIdentidadService;
import pi.service.util.db.server.CRUD;

public class DocumentoIdentidadServiceImpl implements DocumentoIdentidadService {
	
	public static Class table = DocumentoIdentidad.class;

	@Override
	public List<DocumentoIdentidad> list(String app) throws Exception {
		return CRUD.list(app,table);
	}
}
