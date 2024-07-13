package codes.abdullah.project.lang;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class LAs {
	LAs() {

	}

	/**
	 * Return builder to supply keys and values
	 * 
	 * @param keys keys of map
	 * @see LEmptyOrNull#requireNiether(Object)
	 * @see LLength#of(Object[])
	 */
	@SuppressWarnings("unchecked")
	public <K> MapBuilder<K> map(K... keys) {
		return new MapBuilder<K>(keys);
	}

	/**
	 * Helper builder class for in-line creating maps
	 */
	public class MapBuilder<K> {
		private final K[] keys;

		@SuppressWarnings("unchecked")
		protected MapBuilder(K... keys) {
			this.keys = Lang.emptyOrNull.requireNiether(keys);
		}

		/**
		 * Supply values to builder
		 * 
		 * @param values of map
		 */
		@SuppressWarnings({ "unchecked", "rawtypes" })
		public <T> Map<K, T> with(T... values) {
			Map m = new HashMap();
			int klen = Lang.length.of(keys);
			int vlen = Lang.length.of(values);
			int min = Math.min(klen, vlen);
			int i = 0;
			for (; i < min; i++) {
				m.put(keys[i], values[i]);
			}

			int diff = klen - vlen;
			if (diff > 0) {
				for (int j = 0; j < diff; j++) {
					m.put(keys[i], null);
				}
			}

			return m;
		}

	}

	/**
	 * @return a modifiable list
	 * @see LLength#of(Object[], boolean)
	 */
	@SuppressWarnings("unchecked")
	public <T> List<T> list(T... arr) {
		List<T> l = new ArrayList<T>();
		if (Lang.length.of(arr) == 0)
			return l;
		for (T t : arr) {
			l.add(t);
		}
		return l;
	}

	/**
	 * @return a modifiable collection
	 */
	@SuppressWarnings("unchecked")
	public <T> Collection<T> collection(T... arr) {
		return list(arr);
	}

	/**
	 * @return a modifiable queue
	 */
	@SuppressWarnings("unchecked")
	public <T> Queue<T> queue(T... arr) {
		Queue<T> l = new LinkedList<T>();
		if (Lang.length.of(arr) == 0)
			return l;
		for (T t : arr) {
			l.add(t);
		}
		return l;
	}

	/**
	 * @return a modifiable set
	 */
	@SuppressWarnings("unchecked")
	public <T> Set<T> set(T... arr) {
		Set<T> l = new HashSet<>();
		if (Lang.length.of(arr) == 0)
			return l;
		for (T t : arr) {
			l.add(t);
		}
		return l;
	}

}
