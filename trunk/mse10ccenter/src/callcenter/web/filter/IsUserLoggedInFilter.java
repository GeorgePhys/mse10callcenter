package callcenter.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(urlPatterns = "*.jsf")
public class IsUserLoggedInFilter implements Filter {

    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
	    FilterChain chain) throws IOException, ServletException {
	HttpServletRequest servletRequest = (HttpServletRequest) request;
	HttpServletResponse servletResponse = (HttpServletResponse) response;
	HttpSession httpSession = servletRequest.getSession(true);

	String requestURL = servletRequest.getRequestURL().toString();

	if (httpSession.getAttribute("user") == null
		&& !requestURL.contains("login.jsf")
		&& !requestURL.contains("user")
		&& !requestURL.contains("rfRes")) {
	    servletResponse.sendRedirect("/mse10ccenter/pages/login/login.jsf");
	} else {
	    chain.doFilter(request, response);
	}
    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {

    }

}
