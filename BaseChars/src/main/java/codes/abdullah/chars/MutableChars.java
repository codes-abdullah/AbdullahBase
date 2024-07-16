package codes.abdullah.chars;

import codes.abdullah.array.codepoints.support.CodepointSupport;
import codes.abdullah.project.Check;
import codes.abdullah.project.lang.Lang;

final class MutableChars extends Chars {
	private static final long serialVersionUID = -5709731419826563410L;
	private int spc, flags, innerlen;
	private char[] arr;
	private CodepointSupport sps;

	MutableChars(char[] arr, int innerlen, int spc, CodepointSupport sps, int flags) {
		this.arr = Lang.chararray.newDefaultArrayOrCopy(arr, innerlen);
		this.innerlen = Check.length(innerlen, 0, arr.length);
		this.spc = spc;
		this.flags = flags;
		this.sps = sps == null ? CodepointSupport.BMP : sps;
	}

	@Override
	public Chars toImmutable() {
		return new ImmutableChars(arr, innerlen, spc, sps, flags);
	}

	@Override
	public CodepointSupport getSurrogatePairsSupport() {
		return sps;
	}

	@Override
	public int length() {
		return innerlen - spc;
	}

	@Override
	public Chars toMutable() {
		return this;
	}

	@Override
	public boolean isImmutable() {
		return false;
	}

	@Override
	public int lengthActual() {
		return innerlen;
	}

	@Override
	int spc() {
		return spc;
	}

	@Override
	public int getFlags() {
		return flags;
	}

	@Override
	char[] safe() {
		return arr;
	}

	@Override
	char[] unsafe() {
		return arr;
	}

	@Override
	Chars assign(char[] arr, int innerlen, int spc, CodepointSupport sps, int flags) {
		this.arr = arr;
		this.innerlen = innerlen;
		this.spc = spc;
		this.flags = flags;
		this.sps = sps == null ? CodepointSupport.BMP : sps;
		return this;
	}

	@Override
	Chars newInstance(char[] arr, int innerlen, int spc, CodepointSupport sps, int flags) {
		return new MutableChars(arr, innerlen, spc, sps, flags);
	}

	@Override
	public Chars newClone() {
		return new MutableChars(unsafe(), innerlen, spc, sps, flags);
	}

}
