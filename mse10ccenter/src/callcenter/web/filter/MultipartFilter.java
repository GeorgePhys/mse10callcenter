package callcenter.web.filter;

import java.io.File;
import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;

/**
 * This filter detects <tt>multipart/form-data</tt> and <tt>multipart/mixed</tt>
 * POST requests and will then replace the <code>HttpServletRequest</code> by a
 * <code>{@link MultipartRequest}</code>.
 * 
 * @author BalusC
 * @link http://balusc.blogspot.com/2009/12/uploading-files-in-servlet-30.html
 */

@WebFilter(urlPatterns = { "/*" }, initParams = { @WebInitParam(name = "location", value = "/upload") })
public class MultipartFilter implements Filter {

    // Constants
    // ----------------------------------------------------------------------------------

    private static final String INIT_PARAM_LOCATION = "location";
    private static final String REQUEST_METHOD_POST = "POST";
    private static final String CONTENT_TYPE_MULTIPART = "multipart/";

    // Vars
    // --------------------------------------------------------------------------------------

    private String location;

    // Actions
    // ------------------------------------------------------------------------------------

    @Override
    public void init(FilterConfig config) throws ServletException {
	this.location = config.getInitParameter(INIT_PARAM_LOCATION);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
	    FilterChain chain) throws IOException, ServletException {
	HttpServletRequest httpRequest = (HttpServletRequest) request;
	File file = new File(location);
	if (!file.exists()) {
	    file.mkdir();
	}
	if (isMultipartRequest(httpRequest)) {
	    request = new MultipartRequest(httpRequest, location);
	}
	chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
	// NOOP.
    }

    // Helpers
    // ------------------------------------------------------------------------------------

    /**
     * Returns true if the given request is a multipart request.
     * 
     * @param request
     *            The request to be checked.
     * @return True if the given request is a multipart request.
     */
    public static final boolean isMultipartRequest(HttpServletRequest request) {
	return REQUEST_METHOD_POST.equalsIgnoreCase(request.getMethod())
		&& request.getContentType() != null
		&& request.getContentType().toLowerCase()
			.startsWith(CONTENT_TYPE_MULTIPART);
    }

}