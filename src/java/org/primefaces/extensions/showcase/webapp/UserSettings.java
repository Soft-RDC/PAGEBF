package org.primefaces.extensions.showcase.webapp;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.extensions.showcase.model.system.AvailableThemes;
import org.primefaces.extensions.showcase.model.system.Theme;

/**
 * User settings.
 *
 * @author  Oleg Varaksin / last modified by $Author$
 * @version $Revision$
 */
@ManagedBean
@SessionScoped
public class UserSettings implements Serializable {

	private static final long serialVersionUID = 20111020L;

	private List<Theme> availableThemes;
	private Theme currentTheme;

	public UserSettings() {
		currentTheme = AvailableThemes.getInstance().getThemeForName("blitzer");
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
