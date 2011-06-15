package callcenter.servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import callcenter.dto.user.UserRegistrationKey;
import callcenter.service.administration.UserServiceBean;
import callcenter.service.administration.UsersPendingConfirmationBean;

@WebServlet(name = "confirmation", urlPatterns = "/confirmation")
public class UserRegistrationConfirmationServlet extends HttpServlet {

	private static final long serialVersionUID = 4244354868391430055L;

	@EJB
	private UserServiceBean userServiceBean;

	@EJB
	private UsersPendingConfirmationBean pendingConfirmationBean;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String uuid = req.getParameter("id");
		if (!pendingConfirmationBean.exists(uuid)) {
			return;
		}
		UserRegistrationKey key = pendingConfirmationBean.getAndRemove(uuid);
		try {
			userServiceBean.confirmUserRegistration(key);
		} catch (NamingException e) {
			e.printStackTrace();
		}
		resp.sendRedirect(resp
				.encodeRedirectURL("/mse10ccenter/pages/login/login.jsf"));
	}
}
