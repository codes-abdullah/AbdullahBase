package codes.abdullah.project;

import java.util.Properties;
import java.util.TreeMap;

/**
 * simple wrapper for {@link Properties} to support natural ordering
 */
public class SortedProperties extends TreeMap<Object, Object> {
	private static final long serialVersionUID = -12772642988468498L;

	public SortedProperties(Properties p) {
		super(p);
	}

}
