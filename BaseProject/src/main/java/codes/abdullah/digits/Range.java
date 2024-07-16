package codes.abdullah.digits;

import codes.abdullah.project.Immutable;

/**
 * Simple range wrapper implements {@link Immutable}
 */
public interface Range extends Immutable<Range> {

	Range assign(int from, int to);

	Range setFrom(int from);

	Range setTo(int to);

	int getFrom();

	int getTo();

	public static Range of(int from, int to) {
		return new MutableRange(from, to);
	}

}
