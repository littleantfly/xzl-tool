package fun.xzl.tool.map;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

import com.google.common.collect.Maps;

public class MapUtils extends org.apache.commons.collections.MapUtils {

	public MapUtils() {
		super();
	}

	public static final <K, V> Map<K, V> newHashMap() {
		return Maps.newHashMap();
	}

	public static final <K, V> Map<K, V> newConcurrentMap() {
		return Maps.newConcurrentMap();
	}

	public static final <K, V> LinkedHashMap<K, V> newLinkedHashMap() {
		return Maps.newLinkedHashMap();
	}

	public static final <K extends Comparable, V> TreeMap<K, V> newTreeMap() {
		return Maps.newTreeMap();
	}

}
