package fun.xzl.tool.bean;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

/**
 * @author 谢正龙
 * @date 2018年3月20日 上午11:22:05
 * @desc
 * @version V1.0
 * 
 */
public class BeanUtils extends org.apache.commons.beanutils.BeanUtils {

	public static final Map<String, Object> toMap(Object bean)
			throws IntrospectionException, IllegalAccessException, InvocationTargetException {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		BeanInfo beanInfo = Introspector.getBeanInfo(bean.getClass());
		PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
		for (int i = 0; i < propertyDescriptors.length; i++) {
			PropertyDescriptor descriptor = propertyDescriptors[i];
			String propertyName = descriptor.getName();
			if (!propertyName.equals("class")) {
				Method readMethod = descriptor.getReadMethod();
				Object result = readMethod.invoke(bean, new Object[0]);
				if (result != null) {
					if (result instanceof String) {
						if (StringUtils.isNotBlank(result.toString())) {
							returnMap.put(propertyName, result);
						}
					} else {
						returnMap.put(propertyName, result);
					}
				}
			}
		}
		return returnMap;
	}
}
