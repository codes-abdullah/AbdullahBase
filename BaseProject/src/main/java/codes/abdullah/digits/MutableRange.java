package codes.abdullah.digits;

class MutableRange implements Range {
	private int from, to;

	MutableRange(int from, int to) {
		this.from = from;
		this.to = to;
	}

	@Override
	public Range toImmutable() {
		return new ImmutableRange(from, to);
	}

	@Override
	public Range toMutable() {
		return this;
	}

	@Override
	public boolean isImmutable() {
		return false;
	}

	@Override
	public Range assign(int from, int to) {
		this.from = from;
		this.to = to;
		return this;
	}

	@Override
	public Range setFrom(int from) {
		this.from = from;
		return this;
	}

	@Override
	public Range setTo(int to) {
		this.to = to;
		return this;
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
		return "MutableRange [from=" + from + ", to=" + to + "]";
	}

}
