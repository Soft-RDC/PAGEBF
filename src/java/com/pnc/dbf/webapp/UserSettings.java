package com.pnc.dbf.webapp;

import com.pnc.dbf.system.AvailableThemes;
import com.pnc.dbf.system.Theme;
import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class UserSettings implements Serializable {

    private static final long serialVersionUID = 20111020L;

    private List<Theme> availableThemes;
    private Theme currentTheme;

    public UserSettings() {
        currentTheme = AvailableThemes.getInstance().getThemeForName("aristo");
        availableThemes = AvailableThemes.getInstance().getThemes();
    }

    public final List<Theme> getAvailableThemes() {
        return availableThemes;
    }

    public final void setAvailableThemes(List<Theme> availableThemes) {
        this.availableThemes = availableThemes;
    }

    public final Theme getCurrentTheme() {
        return currentTheme;
    }

    public final void setCurrentTheme(Theme currentTheme) {
        this.currentTheme = currentTheme;
    }
}
