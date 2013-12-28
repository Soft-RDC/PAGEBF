/*
 * Copyright 2011 PrimeFaces Extensions.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * $Id$
 */

package org.primefaces.extensions.showcase.webapp;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 * Navigation infos.
 *
 * @author  Oleg Varaksin / last modified by $Author$
 * @version $Revision$
 */
@ManagedBean
@SessionScoped
public class NavigationContext implements Serializable {

	private static final long serialVersionUID = 20111020L;

	public String getMenuitemStyleClass(final String page) {
		final String viewId = getViewId();
		if (viewId != null && viewId.equals(page)) {
			return "ui-state-active";
		}

		return "";
	}

	public String getViewId() {
		FacesContext fc = FacesContext.getCurrentInstance();
		String viewId = fc.getViewRoot().getViewId();
		String selectedComponent;
		if (viewId != null) {
			selectedComponent = viewId.substring(viewId.lastIndexOf("/") + 1, viewId.lastIndexOf("."));
		} else {
			selectedComponent = null;
		}

		return selectedComponent;
	}
}
