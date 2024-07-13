package codes.abdullah.project;

import java.util.Comparator;

public class ClassComparator implements Comparator<Class<?>> {
	public static final Comparator<Class<?>> INSTANCE = new ClassComparator();

	private ClassComparator() {

	}

	@Override
	public int compare(Class<?> o1, Class<?> o2) {
		if (o1.isAssignableFrom(o2))
			return 1;
		else if (o2.isAssignableFrom(o1))
			return -1;
		else if (o1.equals(o2))
			return 0;
		return Integer.MIN_VALUE;
	}

}
