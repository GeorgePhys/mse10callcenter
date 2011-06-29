package callcenter.web.action.admin;

import java.io.File;
import java.io.Serializable;
import java.util.Arrays;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import callcenter.entity.products.Software;
import callcenter.service.administration.SoftwareServiceBean;

@SessionScoped
@ManagedBean(name = "productRegistrationAction")
public class ProductRegistrationAction implements Serializable {

	private static final long serialVersionUID = -6421783327502433744L;

	private byte[] pictureBytes;

	@EJB
	private SoftwareServiceBean service;

	private String text;
	private File file;
	private String[] check;

	public String register(Software software) {
		software.setPicture(pictureBytes);
		service.saveOrUpdate(software);
		return null;
	}

	public void submit() {
		// Now do your thing with the obtained input.
		System.out.println("Text: " + text);
		System.out.println("File: " + file);
		System.out.println("Check: " + Arrays.toString(check));
	}

	public String getText() {
		return text;
	}

	public File getFile() {
		return file;
	}

	public String[] getCheck() {
		return check;
	}

	public void setText(String text) {
		this.text = text;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public void setCheck(String[] check) {
		this.check = check;
	}
}
