package forms;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class UserDataController {

	private List<UserData> users;

	public UserDataController() {
		File file = new File("users2.xml");

		if (file.exists()) {
			loadUsers();
		} else {
			users = new ArrayList<UserData>();
		}
	}

	/**
	 * Add users list.
	 * 
	 * @param user
	 *            user to add.
	 * @return navigation rule to result page
	 */
	public String saveUserData(UserData user) {
		users.add(user);

		persistUsers();
		// set creation date to current date
		user.setCreationDate(new Date());
		// add success message
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage message = new FacesMessage("Потребителя е запазен успешно");
		context.addMessage(null, message);

		return "resultData";
	}

	public void deleteUserData(UserData user) {
		users.remove(user);
		persistUsers();
	}

	/**
	 * Persist users from xml
	 */
	private void persistUsers() {
		XStream xstream = new XStream(new DomDriver("UTF-8"));

		try {
			FileOutputStream fileOutputStream = new FileOutputStream(
					"users2.xml");
			xstream.toXML(users, fileOutputStream);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	/*
	 * Reads users from xml file
	 */
	
	private void loadUsers() {
		XStream xstream = new XStream(new DomDriver("UTF-8"));

		try {
			FileInputStream fileInputStream = new FileInputStream("users2.xml");
			users = (List<UserData>) xstream.fromXML(fileInputStream);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public List<UserData> getUsers() {
		return users;
	}
	
//	public void (UserData user)
//	{
//	    Iterator iter = List<UserData>.iterator();
//	     while (iter.hasNext()) {
//	      System.out.println("string " + iter.next());
//	      }
//	   }
}
