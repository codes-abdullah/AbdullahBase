package codes.abdullah.digits;

import codes.abdullah.project.lang.Lang;

public class ImmutableCharsRadix extends CharsRadix {
	private static final long serialVersionUID = 3358221192674643465L;
	private final StringBuilder sb;

	public ImmutableCharsRadix(int flags, char delimiter, StringBuilder sb) {
		super(flags, delimiter);
		this.sb = sb == null ? new StringBuilder() : new StringBuilder(sb);
	}

	@Override
	CharsRadix assign(StringBuilder c) {
		return new ImmutableCharsRadix(getFlags(), getDelimiter(), c);
	}

	@Override
	StringBuilder getChars() {
		return new StringBuilder(sb);
	}

	@Override
	char[] getBuffer() {
		return Lang.chararray.newDefaultArray();
	}

	@Override
	public CharsRadix toImmutable() {
		return this;
	}

	@Override
	public CharsRadix toMutable() {
		return new MutableCharsRadix(getFlags(), getDelimiter(), sb);
	}

	@Override
	public boolean isImmutable() {
		return true;
	}

}
