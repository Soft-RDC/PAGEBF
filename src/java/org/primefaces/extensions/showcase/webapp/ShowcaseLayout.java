/*
 * Copyright 2011-2012 PrimeFaces Extensions.
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

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import org.primefaces.extensions.model.layout.LayoutOptions;

/**
 * ShowcaseLayout
 *
 * @author  Oleg Varaksin / last modified by $Author$
 * @version $Revision$
 */
@ApplicationScoped
@ManagedBean(eager = true)
public class ShowcaseLayout {

	private String options;

	@PostConstruct
	protected void initialize() {
		LayoutOptions layoutOptions = new LayoutOptions();

		// for all panes
		LayoutOptions panes = new LayoutOptions();
		panes.addOption("resizable", true);
		panes.addOption("closable", true);
		panes.addOption("slidable", false);
		panes.addOption("resizeWithWindow", false);
		panes.addOption("resizeWhileDragging", true);
		layoutOptions.setPanesOptions(panes);

		// north pane
		LayoutOptions north = new LayoutOptions();
		north.addOption("resizable", false);
		north.addOption("closable", false);
		north.addOption("size", 60);
		north.addOption("spacing_open", 0);
		layoutOptions.setNorthOptions(north);

		// south pane
		LayoutOptions south = new LayoutOptions();
		south.addOption("resizable", false);
		south.addOption("closable", false);
		south.addOption("size", 28);
		south.addOption("spacing_open", 0);
		layoutOptions.setSouthOptions(south);

		// center pane
		LayoutOptions center = new LayoutOptions();
		center.addOption("resizable", false);
		center.addOption("closable", false);
		center.addOption("resizeWhileDragging", false);
		center.addOption("minWidth", 200);
		center.addOption("minHeight", 60);
		layoutOptions.setCenterOptions(center);

		// west pane
		LayoutOptions west = new LayoutOptions();
		west.addOption("size", 210);
		west.addOption("minSize", 180);
		west.addOption("maxSize", 500);
		layoutOptions.setWestOptions(west);

		// east pane
		LayoutOptions east = new LayoutOptions();
		east.addOption("size", 448);
		east.addOption("minSize", 180);
		east.addOption("maxSize", 650);
		layoutOptions.setEastOptions(east);

		// nested east layout
		LayoutOptions childEastOptions = new LayoutOptions();
		east.setChildOptions(childEastOptions);

		// east-center pane
		LayoutOptions eastCenter = new LayoutOptions();
		eastCenter.addOption("minHeight", 60);
		childEastOptions.setCenterOptions(eastCenter);

		// south-center pane
		LayoutOptions southCenter = new LayoutOptions();
		southCenter.addOption("size", "70%");
		southCenter.addOption("minSize", 60);
		childEastOptions.setSouthOptions(southCenter);

		// serialize options to JSON string (increase perf.)
		options = layoutOptions.toJson();
	}

	public String getOptions() {
		return options;
	}

	public void setOptions(String options) {
		this.options = options;
	}
}
