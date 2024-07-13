package codes.abdullah.project.lang;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Map;

public class LGeneric {

	/** Gets keys of map */
	public final LGenericKeys keys = new LGenericKeys();
	
	/** Gets values of map */
	public final LGenericValues vals = new LGenericValues();

	LGeneric() {
	}

	/**
	 * Create new <b>empty</b> array instance with type of T, the length is
	 * equivalent to src.length
	 * 
	 * @param src the array type
	 * @return new empty array instance of type T
	 * @throws IllegalArgumentException if argument is not an array
	 */
	public <T> T[] newArray(T[] src) {
		return newArray(src, Lang.length.of(src));
	}

	/**
	 * create new <b>empty</b> array instance with type of T
	 * 
	 * @param src the array type
	 * @param len the length of the new array
	 * @return new empty array instance of type T
	 * @throws IllegalArgumentException if argument is not an array
	 */
	@SuppressWarnings("unchecked")
	public <T> T newArray(T src, int len) {
		final Class<?> type = src.getClass();
		if (!type.isArray()) {
			throw new IllegalArgumentException("not an array: " + type);
		}
		final T dest = ((Object) type == (Object) Object[].class) ? (T) new Object[len]
				: (T) Array.newInstance(type.getComponentType(), len);
		return dest;
	}

	@SuppressWarnings("unchecked")
	public <T> T[] toArray(Collection<T> col) {
		Object[] arr = col.toArray(new Object[col.size()]);
		return (T[]) toArray(arr, arr[0].getClass());
	}

	/**
	 * @param superType the type of collection elements
	 */
	public <T> T[] toArray(Collection<T> col, Class<T> superType) {
		Object[] arr = col.toArray(new Object[col.size()]);
		return toArray(arr, superType);
	}

	/**
	 * Internal usage
	 * 
	 * @param arr       array to copy from
	 * @param superType type of array
	 */
	@SuppressWarnings("unchecked")
	private <T> T[] toArray(Object[] arr, Class<T> superType) {
		T[] arr2 = (T[]) Array.newInstance(superType, arr.length);
		System.arraycopy(arr, 0, arr2, 0, arr.length);
		return arr2;
	}

	public static class LGenericKeys {
		private LGenericKeys() {
		}

		public <K> K[] of(Map<K, ?> m) {
			return Lang.generic.toArray(m.keySet());
		}
	}

	public static class LGenericValues {
		private LGenericValues() {
		}

		public <V> V[] of(Map<?, V> m) {
			return Lang.generic.toArray(m.values());
		}
	}

}
