package codes.abdullah.digits;

class ImmutableRange implements Range {
	private final int from, to;

	ImmutableRange(int from, int to) {
		this.from = from;
		this.to = to;
	}

	@Override
	public Range toImmutable() {
		return this;
	}

	@Override
	public Range toMutable() {
		return new MutableRange(from, to);
	}

	@Override
	public boolean isImmutable() {
		return true;
	}

	@Override
	public Range assign(int from, int to) {
		return new ImmutableRange(from, to);
	}

	@Override
	public Range setFrom(int from) {
		return new ImmutableRange(from, to);
	}

	@Override
	public Range setTo(int to) {
		return new ImmutableRange(from, to);
	}

	@Override
	public int getFrom() {
		return from;
	}

	@Override
	public int getTo() {
		return to;
	}
	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj instanceof Range) {
			Range o = (Range) obj;
			return from == o.getFrom() && to == o.getTo();
		}
		return false;
	}

	@Override
	public String toString() {
		return "ImmutableRange [from=" + from + ", to=" + to + "]";
	}

}
