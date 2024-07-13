package codes.abdullah.project;

import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.ResourceBundle;

/**
 * <b>IMPORTANT:</b> don't use {@link ResourceBundle#getBundle(String)} or
 * {@link ResourceParcel_old#getBundle(String)} since this class does this
 * internally, only pass the paths without extension such as: new
 * String[]{"langs/strings", "langs/errors"}..etc
 * <p>
 * just simple wrapper over immutable {@link Map} which represent resources<br>
 * the most important of this class is the possibility of combined multiple
 * .properties file in one bundle with full support of localization
 */
public final class ResourceParcel_old extends ResourceBundle {
	private final Map<String, String> unmodifiableMap;

	private ResourceParcel_old(ResourceBundle... rbs) {
		Objects.requireNonNull(rbs, "rbs are null");
		Map<String, String> map = new HashMap<>();
		for (ResourceBundle rb : rbs) {
			Enumeration<String> keys = rb.getKeys();
			while (keys.hasMoreElements()) {
				String key = keys.nextElement();
				String val = rb.getString(key);
				map.put(key, val);
			}
		}
		this.unmodifiableMap = Collections.unmodifiableMap(new LinkedHashMap<>(map));
	}

	private ResourceParcel_old(String... paths) {
		if (paths.length == 0)
			throw new IllegalArgumentException("can't load " + ResourceParcel_old.class.getName() + " paths are empty");
		Map<String, String> map = new HashMap<String, String>();
		ResourceBundle rb = null;
		for (String r : paths) {
			rb = ResourceBundle.getBundle(Project.resolveResourcePath(r));
			Enumeration<String> keys = rb.getKeys();
			String key = null;
			while (keys.hasMoreElements()) {
				key = keys.nextElement();
				map.put(key, rb.getObject(key).toString());
			}
		}
		this.unmodifiableMap = Collections.unmodifiableMap(new LinkedHashMap<>(map));
	}

	private ResourceParcel_old(Map<String, String> map) {
		this.unmodifiableMap = Collections.unmodifiableMap(new LinkedHashMap<>(map));
	}

	public final static ResourceParcel_old newParcel(String... paths) {
		return new ResourceParcel_old(paths);
	}

	public final static ResourceParcel_old newParcel(ResourceBundle... rbs) {
		return new ResourceParcel_old(rbs);
	}

	public final ResourceParcel_old loadAndAppend(String... paths) {
		Map<String, String> map = new HashMap<>();
		map.putAll(newParcel(paths).unmodifiableMap);
		map.putAll(unmodifiableMap);
		return new ResourceParcel_old(map);
	}

	public final ResourceParcel_old append(ResourceBundle... rbs) {
		Map<String, String> map = new HashMap<>();
		map.putAll(newParcel(rbs).unmodifiableMap);
		map.putAll(this.unmodifiableMap);
		return new ResourceParcel_old(map);
	}

	public final ResourceParcel_old append(ResourceParcel_old... rps) {
		Map<String, String> map = new HashMap<>();
		for (ResourceParcel_old rp : rps)
			map.putAll(rp.unmodifiableMap);
		return new ResourceParcel_old(map);
	}

	@Override
	protected final Object handleGetObject(String key) {
		return unmodifiableMap.get(key);
	}

	@Override
	public final Enumeration<String> getKeys() {
		ResourceBundle parent = this.parent;
		return new ResourceParcelEnumeration_old(unmodifiableMap.keySet(), (parent != null) ? parent.getKeys() : null);
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + " [" + unmodifiableMap + "]";
	}

}