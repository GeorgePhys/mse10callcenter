package callcenter.util;

import java.util.Properties;
import java.util.UUID;

import javax.naming.InitialContext;
import javax.naming.NamingException;

public final class CommonUtil {

    private static InitialContext cachedInitialContext;

    private CommonUtil() {
    }

    public static String generateUUID() {
	UUID uuid = UUID.randomUUID();
	return uuid.toString();
    }

    public static InitialContext getInitialContext() throws NamingException {
	if (cachedInitialContext == null) {
	    Properties env = new Properties();
	    env.setProperty("java.naming.factory.initial",
		    "org.jnp.interfaces.NamingContextFactory");
	    env.setProperty("java.naming.provider.url", "localhost:1099");
	    env.setProperty("java.naming.factory.url.pkgs", "org.jboss.naming");
	    cachedInitialContext = new InitialContext(env);
	}
	return cachedInitialContext;
    }

    @SuppressWarnings("unchecked")
    public static <T> T lookupSessionBean(Class<T> clazz)
	    throws NamingException {
	return (T) getInitialContext().lookup(
		clazz.getSimpleName() + "/no-interface");
    }
}
