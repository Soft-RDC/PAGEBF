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

package org.primefaces.extensions.showcase.model.system;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * AvailableThemes
 *
 * @author  Oleg Varaksin / last modified by $Author$
 * @version $Revision$
 */
public class AvailableThemes {

	private static AvailableThemes instance = null;

	private final HashMap<String, Theme> themesAsMap;
	private final List<Theme> themes;

	private AvailableThemes() {
		final List<String> themeNames = new ArrayList<String>();

		themeNames.add("afterdark");
		themeNames.add("afternoon");
		themeNames.add("afterwork");
		themeNames.add("aristo");
		themeNames.add("black-tie");
		themeNames.add("blitzer");
		themeNames.add("bluesky");
		themeNames.add("bootstrap");
		themeNames.add("casablanca");
		themeNames.add("cruze");
		themeNames.add("cupertino");
		themeNames.add("dark-hive");
		themeNames.add("delta");
		themeNames.add("dot-luv");
		themeNames.add("eggplant");
		themeNames.add("excite-bike");
		themeNames.add("flick");
		themeNames.add("glass-x");
		themeNames.add("home");
		themeNames.add("hot-sneaks");
		themeNames.add("humanity");
		themeNames.add("le-frog");
		themeNames.add("midnight");
		themeNames.add("mint-choc");
		themeNames.add("overcast");
		themeNames.add("pepper-grinder");
		themeNames.add("redmond");
		themeNames.add("rocket");
		themeNames.add("sam");
		themeNames.add("smoothness");
		themeNames.add("south-street");
		themeNames.add("start");
		themeNames.add("sunny");
		themeNames.add("swanky-purse");
		themeNames.add("trontastic");
		themeNames.add("ui-darkness");
		themeNames.add("ui-lightness");
		themeNames.add("vader");

		themesAsMap = new HashMap<String, Theme>();
		themes = new ArrayList<Theme>();

		for (final String themeName : themeNames) {
			final Theme theme = new Theme();
			theme.setName(themeName);
			theme.setImage("/resources/images/themeswitcher/" + themeName
			               + ".png");

			themes.add(theme);
			themesAsMap.put(theme.getName(), theme);
		}
	}

	public static AvailableThemes getInstance() {
		if (instance == null) {
			instance = new AvailableThemes();
		}

		return instance;
	}

	public final List<Theme> getThemes() {
		return themes;
	}

	public Theme getThemeForName(final String name) {
		return themesAsMap.get(name);
	}
}
