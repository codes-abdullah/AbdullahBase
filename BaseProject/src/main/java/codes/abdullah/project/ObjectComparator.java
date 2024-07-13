package codes.abdullah.project;

import java.util.Comparator;

public class ObjectComparator implements Comparator<Object> {
	public static final Comparator<Object> INSTANCE = new ObjectComparator();

	private ObjectComparator() {

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public int compare(Object o1, Object o2) {
		if (o1 == null && o2 == null)
			return 0;
		else if (o1 == null) {
			return -1;
		} else if (o2 == null) {
			return 1;
		}

		if (o1.getClass() == o2.getClass()) {
			if (o1 instanceof Comparable) {
				return ((Comparable) o1).compareTo(o2);
			} else if (o1 instanceof Comparator) {
				return ((Comparator) o1).compare(o1, o2);
			}
		}
		return o1.toString().compareTo(o2.toString());
	}
}
