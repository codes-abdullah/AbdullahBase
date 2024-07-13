package codes.abdullah.digits;

import codes.abdullah.project.Immutable;

/**
 * Simple range wrapper implements {@link Immutable}
 */
public class Range implements Immutable<Range> {
	private int from, to;
	private boolean immutable;

	public Range() {

	}

	public Range(int from, int to) {
		this(from, to, false);
	}

	Range(int from, int to, boolean immutable) {
		this.from = from;
		this.to = to;
		this.immutable = immutable;
	}

	public Range assign(int from, int to) {
		if (immutable)
			return new Range(from, to, immutable);
		this.from = from;
		this.to = to;
		return this;
	}

	public int getFrom() {
		return from;
	}

	public Range setFrom(int from) {
		return assign(from, to);
	}

	public int getTo() {
		return to;
	}

	public Range setTo(int to) {
		return assign(from, to);
	}

	public boolean isValid() {
		return from >= 0 && to >= 0;
	}

	@Override
	public Range toImmutable() {
		if (immutable)
			return this;
		Range r = new Range(from, to, true);
		return r;
	}

	@Override
	public Range toMutable() {
		if (!immutable)
			return this;
		return new Range(from, to, true);
	}

	@Override
	public boolean isImmutable() {
		return immutable;
	}

	public static Range of(int from, int to) {
		return new Range(from, to);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj instanceof Range) {
			Range o = (Range) obj;
			return from == o.from && to == o.to;
		}
		return false;
	}

	@Override
	public String toString() {
		return "Range [" + from + ":" + to + "]";
	}

}
