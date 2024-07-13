package codes.abdullah.digits;

import codes.abdullah.project.lang.Lang;

public class MutableCharsRadix extends CharsRadix {
	private static final long serialVersionUID = 3358221192674643465L;
	private StringBuilder sb;
	private char[] buffer;

	public MutableCharsRadix(int flags, char delimiter, StringBuilder sb) {
		super(flags, delimiter);
		this.sb = sb == null ? new StringBuilder() : new StringBuilder(sb);
		this.buffer = Lang.chararray.newDefaultArray();
	}

	@Override
	CharsRadix assign(StringBuilder c) {
		this.sb = c;
		return this;
	}

	@Override
	StringBuilder getChars() {
		return sb;
	}

	@Override
	char[] getBuffer() {
		return buffer;
	}

	@Override
	public CharsRadix toImmutable() {
		return new ImmutableCharsRadix(getFlags(), getDelimiter(), sb);
	}

	@Override
	public CharsRadix toMutable() {
		return this;
	}

	@Override
	public boolean isImmutable() {
		return false;
	}

}
