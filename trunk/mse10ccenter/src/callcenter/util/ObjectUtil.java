package callcenter.util;

import java.util.Collection;

public class ObjectUtil {

	public static boolean isValid(Object o) {
		return o != null;
	}

	public static boolean isValid(Collection<?> c) {
		return c != null && !c.isEmpty();
	}

}
