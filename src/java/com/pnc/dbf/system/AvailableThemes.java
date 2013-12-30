package com.pnc.dbf.system;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AvailableThemes {

    private static AvailableThemes instance = null;

    private final HashMap<String, Theme> themesAsMap;
    private final List<Theme> themes;

    private AvailableThemes() {
        final List<String> themeNames = new ArrayList<>();

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

        themesAsMap = new HashMap<>();
        themes = new ArrayList<>();

        for (final String themeName : themeNames) {
            final Theme theme = new Theme();
            theme.setName(themeName);
            theme.setImage("/resources/images/themeswitcher/" + themeName + ".png");

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
