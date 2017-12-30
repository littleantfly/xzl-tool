package fun.xzl.tool.object;

public class ObjectUtils extends org.apache.commons.lang3.ObjectUtils {
	public ObjectUtils() {
        super();
    }
	
	public static final boolean isNull(Object object) {
		return (object == null);
	}
	
	public static final boolean isNotNull(Object object) {
		return !isNull(object);
	}
}
