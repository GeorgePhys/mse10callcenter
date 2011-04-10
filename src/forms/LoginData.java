/**
 * 
 */
package forms;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

public class LoginData {

	private final String name = "test";
	private final String password = "test123";
	public String loginData(UserData user) {
		
		FacesContext context = FacesContext.getCurrentInstance();
		if (user.getName().equals(name) && user.getPassword().equals(password)) {

			context.getExternalContext().getSessionMap()
					.put("loggedUser", user.getName());
			return "main";
		} else {
			FacesMessage message = new FacesMessage(
					"Невалиден потребител/парола");
			context.addMessage(null, message);
			return null;
		}
	}

	public String logout() {
		FacesContext context = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) context.getExternalContext()
				.getSession(true);
		session.invalidate();
		
		return "main";
	}
	
}
