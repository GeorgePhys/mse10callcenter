/**
 * 
 */
package callcenter.web;

import java.util.Locale;

import javax.faces.context.FacesContext;

/**
 * @author mse10slb
 *
 */
public class ChangeLanguage {
	
	public void changeLocal(String locale){
		FacesContext.getCurrentInstance().getViewRoot().setLocale(new Locale(locale));
		}
}
